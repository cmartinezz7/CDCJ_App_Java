package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

class EnciclopediaFragment$5 implements OnClickListener {
   // $FF: synthetic field
   final EnciclopediaFragment this$0;

   EnciclopediaFragment$5(EnciclopediaFragment this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      int childcount = ((LinearLayout)v).getChildCount();
      String url = "";

      for(int i = 0; i < childcount; ++i) {
         View childView = ((LinearLayout)v).getChildAt(i);
         url = ((TextView)childView).getText().toString();
      }

      if (!url.startsWith("https://") && !url.startsWith("http://")) {
         url = "http://" + url;
      }

      Intent toEnc = new Intent("android.intent.action.VIEW");
      toEnc.setData(Uri.parse(url));
      this.this$0.startActivity(toEnc);
   }
}
