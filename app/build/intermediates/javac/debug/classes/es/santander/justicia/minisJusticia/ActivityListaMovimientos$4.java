package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.expedientes.task.DetalleMovimientoTask;

class ActivityListaMovimientos$4 implements OnItemClickListener {
   // $FF: synthetic field
   final ActivityListaMovimientos this$0;

   ActivityListaMovimientos$4(ActivityListaMovimientos this$0) {
      this.this$0 = this$0;
   }

   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      MovementItemDTO movementItem = (MovementItemDTO)ActivityListaMovimientos.access$400(this.this$0).getAdapter().getItem(position);
      ExpedienteDTO expedienteDTO = ExpedientesManager.getInstance().findExpedienteByNumExp(ActivityListaMovimientos.access$000());
      if (movementItem != null) {
         if (movementItem.isDetail()) {
            this.this$0.onTaskFinished("DETALLE_MOVIMIENTO", movementItem);
         } else {
            this.this$0.showProgressDialog(2131886518);
            DetalleMovimientoTask detalleMovimientoTask = new DetalleMovimientoTask(ActivityListaMovimientos.access$500(this.this$0));
            detalleMovimientoTask.execute(new Object[]{movementItem, expedienteDTO.getJuzga(), movementItem.getJnuoper()});
         }
      }

   }
}
