package es.santander.justicia.minisJusticia.common.dto;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import java.util.ArrayList;

public class UserDTO {
    public static final String APP_LETRADOS = "LETRA";
    public static final String APP_PROFESIONALES = "PROF";
    public static final String USERTYPE_EMPRESAS = "EMP";
    public static final String USERTYPE_PARTICULARES = "PART";
    private String app;
    private String codCliente;
    private ArrayList<ExpedienteDTO> expedientes;
    private String nombre;
    private String token;
    private String userType;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public String getApp() {
        return this.app;
    }

    public void setApp(String app2) {
        this.app = app2;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType2) {
        this.userType = userType2;
    }

    public ArrayList<ExpedienteDTO> getExpedientes() {
        return this.expedientes;
    }

    public void setExpedientes(ArrayList<ExpedienteDTO> expedientes2) {
        this.expedientes = expedientes2;
    }

    public String getCodCliente() {
        return this.codCliente;
    }

    public void setCodCliente(String codCliente2) {
        this.codCliente = codCliente2;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre2) {
        this.nombre = nombre2;
    }
}
