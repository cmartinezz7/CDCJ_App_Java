package es.santander.justicia.minisJusticia.models.requests.refrescarTokenMovilidadLA;

import org.simpleframework.xml.Element;

public class RefrescarTokenMovilidadRequestBody {
    @Element(name = "v1:refrescarTokensMovilidad_LA", required = false)
    private RefrescarTokenMovilidadRequestBody entrada;

    public RefrescarTokenMovilidadRequestBody(RefrescarTokenMovilidadRequestBody entrada2) {
        this.entrada = entrada2;
    }
}
