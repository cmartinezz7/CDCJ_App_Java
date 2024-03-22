package es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion;

import org.simpleframework.xml.Element;

public class AutorizacionRetrocesionDto {
    @Element(name = "codOperacion", required = false)
    private String codOperacion;
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "estado", required = false)
    private String estado;
    @Element(name = "motivoResolucion", required = false)
    private String motivoResolucion;

    public AutorizacionRetrocesionDto(String codOperacion2, String codOrganismo2, String estado2, String motivoResolucion2) {
        this.codOperacion = codOperacion2;
        this.codOrganismo = codOrganismo2;
        this.estado = estado2;
        this.motivoResolucion = motivoResolucion2;
    }
}
