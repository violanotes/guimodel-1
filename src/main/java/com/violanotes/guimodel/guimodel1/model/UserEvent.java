package com.violanotes.guimodel.guimodel1.model;

/**
 * Created by pc on 8/11/2017.
 */
public abstract class UserEvent {

    private Class<? extends UserEvent> clazz;

    public Class<? extends UserEvent> getClazz() {
        return clazz;
    }

    public void setClazz(Class<? extends UserEvent> clazz) {
        this.clazz = clazz;
    }
}
