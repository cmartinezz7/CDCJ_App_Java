package es.santander.justicia.minisJusticia.tasks;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.login.services.DetalleUsuarioSoapService;
import es.santander.justicia.minisJusticia.login.services.LoginSSOSoapService;

public class MergeloginUnicoTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "MERGE_LOGIN_UNICO";
    private ActivityCallBack activityCallBack;
    private String token;

    public MergeloginUnicoTask(ActivityCallBack activity, String token2) {
        this.activityCallBack = activity;
        this.token = token2;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        String error = new LoginSSOSoapService().loginTokenSSO(this.token, "E");
        if (error == null) {
            String nombre = new DetalleUsuarioSoapService().getNombreUsuario(LoginManager.getInstance().getTokenSSOTemp());
            if (nombre != null) {
                LoginManager.getInstance().setNombreUsuario(nombre);
            }
            LoginManager.getInstance().loginProfesional("E", LoginManager.getInstance().getTokenSSOTemp(), LoginManager.getInstance().getNombreUsuario());
        }
        return error;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished(TASK_ID, response);
    }
}
