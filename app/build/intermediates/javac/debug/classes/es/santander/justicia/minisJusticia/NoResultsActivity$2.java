package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;

class NoResultsActivity$2 implements OnClickListener {
   // $FF: synthetic field
   final NoResultsActivity this$0;

   NoResultsActivity$2(NoResultsActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      this.this$0.startActivity(NoResultsActivity.access$000(this.this$0));
      this.this$0.finish();
   }
}
