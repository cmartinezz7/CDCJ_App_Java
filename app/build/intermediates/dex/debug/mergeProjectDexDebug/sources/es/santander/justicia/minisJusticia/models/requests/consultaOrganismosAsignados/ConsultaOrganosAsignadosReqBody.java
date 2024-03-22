package es.santander.justicia.minisJusticia.models.requests.consultaOrganismosAsignados;

import org.simpleframework.xml.Element;

public class ConsultaOrganosAsignadosReqBody {
    @Element(name = "wsj:consultaOrganosAsignados", required = false)
    private String string = "";
}
