package es.santander.justicia.minisJusticia;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

class ActivityLoginLetrados$5 implements TextWatcher {
   // $FF: synthetic field
   final Button val$buttonEntrar;
   // $FF: synthetic field
   final ActivityLoginLetrados this$0;

   ActivityLoginLetrados$5(ActivityLoginLetrados this$0, Button var2) {
      this.this$0 = this$0;
      this.val$buttonEntrar = var2;
   }

   public void beforeTextChanged(CharSequence s, int start, int count, int after) {
   }

   public void onTextChanged(CharSequence s, int start, int before, int count) {
   }

   public void afterTextChanged(Editable s) {
      if (!ActivityLoginLetrados.access$100(this.this$0).getText().toString().isEmpty() && !ActivityLoginLetrados.access$200(this.this$0).getText().toString().isEmpty() && !ActivityLoginLetrados.access$300(this.this$0).getText().toString().isEmpty()) {
         this.val$buttonEntrar.setEnabled(true);
      } else {
         this.val$buttonEntrar.setEnabled(false);
      }

   }
}
