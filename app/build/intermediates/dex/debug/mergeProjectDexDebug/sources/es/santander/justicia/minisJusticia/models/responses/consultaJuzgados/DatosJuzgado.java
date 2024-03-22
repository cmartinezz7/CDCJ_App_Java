package es.santander.justicia.minisJusticia.models.responses.consultaJuzgados;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DatosJuzgado {
    @Element(name = "codTipoVia", required = false)
    private String codTipoVia;
    @Element(name = "codentja", required = false)
    private String codentja;
    @Element(name = "codest", required = false)
    private String codest;
    @Element(name = "codpost", required = false)
    private String codpost;
    @Element(name = "codprova", required = false)
    private String codprova;
    @Element(name = "datosPlaza", required = false)
    private DatosPlaza datosPlaza;
    @Element(name = "entornoJudicial", required = false)
    private String entornoJudicial;
    @Element(name = "estado", required = false)
    private String estado;
    @Element(name = "idcent", required = false)
    private String idcent;
    @Element(name = "idempr", required = false)
    private String idempr;
    @Element(name = "juzga", required = false)
    private String juzga;
    @Element(name = "juzgapad", required = false)
    private String juzgapad;
    @Element(name = "nombreOrganismo", required = false)
    private String nombreOrganismo;
    @Element(name = "nombreVia", required = false)
    private String nombreVia;
    @Element(name = "numero", required = false)
    private String numero;
    @Element(name = "provincia", required = false)
    private String provincia;
    @Element(name = "telefono1", required = false)
    private String telefono1;
    @Element(name = "tipoVia", required = false)
    private String tipoVia;
    @Element(name = "unifunc", required = false)
    private String unifunc;

    public String getCodentja() {
        return this.codentja;
    }

    public String getCodest() {
        return this.codest;
    }

    public String getCodpost() {
        return this.codpost;
    }

    public String getCodprova() {
        return this.codprova;
    }

    public DatosPlaza getDatosPlaza() {
        return this.datosPlaza;
    }

    public String getEntornoJudicial() {
        return this.entornoJudicial;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getIdcent() {
        return this.idcent;
    }

    public String getIdempr() {
        return this.idempr;
    }

    public String getJuzga() {
        return this.juzga;
    }

    public String getJuzgapad() {
        return this.juzgapad;
    }

    public String getNombreOrganismo() {
        return this.nombreOrganismo;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public String getTelefono1() {
        return this.telefono1;
    }

    public String getCodTipoVia() {
        return this.codTipoVia;
    }

    public String getNombreVia() {
        return this.nombreVia;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getTipoVia() {
        return this.tipoVia;
    }

    public String getUnifunc() {
        return this.unifunc;
    }
}
