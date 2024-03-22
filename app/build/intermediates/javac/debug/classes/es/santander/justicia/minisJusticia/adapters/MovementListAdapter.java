package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.adapters.MovementListAdapter.1;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class MovementListAdapter extends ArrayAdapter<MovementItemDTO> {
   private final Context context;
   private ArrayList<MovementItemDTO> movementList;
   private ArrayList<MovementItemDTO> filteredList;
   private es.santander.justicia.minisJusticia.adapters.MovementListAdapter.MovementsFilter movementsFilter;

   public MovementListAdapter(Context context, ArrayList<MovementItemDTO> movementList) {
      super(context, 0, movementList);
      this.context = context;
      this.movementList = movementList;
      this.filteredList = movementList;
      this.getFilter();
   }

   public int getCount() {
      return this.filteredList.size();
   }

   public MovementItemDTO getItem(int i) {
      return (MovementItemDTO)this.filteredList.get(i);
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      MovementItemDTO movementItem = this.getItem(position);
      es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder holder = new es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder(this);
      if (convertView == null) {
         convertView = LayoutInflater.from(this.context).inflate(2131558734, parent, false);
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$002(holder, (QFontTextView)convertView.findViewById(2131363078));
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$102(holder, (QFontTextView)convertView.findViewById(2131363014));
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$202(holder, (QFontTextView)convertView.findViewById(2131363025));
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$302(holder, (QFontTextView)convertView.findViewById(2131363049));
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$402(holder, (QFontTextView)convertView.findViewById(2131363060));
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$502(holder, (ImageView)convertView.findViewById(2131362355));
         convertView.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder)convertView.getTag();
      }

      es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$000(holder).setText(movementItem.getDesctipomod() != null ? movementItem.getDesctipomod().substring(0, 1).toUpperCase() + movementItem.getDesctipomod().substring(1).toLowerCase() : "");
      es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$100(holder).setText(movementItem.getJfechare() != null ? movementItem.getJfechare() : "");
      es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$200(holder).setText(movementItem.getSerieYMandamiento() != null ? movementItem.getSerieYMandamiento() : "");
      if (movementItem.getImporte() != null && movementItem.getImporte().length() > 0) {
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setText(CommonUtils.formatImport(movementItem.getImporte()) + " " + CommonUtils.getCurrencySymbol(movementItem.getCodmon()));
      } else {
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setText("");
      }

      MovementStatusEnum status = movementItem.getMovementStatus();
      if (status != null) {
         es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setText(status.getName() != null ? status.getName() : "");
         switch(1.$SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum[status.ordinal()]) {
         case 1:
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setVisibility(0);
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setVisibility(0);
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setColorFilter(ContextCompat.getColor(this.context, 2131100021));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setTextColor(ContextCompat.getColor(this.context, 2131100021));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setTextColor(ContextCompat.getColor(this.context, 2131100021));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setImageResource(2131231140);
            break;
         case 2:
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setVisibility(0);
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setVisibility(0);
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setColorFilter(ContextCompat.getColor(this.context, 2131100947));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setTextColor(ContextCompat.getColor(this.context, 2131100947));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setTextColor(ContextCompat.getColor(this.context, 2131100947));
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setImageResource(2131231049);
            break;
         case 3:
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$400(holder).setVisibility(4);
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$500(holder).setVisibility(4);

            try {
               double importe = Double.parseDouble(movementItem.getImporte());
               if (importe < 0.0D) {
                  es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setTextColor(ContextCompat.getColor(this.context, 2131100022));
               } else {
                  es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder.access$300(holder).setTextColor(ContextCompat.getColor(this.context, 2131100023));
               }
            } catch (Exception var9) {
               Log.e("ExpedientsController", "Error parseo datos", var9);
            }
         }
      } else {
         Log.i("MovementListAdapter", "Operacion sin estado -> jnuoper: " + movementItem.getJnuoper());
      }

      return convertView;
   }

   @NonNull
   public Filter getFilter() {
      if (this.movementsFilter == null) {
         this.movementsFilter = new es.santander.justicia.minisJusticia.adapters.MovementListAdapter.MovementsFilter(this, (1)null);
      }

      return this.movementsFilter;
   }

   // $FF: synthetic method
   static ArrayList access$700(MovementListAdapter x0) {
      return x0.movementList;
   }

   // $FF: synthetic method
   static ArrayList access$802(MovementListAdapter x0, ArrayList x1) {
      return x0.filteredList = x1;
   }
}
