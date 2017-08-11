package com.violanotes.guimodel.guimodel1.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class FacetController {

    protected Map<Concern, Connector> connectorMap = new HashMap<>();

    /**
     * Associate a connector for each concern.
     *
     */
    public abstract void setup();

    /**
     * Look up the connector to use from the map;
     * delegate the event to the connector.
     * @param e the event to handle
     */
    public abstract void handleEvent(UserEvent e);


    /**
     * Class to connect a concern instance to 0-many facet instances.
     */
    public static class Connector {

        /**
         * Create a connector that does not connect to anything.
         * @return a new connector
         */
        protected static Connector mockConnector() {

        }

        /**
         * Create a connector that associates a single concern with
         * a single facet.
         * @return a new connector
         */
        protected static Connector basicConnector(Facet f) {

        }

        /**
         * Create a connector that associates a single concern with
         * two or more facets.
         * @param f the first facet to connect
         * @param facets other facets to connect, in order
         * @return a new connector
         */
        protected static Connector basicConnector(Facet f, Facet... facets) {

        }


    }

}
