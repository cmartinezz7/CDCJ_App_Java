package es.santander.justicia.minisJusticia;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;

class ActivityLoginProfesionalesOld$6 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityLoginProfesionalesOld this$0;

   ActivityLoginProfesionalesOld$6(ActivityLoginProfesionalesOld this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      boolean resetData = false;
      if (ActivityLoginProfesionalesOld.access$400(this.this$0) != position) {
         resetData = true;
         ActivityLoginProfesionalesOld.access$402(this.this$0, position);
      }

      if (!ActivityLoginProfesionalesOld.access$500(this.this$0)) {
         ArrayAdapter<SpinnerValuesDTO> arrayAdapter = (ArrayAdapter)parent.getAdapter();
         SpinnerValuesDTO spnValue = (SpinnerValuesDTO)arrayAdapter.getItem(position);
         String valueCode = spnValue.getCode();
         if (resetData) {
            ActivityLoginProfesionalesOld.access$200(this.this$0);
         }

         byte var11 = -1;
         switch(valueCode.hashCode()) {
         case 67:
            if (valueCode.equals("C")) {
               var11 = 2;
            }
            break;
         case 78:
            if (valueCode.equals("N")) {
               var11 = 1;
            }
            break;
         case 80:
            if (valueCode.equals("P")) {
               var11 = 3;
            }
            break;
         case 83:
            if (valueCode.equals("S")) {
               var11 = 0;
            }
         }

         switch(var11) {
         case 0:
         case 1:
            this.this$0.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(9)});
            break;
         case 2:
         case 3:
            this.this$0.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(14)});
         }
      }

   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
