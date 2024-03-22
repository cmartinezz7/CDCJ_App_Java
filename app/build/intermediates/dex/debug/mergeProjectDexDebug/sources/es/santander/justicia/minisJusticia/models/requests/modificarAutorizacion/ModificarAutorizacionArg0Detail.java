package es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion;

import es.santander.justicia.minisJusticia.models.requests.detalleAutorizacion.DetalleAutorizacionUsuario;
import org.simpleframework.xml.Element;

public class ModificarAutorizacionArg0Detail {
    @Element(name = "autorizacionUsuario")
    private DetalleAutorizacionUsuario detalleAutorizacionUsuario;
    @Element(name = "fechaFinalModificacion")
    private String fechaFinalModificacion;
    @Element(name = "fechaInicialModificacion")
    private String fechaInicialModificacion = "";
    @Element(name = "firma")
    private String firma;

    public ModificarAutorizacionArg0Detail(DetalleAutorizacionUsuario detalleAutorizacionUsuario2) {
        this.detalleAutorizacionUsuario = detalleAutorizacionUsuario2;
    }

    public void setFechaFinalModificacion(String fechaFinalModificacion2) {
        this.fechaFinalModificacion = fechaFinalModificacion2;
    }

    public void setFirma(String firma2) {
        this.firma = firma2;
    }
}
