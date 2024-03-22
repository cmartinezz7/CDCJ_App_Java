package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.1;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.2;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.3;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterOpeEjectDetail extends AdapterAbstractRecycler<ConsultaOperaciones> {
   public static final int VIEW_TYPE_NADA = 1;
   public static final int VIEW_TYPE_ANULAR = 2;
   public static final int VIEW_TYPE_FIRMAR_ANULAR = 3;
   public static final int TYPE_PENDING = 1;
   public static final int TYPE_DONE = 2;
   private int mCurrentType;
   private es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.OnOperativeClicked mOperativeListener;

   public AdapterOpeEjectDetail(Context context, List<ConsultaOperaciones> listNews, int type) {
      super(context, (OnRecyclerClickListener)context, listNews);
      this.mCurrentType = type;
      this.mOperativeListener = (es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.OnOperativeClicked)context;
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = null;
      switch(viewType) {
      case 1:
         v = LayoutInflater.from(this.mContext).inflate(2131558509, parent, false);
         break;
      case 2:
         v = LayoutInflater.from(this.mContext).inflate(2131558507, parent, false);
         break;
      case 3:
         v = LayoutInflater.from(this.mContext).inflate(2131558508, parent, false);
      }

      return new es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder)abstractHolder;
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$000(holder).setText(CommonUtils.formatExpedientWithSpaces(((ConsultaOperaciones)this.getItem(position)).getJuzgadoDestino(), ((ConsultaOperaciones)this.getItem(position)).getJuzgadoOrigen(), ((ConsultaOperaciones)this.getItem(position)).getProcedimiento(), ((ConsultaOperaciones)this.getItem(position)).getNumExpediente(), ((ConsultaOperaciones)this.getItem(position)).getAnyoApertura()));
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$100(holder).setText(((ConsultaOperaciones)this.getItem(position)).getTitular());
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$200(holder).setText(((ConsultaOperaciones)this.getItem(position)).getNumMandamiento());
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$300(holder).setText(CommonUtils.getDateFromExp(((ConsultaOperaciones)this.getItem(position)).getFechaAltaOperacion()));
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$400(holder).setText(CommonUtils.formatImport(((ConsultaOperaciones)this.getItem(position)).getImporte()) + " " + CommonUtils.getCurrencySymbol(((ConsultaOperaciones)this.getItem(position)).getCodigoMoneda()));
      if (es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$500(holder) != null) {
         es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$500(holder).setOnClickListener(new 1(this, holder));
      }

      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$700(holder).setImageResource(this.mCurrentType == 1 ? 2131231141 : 2131231009);
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$700(holder).setBackgroundColor(ContextCompat.getColor(this.mContext, this.mCurrentType == 1 ? 2131100021 : 2131099965));
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$600(holder).setOnSwipeItemClickListener(new 2(this, position));
      es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder.access$600(holder).setOnClickListener(new 3(this, position));
   }

   public int getItemViewType(int position) {
      if (this.mCurrentType == 1 && ((ConsultaOperaciones)this.getItem(position)).getCodigoEstadoOperacion() != null) {
         String var2 = ((ConsultaOperaciones)this.getItem(position)).getCodigoEstadoOperacion();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case 65:
            if (var2.equals("A")) {
               var3 = 0;
            }
            break;
         case 70:
            if (var2.equals("F")) {
               var3 = 3;
            }
            break;
         case 73:
            if (var2.equals("I")) {
               var3 = 1;
            }
            break;
         case 80:
            if (var2.equals("P")) {
               var3 = 2;
            }
         }

         switch(var3) {
         case 0:
            String var4 = ((ConsultaOperaciones)this.getItem(position)).getCodTipoMovimiento();
            byte var5 = -1;
            switch(var4.hashCode()) {
            case 2673:
               if (var4.equals("TE")) {
                  var5 = 1;
               }
               break;
            case 2686:
               if (var4.equals("TR")) {
                  var5 = 2;
               }
               break;
            case 2688:
               if (var4.equals("TT")) {
                  var5 = 3;
               }
               break;
            case 2797:
               if (var4.equals("XE")) {
                  var5 = 0;
               }
            }

            switch(var5) {
            case 0:
            case 1:
            case 2:
            case 3:
               return 2;
            }
         case 1:
         case 2:
            return 2;
         case 3:
            return 3;
         }
      }

      return 1;
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.OnOperativeClicked access$800(AdapterOpeEjectDetail x0) {
      return x0.mOperativeListener;
   }
}
