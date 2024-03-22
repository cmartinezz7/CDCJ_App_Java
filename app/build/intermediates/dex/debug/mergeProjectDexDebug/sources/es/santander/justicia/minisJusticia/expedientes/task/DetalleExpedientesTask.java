package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;

public class DetalleExpedientesTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "DETALLE_EXPEDIENTES";
    private ActivityCallBack activityCallBack;

    public DetalleExpedientesTask(ActivityCallBack activity) {
        this.activityCallBack = activity;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        ExpedientesManager.getInstance().recuperarDetalleExpediente(params[0]);
        return params[1];
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished(TASK_ID, response);
    }
}
