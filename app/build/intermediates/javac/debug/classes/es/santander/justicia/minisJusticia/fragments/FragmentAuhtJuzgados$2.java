package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion;

class FragmentAuhtJuzgados$2 implements OnClickListener {
   // $FF: synthetic field
   final FragmentAuhtJuzgados this$0;

   FragmentAuhtJuzgados$2(FragmentAuhtJuzgados this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0.getActivity(), ActivityAltaAutorizacion.class);
      this.this$0.startActivity(intent);
   }
}
