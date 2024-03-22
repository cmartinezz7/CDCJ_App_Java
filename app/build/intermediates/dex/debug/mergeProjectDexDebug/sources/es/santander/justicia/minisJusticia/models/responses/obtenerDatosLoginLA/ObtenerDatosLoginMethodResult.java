package es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA;

import org.simpleframework.xml.Element;

public class ObtenerDatosLoginMethodResult {
    @Element(name = "methodResult", required = false)
    private ObtenerDatosLoginMethodResultDetail methodResult;

    public ObtenerDatosLoginMethodResultDetail getMethodResult() {
        return this.methodResult;
    }
}
