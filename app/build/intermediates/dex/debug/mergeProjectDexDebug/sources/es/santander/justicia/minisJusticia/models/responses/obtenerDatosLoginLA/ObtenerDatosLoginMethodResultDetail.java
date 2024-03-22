package es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA;

import es.santander.justicia.minisJusticia.models.responses.Contrato;
import es.santander.justicia.minisJusticia.models.responses.InfoDetail;
import es.santander.justicia.minisJusticia.models.responses.Persona;
import es.santander.justicia.minisJusticia.models.responses.SupbTipoPro;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "methodResult", strict = false)
public class ObtenerDatosLoginMethodResultDetail {
    @Element(name = "cliente", required = false)
    private Persona cliente;
    @Element(name = "codDocumento", required = false)
    private String codDocumento;
    @Element(name = "contrato", required = false)
    private Contrato contrato;
    @Element(name = "estadoUsuario", required = false)
    private String estadoUsuario;
    @Element(name = "fecUltimoAcceso", required = false)
    private String fecUltimoAcceso;
    @Element(name = "horaUltimoAcceso", required = false)
    private String horaUltimoAcceso;
    @Element(name = "indMedidaSMS", required = false)
    private String indMedidaSMS;
    @Element(name = "info", required = false)
    private InfoDetail infoDetail;
    @Element(name = "nombreTitular", required = false)
    private String nombreTitular;
    @ElementList(name = "listaServicios", required = false)
    private ArrayList<String> servicioComerciables;
    @Element(name = "subtipoProd", required = false)
    private SupbTipoPro subtipoProd;
    @Element(name = "telefonoOTP", required = false)
    private String telefonoOTP;
    @Element(name = "tipoDocumento", required = false)
    private String tipoDocumento;
    @Element(name = "tipoRelacionUsu", required = false)
    private String tipoRelacionUsu;
    @Element(name = "tokenEmpresas", required = false)
    private String tokenEmpresas;
    @Element(name = "usuarioConexionEmp", required = false)
    private String usuarioConexionEmp;
    @Element(name = "usuarioInternoEmp", required = false)
    private String usuarioInternoEmp;

    public InfoDetail getInfoDetail() {
        return this.infoDetail;
    }

    public String getUsuarioInternoEmp() {
        return this.usuarioInternoEmp;
    }

    public String getUsuarioConexionEmp() {
        return this.usuarioConexionEmp;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public String getCodDocumento() {
        return this.codDocumento;
    }

    public Persona getCliente() {
        return this.cliente;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public SupbTipoPro getSubtipoProd() {
        return this.subtipoProd;
    }

    public Contrato getContrato() {
        return this.contrato;
    }

    public String getTipoRelacionUsu() {
        return this.tipoRelacionUsu;
    }

    public String getEstadoUsuario() {
        return this.estadoUsuario;
    }

    public String getFecUltimoAcceso() {
        return this.fecUltimoAcceso;
    }

    public String getHoraUltimoAcceso() {
        return this.horaUltimoAcceso;
    }

    public String getTelefonoOTP() {
        return this.telefonoOTP;
    }

    public String getIndMedidaSMS() {
        return this.indMedidaSMS;
    }

    public ArrayList<String> getServicioComerciables() {
        return this.servicioComerciables;
    }

    public String getTokenEmpresas() {
        return this.tokenEmpresas;
    }
}
