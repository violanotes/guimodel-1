package com.violanotes.guimodel.guimodel1.model.facet;

import com.violanotes.guimodel.guimodel1.model.concern.ConcernListener;
import com.violanotes.guimodel.guimodel1.model.exception.ConcernEventHandlingException;
import com.violanotes.guimodel.guimodel1.model.concern.ConcernEvent;
import com.violanotes.guimodel.guimodel1.model.concern.FileDisplayedConcern;
import com.violanotes.guimodel.guimodel1.model.concern.SelectedFileConcern;

/**
 * Created by pc on 8/11/2017.
 *
 * The facet can have distinct instances of a concern class.
 *
 */
public class SelectAndLoadFileFacet extends Facet {

    private SelectedFileConcern selectedFileConcern;
    private FileDisplayedConcern fileDisplayedConcern;


    @Override
    public void handleEvent(ConcernEvent<ConcernListener> e) throws ConcernEventHandlingException {
        e.handleEvent(getListener(e.getSource()));
    }
}
