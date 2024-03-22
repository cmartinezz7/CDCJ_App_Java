package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "prefixRige10", reference = "http://www.isban.es/webservices/MOEMC2/Contratos_la/F_moemc2_contratos_la/empresas/ACEMPMOVContratos/v1")})
@Root(name = "prefixRige10", strict = false)
public class LoginUnicoBody {
    @Element(name = "realizarLoginUnico_LAResponse", required = false)
    private LoginUnicoMethodResult methodResult;

    public LoginUnicoMethodResult getMethodResult() {
        return this.methodResult;
    }
}
