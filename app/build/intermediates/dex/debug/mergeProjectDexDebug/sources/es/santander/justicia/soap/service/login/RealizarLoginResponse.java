package es.santander.justicia.soap.service.login;

import es.santander.justicia.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class RealizarLoginResponse {
    private String codigoPersona;
    private List<String> listaServiciosComerciales = new ArrayList();
    private String nombreTitular;
    private String tipoPersona;
    private String token;

    public RealizarLoginResponse(SoapObject responseSoapObject) {
        this.token = ((SoapObject) responseSoapObject.getProperty("info")).getPropertyAsString("token");
        this.nombreTitular = responseSoapObject.getPropertyAsString("nombreTitular");
        SoapObject listaServiciosObject = (SoapObject) responseSoapObject.getProperty("listaServicios");
        for (int i = 0; i < listaServiciosObject.getPropertyCount(); i++) {
            this.listaServiciosComerciales.add(listaServiciosObject.getPropertyAsString(i));
        }
        SoapObject clinteObject = (SoapObject) responseSoapObject.getProperty("cliente");
        if (clinteObject != null) {
            this.tipoPersona = clinteObject.getPropertyAsString("TIPO_DE_PERSONA");
            this.codigoPersona = clinteObject.getPropertyAsString("CODIGO_DE_PERSONA");
        }
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public String getNombreTitular() {
        return this.nombreTitular;
    }

    public void setNombreTitular(String nombreTitular2) {
        this.nombreTitular = nombreTitular2;
    }

    public List<String> getListaServiciosComerciales() {
        return this.listaServiciosComerciales;
    }

    public void setListaServiciosComerciales(List<String> listaServiciosComerciales2) {
        this.listaServiciosComerciales = listaServiciosComerciales2;
    }

    public String getTipoPersona() {
        return this.tipoPersona;
    }

    public void setTipoPersona(String tipoPersona2) {
        this.tipoPersona = tipoPersona2;
    }

    public String getCodigoPersona() {
        return this.codigoPersona;
    }

    public void setCodigoPersona(String codigoPersona2) {
        this.codigoPersona = codigoPersona2;
    }

    public boolean tieneAccesoAlServicioComercial(Constants.ServiciosComerciales servicioComercial) {
        for (String servCom : this.listaServiciosComerciales) {
            if (servCom.equalsIgnoreCase(servicioComercial.valor())) {
                return true;
            }
        }
        return false;
    }
}
