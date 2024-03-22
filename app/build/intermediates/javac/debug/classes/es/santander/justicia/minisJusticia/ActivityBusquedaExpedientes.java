package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityBusquedaExpedientes.1;
import es.santander.justicia.minisJusticia.ActivityBusquedaExpedientes.2;
import es.santander.justicia.minisJusticia.ActivityBusquedaExpedientes.3;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

public class ActivityBusquedaExpedientes extends ActivityAbstractBusqueda {
   private Spinner mSpinenrTipoSeleccion;
   private Spinner mSpinenrSituacion;
   private Spinner mSpinenrMoneda;
   private String mTipoSeleccion;
   private String mSituacion;
   private String mMoneda;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558434);
      this.getWindow().setSoftInputMode(2);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/busqueda_expediente");
   }

   protected void defineSpinners() {
      mTextDateTo.setClickable(false);
      mTextDateFrom.setClickable(false);
      this.findViewById(2131362341).setClickable(false);
      this.findViewById(2131362340).setClickable(false);
      this.mSpinenrTipoSeleccion = (Spinner)this.findViewById(2131362737);
      this.mSpinenrSituacion = (Spinner)this.findViewById(2131362738);
      this.mSpinenrMoneda = (Spinner)this.findViewById(2131362733);
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnSelectionTypeExpedient"));
      arrayAdapterSeleccion.setDropDownViewResource(2131558753);
      this.mSpinenrTipoSeleccion.setAdapter(arrayAdapterSeleccion);
      this.mSpinenrTipoSeleccion.setOnItemSelectedListener(new 1(this));
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterSituacion = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnCaseFileStatus"));
      arrayAdapterSituacion.setDropDownViewResource(2131558753);
      this.mSpinenrSituacion.setAdapter(arrayAdapterSituacion);
      this.mSpinenrSituacion.setOnItemSelectedListener(new 2(this));
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterMoneda = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnCoins"));
      arrayAdapterMoneda.setDropDownViewResource(2131558753);
      this.mSpinenrMoneda.setAdapter(arrayAdapterMoneda);
      this.mSpinenrMoneda.setOnItemSelectedListener(new 3(this));
   }

   protected void buscarClick() {
      if (!this.checkFields()) {
         Intent intent = new Intent();
         if (this.mTextJuzga.getText() != null && !this.mTextJuzga.getText().toString().isEmpty()) {
            intent.putExtra("extra_juzga", this.mTextJuzga.getText().toString());
         }

         if (this.mEditJuzori.getText() != null && !this.mEditJuzori.getText().toString().isEmpty()) {
            intent.putExtra("extra_juzgori", this.mEditJuzori.getText().toString());
         }

         if (this.mEditJproced.getText() != null && !this.mEditJproced.getText().toString().isEmpty()) {
            intent.putExtra("extra_jproced", this.mEditJproced.getText().toString().toUpperCase());
         }

         if (this.mEditJnumexp.getText() != null && !this.mEditJnumexp.getText().toString().isEmpty()) {
            intent.putExtra("extra_jnumexp", this.mEditJnumexp.getText().toString());
         }

         if (this.mEditJanoapex.getText() != null && !this.mEditJanoapex.getText().toString().isEmpty()) {
            intent.putExtra("extra_janoapex", this.mEditJanoapex.getText().toString());
         }

         if (this.mTipoSeleccion != null) {
            intent.putExtra("extra_tipo_seleccion", this.mTipoSeleccion);
         }

         if (this.mSituacion != null) {
            intent.putExtra("extra_state", this.mSituacion);
         }

         if (this.mMoneda != null) {
            intent.putExtra("extra_moneda", this.mMoneda);
         }

         if (mDateDesde != null) {
            intent.putExtra("extra_desde", mDateDesde);
         }

         if (mDateHasta != null) {
            intent.putExtra("extra_hasta", mDateHasta);
         }

         this.setResult(-1, intent);
         this.finish();
      }

   }

   // $FF: synthetic method
   static String access$002(ActivityBusquedaExpedientes x0, String x1) {
      return x0.mTipoSeleccion = x1;
   }

   // $FF: synthetic method
   static String access$102(ActivityBusquedaExpedientes x0, String x1) {
      return x0.mSituacion = x1;
   }

   // $FF: synthetic method
   static String access$202(ActivityBusquedaExpedientes x0, String x1) {
      return x0.mMoneda = x1;
   }
}
