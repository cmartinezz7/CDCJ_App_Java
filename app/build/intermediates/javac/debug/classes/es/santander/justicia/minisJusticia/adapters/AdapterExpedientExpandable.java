package es.santander.justicia.minisJusticia.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.1;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AdapterExpedientExpandable extends BaseExpandableListAdapter {
   private Activity context;
   private ArrayList<ExpedienteDTO> listaExpedientes;
   public String barra;
   public ContextCompat contextCompact;
   private ArrayList<String> spinnerData;
   private String numExpediente;
   private ExpandableListView expandableListView;

   public AdapterExpedientExpandable(Activity context, ArrayList<ExpedienteDTO> listaExpedientes, ExpandableListView expListView) {
      this.context = context;
      this.listaExpedientes = listaExpedientes;
      this.expandableListView = expListView;
   }

   public List<SaldoDTO> getSaldos(ExpedienteDTO expedienteDTO) {
      List<SaldoDTO> saldos = null;
      if (expedienteDTO.isDetail()) {
         saldos = expedienteDTO.getSaldos();
      }

      if (saldos == null) {
         saldos = new ArrayList();
      }

      return (List)saldos;
   }

   public Object getChild(int groupPosition, int childPosition) {
      List<SaldoDTO> saldos = this.getSaldos((ExpedienteDTO)this.listaExpedientes.get(groupPosition));
      return saldos != null ? saldos.get(childPosition) : null;
   }

   public long getChildId(int groupPosition, int childPosition) {
      return (long)childPosition;
   }

   public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
      SaldoDTO saldoDTO = (SaldoDTO)this.getChild(groupPosition, childPosition);
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder childHolder = new es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder(this);
      if (convertView == null) {
         convertView = LayoutInflater.from(this.context).inflate(2131558732, parent, false);
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$002(childHolder, (Button)convertView.findViewById(2131361946));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$102(childHolder, (TextView)convertView.findViewById(2131363080));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$202(childHolder, (TextView)convertView.findViewById(2131363046));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$302(childHolder, (TextView)convertView.findViewById(2131363023));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$402(childHolder, (TextView)convertView.findViewById(2131363032));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$502(childHolder, (TextView)convertView.findViewById(2131363033));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$602(childHolder, (TextView)convertView.findViewById(2131363045));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$702(childHolder, (TextView)convertView.findViewById(2131363047));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$802(childHolder, (TextView)convertView.findViewById(2131363050));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$902(childHolder, (TextView)convertView.findViewById(2131363048));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$1002(childHolder, (TextView)convertView.findViewById(2131363036));
         convertView.setTag(childHolder);
      } else {
         childHolder = (es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder)convertView.getTag();
      }

      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$100(childHolder).setText("CANTIDADES EN " + saldoDTO.getMoneda());
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$200(childHolder).setText(CommonUtils.formatImport(saldoDTO.getSaldodia()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$300(childHolder).setText(CommonUtils.formatImport(saldoDTO.getIngpendconso()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$400(childHolder).setText(CommonUtils.formatImport(saldoDTO.getPagopendconso()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$500(childHolder).setText(CommonUtils.formatImport(saldoDTO.getPagopendconf()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$600(childHolder).setText(CommonUtils.formatImport(saldoDTO.getSaldoconso()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$700(childHolder).setText(CommonUtils.formatImport(saldoDTO.getSaldodisp()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$800(childHolder).setText(CommonUtils.formatImport(saldoDTO.getSaldoingdeposito()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$900(childHolder).setText(CommonUtils.formatImport(saldoDTO.getSaldoingerroneo()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$1000(childHolder).setText(CommonUtils.formatImport(saldoDTO.getPrincipal()));
      String status = ((ExpedienteDTO)this.listaExpedientes.get(groupPosition)).getSituacion();
      if (isLastChild) {
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$000(childHolder).setVisibility(0);
      } else {
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$000(childHolder).setVisibility(8);
      }

      Log.i("ExpedienteExtensible", "Expdiente visualizado: " + ((ExpedienteDTO)this.listaExpedientes.get(groupPosition)).toString());
      this.numExpediente = ((ExpedienteDTO)this.listaExpedientes.get(groupPosition)).getCodExpediente();
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder.access$000(childHolder).setOnClickListener(new 1(this, groupPosition));
      this.barra = status;
      RelativeLayout RLbarra = (RelativeLayout)convertView.findViewById(2131362143);
      ContextCompat var10001;
      if (this.barra.toUpperCase(Locale.ENGLISH).equals("CREADO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131100021));
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("CONCLUIDO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131100947));
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("ABIERTO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131099962));
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("CANCELADO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131100947));
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("EJECUTADO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131099965));
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("OPERATIVO")) {
         var10001 = this.contextCompact;
         RLbarra.setBackgroundColor(ContextCompat.getColor(this.context, 2131099962));
      }

      return convertView;
   }

   public int getChildrenCount(int groupPosition) {
      int childrenCount = this.getSaldos((ExpedienteDTO)this.listaExpedientes.get(groupPosition)).size();
      return childrenCount;
   }

   public Object getGroup(int groupPosition) {
      return this.listaExpedientes.get(groupPosition);
   }

   public int getGroupCount() {
      return this.listaExpedientes.size();
   }

   public long getGroupId(int groupPosition) {
      return (long)groupPosition;
   }

   public View getGroupView(int position, boolean isExpanded, View rowView, ViewGroup parent) {
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder groupHolder = new es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder(this);
      if (rowView == null) {
         rowView = LayoutInflater.from(this.context).inflate(2131558731, parent, false);
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1402(groupHolder, (TextView)rowView.findViewById(2131363028));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1502(groupHolder, (TextView)rowView.findViewById(2131363006));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1602(groupHolder, (TextView)rowView.findViewById(2131363007));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1702(groupHolder, (TextView)rowView.findViewById(2131363053));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1802(groupHolder, (TextView)rowView.findViewById(2131362998));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1902(groupHolder, (TextView)rowView.findViewById(2131363020));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2002(groupHolder, (LinearLayout)rowView.findViewById(2131362438));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2102(groupHolder, (ImageView)rowView.findViewById(2131362284));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2202(groupHolder, (RelativeLayout)rowView.findViewById(2131362143));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2302(groupHolder, (TextView)rowView.findViewById(2131363021));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2402(groupHolder, (TextView)rowView.findViewById(2131362989));
         rowView.setTag(groupHolder);
      } else {
         groupHolder = (es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder)rowView.getTag();
      }

      if (!isExpanded) {
         this.expandableListView.setDividerHeight(0);
      } else {
         this.expandableListView.setDividerHeight(-19);
      }

      this.expandableListView.setFooterDividersEnabled(false);
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1400(groupHolder).setText(CommonUtils.getProceedingFormatted(((ExpedienteDTO)this.listaExpedientes.get(position)).getCodExpediente()));
      String tvPri = ((ExpedienteDTO)this.listaExpedientes.get(position)).getPrimov().toString();
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1500(groupHolder).setText(DateUtils.formatDate(tvPri));
      String tvUlt = ((ExpedienteDTO)this.listaExpedientes.get(position)).getUltmov().toString();
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1600(groupHolder).setText(DateUtils.formatDate(tvUlt));
      if (!((ExpedienteDTO)this.listaExpedientes.get(position)).isExpanded() && ((ExpedienteDTO)this.listaExpedientes.get(position)).getIntCostas() != null && !Objects.equals(((ExpedienteDTO)this.listaExpedientes.get(position)).getIntCostas(), "") && !Objects.equals(((ExpedienteDTO)this.listaExpedientes.get(position)).getIntCostas(), " ")) {
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2300(groupHolder).setText(String.format("%s %s", CommonUtils.formatImport(((ExpedienteDTO)this.listaExpedientes.get(position)).getIntCostas()), CommonUtils.getCurrencySymbol(((ExpedienteDTO)this.listaExpedientes.get(position)).getCodmon())));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2300(groupHolder).setVisibility(0);
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2400(groupHolder).setVisibility(0);
      } else {
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2300(groupHolder).setVisibility(8);
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2400(groupHolder).setVisibility(8);
      }

      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1700(groupHolder).setText(((ExpedienteDTO)this.listaExpedientes.get(position)).getSituacion());
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1800(groupHolder).setText(CommonUtils.formatImport(((ExpedienteDTO)this.listaExpedientes.get(position)).getSaldo()));
      es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1900(groupHolder).setText(CommonUtils.getCurrencySymbol(((ExpedienteDTO)this.listaExpedientes.get(position)).getCodmon()));
      this.spinnerData = new ArrayList();

      for(int i = 0; i < this.listaExpedientes.size(); ++i) {
         this.spinnerData.add(((ExpedienteDTO)this.listaExpedientes.get(i)).getCodExpediente());
      }

      this.barra = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$1700(groupHolder).getText().toString();
      RelativeLayout var10000;
      ContextCompat var10001;
      if (this.barra.toUpperCase(Locale.ENGLISH).equals("CREADO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131100021));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131231074);
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("CONCLUIDO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131100947));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131231009);
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("ABIERTO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131099962));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131230999);
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("CANCELADO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131100947));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131231013);
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("EJECUTADO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131099965));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131231009);
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("OPERATIVO")) {
         var10000 = es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2200(groupHolder);
         var10001 = this.contextCompact;
         var10000.setBackgroundColor(ContextCompat.getColor(this.context, 2131099962));
         es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder.access$2100(groupHolder).setImageResource(2131231141);
      }

      return rowView;
   }

   public boolean hasStableIds() {
      return true;
   }

   public boolean isChildSelectable(int groupPosition, int childPosition) {
      return true;
   }

   public void onGroupExpanded(int groupPosition) {
      super.onGroupExpanded(groupPosition);
      TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (expandir)");
   }

   // $FF: synthetic method
   static Activity access$1100(AdapterExpedientExpandable x0) {
      return x0.context;
   }

   // $FF: synthetic method
   static ArrayList access$1200(AdapterExpedientExpandable x0) {
      return x0.spinnerData;
   }

   // $FF: synthetic method
   static String access$1300(AdapterExpedientExpandable x0) {
      return x0.numExpediente;
   }
}
