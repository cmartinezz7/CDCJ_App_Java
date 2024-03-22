package es.santander.justicia.minisJusticia.models.responses.buscPetAcceso;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import es.santander.justicia.minisJusticia.models.ExpedienteDetailLetrados;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "return", strict = false)
public class BuscarPeticionesAcceso implements Serializable, Parent<ExpedienteDetailLetrados> {
    @Element(name = "anioApertura", required = false)
    private String anioApertura;
    @Element(name = "apellido1", required = false)
    private String apellido1;
    @Element(name = "codCompletoExpediente", required = false)
    private String codCompletoExpediente;
    @Element(name = "codDocumento", required = false)
    private String codDocumento;
    @Element(name = "codEstadoActualExp", required = false)
    private String codEstadoActualExp;
    @Element(name = "codJuzDest", required = false)
    private String codJuzDest;
    @Element(name = "codJuzOri", required = false)
    private String codJuzOri;
    @Element(name = "codProced", required = false)
    private String codProced;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "desEstadoActualExp", required = false)
    private String desEstadoActualExp;
    @Element(name = "desEstadoPeticion", required = false)
    private String desEstadoPeticion;
    @Element(name = "dsComentarios", required = false)
    private String dsComentarios;
    @Element(name = "fecDeLaPeticion", required = false)
    private String fecDeLaPeticion;
    @Element(name = "fecModificacionPeticion", required = false)
    private String fecModificacionPeticion;
    @Element(name = "nombre", required = false)
    private String nombre;
    @Element(name = "numExpediente", required = false)
    private String numExpediente;
    @Element(name = "numeroPagina", required = false)
    private int numerPagina;
    @Element(name = "tamannoPagina", required = false)
    private int tamannoPagina;
    @Element(name = "totalPaginas", required = false)
    private int totalPaginas;

    public int getNumerPagina() {
        return this.numerPagina;
    }

    public int getTamannoPagina() {
        return this.tamannoPagina;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public String getAnioApertura() {
        return this.anioApertura;
    }

    public String getCodCompletoExpediente() {
        return this.codCompletoExpediente;
    }

    public String getCodDocumento() {
        return this.codDocumento;
    }

    public String getCodEstadoActualExp() {
        return this.codEstadoActualExp;
    }

    public String getCodJuzDest() {
        return this.codJuzDest;
    }

    public String getCodJuzOri() {
        return this.codJuzOri;
    }

    public String getCodProced() {
        return this.codProced;
    }

    public String getCodTipoDocumento() {
        return this.codTipoDocumento;
    }

    public String getDesEstadoActualExp() {
        return this.desEstadoActualExp;
    }

    public String getDesEstadoPeticion() {
        return this.desEstadoPeticion;
    }

    public String getDsComentarios() {
        return this.dsComentarios;
    }

    public String getFecDeLaPeticion() {
        return this.fecDeLaPeticion;
    }

    public String getFecModificacionPeticion() {
        return this.fecModificacionPeticion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public String getNumExpediente() {
        return this.numExpediente;
    }

    public List<ExpedienteDetailLetrados> getChildList() {
        return new ArrayList();
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
