package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.1;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.2;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.3;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.4;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.5;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail.DetalleExpSaldos;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterExpaConsuExpe extends ExpandableRecyclerAdapter<DatosExpedienteResponse, DetalleExpSaldos, ExpedienteConsultaParenViewHolder, ExpedienteChildViewHolder> {
   private final int TYPE_CARD_CREATED_CONCLUDED = 2;
   private final int TYPE_CARD_CANCELLED = 3;
   private final int TYPE_CARD_GLOBAL = 4;
   private final int TYPE_LINEAR_CREATED_CONCLUDED = 5;
   private final int TYPE_LINEAR_CANCELLED = 6;
   private final int TYPE_LINEAR_GLOBAL = 7;
   private List<DatosExpedienteResponse> mParentList;
   private Context mContext;
   private LayoutInflater mInflater;
   private int mExpandedCard;
   private es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnOthersClick mOthersListener;
   private es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnDetailsClick mDetailListener;

   public AdapterExpaConsuExpe(Context context, @NonNull List<DatosExpedienteResponse> parentList, es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnOthersClick othersListener, es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnDetailsClick detailListener) {
      super(parentList);
      this.mParentList = parentList;
      this.mContext = context;
      this.mInflater = LayoutInflater.from(this.mContext);
      this.mExpandedCard = -1;
      this.mOthersListener = othersListener;
      this.mDetailListener = detailListener;
   }

   @NonNull
   public ExpedienteConsultaParenViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
      ExpedienteConsultaParenViewHolder view = null;
      switch(viewType) {
      case 2:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558505, parentViewGroup, false));
         break;
      case 3:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558504, parentViewGroup, false));
         break;
      case 4:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558503, parentViewGroup, false));
         break;
      case 5:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558619, parentViewGroup, false));
         break;
      case 6:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558618, parentViewGroup, false));
         break;
      case 7:
         view = new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(2131558620, parentViewGroup, false));
      }

      return view;
   }

   @NonNull
   public ExpedienteChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
      return new ExpedienteChildViewHolder(this.mInflater.inflate(2131558622, childViewGroup, false));
   }

   public int getChildCount(int parentPosition) {
      return ((DatosExpedienteResponse)this.mParentList.get(parentPosition)).getChildList().size() - 1;
   }

   private DatosExpedienteResponse getParentItem(int parentPosition) {
      return (DatosExpedienteResponse)this.mParentList.get(parentPosition);
   }

   public int getChildViewType(int parentPosition, int childPosition) {
      return super.getChildViewType(parentPosition, childPosition);
   }

   public int getParentViewType(int parentPosition) {
      String var2 = this.getParentItem(parentPosition).getSitexp();
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
         return parentPosition == this.mExpandedCard ? 5 : 2;
      case 2:
         return parentPosition == this.mExpandedCard ? 6 : 3;
      case 3:
      case 4:
      case 5:
         return parentPosition == this.mExpandedCard ? 7 : 4;
      default:
         return parentPosition == this.mExpandedCard ? 5 : 2;
      }
   }

   public boolean isParentViewType(int viewType) {
      Log.d("Silos", "viewType " + viewType);
      switch(viewType) {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
         Log.d("Silos", "is parent");
         return true;
      default:
         Log.d("Silos", "isn't pareeeeeeent");
         return false;
      }
   }

   public void onBindParentViewHolder(@NonNull ExpedienteConsultaParenViewHolder parentViewHolder, int parentPosition, @NonNull DatosExpedienteResponse parent) {
      parentViewHolder.mTextNumExp.setText(this.getParentItem(parentPosition).getCodExpediente());
      parentViewHolder.mTextDateFirstMov.setText(CommonUtils.getDateFromExp(this.getParentItem(parentPosition).getPrimov()));
      parentViewHolder.mTextDateLastMov.setText(CommonUtils.getDateFromExp(this.getParentItem(parentPosition).getUltmov()));
      parentViewHolder.mTextSituation.setText(this.getParentItem(parentPosition).getSituacion());
      parentViewHolder.mTextAmount.setText(this.getParentItem(parentPosition).getSaldos().getImpsald() + " " + this.getParentItem(parentPosition).getSaldos().getCodmon());
      String var4 = this.getParentItem(parentPosition).getSitexp();
      byte var5 = -1;
      switch(var4.hashCode()) {
      case 2081:
         if (var4.equals("AB")) {
            var5 = 2;
         }
         break;
      case 2142:
         if (var4.equals("CA")) {
            var5 = 3;
         }
         break;
      case 2156:
         if (var4.equals("CO")) {
            var5 = 1;
         }
         break;
      case 2159:
         if (var4.equals("CR")) {
            var5 = 0;
         }
         break;
      case 2213:
         if (var4.equals("EJ")) {
            var5 = 4;
         }
         break;
      case 2529:
         if (var4.equals("OP")) {
            var5 = 5;
         }
      }

      switch(var5) {
      case 0:
         parentViewHolder.mImageState.setImageResource(2131231073);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099964));
         break;
      case 1:
         parentViewHolder.mImageState.setImageResource(2131231001);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099963));
         break;
      case 2:
         parentViewHolder.mImageState.setImageResource(2131230998);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099962));
         break;
      case 3:
         parentViewHolder.mImageState.setImageResource(2131231076);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099963));
         break;
      case 4:
         parentViewHolder.mImageState.setImageResource(2131231001);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099965));
         break;
      case 5:
         parentViewHolder.mImageState.setImageResource(2131231139);
         parentViewHolder.mImageState.setBackgroundColor(ContextCompat.getColor(this.mContext, 2131099965));
      }

      if (parentViewHolder.mSwipeLayout != null) {
         parentViewHolder.mSwipeLayout.setOnClickListener(new 1(this, parentPosition));
         if (parentViewHolder.mCard != null) {
            parentViewHolder.mCard.setOnClickListener(new 2(this, parentPosition));
         }

         if (parentViewHolder.mLinearGlobal != null) {
            parentViewHolder.mLinearGlobal.setOnClickListener(new 3(this, parentPosition));
         }

         parentViewHolder.mSwipeLayout.setOnSwipeItemClickListener(new 4(this, parentPosition));
      }

      if (parentViewHolder.mImageSwipe != null) {
         parentViewHolder.mImageSwipe.setOnClickListener(new 5(this, parentViewHolder));
      }

   }

   private int getResourceOperative(int i, String state) {
      TypedArray resources = null;
      byte var5 = -1;
      switch(state.hashCode()) {
      case 2142:
         if (state.equals("CA")) {
            var5 = 2;
         }
         break;
      case 2156:
         if (state.equals("CO")) {
            var5 = 0;
         }
         break;
      case 2159:
         if (state.equals("CR")) {
            var5 = 1;
         }
      }

      switch(var5) {
      case 0:
      case 1:
         resources = this.mContext.getResources().obtainTypedArray(2130903072);
         break;
      case 2:
         resources = this.mContext.getResources().obtainTypedArray(2130903068);
      }

      if (resources != null) {
         int id = resources.getResourceId(i, -1);
         switch(id) {
         case 2131886114:
            return 6;
         case 2131886301:
            return 5;
         }
      }

      return -1;
   }

   public void onBindChildViewHolder(@NonNull ExpedienteChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull DetalleExpSaldos child) {
      if (child.getIngpendconso() == null) {
         childViewHolder.mCard.setVisibility(8);
      } else {
         childViewHolder.mCard.setVisibility(0);
         childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != this.getChildCount(parentPosition) ? 2131230827 : 2131230828));
         childViewHolder.mTextMovements.setVisibility(0);
      }

   }

   // $FF: synthetic method
   static int access$000(AdapterExpaConsuExpe x0) {
      return x0.mExpandedCard;
   }

   // $FF: synthetic method
   static int access$002(AdapterExpaConsuExpe x0, int x1) {
      return x0.mExpandedCard = x1;
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnDetailsClick access$100(AdapterExpaConsuExpe x0) {
      return x0.mDetailListener;
   }

   // $FF: synthetic method
   static DatosExpedienteResponse access$200(AdapterExpaConsuExpe x0, int x1) {
      return x0.getParentItem(x1);
   }

   // $FF: synthetic method
   static int access$300(AdapterExpaConsuExpe x0, int x1, String x2) {
      return x0.getResourceOperative(x1, x2);
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.OnOthersClick access$400(AdapterExpaConsuExpe x0) {
      return x0.mOthersListener;
   }
}
