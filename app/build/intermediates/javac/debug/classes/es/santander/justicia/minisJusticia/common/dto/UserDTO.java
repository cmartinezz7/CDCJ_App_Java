package es.santander.justicia.minisJusticia.common.dto;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import java.util.ArrayList;

public class UserDTO {
   public static final String APP_PROFESIONALES = "PROF";
   public static final String APP_LETRADOS = "LETRA";
   public static final String USERTYPE_PARTICULARES = "PART";
   public static final String USERTYPE_EMPRESAS = "EMP";
   private String token;
   private String codCliente;
   private String app;
   private String userType;
   private String nombre;
   private ArrayList<ExpedienteDTO> expedientes;

   public String getToken() {
      return this.token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public String getApp() {
      return this.app;
   }

   public void setApp(String app) {
      this.app = app;
   }

   public String getUserType() {
      return this.userType;
   }

   public void setUserType(String userType) {
      this.userType = userType;
   }

   public ArrayList<ExpedienteDTO> getExpedientes() {
      return this.expedientes;
   }

   public void setExpedientes(ArrayList<ExpedienteDTO> expedientes) {
      this.expedientes = expedientes;
   }

   public String getCodCliente() {
      return this.codCliente;
   }

   public void setCodCliente(String codCliente) {
      this.codCliente = codCliente;
   }

   public String getNombre() {
      return this.nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
}
