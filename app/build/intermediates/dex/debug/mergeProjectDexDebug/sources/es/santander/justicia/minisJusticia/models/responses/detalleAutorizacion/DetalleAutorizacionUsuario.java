package es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleAutorizacionUsuario {
    @Element(name = "apellido1", required = false)
    private String apellido1;
    @Element(name = "apellido2", required = false)
    private String apellido2;
    @Element(name = "codNumDocumento", required = false)
    private String codNumDocumento;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "codigoUsuario", required = false)
    private String codigoUsuario;
    @Element(name = "nombre", required = false)
    private String nombre;
    @Element(name = "perfil", required = false)
    private String perfil;

    public String getApellido1() {
        return this.apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public String getCodNumDocumento() {
        return this.codNumDocumento;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public String getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPerfil() {
        return this.perfil;
    }
}
