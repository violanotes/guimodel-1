package com.violanotes.guimodel.guimodel1.model;

/**
 * Created by pc on 8/11/2017.
 */
public class SelectedFileConcern {

    private SelectionData currentSelection;

    private State currentState;

    private FacetController facetController;

    /**
     * Initialize the concern.  Things such as the current selection.
     */
    public SelectedFileConcern() {
        currentSelection = SelectionData.newDefaultInstance();
    }

    protected void raiseEvent(UserEvent e) {
        facetController.handleEvent(e);
    }

    public enum State {
        NO_FILE_SELECTED,
        FILE_SELECTED
    }

    /**
     * Selection changed event.
     */
    public static class SelectionChangedEvent extends UserEvent {

        /**
         * Initialize default data.
         */
        public SelectionChangedEvent() {
            setClazz(SelectionChangedEvent.class);
        }

        private SelectionData newSelection;
        private State newState;
    }

    public static class SelectionData {
        protected String filepath;

        protected SelectionData() {}

        /**
         * Static constructor to build default selection data.
         * @return default selection data
         */
        protected static SelectionData newDefaultInstance() {
            SelectionData selectionData = new SelectionData();
            selectionData.filepath = null;

            return selectionData;
        }
    }

    /**
     * Interface for a facet to implement.
     */
    public interface Listener {
        void handleSelectionChanged() throws EventHandlingException;
    }

}