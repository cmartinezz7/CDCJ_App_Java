package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.1;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.2;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.3;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.4;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.5;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.6;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail.DetalleExpSaldos;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdapterConsultaExp extends AdapterAbstractRecycler<DatosExpedienteNew> {
   private final int TYPE_CARD_CREATED_CONCLUDED = 2;
   private final int TYPE_CARD_CANCELLED = 3;
   private final int TYPE_CARD_GLOBAL = 4;
   private final int TYPE_LINEAR_CREATED_CONCLUDED = 5;
   private final int TYPE_LINEAR_CANCELLED = 6;
   private final int TYPE_LINEAR_GLOBAL = 7;
   private final int TYPE_CHILD = 8;
   private LayoutInflater mInflater;
   private int mExpandedCard;
   private es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnExpandClick mOnExpandClick;
   private es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnActivarClick mOnActivarClick;

   public AdapterConsultaExp(Context context, es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnExpandClick onExpandClick, es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnActivarClick onActivarClick, List<DatosExpedienteNew> listNews) {
      super(context, (OnRecyclerClickListener)null, listNews);
      this.mContext = context;
      this.mInflater = LayoutInflater.from(this.mContext);
      this.mExpandedCard = -1;
      this.mOnExpandClick = onExpandClick;
      this.mOnActivarClick = onActivarClick;
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder view = null;
      switch(viewType) {
      case 2:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558505, parent, false));
         break;
      case 3:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558504, parent, false));
         break;
      case 4:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558503, parent, false));
         break;
      case 5:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558619, parent, false));
         break;
      case 6:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558618, parent, false));
         break;
      case 7:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558620, parent, false));
         break;
      case 8:
         view = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder(this, this.mInflater.inflate(2131558622, parent, false));
      }

      return view;
   }

   public DetalleExpSaldos getChildItem(int position) {
      return ((DatosExpedienteNew)this.getItem(position)).getDetalleExpSaldos();
   }

   public int getItemViewType(int position) {
      if (((DatosExpedienteNew)this.getItem(position)).getSitexp() != null) {
         String var2 = ((DatosExpedienteNew)this.getItem(position)).getSitexp();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case 2081:
            if (var2.equals("AB")) {
               var3 = 3;
            }
            break;
         case 2142:
            if (var2.equals("CA")) {
               var3 = 2;
            }
            break;
         case 2156:
            if (var2.equals("CO")) {
               var3 = 1;
            }
            break;
         case 2159:
            if (var2.equals("CR")) {
               var3 = 0;
            }
            break;
         case 2213:
            if (var2.equals("EJ")) {
               var3 = 4;
            }
            break;
         case 2529:
            if (var2.equals("OP")) {
               var3 = 5;
            }
         }

         switch(var3) {
         case 0:
         case 1:
            return position == this.mExpandedCard ? 5 : 2;
         case 2:
            return position == this.mExpandedCard ? 6 : 3;
         case 3:
         case 4:
         case 5:
            return position == this.mExpandedCard ? 7 : 4;
         default:
            return position == this.mExpandedCard ? 5 : 2;
         }
      } else {
         return 8;
      }
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder)abstractHolder;
      int currentStateColor;
      if (!((DatosExpedienteNew)this.getItem(position)).isChild()) {
         holder.mTextNumExp.setText(CommonUtils.getProceedingFormatted(((DatosExpedienteNew)this.getItem(position)).getCodExpediente()));
         holder.mTextDateFirstMov.setText(CommonUtils.getDateFromExp(((DatosExpedienteNew)this.getItem(position)).getPrimov()));
         holder.mTextDateLastMov.setText(CommonUtils.getDateFromExp(((DatosExpedienteNew)this.getItem(position)).getUltmov()));
         holder.mTextSituation.setText(((DatosExpedienteNew)this.getItem(position)).getSituacion());
         holder.mTextAmount.setText(CommonUtils.formatImport(((DatosExpedienteNew)this.getItem(position)).getSaldos().getImpsald()) + " " + CommonUtils.getCurrencySymbol(((DatosExpedienteNew)this.getItem(position)).getSaldos().getCodmon()));
         holder.lImpCostas.setVisibility(8);
         if (((DatosExpedienteNew)this.getItem(position)).getImpInterCostas() != null && ((DatosExpedienteNew)this.getItem(position)).isExpanded()) {
            holder.mImpCostas.setText(CommonUtils.formatImport(((DatosExpedienteNew)this.getItem(position)).getImpInterCostas()) + " " + CommonUtils.getCurrencySymbol(((DatosExpedienteNew)this.getItem(position)).getSaldos().getCodmon()));
            holder.lImpCostas.setVisibility(0);
         } else {
            holder.lImpCostas.setVisibility(8);
         }

         currentStateColor = 0;
         String var5 = ((DatosExpedienteNew)this.getItem(position)).getSitexp();
         byte var6 = -1;
         switch(var5.hashCode()) {
         case 2081:
            if (var5.equals("AB")) {
               var6 = 2;
            }
            break;
         case 2142:
            if (var5.equals("CA")) {
               var6 = 3;
            }
            break;
         case 2156:
            if (var5.equals("CO")) {
               var6 = 1;
            }
            break;
         case 2159:
            if (var5.equals("CR")) {
               var6 = 0;
            }
            break;
         case 2213:
            if (var5.equals("EJ")) {
               var6 = 4;
            }
            break;
         case 2529:
            if (var5.equals("OP")) {
               var6 = 5;
            }
         }

         switch(var6) {
         case 0:
            holder.mImageState.setImageResource(2131231074);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131100021);
            break;
         case 1:
            holder.mImageState.setImageResource(2131231009);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131100947);
            break;
         case 2:
            holder.mImageState.setImageResource(2131230999);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099962);
            break;
         case 3:
            holder.mImageState.setImageResource(2131231013);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131100947);
            break;
         case 4:
            holder.mImageState.setImageResource(2131231009);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099965);
            break;
         case 5:
            holder.mImageState.setImageResource(2131231141);
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099962);
         }

         if (holder.mLinearGlobal != null) {
            Drawable stateBackgroundDrawable = ContextCompat.getDrawable(this.mContext, 2131231325);
            if (stateBackgroundDrawable != null) {
               stateBackgroundDrawable.setColorFilter(currentStateColor, Mode.SRC_IN);
            }

            holder.mImageState.setBackground(stateBackgroundDrawable);
            holder.mImageState.invalidate();
         } else {
            holder.mImageState.setBackgroundColor(currentStateColor);
         }

         if (holder.mSwipeLayout != null) {
            holder.mSwipeLayout.setOnClickListener(new 1(this, position));
            if (holder.mImageSwipe != null) {
               holder.mImageSwipe.setOnClickListener(new 2(this, holder));
            }

            holder.mSwipeLayout.setOnSwipeItemClickListener(new 3(this, position));
         } else {
            if (holder.mCard != null) {
               holder.mCard.setOnClickListener(new 4(this, position));
            }

            if (holder.mLinearGlobal != null) {
               holder.mLinearGlobal.setOnClickListener(new 5(this, position));
            }
         }
      } else if (this.getChildItem(position) != null) {
         for(currentStateColor = 1; ((DatosExpedienteNew)this.getItem(position - currentStateColor)).isChild(); ++currentStateColor) {
         }

         int currentStateColor = 0;
         if (((DatosExpedienteNew)this.getItem(position - currentStateColor)).getSitexp() != null) {
            String var10 = ((DatosExpedienteNew)this.getItem(position - currentStateColor)).getSitexp();
            byte var7 = -1;
            switch(var10.hashCode()) {
            case 2081:
               if (var10.equals("AB")) {
                  var7 = 3;
               }
               break;
            case 2142:
               if (var10.equals("CA")) {
                  var7 = 2;
               }
               break;
            case 2156:
               if (var10.equals("CO")) {
                  var7 = 1;
               }
               break;
            case 2159:
               if (var10.equals("CR")) {
                  var7 = 0;
               }
               break;
            case 2213:
               if (var10.equals("EJ")) {
                  var7 = 5;
               }
               break;
            case 2529:
               if (var10.equals("OP")) {
                  var7 = 4;
               }
            }

            switch(var7) {
            case 0:
               currentStateColor = ContextCompat.getColor(this.mContext, 2131100021);
               break;
            case 1:
            case 2:
               currentStateColor = ContextCompat.getColor(this.mContext, 2131100947);
               break;
            case 3:
            case 4:
               currentStateColor = ContextCompat.getColor(this.mContext, 2131099962);
               break;
            case 5:
               currentStateColor = ContextCompat.getColor(this.mContext, 2131099965);
            }

            Drawable stateBackgroundDrawable = ContextCompat.getDrawable(this.mContext, 2131231322);
            if (stateBackgroundDrawable != null) {
               stateBackgroundDrawable.setColorFilter(currentStateColor, Mode.SRC_IN);
            }

            holder.mViewChild.setBackground(stateBackgroundDrawable);
            holder.mViewChild.invalidate();
         }

         holder.mTextAmountCurrency.setText(String.format(this.mContext.getString(2131886121), this.getChildItem(position).getMoneda()));
         holder.mTextAmountDay.setText(CommonUtils.formatImport(this.getChildItem(position).getSaldodia()));
         holder.mTextIncomPdtCons.setText(CommonUtils.formatImport(this.getChildItem(position).getIngpendconso()));
         holder.mTextPdtCons.setText(CommonUtils.formatImport(this.getChildItem(position).getPagopendconso()));
         holder.mTextPdtConf.setText(CommonUtils.formatImport(this.getChildItem(position).getPagopendconf()));
         holder.mTextAmountCons.setText(CommonUtils.formatImport(this.getChildItem(position).getSaldoconso()));
         holder.mTextAmountDisp.setText(CommonUtils.formatImport(this.getChildItem(position).getSaldodisp()));
         holder.mTextAmountErr.setText(CommonUtils.formatImport(this.getChildItem(position).getSaldoingerroneo()));
         holder.mTextAmountReso.setText(CommonUtils.formatImport(this.getChildItem(position).getSaldoingdeposito()));
         holder.mTextPrincipal.setText(CommonUtils.formatImport(this.getChildItem(position).getPrincipal()));
         if ((position + 1 >= this.getItemCount() || ((DatosExpedienteNew)this.getItem(position + 1)).isChild()) && (position + 1 != this.getItemCount() || !((DatosExpedienteNew)this.getItem(position)).isChild())) {
            holder.mTextMovements.setVisibility(8);
         } else {
            holder.mTextMovements.setVisibility(0);
            holder.mTextMovements.setOnClickListener(new 6(this, position));
         }
      }

   }

   public void setExpandedCard(int expandedCard) {
      this.mExpandedCard = expandedCard;
   }

   public ArrayList<DatosExpedienteDetail> getListMovements() {
      ArrayList<DatosExpedienteDetail> movements = new ArrayList();
      Iterator var2 = this.mListItems.iterator();

      while(var2.hasNext()) {
         DatosExpedienteNew datosExpedienteNew = (DatosExpedienteNew)var2.next();
         if (datosExpedienteNew.getJnumexp() != null && !datosExpedienteNew.getJnumexp().isEmpty() && datosExpedienteNew.getJproced() != null && !datosExpedienteNew.getJproced().isEmpty() && datosExpedienteNew.getJuzga() != null && !datosExpedienteNew.getJuzga().isEmpty() && datosExpedienteNew.getJuzgori() != null && !datosExpedienteNew.getJuzgori().isEmpty()) {
            movements.add(new DatosExpedienteDetail(datosExpedienteNew.getJanoapex(), datosExpedienteNew.getJnumexp(), datosExpedienteNew.getJproced(), datosExpedienteNew.getJuzga(), datosExpedienteNew.getJuzgori(), datosExpedienteNew.getPrimov(), datosExpedienteNew.getUltmov()));
         }
      }

      return movements;
   }

   // $FF: synthetic method
   static int access$000(AdapterConsultaExp x0) {
      return x0.mExpandedCard;
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnExpandClick access$100(AdapterConsultaExp x0) {
      return x0.mOnExpandClick;
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.OnActivarClick access$200(AdapterConsultaExp x0) {
      return x0.mOnActivarClick;
   }
}
