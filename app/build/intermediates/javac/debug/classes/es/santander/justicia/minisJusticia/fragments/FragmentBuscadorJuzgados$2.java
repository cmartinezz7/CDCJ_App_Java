package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import java.util.ArrayList;

class FragmentBuscadorJuzgados$2 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ArrayList val$spinerEnvironment;
   // $FF: synthetic field
   final FragmentBuscadorJuzgados this$0;

   FragmentBuscadorJuzgados$2(FragmentBuscadorJuzgados this$0, ArrayList var2) {
      this.this$0 = this$0;
      this.val$spinerEnvironment = var2;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      FragmentBuscadorJuzgados.access$102(this.this$0, ((SpinnerValuesDTO)this.val$spinerEnvironment.get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
