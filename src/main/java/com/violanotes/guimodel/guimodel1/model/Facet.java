package com.violanotes.guimodel.guimodel1.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class Facet {

    protected Map<Concern, Listener> listenerMap = new HashMap<>();

    /**
     * Setup listeners in subclasses.
     */
    protected void setupListeners() {}

    /**
     * Associate a listener with a concern.
     * @param concern the concern to listen to
     * @param listener the listener for the concern
     */
    protected void addListener(Concern concern, Listener listener) {
        listenerMap.put(concern, listener);
    }


}
