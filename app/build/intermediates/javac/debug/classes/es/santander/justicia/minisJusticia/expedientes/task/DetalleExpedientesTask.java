package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;

public class DetalleExpedientesTask extends AsyncTask<Object, Object, Object> {
   private ActivityCallBack activityCallBack;
   public static final String TASK_ID = "DETALLE_EXPEDIENTES";

   public DetalleExpedientesTask(ActivityCallBack activity) {
      this.activityCallBack = activity;
   }

   protected Object doInBackground(Object... params) {
      ExpedienteDTO expedienteDTO = (ExpedienteDTO)params[0];
      ExpedientesManager.getInstance().recuperarDetalleExpediente(expedienteDTO);
      return params[1];
   }

   protected void onPostExecute(Object response) {
      this.activityCallBack.onTaskFinished("DETALLE_EXPEDIENTES", response);
   }
}
