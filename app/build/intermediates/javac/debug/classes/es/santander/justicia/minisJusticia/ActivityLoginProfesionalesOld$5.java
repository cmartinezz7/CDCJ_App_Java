package es.santander.justicia.minisJusticia;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;

class ActivityLoginProfesionalesOld$5 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityLoginProfesionalesOld this$0;

   ActivityLoginProfesionalesOld$5(ActivityLoginProfesionalesOld this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      boolean resetData = false;
      if (ActivityLoginProfesionalesOld.access$100(this.this$0) != position) {
         resetData = true;
         ActivityLoginProfesionalesOld.access$102(this.this$0, position);
      }

      switch(position) {
      case 0:
         this.this$0.secondSpinnerContainer.setVisibility(0);
         if (resetData) {
            ActivityLoginProfesionalesOld.access$200(this.this$0);
         }

         this.this$0.spnDocumentTypes.setSelection(0);
         this.this$0.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(9)});
         ActivityLoginProfesionalesOld.access$302(this.this$0, true);
         break;
      case 1:
         this.this$0.secondSpinnerContainer.setVisibility(8);
         if (resetData) {
            ActivityLoginProfesionalesOld.access$200(this.this$0);
         }

         this.this$0.etDocumentNumber.setHint(2131886474);
         this.this$0.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(20)});
         ActivityLoginProfesionalesOld.access$302(this.this$0, false);
      }

   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
