package es.santander.justicia.minisJusticia.fragments;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.ActivitySeizures;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.PlaceholderFragment;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.fragments.FragmentAdvices.1;
import es.santander.justicia.minisJusticia.fragments.FragmentAdvices.2;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.models.responses.avisos.Avisos;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.List;

public class FragmentAdvices extends PlaceholderFragment implements OnRecyclerClickListener {
   private RecyclerView mRecycler;
   private List<Avisos> mAvisosList;
   private RelativeLayout mRelativeNoAdvices;
   private boolean makeConn = true;
   private BroadcastReceiver mMessageReceiver = new 1(this);

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate(2131558566, container, false);
      this.initUi(rootView);
      this.mRelativeNoAdvices = (RelativeLayout)rootView.findViewById(2131362629);
      this.mRecycler = (RecyclerView)rootView.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(true);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
      LocalBroadcastManager.getInstance(this.getActivity()).registerReceiver(this.mMessageReceiver, new IntentFilter("user-detail-ready"));
      return rootView;
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/avisos");
   }

   public void onResume() {
      super.onResume();
      if (!((ActivityHomeLetrados)this.getActivity()).mConnIsRunning) {
         this.getCall();
      }

      this.getActivity().findViewById(2131362308).setVisibility(0);
   }

   public void onDestroy() {
      LocalBroadcastManager.getInstance(this.getActivity()).unregisterReceiver(this.mMessageReceiver);
      super.onDestroy();
   }

   private void initUi(View rootView) {
      String value = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea1");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QFontTextView)rootView.findViewById(2131362876)).setText(String.format(this.getString(2131886303), value));
      }

      String value2 = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea2");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QFontTextView)rootView.findViewById(2131362875)).setText(String.format(this.getString(2131886302), value2));
      }

   }

   private void getCall() {
      ConnectionBuilder.getAdvicesCall(PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo")).enqueue(new 2(this, this.getActivity(), true, true));
   }

   public void onItemClickListener(int position) {
      Intent intent = null;
      String var3 = ((Avisos)this.mAvisosList.get(position)).getCodAviso();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case 65214:
         if (var3.equals("AVS")) {
            var4 = 2;
         }
         break;
      case 66568:
         if (var3.equals("CDI")) {
            var4 = 3;
         }
         break;
      case 66572:
         if (var3.equals("CDM")) {
            var4 = 4;
         }
         break;
      case 66574:
         if (var3.equals("CDO")) {
            var4 = 1;
         }
         break;
      case 68424:
         if (var3.equals("EBE")) {
            var4 = 0;
         }
         break;
      case 81857:
         if (var3.equals("SAO")) {
            var4 = 5;
         }
      }

      switch(var4) {
      case 0:
         intent = new Intent(this.getActivity(), ActivitySeizures.class);
         intent.putExtra("extra_estado_embargo", "EN");
         this.startActivity(intent);
         break;
      case 1:
         intent = new Intent(this.getActivity(), ActivityDetalleOperacion.class);
         intent.putExtra("extra_juzdestino", PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"));
         intent.putExtra("extra_moneda", "EUR");
         intent.putExtra("extra_operacion", "PTE_CON");
         intent.putExtra("extra_operacion_seleccionada", "CONFIRMACIONES");
         this.startActivity(intent);
         break;
      case 2:
         ((ActivityHomeLetrados)this.getActivity()).loadAuthFromAdvices();
         break;
      case 3:
         intent = new Intent(this.getActivity(), ActivityDetalleOperacion.class);
         intent.putExtra("extra_juzdestino", PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"));
         intent.putExtra("extra_moneda", "EUR");
         intent.putExtra("extra_operacion", "PTE_ING");
         intent.putExtra("extra_operacion_seleccionada", "INGRESOS");
         this.startActivity(intent);
         break;
      case 4:
         ((ActivityHomeLetrados)this.getActivity()).loadOperationsFromAdvices();
         break;
      case 5:
         intent = new Intent(this.getActivity(), ActivityDetalleMovimiento.class);
         intent.putExtra("extra_operacion", ((Avisos)this.mAvisosList.get(position)).getCodOperacion());
         intent.putExtra("extra_organismo", ((Avisos)this.mAvisosList.get(position)).getCodOrganismo());
         this.startActivity(intent);
      }

   }

   // $FF: synthetic method
   static List access$000(FragmentAdvices x0) {
      return x0.mAvisosList;
   }

   // $FF: synthetic method
   static void access$100(FragmentAdvices x0) {
      x0.getCall();
   }

   // $FF: synthetic method
   static List access$002(FragmentAdvices x0, List x1) {
      return x0.mAvisosList = x1;
   }

   // $FF: synthetic method
   static RelativeLayout access$200(FragmentAdvices x0) {
      return x0.mRelativeNoAdvices;
   }

   // $FF: synthetic method
   static RecyclerView access$300(FragmentAdvices x0) {
      return x0.mRecycler;
   }
}
