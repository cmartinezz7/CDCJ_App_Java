package es.santander.justicia.minisJusticia.expedientes.task;

import android.os.AsyncTask;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.expedientes.services.ExpedientesSoapService;
import java.util.ArrayList;

public class LoginExpedientesTask extends AsyncTask<Object, Object, Object> {
   private ActivityCallBack activityCallBack;
   public static final String TASK_ID = "LOGIN_EXPEDIENTES";

   public LoginExpedientesTask(ActivityCallBack activity) {
      this.activityCallBack = activity;
   }

   protected Object doInBackground(Object... params) {
      ExpedientesSoapService expedientesSoapService = new ExpedientesSoapService();
      ArrayList<ExpedienteDTO> misExpedientes = expedientesSoapService.getExpedientes();
      if (misExpedientes != null) {
         ExpedientesManager.getInstance().setExpedientes(misExpedientes);
      }

      return misExpedientes;
   }

   protected void onPostExecute(Object response) {
      this.activityCallBack.onTaskFinished("LOGIN_EXPEDIENTES", response);
   }
}
