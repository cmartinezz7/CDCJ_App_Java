package es.santander.justicia.minisJusticia.models.responses.erroLoginUnico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "prefixRige10", reference = "http://www.isban.es/webservices/MOEMC2/Contratos_la/F_moemc2_contratos_la/santander/empresas/functionalFaults/v1")})
@Root(name = "prefixRige10", strict = false)
public class ErrorPrefixLoginUnico {
    @Element(name = "com.isb.moemc2.contratos.la.f.exc.General_Contratos_LA", required = false)
    private ErrorPrefixDetailLoginUnico errorPrefixDetailLoginUnico;

    public ErrorPrefixDetailLoginUnico getErrorPrefixDetailLoginUnico() {
        return this.errorPrefixDetailLoginUnico;
    }
}
