package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class LoginUnicoTipoProducto {
    @Element(name = "EMPRESA", required = false)
    private String empresa;

    public String getEmpresa() {
        return this.empresa;
    }
}
