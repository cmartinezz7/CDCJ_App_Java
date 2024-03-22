package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityBusquedaEmbargos.1;
import es.santander.justicia.minisJusticia.ActivityBusquedaEmbargos.2;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QEditText;

public class ActivityBusquedaEmbargos extends ActivityAbstractBusqueda {
   private String mTipoEmbargo;
   private String mEstadoEmbargo;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558433);
      this.getWindow().setSoftInputMode(2);
      this.initUi();
      this.mEditJuzori.requestFocus();
   }

   protected void defineSpinners() {
      Spinner spinenrTipo = (Spinner)this.findViewById(2131362741);
      Spinner spinenrEstado = (Spinner)this.findViewById(2131362739);
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterTipo = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnTipoEmbargo"));
      arrayAdapterTipo.setDropDownViewResource(2131558753);
      spinenrTipo.setAdapter(arrayAdapterTipo);
      spinenrTipo.setOnItemSelectedListener(new 1(this));
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterEstado = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnEstadoEmbargo"));
      arrayAdapterEstado.setDropDownViewResource(2131558753);
      spinenrEstado.setAdapter(arrayAdapterEstado);
      spinenrEstado.setOnItemSelectedListener(new 2(this));
   }

   protected void buscarClick() {
      if (!this.checkFields()) {
         QEditText mEditImporteDesde = (QEditText)this.findViewById(2131362119);
         QEditText mEditImporteHasta = (QEditText)this.findViewById(2131362120);
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

         if (this.mTipoEmbargo != null) {
            intent.putExtra("extra_tipo_embargo", this.mTipoEmbargo);
         }

         if (this.mEstadoEmbargo != null) {
            intent.putExtra("extra_estado_embargo", this.mEstadoEmbargo);
         }

         if (mEditImporteDesde.getText() != null && !mEditImporteDesde.getText().toString().isEmpty()) {
            intent.putExtra("extra_importe_desde", mEditImporteDesde.getText().toString());
         }

         if (mEditImporteHasta.getText() != null && !mEditImporteHasta.getText().toString().isEmpty()) {
            intent.putExtra("extra_importe_hasta", mEditImporteHasta.getText().toString());
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
   static String access$002(ActivityBusquedaEmbargos x0, String x1) {
      return x0.mTipoEmbargo = x1;
   }

   // $FF: synthetic method
   static String access$102(ActivityBusquedaEmbargos x0, String x1) {
      return x0.mEstadoEmbargo = x1;
   }
}
