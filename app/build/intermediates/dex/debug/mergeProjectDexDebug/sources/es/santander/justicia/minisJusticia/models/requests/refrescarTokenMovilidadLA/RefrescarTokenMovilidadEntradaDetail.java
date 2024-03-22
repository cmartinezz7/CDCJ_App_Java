package es.santander.justicia.minisJusticia.models.requests.refrescarTokenMovilidadLA;

import org.simpleframework.xml.Element;

public class RefrescarTokenMovilidadEntradaDetail {
    @Element(name = "token", required = false)
    private String token;

    public RefrescarTokenMovilidadEntradaDetail(String token2) {
        this.token = token2;
    }
}
