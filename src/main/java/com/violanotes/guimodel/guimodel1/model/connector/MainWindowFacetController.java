package com.violanotes.guimodel.guimodel1.model.connector;

import com.violanotes.guimodel.guimodel1.model.concern.Concern;
import com.violanotes.guimodel.guimodel1.model.concern.SelectedFileConcern;
import com.violanotes.guimodel.guimodel1.model.facet.Facet;
import com.violanotes.guimodel.guimodel1.model.facet.SelectAndLoadFileFacet;

/**
 * Created by pc on 8/11/2017.
 *
 * The facet controller HAS concerns and facets.
 *
 * It automatically tries to handle events through the registered connectors.
 *
 */
public class MainWindowFacetController extends FacetController {

    private Concern selectedFileConcern;

    private Facet selectAndLoadFileFacet;

    /**
     * Build concerns here; build facets here.
     * Build connectors here
     *
     * Eventually concerns and facets would be injected into this.
     */
    @Override
    public void setup() {

        selectedFileConcern = new SelectedFileConcern();
        selectAndLoadFileFacet = new SelectAndLoadFileFacet();

        Connector connector = Connector.newBasicConnectorTo(selectAndLoadFileFacet);

        associateConcernToConnector(selectedFileConcern, connector);
    }
}
