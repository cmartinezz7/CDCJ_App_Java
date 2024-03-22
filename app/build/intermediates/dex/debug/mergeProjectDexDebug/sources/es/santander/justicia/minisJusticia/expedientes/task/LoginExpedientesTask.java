package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.expedientes.services.ExpedientesSoapService;
import java.util.ArrayList;

public class LoginExpedientesTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "LOGIN_EXPEDIENTES";
    private ActivityCallBack activityCallBack;

    public LoginExpedientesTask(ActivityCallBack activity) {
        this.activityCallBack = activity;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        ArrayList<ExpedienteDTO> misExpedientes = new ExpedientesSoapService().getExpedientes();
        if (misExpedientes != null) {
            ExpedientesManager.getInstance().setExpedientes(misExpedientes);
        }
        return misExpedientes;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished(TASK_ID, response);
    }
}
