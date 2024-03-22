package es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA;

import org.simpleframework.xml.Element;

public class ObtenerDatosLoginEntradaDetail {
    @Element(name = "alias", required = false)
    private String alias;
    @Element(name = "servicioComerciable", required = false)
    private String servicioComerciable = "AA";
    @Element(name = "token", required = false)
    private String token;
    @Element(name = "usuarioRaf", required = false)
    private String usuarioRaf;

    public ObtenerDatosLoginEntradaDetail(String alias2, String token2, String usuarioRaf2, String servicioComerciable2) {
        this.alias = alias2;
        this.token = token2;
        this.usuarioRaf = usuarioRaf2;
    }
}
