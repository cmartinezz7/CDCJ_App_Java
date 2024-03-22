package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.1;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.2;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.3;
import es.santander.justicia.minisJusticia.models.responses.seizures.Embargo;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoDetail;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterExpaSeizures extends ExpandableRecyclerAdapter<Embargo, EmbargoDetail, SeizureParentViewHolder, SeizureChildViewHolder> {
   public static final String BA = "BA";
   public static final String ER = "ER";
   public static final String PE = "PE";
   public static final String SE = "SE";
   public static final String EN = "EN";
   public static final String RX = "RX";
   public static final String RA = "RA";
   public static final String FRA = "FRA";
   public static final String RE = "RE";
   public static final String PP = "PP";
   public static final String PA = "PA";
   public static final String PR = "PR";
   private final int TYPE_CARD = 3;
   private final int TYPE_LINEAR = 4;
   private List<Embargo> mParentList;
   private Context mContext;
   private LayoutInflater mInflater;
   private int mExpandedCard;
   private es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.OnBajaClickListener onBajaClickListener;

   public AdapterExpaSeizures(Context context, @NonNull List<Embargo> parentList) {
      super(parentList);
      this.mParentList = parentList;
      this.mContext = context;
      this.mInflater = LayoutInflater.from(this.mContext);
      this.mExpandedCard = -1;
      this.onBajaClickListener = (es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.OnBajaClickListener)context;
   }

   @NonNull
   public SeizureParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
      SeizureParentViewHolder view = null;
      switch(viewType) {
      case 3:
         view = new SeizureParentViewHolder(this.mInflater.inflate(2131558513, parentViewGroup, false));
         break;
      case 4:
         view = new SeizureParentViewHolder(this.mInflater.inflate(2131558623, parentViewGroup, false));
      }

      return view;
   }

   @NonNull
   public SeizureChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
      return new SeizureChildViewHolder(this.mInflater.inflate(2131558624, childViewGroup, false));
   }

   public int getChildCount(int parentPosition) {
      return ((Embargo)this.mParentList.get(parentPosition)).getChildList().size() - 1;
   }

   public int getParentViewType(int parentPosition) {
      return parentPosition == this.mExpandedCard ? 4 : 3;
   }

   public boolean isParentViewType(int viewType) {
      return viewType == 4 || viewType == 3;
   }

   public int getItemViewType(int flatPosition) {
      Log.d("Silos", "itemViewType: " + super.getItemViewType(flatPosition));
      return super.getItemViewType(flatPosition);
   }

   public void onBindParentViewHolder(@NonNull SeizureParentViewHolder parentViewHolder, int parentPosition, @NonNull Embargo parent) {
      parentViewHolder.mSwipeLayout.setOnClickListener(new 1(this, parentPosition));
      parentViewHolder.mImageSwipe.setOnClickListener(new 2(this, parentViewHolder));
      parentViewHolder.mSwipeLayout.setOnSwipeItemClickListener(new 3(this));

      try {
         parentViewHolder.mTextExpediente.setText(CommonUtils.formatExpedientWithSpaces(parent.getCodigoJuzgadoDestino(), parent.getCodigoJuzgadoOrigen(), parent.getCodigoProcedimiento(), parent.getNumeroExpediente(), parent.getAnoAperturaExpediente()));
         parentViewHolder.mTextFechaAlta.setText(CommonUtils.getDateFromExp(parent.getFechaAltaRegistro()));
         parentViewHolder.mTextTipoEmbargo.setText(parent.getCodigoTipoEmbargo());
         parentViewHolder.mTextSituacion.setText(parent.getDescEstado());
         parentViewHolder.mTextImporte.setText(CommonUtils.formatImport(parent.getImporteTotalEmbargo()) + " " + CommonUtils.getCurrencySymbol(parent.getCodigoMoneda()));
         int currentStateColor = 0;
         String var5 = parent.getCodigoEstado();
         byte var6 = -1;
         switch(var5.hashCode()) {
         case 2111:
            if (var5.equals("BA")) {
               var6 = 0;
            }
            break;
         case 2217:
            if (var5.equals("EN")) {
               var6 = 4;
            }
            break;
         case 2221:
            if (var5.equals("ER")) {
               var6 = 1;
            }
            break;
         case 2545:
            if (var5.equals("PA")) {
               var6 = 11;
            }
            break;
         case 2549:
            if (var5.equals("PE")) {
               var6 = 2;
            }
            break;
         case 2560:
            if (var5.equals("PP")) {
               var6 = 9;
            }
            break;
         case 2562:
            if (var5.equals("PR")) {
               var6 = 10;
            }
            break;
         case 2607:
            if (var5.equals("RA")) {
               var6 = 6;
            }
            break;
         case 2611:
            if (var5.equals("RE")) {
               var6 = 8;
            }
            break;
         case 2630:
            if (var5.equals("RX")) {
               var6 = 5;
            }
            break;
         case 2642:
            if (var5.equals("SE")) {
               var6 = 3;
            }
            break;
         case 69877:
            if (var5.equals("FRA")) {
               var6 = 7;
            }
         }

         switch(var6) {
         case 0:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099963);
            parentViewHolder.mImageLateral.setImageResource(2131231075);
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 1:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131100006);
            parentViewHolder.mImageLateral.setImageResource(2131231073);
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 2:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099964);
            parentViewHolder.mImageLateral.setImageResource(2131231073);
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 3:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099963);
            parentViewHolder.mImageLateral.setImageResource(2131231139);
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 4:
         case 5:
         case 6:
         case 7:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131100021);
            parentViewHolder.mImageLateral.setImageResource(2131231141);
            parentViewHolder.mImageSwipe.setVisibility(0);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(true);
            break;
         case 8:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099965);
            parentViewHolder.mImageLateral.setImageResource(2131231009);
            parentViewHolder.mImageLateral.setColorFilter(ContextCompat.getColor(this.mContext, 2131100979));
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 9:
         case 10:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099962);
            parentViewHolder.mImageLateral.setImageResource(2131231074);
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
            break;
         case 11:
            currentStateColor = ContextCompat.getColor(this.mContext, 2131099962);
            parentViewHolder.mImageLateral.setImageResource(2131231009);
            parentViewHolder.mImageLateral.setColorFilter(ContextCompat.getColor(this.mContext, 2131100979));
            parentViewHolder.mImageSwipe.setVisibility(8);
            parentViewHolder.mSwipeLayout.setSwipeEnabled(false);
         }

         if (parentViewHolder.mLinear != null) {
            Drawable stateBackgroundDrawable = ContextCompat.getDrawable(this.mContext, 2131231325);
            if (stateBackgroundDrawable != null) {
               stateBackgroundDrawable.setColorFilter(currentStateColor, Mode.SRC_IN);
            }

            parentViewHolder.mImageLateral.setBackground(stateBackgroundDrawable);
            parentViewHolder.mImageLateral.invalidate();
         } else {
            parentViewHolder.mImageLateral.setBackgroundColor(currentStateColor);
         }
      } catch (Exception var7) {
         Log.d("AdapterExpaSeizures", "error datos");
         parentViewHolder.mImageLateral.setVisibility(8);
         parentViewHolder.mImageLateral.setVisibility(8);
         parentViewHolder.mImageSwipe.setVisibility(8);
         parentViewHolder.mSwipeLayout.setVisibility(8);
      }

   }

   public void onBindChildViewHolder(@NonNull SeizureChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull EmbargoDetail child) {
      childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != this.getChildCount(parentPosition) ? 2131230827 : 2131230828));
      childViewHolder.mTextNumDoc.setText(child.getDocument());
      childViewHolder.mTextTitular.setText(child.getNombre());
      childViewHolder.mTextImporte.setText(CommonUtils.formatImport(child.getImporte()) + " " + CommonUtils.getCurrencySymbol(((Embargo)this.mParentList.get(parentPosition)).getCodigoMoneda()));
      int currentStateColor = 0;
      String var6 = ((Embargo)this.getParentList().get(parentPosition)).getCodigoEstado();
      byte var7 = -1;
      switch(var6.hashCode()) {
      case 2111:
         if (var6.equals("BA")) {
            var7 = 0;
         }
         break;
      case 2217:
         if (var6.equals("EN")) {
            var7 = 4;
         }
         break;
      case 2221:
         if (var6.equals("ER")) {
            var7 = 2;
         }
         break;
      case 2545:
         if (var6.equals("PA")) {
            var7 = 10;
         }
         break;
      case 2549:
         if (var6.equals("PE")) {
            var7 = 3;
         }
         break;
      case 2560:
         if (var6.equals("PP")) {
            var7 = 9;
         }
         break;
      case 2562:
         if (var6.equals("PR")) {
            var7 = 11;
         }
         break;
      case 2607:
         if (var6.equals("RA")) {
            var7 = 6;
         }
         break;
      case 2611:
         if (var6.equals("RE")) {
            var7 = 8;
         }
         break;
      case 2630:
         if (var6.equals("RX")) {
            var7 = 5;
         }
         break;
      case 2642:
         if (var6.equals("SE")) {
            var7 = 1;
         }
         break;
      case 69877:
         if (var6.equals("FRA")) {
            var7 = 7;
         }
      }

      switch(var7) {
      case 0:
      case 1:
         currentStateColor = ContextCompat.getColor(this.mContext, 2131100947);
         break;
      case 2:
      case 3:
         currentStateColor = ContextCompat.getColor(this.mContext, 2131100022);
         break;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         currentStateColor = ContextCompat.getColor(this.mContext, 2131100021);
         break;
      case 9:
      case 10:
      case 11:
         currentStateColor = ContextCompat.getColor(this.mContext, 2131099965);
      }

      Drawable stateBackgroundDrawable = ContextCompat.getDrawable(this.mContext, 2131231322);
      if (stateBackgroundDrawable != null) {
         stateBackgroundDrawable.setColorFilter(currentStateColor, Mode.SRC_IN);
      }

      childViewHolder.mViewLaeral.setBackground(stateBackgroundDrawable);
      childViewHolder.mViewLaeral.invalidate();
   }

   // $FF: synthetic method
   static int access$000(AdapterExpaSeizures x0) {
      return x0.mExpandedCard;
   }

   // $FF: synthetic method
   static int access$002(AdapterExpaSeizures x0, int x1) {
      return x0.mExpandedCard = x1;
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.OnBajaClickListener access$100(AdapterExpaSeizures x0) {
      return x0.onBajaClickListener;
   }
}
