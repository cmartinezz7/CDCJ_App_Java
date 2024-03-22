package es.santander.justicia.minisJusticia.models.responses.loginunico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class LoginUnicoCliente {
    @Element(name = "CODIGO_DE_PERSONA", required = false)
    private String codigoDePersona;
    @Element(name = "TIPO_DE_PERSONA", required = false)
    private String tipoDePersona;

    public String getTipoDePersona() {
        return this.tipoDePersona;
    }

    public String getCodigoDePersona() {
        return this.codigoDePersona;
    }
}
