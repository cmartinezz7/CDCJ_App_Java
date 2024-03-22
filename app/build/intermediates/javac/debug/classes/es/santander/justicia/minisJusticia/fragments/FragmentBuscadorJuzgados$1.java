package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import java.util.ArrayList;

class FragmentBuscadorJuzgados$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ArrayList val$spinnerProvinces;
   // $FF: synthetic field
   final FragmentBuscadorJuzgados this$0;

   FragmentBuscadorJuzgados$1(FragmentBuscadorJuzgados this$0, ArrayList var2) {
      this.this$0 = this$0;
      this.val$spinnerProvinces = var2;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      FragmentBuscadorJuzgados.access$002(this.this$0, ((SpinnerValuesDTO)this.val$spinnerProvinces.get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
