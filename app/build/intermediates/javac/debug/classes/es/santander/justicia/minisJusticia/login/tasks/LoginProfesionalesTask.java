package es.santander.justicia.minisJusticia.login.tasks;

import android.os.AsyncTask;
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
   private ActivityCallBack activityCallBack;
   public static final String TASK_ID = "LOGIN_PROFESIONALES";

   public LoginProfesionalesTask(ActivityCallBack activity) {
      this.activityCallBack = activity;
   }

   protected Object doInBackground(Object... params) {
      String typeDoc = (String)params[0];
      String documento = (String)params[1];
      String code = (String)params[2];
      String pass = (String)params[3];
      String error = null;
      String userType = null;
      LoginManager.getInstance().logout();
      if (typeDoc != null && "N".equals(typeDoc)) {
         while(documento.length() < 9) {
            documento = "0" + documento;
         }
      }

      if (code != null) {
         LoginProfesionalEmpresaSoapService loginProfesionalEmpresaSoapService = new LoginProfesionalEmpresaSoapService();
         error = loginProfesionalEmpresaSoapService.login(typeDoc, documento, code, pass);
         userType = "EMP";
      } else {
         LoginProfesionalParticularSoapService loginProfesionalparticularSoapService = new LoginProfesionalParticularSoapService();
         error = loginProfesionalparticularSoapService.login(typeDoc, documento, pass);
         userType = "PART";
      }

      if (error == null) {
         LoginSSOSoapService loginSSOSoapService = new LoginSSOSoapService();
         error = loginSSOSoapService.loginTokenSSO(LoginManager.getInstance().getTokenConTemp(), "EMP".equals(userType) ? "E" : "P");
         if (error == null) {
            DetalleUsuarioSoapService setalleUsuarioSoapService = new DetalleUsuarioSoapService();
            String nombre = setalleUsuarioSoapService.getNombreUsuario(LoginManager.getInstance().getTokenSSOTemp());
            if (nombre != null) {
               LoginManager.getInstance().setNombreUsuario(nombre);
            }

            LoginManager.getInstance().loginProfesional(userType, LoginManager.getInstance().getTokenSSOTemp(), LoginManager.getInstance().getNombreUsuario());
         }
      }

      if (error == null && LoginManager.getInstance().getUser() != null) {
         TealiumHelper.trackEvent("/login", "login (ok)");
      } else {
         Map<String, String> data = new HashMap();
         data.put("perfil_app", "PROF");
         data.put("perfil_profesional", userType);
         TealiumHelper.trackEvent("/login", "login (ko)", data);
      }

      return error;
   }

   protected void onPostExecute(Object response) {
      this.activityCallBack.onTaskFinished("LOGIN_PROFESIONALES", response);
   }
}
