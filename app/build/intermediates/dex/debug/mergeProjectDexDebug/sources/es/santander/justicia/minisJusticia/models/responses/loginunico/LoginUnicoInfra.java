package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@NamespaceList({@Namespace(prefix = "Version", reference = "1.0"), @Namespace(prefix = "soap-env:actor", reference = "http://www.isban.es/soap/actor/coexistence"), @Namespace(prefix = "soap-env:mustUnderstand", reference = "0")})
@Root(name = "Infra")
public class LoginUnicoInfra {
}
