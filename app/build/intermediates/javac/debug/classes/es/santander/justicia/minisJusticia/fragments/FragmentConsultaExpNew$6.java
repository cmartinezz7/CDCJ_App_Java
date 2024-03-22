package es.santander.justicia.minisJusticia.fragments;

import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import java.util.Comparator;

class FragmentConsultaExpNew$6 implements Comparator<DatosExpedienteNew> {
   // $FF: synthetic field
   final FragmentConsultaExpNew this$0;

   FragmentConsultaExpNew$6(FragmentConsultaExpNew this$0) {
      this.this$0 = this$0;
   }

   public int compare(DatosExpedienteNew o1, DatosExpedienteNew o2) {
      return o1.getCodExpediente().compareTo(o2.getCodExpediente());
   }
}
