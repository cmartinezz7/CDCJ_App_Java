package es.santander.justicia.minisJusticia.login.tasks;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.login.services.DetalleUsuarioSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginProfesionalEmpresaSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginProfesionalParticularSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginSSOSoapService;
import java.util.HashMap;
import java.util.Map;

public class LoginProfesionalesTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "LOGIN_PROFESIONALES";
    private ActivityCallBack activityCallBack;

    public LoginProfesionalesTask(ActivityCallBack activity) {
        this.activityCallBack = activity;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        String userType;
        String error;
        String typeDoc = params[0];
        String documento = params[1];
        String code = params[2];
        String pass = params[3];
        LoginManager.getInstance().logout();
        if (typeDoc != null && "N".equals(typeDoc)) {
            while (documento.length() < 9) {
                documento = "0" + documento;
            }
        }
        if (code != null) {
            error = new LoginProfesionalEmpresaSoapService().login(typeDoc, documento, code, pass);
            userType = UserDTO.USERTYPE_EMPRESAS;
        } else {
            error = new LoginProfesionalParticularSoapService().login(typeDoc, documento, pass);
            userType = UserDTO.USERTYPE_PARTICULARES;
        }
        if (error == null) {
            error = new LoginSSOSoapService().loginTokenSSO(LoginManager.getInstance().getTokenConTemp(), UserDTO.USERTYPE_EMPRESAS.equals(userType) ? "E" : ActivityDetalleOperacion.CODIGO_ESTADO_P);
            if (error == null) {
                String nombre = new DetalleUsuarioSoapService().getNombreUsuario(LoginManager.getInstance().getTokenSSOTemp());
                if (nombre != null) {
                    LoginManager.getInstance().setNombreUsuario(nombre);
                }
                LoginManager.getInstance().loginProfesional(userType, LoginManager.getInstance().getTokenSSOTemp(), LoginManager.getInstance().getNombreUsuario());
            }
        }
        if (error != null || LoginManager.getInstance().getUser() == null) {
            Map<String, String> data = new HashMap<>();
            data.put(TealiumHelper.TEALIUM_PERFIL_APP, UserDTO.APP_PROFESIONALES);
            data.put(TealiumHelper.TEALIUM_PERFIL_PROFESIONAL, userType);
            TealiumHelper.trackEvent("/login", "login (ko)", data);
        } else {
            TealiumHelper.trackEvent("/login", "login (ok)");
        }
        return error;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished("LOGIN_PROFESIONALES", response);
    }
}
