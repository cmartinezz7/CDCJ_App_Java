package es.santander.justicia.minisJusticia.login.manager;

import android.util.Base64;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import java.util.ArrayList;

public class LoginManager {
   private static LoginManager instance;
   private String tokenConTemp = null;
   private String tokenSSOTemp = null;
   private String nombreUsuarioTemp = null;
   private String codClienteTemp = null;
   private ArrayList<NoticiaActualidadDTO> newsList = new ArrayList();
   private NoticiaActualidadDTO ssdNews;

   public static synchronized LoginManager getInstance() {
      if (instance == null) {
         instance = new LoginManager();
      }

      return instance;
   }

   public boolean isUserLogged() {
      return MainApplication.getAppContext().getUser() != null;
   }

   public boolean loginProfesional(String userType, String tokenSSO, String nombre) {
      UserDTO userDTO = new UserDTO();
      userDTO.setToken(tokenSSO);
      userDTO.setApp("PROF");
      userDTO.setUserType(userType);
      userDTO.setNombre(nombre);
      if (this.getTokenConTemp() != null) {
         if ("PART".equals(userType)) {
            try {
               byte[] byteArray = this.getTokenConTemp().getBytes();
               byte[] tokenB64 = Base64.decode(byteArray, 0);
               String token_cod_cliente = new String(tokenB64, "UTF-8");
               String[] tokenParts = token_cod_cliente.split("#");
               byte[] tokenCDB64 = Base64.decode(tokenParts[3].getBytes(), 0);
               String cod_cliente = new String(tokenCDB64, "UTF-8");
               String tipoPersona = cod_cliente.substring(cod_cliente.indexOf("<tipoPersona>") + 13, cod_cliente.indexOf("</tipoPersona>"));
               String codigoPersona = cod_cliente.substring(cod_cliente.indexOf("<codigoPersona>") + 15, cod_cliente.indexOf("</codigoPersona>"));
               userDTO.setCodCliente(tipoPersona + "-" + codigoPersona);
               this.setTokenConTemp((String)null);
            } catch (Exception var13) {
               Log.e("LoginManager", "Error al decodificar el token", var13);
            }
         } else {
            userDTO.setCodCliente(this.getCodClienteTemp());
            this.setTokenConTemp((String)null);
            this.setCodClienteTemp((String)null);
         }
      }

      MainApplication.getAppContext().setUser(userDTO);
      this.tokenConTemp = null;
      this.tokenSSOTemp = null;
      this.nombreUsuarioTemp = null;
      return true;
   }

   public boolean loginLetrados(String tokenSSO, String nombre, String cod_cliente) {
      UserDTO userDTO = new UserDTO();
      userDTO.setToken(tokenSSO);
      userDTO.setApp("LETRA");
      userDTO.setNombre(nombre);
      userDTO.setCodCliente(cod_cliente);
      MainApplication.getAppContext().setUser(userDTO);
      return true;
   }

   public UserDTO getUser() {
      return MainApplication.getAppContext().getUser();
   }

   public String getToken() {
      return MainApplication.getAppContext().getUser() != null ? MainApplication.getAppContext().getUser().getToken() : null;
   }

   public void setToken(String token) {
      if (MainApplication.getAppContext().getUser() != null) {
         MainApplication.getAppContext().getUser().setToken(token);
      }

   }

   public void logout() {
      MainApplication.getAppContext().setUser((UserDTO)null);
      this.tokenConTemp = null;
      this.tokenSSOTemp = null;
      this.nombreUsuarioTemp = null;
   }

   public String getNombreUsuario() {
      return MainApplication.getAppContext().getUser() != null && MainApplication.getAppContext().getUser().getNombre() != null ? MainApplication.getAppContext().getUser().getNombre() : this.nombreUsuarioTemp;
   }

   public void setNombreUsuario(String nombreUsuario) {
      if (MainApplication.getAppContext().getUser() != null) {
         MainApplication.getAppContext().getUser().setNombre(nombreUsuario);
      } else {
         this.nombreUsuarioTemp = nombreUsuario;
      }

   }

   public String getTokenConTemp() {
      return this.tokenConTemp;
   }

   public void setTokenConTemp(String tokenConTemp) {
      this.tokenConTemp = tokenConTemp;
   }

   public String getCodClienteTemp() {
      return this.codClienteTemp;
   }

   public void setCodClienteTemp(String codClienteTemp) {
      this.codClienteTemp = codClienteTemp;
   }

   public String getTokenSSOTemp() {
      return this.tokenSSOTemp;
   }

   public void setTokenSSOTemp(String tokenSSOTemp) {
      this.tokenSSOTemp = tokenSSOTemp;
   }

   public NoticiaActualidadDTO getSsdNews() {
      return this.ssdNews;
   }

   public void setSsdNews(NoticiaActualidadDTO ssdNews) {
      this.ssdNews = ssdNews;
   }

   public ArrayList<NoticiaActualidadDTO> getNewsList() {
      return this.newsList;
   }

   public void setNewsList(ArrayList<NoticiaActualidadDTO> newsList) {
      this.newsList = newsList;
   }
}
