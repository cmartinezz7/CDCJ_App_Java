package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityBusquedaMovimientos.1;
import es.santander.justicia.minisJusticia.ActivityBusquedaMovimientos.2;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QEditText;

public class ActivityBusquedaMovimientos extends ActivityAbstractBusqueda {
   private String mType;
   private String mMoney;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558435);
      this.getWindow().setSoftInputMode(2);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/busqueda_movimiento");
   }

   protected void defineSpinners() {
      Spinner spinenrTipo = (Spinner)this.findViewById(2131362741);
      Spinner spinenrEstado = (Spinner)this.findViewById(2131362733);
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterTipo = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnMotionQuery"));
      arrayAdapterTipo.setDropDownViewResource(2131558753);
      spinenrTipo.setAdapter(arrayAdapterTipo);
      spinenrTipo.setOnItemSelectedListener(new 1(this));
      ArrayAdapter<SpinnerValuesDTO> arrayAdapterEstado = new ArrayAdapter(this, 2131558752, 2131362922, SpinnerContentModel.getSpinnerValues("spnCoins"));
      arrayAdapterEstado.setDropDownViewResource(2131558753);
      spinenrEstado.setAdapter(arrayAdapterEstado);
      spinenrEstado.setOnItemSelectedListener(new 2(this));
   }

   protected void buscarClick() {
      if (!this.checkFields()) {
         QEditText mEditImporteDesde = (QEditText)this.findViewById(2131362119);
         QEditText mEditImporteHasta = (QEditText)this.findViewById(2131362120);
         Intent intent = new Intent();
         if (mDateDesde != null && !mDateDesde.isEmpty()) {
            intent.putExtra("extra_desde", mDateDesde);
         }

         if (mDateHasta != null && !mDateHasta.isEmpty()) {
            intent.putExtra("extra_hasta", mDateHasta);
         }

         if (mEditImporteDesde.getText() != null && !mEditImporteDesde.getText().toString().isEmpty()) {
            intent.putExtra("extra_importe_desde", mEditImporteDesde.getText().toString());
         }

         if (mEditImporteHasta.getText() != null && !mEditImporteHasta.getText().toString().isEmpty()) {
            intent.putExtra("extra_importe_hasta", mEditImporteHasta.getText().toString());
         }

         if (this.mType != null && !this.mType.isEmpty()) {
            intent.putExtra("extra_tipo_movimiento", this.mType);
         }

         if (this.mMoney != null && !this.mMoney.isEmpty()) {
            intent.putExtra("extra_moneda", this.mMoney);
         }

         this.setResult(-1, intent);
         this.finish();
      }

   }

   // $FF: synthetic method
   static String access$002(ActivityBusquedaMovimientos x0, String x1) {
      return x0.mType = x1;
   }

   // $FF: synthetic method
   static String access$102(ActivityBusquedaMovimientos x0, String x1) {
      return x0.mMoney = x1;
   }
}
