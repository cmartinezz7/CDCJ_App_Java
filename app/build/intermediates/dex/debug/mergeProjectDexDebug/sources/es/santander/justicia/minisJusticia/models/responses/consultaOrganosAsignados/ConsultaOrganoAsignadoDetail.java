package es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ConsultaOrganoAsignadoDetail {
    @Element(name = "cargo", required = false)
    private String cargo;
    @Element(name = "codTipRelacion", required = false)
    private String codTipRelacion;
    @Element(name = "codUo", required = false)
    private String codUo;
    @Element(name = "desCargo", required = false)
    private String desCargo;
    @Element(name = "desTipRelacion", required = false)
    private String desTipRelacion;
    @Element(name = "desUo", required = false)
    private String desUo;
    @Element(name = "fecFin", required = false)
    private String fecFin;
    @Element(name = "fecInicio", required = false)
    private String fecInicio;

    public String getCargo() {
        return this.cargo;
    }

    public String getCodTipRelacion() {
        return this.codTipRelacion;
    }

    public String getCodUo() {
        return this.codUo;
    }

    public String getDesCargo() {
        return this.desCargo;
    }

    public String getDesTipRelacion() {
        return this.desTipRelacion;
    }

    public String getDesUo() {
        return this.desUo;
    }

    public String getFecFin() {
        return this.fecFin;
    }

    public String getFecInicio() {
        return this.fecInicio;
    }
}
