package com.violanotes.guimodel.guimodel1.model.concern;

import com.violanotes.guimodel.guimodel1.model.exception.ConcernEventHandlingException;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class ConcernEvent<ListenerClass extends ConcernListener> {

    private Class<? extends ConcernEvent> clazz;

    private Concern source;

    public abstract void handleEvent(ListenerClass listener) throws ConcernEventHandlingException;

    /**
     * Associate this event with the corresponding method
     * in the listener interface.
     *
     * @param listener the listener instance on which to
     *                 invoke the proper method.
     * @throws ConcernEventHandlingException on exception in invoked method
     */
    public void handleEvent_Old(ListenerClass listener) throws ConcernEventHandlingException {

        if (listener == null) throw new NullPointerException();
    }

    public Class<? extends ConcernEvent> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends ConcernEvent> clazz) {
        this.clazz = clazz;
    }

    public Concern getSource() {
        return source;
    }

    public void setSource(Concern source) {
        this.source = source;
    }
}
