package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivitySearchTribunals.1;
import es.santander.justicia.minisJusticia.ActivitySearchTribunals.2;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.views.QTextView;
import java.util.ArrayList;

public class ActivitySearchTribunals extends ActivityAbstractLetrados implements OnRecyclerClickListener {
   private RecyclerView mRecycler;
   private ArrayList<DatosJuzgado> mListTribunal;
   private RelativeLayout mLayoutNoResults;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558442);
      this.iniUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/lista_juzgados");
   }

   private void iniUi() {
      ((QTextView)this.findViewById(2131362928)).setText(this.getString(2131886808));
      this.mRecycler = (RecyclerView)this.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(true);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
      this.findViewById(2131362172).setVisibility(8);
      this.mLayoutNoResults = (RelativeLayout)this.findViewById(2131362367);
      this.findViewById(2131361975).setOnClickListener(new 1(this));
      this.getJuzgados();
   }

   private void getJuzgados() {
      ConnectionBuilder.getConsultaJuzgados(this.getIntent().getStringExtra("extra_cod_provincia"), this.getIntent().getStringExtra("extra_cod_entorno_judicial")).enqueue(new 2(this, this, true, true));
   }

   private ArrayList<DatosJuzgado> removeDatosPaginacion(ArrayList<DatosJuzgado> datosJuzgados) {
      int count;
      for(count = 0; ((DatosJuzgado)datosJuzgados.get(count)).getEntornoJudicial() != null; ++count) {
      }

      datosJuzgados.remove(count);
      return datosJuzgados;
   }

   public void onItemClickListener(int position) {
      TealiumHelper.trackEvent("/lista_juzgados", "lista_juzgados (selección de juzgado)");
      Intent intent = new Intent(this, ActivityMapJuzgados.class);
      intent.putExtra("extra_juzga", ((DatosJuzgado)this.mListTribunal.get(position)).getJuzga());
      this.startActivity(intent);
   }

   // $FF: synthetic method
   static ArrayList access$002(ActivitySearchTribunals x0, ArrayList x1) {
      return x0.mListTribunal = x1;
   }

   // $FF: synthetic method
   static ArrayList access$100(ActivitySearchTribunals x0, ArrayList x1) {
      return x0.removeDatosPaginacion(x1);
   }

   // $FF: synthetic method
   static ArrayList access$000(ActivitySearchTribunals x0) {
      return x0.mListTribunal;
   }

   // $FF: synthetic method
   static RelativeLayout access$200(ActivitySearchTribunals x0) {
      return x0.mLayoutNoResults;
   }

   // $FF: synthetic method
   static RecyclerView access$300(ActivitySearchTribunals x0) {
      return x0.mRecycler;
   }
}
