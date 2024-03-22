package es.santander.justicia.minisJusticia.models.responses.detalleUsuario;

import org.simpleframework.xml.Element;

public class DetalleUsuarioResponeReturn {
    @Element(name = "return", required = false)
    private DetalleUsuario detalleUsuario;

    public DetalleUsuario getDetalleUsuario() {
        return this.detalleUsuario;
    }
}
