package es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ConsultaOrganismoReturn {
    @ElementList(name = "return", required = false)
    private ArrayList<ConsultaOrganoAsignadoDetail> consultaOrganimosAsignadoCodUos;

    public ArrayList<ConsultaOrganoAsignadoDetail> getConsultaOrganimosAsignadoCodUos() {
        return this.consultaOrganimosAsignadoCodUos;
    }
}
