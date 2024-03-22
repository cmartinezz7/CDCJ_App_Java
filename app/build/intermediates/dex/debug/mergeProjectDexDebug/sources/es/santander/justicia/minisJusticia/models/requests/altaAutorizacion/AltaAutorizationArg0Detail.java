package es.santander.justicia.minisJusticia.models.requests.altaAutorizacion;

import org.simpleframework.xml.Element;

public class AltaAutorizationArg0Detail {
    @Element(name = "datosAutorizacion", required = false)
    private DatosAutorizacion datosAutorizacion;
    @Element(name = "firma", required = false)
    private String firma;

    public DatosAutorizacion getDatosAutorizacion() {
        return this.datosAutorizacion;
    }

    public void setDatosAutorizacion(DatosAutorizacion datosAutorizacion2) {
        this.datosAutorizacion = datosAutorizacion2;
    }

    public String getFirma() {
        return this.firma;
    }

    public void setFirma(String firma2) {
        this.firma = firma2;
    }
}
