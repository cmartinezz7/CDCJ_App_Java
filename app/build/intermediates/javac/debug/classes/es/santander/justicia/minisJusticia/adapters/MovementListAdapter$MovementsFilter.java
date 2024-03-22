package es.santander.justicia.minisJusticia.adapters;

import android.util.Log;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import es.santander.justicia.minisJusticia.adapters.MovementListAdapter.1;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class MovementListAdapter$MovementsFilter extends Filter {
   // $FF: synthetic field
   final MovementListAdapter this$0;

   private MovementListAdapter$MovementsFilter(MovementListAdapter var1) {
      this.this$0 = var1;
   }

   protected FilterResults performFiltering(CharSequence constraint) {
      FilterResults results = new FilterResults();
      if (constraint != null && constraint.length() != 0) {
         ArrayList<MovementItemDTO> tempMovementList = new ArrayList();
         String[] parameters = constraint.toString().split(":");
         String dateFrom = parameters[0];
         String dateTo = parameters[1];
         String importFrom = parameters[2];
         String importTo = parameters[3];
         String movementType = parameters[4];
         String coinType = parameters[5];
         if (dateFrom.equals("null") && dateTo.equals("null") && importFrom.equals("null") && importTo.equals("null") && movementType.equals("null") && coinType.equals("null")) {
            results.values = MovementListAdapter.access$700(this.this$0);
            results.count = MovementListAdapter.access$700(this.this$0).size();
         } else {
            Iterator var12 = MovementListAdapter.access$700(this.this$0).iterator();

            while(var12.hasNext()) {
               MovementItemDTO movement = (MovementItemDTO)var12.next();
               boolean passFilter = false;
               String itemDate = movement.getJfechare();
               String itemImport = movement.getJimpnomi();
               String itemMovementType = movement.getImporte();
               String itemCoinType = movement.getMoneda();
               SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
               Date to;
               Date date;
               if (!dateFrom.equals("null") && !dateTo.equals("null")) {
                  try {
                     to = sdf.parse(dateFrom);
                     date = sdf.parse(itemDate);
                     Date to = sdf.parse(dateTo);
                     if (date.before(to) && date.after(to) || date.equals(to) || date.equals(to)) {
                        passFilter = true;
                     }
                  } catch (ParseException var27) {
                     Log.e("performFiltering", "ParseException", var27);
                  }
               } else if (!dateFrom.equals("null") && dateTo.equals("null")) {
                  try {
                     to = sdf.parse(dateFrom);
                     date = sdf.parse(itemDate);
                     if (date.equals(to) || date.after(to)) {
                        passFilter = true;
                     }
                  } catch (ParseException var25) {
                     Log.e("performFiltering", "ParseException", var25);
                  }
               } else if (dateFrom.equals("null") && !dateTo.equals("null")) {
                  try {
                     to = sdf.parse(dateTo);
                     date = sdf.parse(itemDate);
                     if (date.equals(to) || date.before(to)) {
                        passFilter = true;
                     }
                  } catch (ParseException var26) {
                     Log.e("performFiltering", "ParseException", var26);
                  }
               } else {
                  passFilter = true;
               }

               if (passFilter) {
                  passFilter = false;
                  double to;
                  double iImport;
                  if (!importFrom.equals("null") && !importTo.equals("null")) {
                     to = Double.parseDouble(importFrom);
                     iImport = Double.parseDouble(itemImport);
                     double to = Double.parseDouble(importTo);
                     if (iImport > to && iImport < to || iImport == to || iImport == to) {
                        passFilter = true;
                     }
                  } else if (!importFrom.equals("null") && importTo.equals("null")) {
                     to = Double.parseDouble(importFrom);
                     iImport = Double.parseDouble(itemImport);
                     if (iImport >= to) {
                        passFilter = true;
                     }
                  } else if (importFrom.equals("null") && !importTo.equals("null")) {
                     to = Double.parseDouble(importTo);
                     iImport = Double.parseDouble(itemImport);
                     if (iImport <= to) {
                        passFilter = true;
                     }
                  } else if (importFrom.equals("null") && importTo.equals("null")) {
                     passFilter = true;
                  }
               }

               if (passFilter) {
                  passFilter = false;
                  if (!movementType.equals("null") && itemMovementType.equals(movementType)) {
                     passFilter = true;
                  } else if (movementType.equals("null")) {
                     passFilter = true;
                  }
               }

               if (passFilter) {
                  passFilter = false;
                  if (!coinType.equals("null") && itemCoinType.equals(coinType)) {
                     passFilter = true;
                  } else if (coinType.equals("null")) {
                     passFilter = true;
                  }
               }

               if (passFilter) {
                  tempMovementList.add(movement);
               }
            }

            results.values = tempMovementList;
            results.count = tempMovementList.size();
         }
      } else {
         results.values = MovementListAdapter.access$700(this.this$0);
         results.count = MovementListAdapter.access$700(this.this$0).size();
      }

      return results;
   }

   protected void publishResults(CharSequence constraint, FilterResults results) {
      MovementListAdapter.access$802(this.this$0, (ArrayList)results.values);
      this.this$0.notifyDataSetChanged();
   }

   // $FF: synthetic method
   MovementListAdapter$MovementsFilter(MovementListAdapter x0, 1 x1) {
      this(x0);
   }
}
