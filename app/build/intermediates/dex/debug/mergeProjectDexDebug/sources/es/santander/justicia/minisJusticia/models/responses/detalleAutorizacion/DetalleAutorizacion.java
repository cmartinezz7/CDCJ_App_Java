package es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleAutorizacion {
    @Element(name = "juzgado", required = false)
    private DetalleAutorizacionJuzgado detalleAutorizacionJuzgado;
    @Element(name = "usuario", required = false)
    private DetalleAutorizacionUsuario detalleAutorizacionUsuario;
    @Element(name = "fechaFinal", required = false)
    private String fechaFinal;
    @Element(name = "fechaInicial", required = false)
    private String fechaInicial;

    public DetalleAutorizacionJuzgado getDetalleAutorizacionJuzgado() {
        return this.detalleAutorizacionJuzgado;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public DetalleAutorizacionUsuario getDetalleAutorizacionUsuario() {
        return this.detalleAutorizacionUsuario;
    }
}
