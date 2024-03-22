package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import es.santander.justicia.minisJusticia.ActivityDetallesNoticia;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;

class NoticiasActualidadFragment$1 implements OnItemClickListener {
   // $FF: synthetic field
   final NoticiasActualidadFragment this$0;

   NoticiasActualidadFragment$1(NoticiasActualidadFragment this$0) {
      this.this$0 = this$0;
   }

   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      NoticiaActualidadDTO newsDetail = (NoticiaActualidadDTO)parent.getItemAtPosition(position);
      Bundle noticia = new Bundle();
      noticia.putParcelable("noticia", newsDetail);
      Intent intent = new Intent(this.this$0.getActivity(), ActivityDetallesNoticia.class);
      intent.putExtra("noticia", newsDetail);
      this.this$0.startActivity(intent);
   }
}
