package es.santander.justicia.minisJusticia.login.manager;

import android.util.Base64;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import java.util.ArrayList;

public class LoginManager {
    private static LoginManager instance;
    private String codClienteTemp = null;
    private ArrayList<NoticiaActualidadDTO> newsList = new ArrayList<>();
    private String nombreUsuarioTemp = null;
    private NoticiaActualidadDTO ssdNews;
    private String tokenConTemp = null;
    private String tokenSSOTemp = null;

    public static synchronized LoginManager getInstance() {
        LoginManager loginManager;
        synchronized (LoginManager.class) {
            if (instance == null) {
                instance = new LoginManager();
            }
            loginManager = instance;
        }
        return loginManager;
    }

    public boolean isUserLogged() {
        return MainApplication.getAppContext().getUser() != null;
    }

    public boolean loginProfesional(String userType, String tokenSSO, String nombre) {
        UserDTO userDTO = new UserDTO();
        userDTO.setToken(tokenSSO);
        userDTO.setApp(UserDTO.APP_PROFESIONALES);
        userDTO.setUserType(userType);
        userDTO.setNombre(nombre);
        if (getTokenConTemp() != null) {
            if (UserDTO.USERTYPE_PARTICULARES.equals(userType)) {
                try {
                    String cod_cliente = new String(Base64.decode(new String(Base64.decode(getTokenConTemp().getBytes(), 0), "UTF-8").split("#")[3].getBytes(), 0), "UTF-8");
                    String tipoPersona = cod_cliente.substring(cod_cliente.indexOf("<tipoPersona>") + 13, cod_cliente.indexOf("</tipoPersona>"));
                    userDTO.setCodCliente(tipoPersona + "-" + cod_cliente.substring(cod_cliente.indexOf("<codigoPersona>") + 15, cod_cliente.indexOf("</codigoPersona>")));
                    setTokenConTemp((String) null);
                } catch (Exception e) {
                    Log.e("LoginManager", "Error al decodificar el token", e);
                }
            } else {
                userDTO.setCodCliente(getCodClienteTemp());
                setTokenConTemp((String) null);
                setCodClienteTemp((String) null);
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
        userDTO.setApp(UserDTO.APP_LETRADOS);
        userDTO.setNombre(nombre);
        userDTO.setCodCliente(cod_cliente);
        MainApplication.getAppContext().setUser(userDTO);
        return true;
    }

    public UserDTO getUser() {
        return MainApplication.getAppContext().getUser();
    }

    public String getToken() {
        if (MainApplication.getAppContext().getUser() != null) {
            return MainApplication.getAppContext().getUser().getToken();
        }
        return null;
    }

    public void setToken(String token) {
        if (MainApplication.getAppContext().getUser() != null) {
            MainApplication.getAppContext().getUser().setToken(token);
        }
    }

    public void logout() {
        MainApplication.getAppContext().setUser((UserDTO) null);
        this.tokenConTemp = null;
        this.tokenSSOTemp = null;
        this.nombreUsuarioTemp = null;
    }

    public String getNombreUsuario() {
        if (MainApplication.getAppContext().getUser() == null || MainApplication.getAppContext().getUser().getNombre() == null) {
            return this.nombreUsuarioTemp;
        }
        return MainApplication.getAppContext().getUser().getNombre();
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

    public void setTokenConTemp(String tokenConTemp2) {
        this.tokenConTemp = tokenConTemp2;
    }

    public String getCodClienteTemp() {
        return this.codClienteTemp;
    }

    public void setCodClienteTemp(String codClienteTemp2) {
        this.codClienteTemp = codClienteTemp2;
    }

    public String getTokenSSOTemp() {
        return this.tokenSSOTemp;
    }

    public void setTokenSSOTemp(String tokenSSOTemp2) {
        this.tokenSSOTemp = tokenSSOTemp2;
    }

    public NoticiaActualidadDTO getSsdNews() {
        return this.ssdNews;
    }

    public void setSsdNews(NoticiaActualidadDTO ssdNews2) {
        this.ssdNews = ssdNews2;
    }

    public ArrayList<NoticiaActualidadDTO> getNewsList() {
        return this.newsList;
    }

    public void setNewsList(ArrayList<NoticiaActualidadDTO> newsList2) {
        this.newsList = newsList2;
    }
}
