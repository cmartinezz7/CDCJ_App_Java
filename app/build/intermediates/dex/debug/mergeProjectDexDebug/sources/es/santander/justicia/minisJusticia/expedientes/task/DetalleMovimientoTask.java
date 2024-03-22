package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.expedientes.services.DetalleMovimientoSoapService;

public class DetalleMovimientoTask extends AsyncTask<Object, Object, Object> {
    public static final String TASK_ID = "DETALLE_MOVIMIENTO";
    private ActivityCallBack activityCallBack;

    public DetalleMovimientoTask(ActivityCallBack activity) {
        this.activityCallBack = activity;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object... params) {
        return new DetalleMovimientoSoapService().getDetalleMovimiento(params[0], params[1], params[2]);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        this.activityCallBack.onTaskFinished(TASK_ID, response);
    }
}
