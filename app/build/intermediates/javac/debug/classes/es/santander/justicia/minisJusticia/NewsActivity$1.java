package es.santander.justicia.minisJusticia;

import android.util.Log;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;

class NewsActivity$1 implements OnPageChangeListener {
   // $FF: synthetic field
   final NewsActivity this$0;

   NewsActivity$1(NewsActivity this$0) {
      this.this$0 = this$0;
   }

   public void onPageScrollStateChanged(int state) {
   }

   public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
   }

   public void onPageSelected(int position) {
      Log.i("TAG", "position: " + position);
      switch(position) {
      case 0:
         TealiumHelper.trackView("/noticia_actual");
         break;
      case 1:
         TealiumHelper.trackView("/sentencia_dia");
         break;
      case 2:
         TealiumHelper.trackView("/enciclopedia_civil");
      }

   }
}
