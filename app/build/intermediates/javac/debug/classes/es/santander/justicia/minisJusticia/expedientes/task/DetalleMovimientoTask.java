package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.expedientes.services.DetalleMovimientoSoapService;

public class DetalleMovimientoTask extends AsyncTask<Object, Object, Object> {
   private ActivityCallBack activityCallBack;
   public static final String TASK_ID = "DETALLE_MOVIMIENTO";

   public DetalleMovimientoTask(ActivityCallBack activity) {
      this.activityCallBack = activity;
   }

   protected Object doInBackground(Object... params) {
      DetalleMovimientoSoapService detalleMovimientoSoapService = new DetalleMovimientoSoapService();
      MovementItemDTO movementItemDTO = (MovementItemDTO)params[0];
      String juzga = (String)params[1];
      String jnuoper = (String)params[2];
      return detalleMovimientoSoapService.getDetalleMovimiento(movementItemDTO, juzga, jnuoper);
   }

   protected void onPostExecute(Object response) {
      this.activityCallBack.onTaskFinished("DETALLE_MOVIMIENTO", response);
   }
}
