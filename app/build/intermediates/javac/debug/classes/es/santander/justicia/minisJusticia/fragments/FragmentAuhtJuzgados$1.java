package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityAltaAutorizacion;

class FragmentAuhtJuzgados$1 implements OnClickListener {
   // $FF: synthetic field
   final FragmentAuhtJuzgados this$0;

   FragmentAuhtJuzgados$1(FragmentAuhtJuzgados this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0.getActivity(), ActivityAltaAutorizacion.class);
      Bundle bundle = new Bundle();
      bundle.putString("extra_search", "extra_search");
      intent.putExtras(bundle);
      this.this$0.startActivityForResult(intent, 32);
   }
}
