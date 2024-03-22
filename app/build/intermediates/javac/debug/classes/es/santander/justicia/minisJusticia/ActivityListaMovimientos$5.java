package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;

class ActivityListaMovimientos$5 implements OnScrollListener {
   // $FF: synthetic field
   final ActivityListaMovimientos this$0;

   ActivityListaMovimientos$5(ActivityListaMovimientos this$0) {
      this.this$0 = this$0;
   }

   public void onScrollStateChanged(AbsListView view, int scrollState) {
   }

   public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
      int incrementalOffset = ActivityListaMovimientos.access$600(this.this$0).calculateIncrementalOffset(firstVisibleItem, visibleItemCount);
      ActivityListaMovimientos.access$720(this.this$0, incrementalOffset);
      float rango = 150.0F * (float)(ActivityListaMovimientos.access$800(this.this$0).size() + 1);
      float scrollRelativo = (float)ActivityListaMovimientos.access$700(this.this$0) > rango ? rango : (float)ActivityListaMovimientos.access$700(this.this$0);
      float scrollInverso = rango - scrollRelativo;
      float newTextSice = 16.0F * (scrollInverso / rango);
      float alpha = scrollInverso / rango;
      if (alpha < 0.2F) {
         alpha = 0.0F;
      }

      if (ActivityListaMovimientos.access$800(this.this$0) != null) {
         if (ActivityListaMovimientos.access$900(this.this$0) == null) {
            ActivityListaMovimientos.access$902(this.this$0, new ArrayList());
            ActivityListaMovimientos.access$1002(this.this$0, new ArrayList());

            for(int i = 1; i <= ActivityListaMovimientos.access$800(this.this$0).size() && i <= 5; ++i) {
               ActivityListaMovimientos.access$1000(this.this$0).add(this.this$0.findViewById(this.this$0.findIdByName("lnr_expandible" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("tv_text_total_abonos" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("tv_text_total_cargos" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("tv_text_total_pendiente" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("text_total_abonos" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("text_total_cargos" + i)));
               ActivityListaMovimientos.access$900(this.this$0).add((TextView)this.this$0.findViewById(this.this$0.findIdByName("text_total_pendiente" + i)));
            }
         }

         Iterator var14 = ActivityListaMovimientos.access$900(this.this$0).iterator();

         while(var14.hasNext()) {
            TextView tv = (TextView)var14.next();
            tv.setTextSize(newTextSice);
            tv.setAlpha(alpha);
         }

         var14 = ActivityListaMovimientos.access$1000(this.this$0).iterator();

         while(var14.hasNext()) {
            View v = (View)var14.next();
            LayoutParams relativeParams = (LayoutParams)v.getLayoutParams();
            relativeParams.topMargin = (int)(20.0F * (scrollInverso / rango));
            v.setLayoutParams(relativeParams);
         }
      }

   }
}
