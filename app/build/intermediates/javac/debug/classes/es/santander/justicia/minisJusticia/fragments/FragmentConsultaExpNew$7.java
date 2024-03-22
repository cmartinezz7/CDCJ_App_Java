package es.santander.justicia.minisJusticia.fragments;

import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;

class FragmentConsultaExpNew$7 implements DialogSolicitudCalback {
   // $FF: synthetic field
   final FragmentConsultaExpNew this$0;

   FragmentConsultaExpNew$7(FragmentConsultaExpNew this$0) {
      this.this$0 = this$0;
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      DatosExpedienteNew datosExpedienteNew = (DatosExpedienteNew)this.this$0.mItems.get(position);
      FragmentConsultaExpNew.access$400(this.this$0, datosExpedienteNew.getJanoapex(), datosExpedienteNew.getJnumexp(), datosExpedienteNew.getJuzga(), datosExpedienteNew.getJuzgori(), datosExpedienteNew.getJproced(), datosExpedienteNew.getCodExpAlt(), datosExpedienteNew.getCodmon(), pass);
   }
}
