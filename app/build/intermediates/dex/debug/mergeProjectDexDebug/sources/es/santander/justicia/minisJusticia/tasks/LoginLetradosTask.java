package es.santander.justicia.minisJusticia.tasks;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.login.services.LoginProfesionalEmpresaSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginProfesionalParticularSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginSSOSoapService;

public class LoginLetradosTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "LOGIN_PROFESIONALES";
    private ActivityCallBack activityCallBack;

    public LoginLetradosTask(ActivityCallBack activity) {
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
        if (code != null) {
            error = new LoginProfesionalEmpresaSoapService().login(typeDoc, documento, code, pass);
            userType = UserDTO.USERTYPE_EMPRESAS;
        } else {
            error = new LoginProfesionalParticularSoapService().login(typeDoc, documento, pass);
            userType = UserDTO.USERTYPE_PARTICULARES;
        }
        if (error != null) {
            return error;
        }
        return new LoginSSOSoapService().loginTokenSSO(LoginManager.getInstance().getTokenConTemp(), UserDTO.USERTYPE_EMPRESAS.equals(userType) ? "E" : ActivityDetalleOperacion.CODIGO_ESTADO_P);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished("LOGIN_PROFESIONALES", response);
    }
}
