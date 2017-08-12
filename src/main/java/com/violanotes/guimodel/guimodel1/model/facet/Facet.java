package com.violanotes.guimodel.guimodel1.model.facet;

import com.violanotes.guimodel.guimodel1.model.exception.ConcernEventHandlingException;
import com.violanotes.guimodel.guimodel1.model.concern.ConcernListener;
import com.violanotes.guimodel.guimodel1.model.concern.ConcernEvent;
import com.violanotes.guimodel.guimodel1.model.concern.Concern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class Facet {

    protected Map<Concern, ConcernListener> listenerMap = new HashMap<>();

    /**
     * Setup listeners in subclasses.
     */
    protected void setupListeners() {}

    /**
     * Associate a ConcernListener with a concern.
     * @param concern the concern to listen to
     * @param ConcernListener the ConcernListener for the concern
     */
    protected void addListener(Concern concern, ConcernListener ConcernListener) {
        listenerMap.put(concern, ConcernListener);
    }

    protected ConcernListener getListener(Concern c) {
        return listenerMap.get(c);
    }

    public abstract void handleEvent(ConcernEvent<ConcernListener> e) throws ConcernEventHandlingException;


}
