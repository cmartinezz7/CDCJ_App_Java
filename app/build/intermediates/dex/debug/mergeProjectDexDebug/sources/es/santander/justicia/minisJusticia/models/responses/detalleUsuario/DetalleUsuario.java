package es.santander.justicia.minisJusticia.models.responses.detalleUsuario;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetalleUsuario implements Serializable {
    @Element(name = "apellidoPrimero", required = false)
    private String apellidoPrimero;
    @Element(name = "apellidoSegundo", required = false)
    private String apellidoSegundo;
    @Element(name = "codCargo", required = false)
    private String codCargo;
    @Element(name = "codEntornoJudicial", required = false)
    private String codEntornoJudicial;
    @Element(name = "codEstadoUsuario", required = false)
    private String codEstadoUsuario;
    @Element(name = "codOrganismo", required = false)
    private String codOrganismo;
    @Element(name = "codPerfil", required = false)
    private String codPerfil;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "codTipoRelacion", required = false)
    private String codTipoRelacion;
    @Element(name = "codUoPadre", required = false)
    private String codUoPadre;
    @Element(name = "codUsuario", required = false)
    private String codUsuario;
    @Element(name = "codigoTipoPersona", required = false)
    private String codigoTipoPersona;
    @Element(name = "desCargo", required = false)
    private String desCargo;
    @Element(name = "desEstadoUsuario", required = false)
    private String desEstadoUsuario;
    @Element(name = "desOrganismo", required = false)
    private String desOrganismo;
    @Element(name = "desPlaza", required = false)
    private String desPlaza;
    @Element(name = "desProvinciaOrganismo", required = false)
    private String desProvinciaOrganismo;
    @Element(name = "desTipoDocumento", required = false)
    private String desTipoDocumento;
    @Element(name = "desTipoRelacion", required = false)
    private String desTipoRelacion;
    @Element(name = "email", required = false)
    private String email;
    @Element(name = "nombreUsuario", required = false)
    private String nombreUsuario;
    @Element(name = "numDocumento", required = false)
    private String numDocumento;
    @Element(name = "numTelefono1", required = false)
    private String numTelefono1;
    @Element(name = "numeroPersona", required = false)
    private String numeroPersona;

    public String getApellidoPrimero() {
        return this.apellidoPrimero;
    }

    public String getApellidoSegundo() {
        return this.apellidoSegundo;
    }

    public String getCodCargo() {
        return this.codCargo;
    }

    public String getCodEntornoJudicial() {
        return this.codEntornoJudicial;
    }

    public String getCodEstadoUsuario() {
        return this.codEstadoUsuario;
    }

    public String getCodOrganismo() {
        return this.codOrganismo;
    }

    public String getCodPerfil() {
        return this.codPerfil;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public String getCodTipoRelacion() {
        return this.codTipoRelacion;
    }

    public String getCodUoPadre() {
        return this.codUoPadre;
    }

    public String getCodUsuario() {
        return this.codUsuario;
    }

    public String getCodigoTipoPersona() {
        return this.codigoTipoPersona;
    }

    public String getDesCargo() {
        return this.desCargo;
    }

    public String getDesEstadoUsuario() {
        return this.desEstadoUsuario;
    }

    public String getDesOrganismo() {
        return this.desOrganismo;
    }

    public String getDesPlaza() {
        return this.desPlaza;
    }

    public String getDesProvinciaOrganismo() {
        return this.desProvinciaOrganismo;
    }

    public String getDesTipoDocumento() {
        return this.desTipoDocumento;
    }

    public String getDesTipoRelacion() {
        return this.desTipoRelacion;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public String getNumDocumento() {
        return this.numDocumento;
    }

    public String getNumTelefono1() {
        return this.numTelefono1;
    }

    public String getNumeroPersona() {
        return this.numeroPersona;
    }
}
