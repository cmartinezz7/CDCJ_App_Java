package es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados;

import es.santander.justicia.minisJusticia.models.responses.ErrorResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "ns2", reference = "http://www.imcs.es/cdcj-wsjuzgados-mobile/WSJuzgadosMobile/")})
@Root(name = "ns2:consultaOrganosAsignadosResponse")
public class ConsultaOrganosAsignadosRespBody extends ErrorResponse {
    @Element(name = "consultaOrganosAsignadosResponse", required = false)
    private ConsultaOrganismoReturn consultaOrganismoReturn;

    public ConsultaOrganismoReturn getConsultaOrganismoReturn() {
        return this.consultaOrganismoReturn;
    }
}
