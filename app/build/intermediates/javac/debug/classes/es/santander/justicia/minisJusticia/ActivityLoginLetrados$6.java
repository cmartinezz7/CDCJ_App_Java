package es.santander.justicia.minisJusticia;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;

class ActivityLoginLetrados$6 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityLoginLetrados this$0;

   ActivityLoginLetrados$6(ActivityLoginLetrados this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      switch(position) {
      case 0:
         ActivityLoginLetrados.access$200(this.this$0).setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(14)});
         break;
      case 1:
      case 2:
      case 3:
         ActivityLoginLetrados.access$200(this.this$0).setFilters(new InputFilter[]{new RegexInputFilter("^[a-zA-Z0-9]*$"), new LengthFilter(9)});
      }

      ActivityLoginLetrados.access$200(this.this$0).setText("");
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
