package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityBusquedaAuthExpedi;

class FragmentAuthExp$1 implements OnClickListener {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$1(FragmentAuthExp this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      Intent intent = new Intent(this.this$0.getActivity(), ActivityBusquedaAuthExpedi.class);
      this.this$0.startActivityForResult(intent, 1);
   }
}
