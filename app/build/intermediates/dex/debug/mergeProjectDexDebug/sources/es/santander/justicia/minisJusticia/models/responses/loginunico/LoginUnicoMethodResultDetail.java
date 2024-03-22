package es.santander.justicia.minisJusticia.models.responses.loginunico;

import es.santander.justicia.minisJusticia.models.responses.Contrato;
import es.santander.justicia.minisJusticia.models.responses.InfoDetail;
import es.santander.justicia.minisJusticia.models.responses.ServicioComerciable;
import es.santander.justicia.minisJusticia.models.responses.SupbTipoPro;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "methodResult", strict = false)
public class LoginUnicoMethodResultDetail {
    @Element(name = "aliasDuplicado", required = false)
    private String aliasDuplicado;
    @Element(name = "codDocumento", required = false)
    private String codDocumento;
    @Element(name = "estadoFirma", required = false)
    private String estadoFirma;
    @Element(name = "estadoUsuario", required = false)
    private String estadoUsuario;
    @Element(name = "fecUltFirma", required = false)
    private String fecUltFirma;
    @Element(name = "fecUltimoAcceso", required = false)
    private String fecUltimoAcceso;
    @Element(name = "firmaUsuarido", required = false)
    private String firmaUsuarido;
    @Element(name = "horaUltimoAcceso", required = false)
    private String horaUltimoAcceso;
    @Element(name = "indAltaFirma", required = false)
    private String indAltaFirma;
    @Element(name = "indApoderadoDelegado", required = false)
    private String indApoderadoDelegado;
    @Element(name = "indCaputarClave", required = false)
    private String indCaputarClave;
    @Element(name = "cliente", required = false)
    private LoginUnicoCliente loginUnicoCliente;
    @Element(name = "contrato", required = false)
    private Contrato loginUnicoContrato;
    @Element(name = "info", required = false)
    private InfoDetail loginUnicoInfoDetail;
    @Element(name = "nombreTitular", required = false)
    private String nombreTitular;
    @ElementList(name = "listaServicios", required = false)
    private ArrayList<ServicioComerciable> servicioComerciable;
    @Element(name = "subtipoProd", required = false)
    private SupbTipoPro supbTipoPro;
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

    public InfoDetail getLoginUnicoInfoDetail() {
        return this.loginUnicoInfoDetail;
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

    public LoginUnicoCliente getLoginUnicoCliente() {
        return this.loginUnicoCliente;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public Contrato getLoginUnicoContrato() {
        return this.loginUnicoContrato;
    }

    public SupbTipoPro getSupbTipoPro() {
        return this.supbTipoPro;
    }

    public String getEstadoFirma() {
        return this.estadoFirma;
    }

    public String getTipoRelacionUsu() {
        return this.tipoRelacionUsu;
    }

    public String getEstadoUsuario() {
        return this.estadoUsuario;
    }

    public String getFirmaUsuarido() {
        return this.firmaUsuarido;
    }

    public String getFecUltimoAcceso() {
        return this.fecUltimoAcceso;
    }

    public String getHoraUltimoAcceso() {
        return this.horaUltimoAcceso;
    }

    public String getFecUltFirma() {
        return this.fecUltFirma;
    }

    public String getTelefonoOTP() {
        return this.telefonoOTP;
    }

    public String getTokenEmpresas() {
        return this.tokenEmpresas;
    }

    public String getAliasDuplicado() {
        return this.aliasDuplicado;
    }

    public String getIndCaputarClave() {
        return this.indCaputarClave;
    }

    public String getIndAltaFirma() {
        return this.indAltaFirma;
    }

    public String getIndApoderadoDelegado() {
        return this.indApoderadoDelegado;
    }
}
