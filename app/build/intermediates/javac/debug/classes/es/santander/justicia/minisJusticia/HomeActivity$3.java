package es.santander.justicia.minisJusticia;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import java.util.Comparator;

class HomeActivity$3 implements Comparator<ExpedienteDTO> {
   // $FF: synthetic field
   final HomeActivity this$0;

   HomeActivity$3(HomeActivity this$0) {
      this.this$0 = this$0;
   }

   public int compare(ExpedienteDTO o1, ExpedienteDTO o2) {
      return o1.getCodExpediente().compareTo(o2.getCodExpediente());
   }
}
