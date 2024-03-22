package es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA;

import es.santander.justicia.minisJusticia.models.responses.erroLoginUnico.ErrorFaultLoginUnico;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "prefixRige10", reference = "http://www.isban.es/webservices/MOEMC2/Contratos_la/F_moemc2_contratos_la/empresas/ACEMPMOVContratos/v1")})
@Root(name = "prefixRige10", strict = false)
public class ObtenerDatosLoginResponseBody {
    @Element(name = "Fault", required = false)
    private ErrorFaultLoginUnico fault;
    @Element(name = "obtenerDatosLogin_LAResponse", required = false)
    private ObtenerDatosLoginMethodResult obtenerDatosLoginMethodResult;

    public ObtenerDatosLoginMethodResult getObtenerDatosLoginMethodResult() {
        return this.obtenerDatosLoginMethodResult;
    }

    public ErrorFaultLoginUnico getFault() {
        return this.fault;
    }
}
