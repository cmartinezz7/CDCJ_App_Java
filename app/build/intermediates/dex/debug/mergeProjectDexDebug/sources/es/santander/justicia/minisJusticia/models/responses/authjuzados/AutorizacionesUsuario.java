package es.santander.justicia.minisJusticia.models.responses.authjuzados;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "return", strict = false)
public class AutorizacionesUsuario implements Serializable {
    @Element(name = "apellido1", required = false)
    private String apellido1;
    @Element(name = "apellido2", required = false)
    private String apellido2;
    @Element(name = "codNumDocumento", required = false)
    private String codNumDocumento;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "fechaFinal", required = false)
    private String fechaFinal;
    @Element(name = "fechaInicial", required = false)
    private String fechaInicial;
    @Element(name = "nombre", required = false)
    private String nombre;
    @Element(name = "numeroPagina", required = false)
    private int numerPagina;
    @Element(name = "perfil", required = false)
    private String perfil;
    @Element(name = "tamannoPagina", required = false)
    private int tamannoPagina;
    @Element(name = "totalPaginas", required = false)
    private int totalPaginas;

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

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public String getFechaInicial() {
        return this.fechaInicial;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPerfil() {
        return this.perfil;
    }

    public int getNumerPagina() {
        return this.numerPagina;
    }

    public int getTamannoPagina() {
        return this.tamannoPagina;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }
}
