package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityBusquedaAuthExpedi.1;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

public class ActivityBusquedaAuthExpedi extends ActivityAbstractBusqueda {
   private Spinner mSpinnerState;
   private String mStateCode;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558432);
      this.getWindow().setSoftInputMode(2);
      this.initUi();
   }

   protected void defineSpinners() {
      this.mSpinnerState = (Spinner)this.findViewById(2131362739);
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnAccessRequestStatus"));
      arrayAdapterSeleccion.setDropDownViewResource(2131558753);
      this.mSpinnerState.setAdapter(arrayAdapterSeleccion);
      this.mSpinnerState.setOnItemSelectedListener(new 1(this));
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

         if (this.mStateCode != null) {
            intent.putExtra("extra_state", this.mStateCode);
         }

         this.setResult(-1, intent);
         this.finish();
      }

   }

   // $FF: synthetic method
   static String access$002(ActivityBusquedaAuthExpedi x0, String x1) {
      return x0.mStateCode = x1;
   }
}
