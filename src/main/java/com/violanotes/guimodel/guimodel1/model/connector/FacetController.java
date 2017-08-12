package com.violanotes.guimodel.guimodel1.model.connector;

import com.violanotes.guimodel.guimodel1.model.exception.ConcernEventHandlingException;
import com.violanotes.guimodel.guimodel1.model.concern.ConcernEvent;
import com.violanotes.guimodel.guimodel1.model.concern.Concern;
import com.violanotes.guimodel.guimodel1.model.facet.Facet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class FacetController {

    protected Map<Concern, Connector> connectorMap = new HashMap<>();

    /**
     * Associate a connector for each concern.
     * Each subclass should do this.
     */
    public abstract void setup();

    /**
     * Associate a concern with a connector
     * @param concern the concern to associate
     * @param connector the connector to associate
     * @throws NullPointerException if concern or connector is null
     */
    public void associateConcernToConnector(Concern concern, Connector connector) {

        if (concern == null) throw new NullPointerException("Concern should not be null");
        if (connector == null) throw new NullPointerException("Connector should not be null");

        connectorMap.put(concern, connector);
    }

    /**
     * Get the connector associated with the given concern.
     * @param concern concern to use as key to search for a connector
     * @return the connector associated with the given concern
     * @throws ConcernEventHandlingException if no connector is found for the given concern
     * @throws NullPointerException if the concern is null
     */
    public Connector getConnectorForConcern(Concern concern) throws ConcernEventHandlingException, NullPointerException {

        if (concern == null) throw new NullPointerException("Concern should not be null");

        Connector connector = connectorMap.get(concern);

        if (connector == null) throw new ConcernEventHandlingException("No connector defined for source concern '" + concern + "'");

        return connector;
    }

    /**
     * Look up the connector to use from the map;
     * delegate the event to the connector.
     * @param e the event to handle
     * @throws NullPointerException if the event is null
     */
    public void handleEvent(ConcernEvent e) throws ConcernEventHandlingException {

        if (e == null) throw new NullPointerException();

        Connector connector = getConnectorForConcern(e.getSource());

        connector.delegateEvent(e);
    }

    /**
     * Class to connect a concern instance to 0-many facet instances.
     */
    public static abstract class Connector {

        protected abstract void delegateEvent(ConcernEvent e) throws ConcernEventHandlingException;

        /**
         * Create a connector that does not connect to anything.
         * @return a new connector
         */
        protected static Connector newMockConnector() {
            return new Connector() {
                /**
                 * Mock delegating an event to a facet
                 * @param e the event to delegate
                 */
                @Override
                protected void delegateEvent(ConcernEvent e) throws ConcernEventHandlingException {
                    // do nothing for mock
                }
            };
        }

        /**
         * Create a connector that associates a single concern with
         * a single facet.
         * @return a new connector
         */
        protected static Connector newBasicConnectorTo(final Facet f) {
            return new Connector() {
                /**
                 * Delegate event to a single facet
                 * @param e the event to delegate
                 */
                @Override
                protected void delegateEvent(ConcernEvent e) throws ConcernEventHandlingException {
                    f.handleEvent(e);
                }
            };
        }

        /**
         * Create a connector that associates a single concern with
         * two or more facets.
         * @param f the first facet to connect
         * @param facets other facets to connect, in order
         * @return a new connector
         */
        protected static Connector newBasicConnectorTo(Facet f, Facet...facets) {
            return new Connector() {
                /**
                 * Delegate to other facets, as present.
                 * @param e the event to delegate
                 */
                @Override
                protected void delegateEvent(ConcernEvent e) throws ConcernEventHandlingException {
                    f.handleEvent(e);

                    for (Facet facet : facets) {
                        facet.handleEvent(e);
                    }
                }
            };
        }
    }

}
