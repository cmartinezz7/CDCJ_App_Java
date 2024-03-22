package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.view.View;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.adapters.AdapterOperaciones;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations.1;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations.2;
import es.santander.justicia.minisJusticia.models.responses.OperacionGlobal;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;

public class FragmentOperations extends FragmentAbstractListados<OperacionGlobal> implements OnRecyclerClickListener {
   public static final String PTE_COB = "PTE_COB";
   public static final String PTE_CON = "PTE_CON";
   public static final String PTE_ING = "PTE_ING";
   public static final String DE = "DE";
   public static final String MANDAMIENTO_DE_PAGO = "PGM";
   public static final String IN = "IN";
   public static final String INGRESO_EJECUTADO = "PGI";
   public static final String COBROS = "COBROS";
   public static final String INGRESOS = "INGRESOS";
   public static final String CONFIRMACIONES = "CONFIRMACIONES";

   protected void initUi(View view) {
      if (this.getArguments().getInt("section_number") == 2131886584) {
         TealiumHelper.trackView("/operaciones_ejecutadas");
         this.getDoneOperations();
      } else {
         TealiumHelper.trackView("/operaciones_pendientes");
         this.getPendintOperations();
      }

      view.findViewById(2131362172).setVisibility(8);
   }

   private void showOperations(ArrayList<OperacionGlobal> operacionGlobals, int type) {
      this.mItems = operacionGlobals;
      this.mRecycler.setAdapter(new AdapterOperaciones(this.getActivity(), this, this.mItems, type));
   }

   private void getDoneOperations() {
      ConnectionBuilder.getOpeEjectConsultaCall(PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"), "EUR", 5).enqueue(new 1(this, this.getActivity(), true, true));
   }

   private void getPendintOperations() {
      ConnectionBuilder.getOpePendientesConsultaCall(PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo")).enqueue(new 2(this, this.getActivity(), true, true));
   }

   public void onItemClickListener(int position) {
      Intent intent = new Intent(this.getActivity(), ActivityDetalleOperacion.class);
      intent.putExtra("extra_juzdestino", PreferencesHelper.newInstance(this.getActivity()).getString("preference_cod_uo"));
      intent.putExtra("extra_moneda", ((OperacionGlobal)this.mItems.get(position)).getCodmon());
      String var3 = ((OperacionGlobal)this.mItems.get(position)).getTipoOpe();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case 2177:
         if (var3.equals("DE")) {
            var4 = 3;
         }
         break;
      case 2341:
         if (var3.equals("IN")) {
            var4 = 4;
         }
         break;
      case 457319128:
         if (var3.equals("PTE_COB")) {
            var4 = 0;
         }
         break;
      case 457319140:
         if (var3.equals("PTE_CON")) {
            var4 = 1;
         }
         break;
      case 457324868:
         if (var3.equals("PTE_ING")) {
            var4 = 2;
         }
      }

      switch(var4) {
      case 0:
         intent.putExtra("extra_operacion_seleccionada", "COBROS");
         break;
      case 1:
         intent.putExtra("extra_operacion_seleccionada", "CONFIRMACIONES");
         break;
      case 2:
         intent.putExtra("extra_operacion_seleccionada", "INGRESOS");
         break;
      case 3:
         intent.putExtra("extra_operacion", "PGM");
         break;
      case 4:
         intent.putExtra("extra_operacion", "PGI");
         break;
      default:
         intent.putExtra("extra_operacion", ((OperacionGlobal)this.mItems.get(position)).getTipoOpe());
      }

      this.startActivity(intent);
   }

   // $FF: synthetic method
   static void access$000(FragmentOperations x0, ArrayList x1, int x2) {
      x0.showOperations(x1, x2);
   }
}
