package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivitySelectTribunal.1;
import es.santander.justicia.minisJusticia.ActivitySelectTribunal.2;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganoAsignadoDetail;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;

public class ActivitySelectTribunal extends ActivityAbstractLetrados implements OnRecyclerClickListener {
   private RecyclerView mRecycler;
   private ArrayList<ConsultaOrganoAsignadoDetail> mListTribunal;
   private PreferencesHelper mPreferenceHelper;

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
      ((QTextView)this.findViewById(2131362928)).setText(this.getString(2131886761));
      this.mPreferenceHelper = PreferencesHelper.newInstance(this);
      this.mRecycler = (RecyclerView)this.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(true);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
      this.findViewById(2131362172).setVisibility(8);
      this.callConsultaOrganosAsignados();
   }

   private void callSelectTribunal(String codUoSelected, int position) {
      TealiumHelper.trackEvent("/lista_juzgados", "lista_juzgados (selección de juzgado)");
      ConnectionBuilder.getCambiarOrganismoCall(codUoSelected).enqueue(new 1(this, this, true, true, position));
   }

   private void callConsultaOrganosAsignados() {
      ConnectionBuilder.getConsultaOrganosAsigandosCall().enqueue(new 2(this, this, true, true));
   }

   public void onItemClickListener(int position) {
      this.callSelectTribunal(((ConsultaOrganoAsignadoDetail)this.mListTribunal.get(position)).getCodUo(), position);
   }

   private void orderTribunals() {
      int indexTribunal = -1;

      for(int i = 0; i < this.mListTribunal.size(); ++i) {
         if (((ConsultaOrganoAsignadoDetail)this.mListTribunal.get(i)).getCodUo().equals(this.mPreferenceHelper.getString("preference_cod_uo"))) {
            indexTribunal = i;
            break;
         }
      }

      if (indexTribunal != -1) {
         ConsultaOrganoAsignadoDetail consultaOrganimosAsignadoCodUo = (ConsultaOrganoAsignadoDetail)this.mListTribunal.get(indexTribunal);
         this.mListTribunal.remove(indexTribunal);
         this.mListTribunal.add(0, consultaOrganimosAsignadoCodUo);
      }

   }

   // $FF: synthetic method
   static ArrayList access$000(ActivitySelectTribunal x0) {
      return x0.mListTribunal;
   }

   // $FF: synthetic method
   static PreferencesHelper access$100(ActivitySelectTribunal x0) {
      return x0.mPreferenceHelper;
   }

   // $FF: synthetic method
   static RecyclerView access$200(ActivitySelectTribunal x0) {
      return x0.mRecycler;
   }

   // $FF: synthetic method
   static ArrayList access$002(ActivitySelectTribunal x0, ArrayList x1) {
      return x0.mListTribunal = x1;
   }

   // $FF: synthetic method
   static void access$300(ActivitySelectTribunal x0) {
      x0.orderTribunals();
   }
}
