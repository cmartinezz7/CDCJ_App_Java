package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivitySearchTribunals;

class FragmentBuscadorJuzgados$3 implements OnClickListener {
   // $FF: synthetic field
   final FragmentBuscadorJuzgados this$0;

   FragmentBuscadorJuzgados$3(FragmentBuscadorJuzgados this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0.getActivity(), ActivitySearchTribunals.class);
      intent.putExtra("extra_cod_provincia", FragmentBuscadorJuzgados.access$000(this.this$0));
      intent.putExtra("extra_cod_entorno_judicial", FragmentBuscadorJuzgados.access$100(this.this$0));
      this.this$0.startActivity(intent);
   }
}
