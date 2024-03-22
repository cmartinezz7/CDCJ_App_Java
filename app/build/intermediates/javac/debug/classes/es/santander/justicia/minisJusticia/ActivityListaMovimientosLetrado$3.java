package es.santander.justicia.minisJusticia;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import java.util.Iterator;

class ActivityListaMovimientosLetrado$3 extends OnScrollListener {
   // $FF: synthetic field
   final ActivityListaMovimientosLetrado this$0;

   ActivityListaMovimientosLetrado$3(ActivityListaMovimientosLetrado this$0) {
      this.this$0 = this$0;
   }

   public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
      super.onScrolled(recyclerView, dx, dy);
      Log.d("Silos", "scrollBar " + ActivityListaMovimientosLetrado.access$500(this.this$0).computeVerticalScrollOffset());
      ActivityListaMovimientosLetrado.access$602(this.this$0, ActivityListaMovimientosLetrado.access$500(this.this$0).computeVerticalScrollOffset());
      float rango = 150.0F * (float)(ActivityListaMovimientosLetrado.access$700(this.this$0).size() + 1);
      float scrollRelativo = (float)ActivityListaMovimientosLetrado.access$600(this.this$0) > rango ? rango : (float)ActivityListaMovimientosLetrado.access$600(this.this$0);
      float scrollInverso = rango - scrollRelativo;
      float newTextSice = 16.0F * (scrollInverso / rango);
      float alpha = scrollInverso / rango;
      if (alpha < 0.2F) {
         alpha = 0.0F;
      }

      Iterator var9;
      if (ActivityListaMovimientosLetrado.access$700(this.this$0) != null) {
         var9 = ActivityListaMovimientosLetrado.access$800(this.this$0).iterator();

         while(var9.hasNext()) {
            QFontTextView tv = (QFontTextView)var9.next();
            tv.setTextSize(newTextSice);
            tv.setAlpha(alpha);
         }
      }

      var9 = ActivityListaMovimientosLetrado.access$900(this.this$0).iterator();

      while(var9.hasNext()) {
         View v = (View)var9.next();
         LayoutParams relativeParams = (LayoutParams)v.getLayoutParams();
         relativeParams.topMargin = (int)(5.0F * (scrollInverso / rango));
         v.setLayoutParams(relativeParams);
      }

   }
}
