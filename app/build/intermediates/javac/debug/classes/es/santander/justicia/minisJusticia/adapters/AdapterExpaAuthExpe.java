package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.1;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.2;
import es.santander.justicia.minisJusticia.models.ExpedienteDetailLetrados;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterExpaAuthExpe extends ExpandableRecyclerAdapter<BuscarPeticionesAcceso, ExpedienteDetailLetrados, ExpedienteAuthParentViewHolder, ExpedienteChildViewHolder> {
   private final int TYPE_CARD_ACCEPT = 1;
   private final int TYPE_CARD_DENIE = 2;
   private final int TYPE_CARD_PENDING = 3;
   private final int TYPE_CARD_BAJA = 4;
   private final int TYPE_LINEAR_ACCPET = 5;
   private final int TYPE_LINEAR_DENIE = 6;
   private final int TYPE_LINEAR_PENDING = 7;
   private final int TYPE_LINEAR_BAJA = 8;
   private List<BuscarPeticionesAcceso> mParentList;
   private Context mContext;
   private LayoutInflater mInflater;
   private int mExpandedCard;
   private es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.OnOthersClick mOthersListener;

   public AdapterExpaAuthExpe(Context context, @NonNull List<BuscarPeticionesAcceso> parentList, es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.OnOthersClick othersListener) {
      super(parentList);
      this.mParentList = parentList;
      this.mContext = context;
      this.mInflater = LayoutInflater.from(this.mContext);
      this.mExpandedCard = -1;
      this.mOthersListener = othersListener;
   }

   @NonNull
   public ExpedienteAuthParentViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
      ExpedienteAuthParentViewHolder view = null;
      switch(viewType) {
      case 1:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558499, parentViewGroup, false));
         break;
      case 2:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558501, parentViewGroup, false));
         break;
      case 3:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558502, parentViewGroup, false));
         break;
      case 4:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558500, parentViewGroup, false));
         break;
      case 5:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558614, parentViewGroup, false));
         break;
      case 6:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558616, parentViewGroup, false));
         break;
      case 7:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558617, parentViewGroup, false));
         break;
      case 8:
         view = new ExpedienteAuthParentViewHolder(this.mInflater.inflate(2131558615, parentViewGroup, false));
      }

      return view;
   }

   @NonNull
   public ExpedienteChildViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
      return new ExpedienteChildViewHolder(this.mInflater.inflate(2131558622, childViewGroup, false));
   }

   public int getChildCount(int parentPosition) {
      return ((BuscarPeticionesAcceso)this.mParentList.get(parentPosition)).getChildList().size() - 1;
   }

   private BuscarPeticionesAcceso getParentItem(int parentPosition) {
      return (BuscarPeticionesAcceso)this.mParentList.get(parentPosition);
   }

   public int getParentViewType(int parentPosition) {
      String var2 = this.getParentItem(parentPosition).getCodEstadoActualExp();
      byte var3 = -1;
      switch(var2.hashCode()) {
      case 2091:
         if (var2.equals("AL")) {
            var3 = 0;
         }
         break;
      case 2111:
         if (var2.equals("BA")) {
            var3 = 3;
         }
         break;
      case 2177:
         if (var2.equals("DE")) {
            var3 = 1;
         }
         break;
      case 2549:
         if (var2.equals("PE")) {
            var3 = 2;
         }
      }

      switch(var3) {
      case 0:
         return parentPosition == this.mExpandedCard ? 5 : 1;
      case 1:
         return parentPosition == this.mExpandedCard ? 6 : 2;
      case 2:
         return parentPosition == this.mExpandedCard ? 7 : 3;
      case 3:
         return parentPosition == this.mExpandedCard ? 8 : 4;
      default:
         return -1;
      }
   }

   public boolean isParentViewType(int viewType) {
      switch(viewType) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         return true;
      default:
         return false;
      }
   }

   public void onBindParentViewHolder(@NonNull ExpedienteAuthParentViewHolder parentViewHolder, int parentPosition, @NonNull BuscarPeticionesAcceso parent) {
      parentViewHolder.mTextNumExp.setText(CommonUtils.formatExpedientWithSpaces(this.getParentItem(parentPosition).getCodJuzDest(), this.getParentItem(parentPosition).getCodJuzOri(), this.getParentItem(parentPosition).getCodProced(), this.getParentItem(parentPosition).getNumExpediente(), this.getParentItem(parentPosition).getAnioApertura()));
      parentViewHolder.mTextDate.setText(CommonUtils.getDateFromExp(this.getParentItem(parentPosition).getFecDeLaPeticion()));
      parentViewHolder.mTextState.setText(this.getParentItem(parentPosition).getDesEstadoPeticion());
      parentViewHolder.mTextStateC.setText(this.getParentItem(parentPosition).getDesEstadoActualExp());
      parentViewHolder.mTextName.setText(this.getParentItem(parentPosition).getNombre() + (CommonUtils.isNotNullNotBlackNotStringNull(this.getParentItem(parentPosition).getApellido1()) ? " " + this.getParentItem(parentPosition).getApellido1() : ""));
      parentViewHolder.mSwipeLayout.setOnSwipeItemClickListener(new 1(this, parentViewHolder, parentPosition));
      parentViewHolder.mImageSwipe.setOnClickListener(new 2(this, parentViewHolder));
   }

   private void closeParent(ExpedienteAuthParentViewHolder parentViewHolder, View view) {
      parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
      parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, parentViewHolder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0F : view.getX() - 1000.0F, view.getY(), 0));
   }

   private int getResourceOperative(int i, String state) {
      TypedArray resources = null;
      byte var5 = -1;
      switch(state.hashCode()) {
      case 2091:
         if (state.equals("AL")) {
            var5 = 0;
         }
         break;
      case 2111:
         if (state.equals("BA")) {
            var5 = 3;
         }
         break;
      case 2177:
         if (state.equals("DE")) {
            var5 = 1;
         }
         break;
      case 2549:
         if (state.equals("PE")) {
            var5 = 2;
         }
      }

      switch(var5) {
      case 0:
         resources = this.mContext.getResources().obtainTypedArray(2130903067);
         break;
      case 1:
         resources = this.mContext.getResources().obtainTypedArray(2130903074);
         break;
      case 2:
         resources = this.mContext.getResources().obtainTypedArray(2130903075);
         break;
      case 3:
         resources = this.mContext.getResources().obtainTypedArray(2130903070);
      }

      if (resources != null) {
         int id = resources.getResourceId(i, -1);
         switch(id) {
         case 2131886110:
            return 0;
         case 2131886149:
            return 2;
         case 2131886376:
            return 1;
         case 2131886590:
            return 3;
         case 2131886668:
            return 4;
         }
      }

      return -1;
   }

   public void onBindChildViewHolder(@NonNull ExpedienteChildViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull ExpedienteDetailLetrados child) {
      childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != this.getChildCount(parentPosition) ? 2131230827 : 2131230828));
   }

   // $FF: synthetic method
   static void access$000(AdapterExpaAuthExpe x0, ExpedienteAuthParentViewHolder x1, View x2) {
      x0.closeParent(x1, x2);
   }

   // $FF: synthetic method
   static BuscarPeticionesAcceso access$100(AdapterExpaAuthExpe x0, int x1) {
      return x0.getParentItem(x1);
   }

   // $FF: synthetic method
   static int access$200(AdapterExpaAuthExpe x0, int x1, String x2) {
      return x0.getResourceOperative(x1, x2);
   }

   // $FF: synthetic method
   static es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.OnOthersClick access$300(AdapterExpaAuthExpe x0) {
      return x0.mOthersListener;
   }
}
