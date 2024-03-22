package es.santander.justicia.minisJusticia;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;

class BienvenidaViewPagerActivity$1 implements OnPageChangeListener {
   // $FF: synthetic field
   final BienvenidaViewPagerActivity this$0;

   BienvenidaViewPagerActivity$1(BienvenidaViewPagerActivity this$0) {
      this.this$0 = this$0;
   }

   public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
   }

   public void onPageSelected(int position) {
      switch(position) {
      case 0:
         TealiumHelper.trackView("/resumenApp");
         BienvenidaViewPagerActivity.access$000(this.this$0).setImageDrawable(this.this$0.getResources().getDrawable(2131231046));
         BienvenidaViewPagerActivity.access$100(this.this$0).setImageDrawable(this.this$0.getResources().getDrawable(2131231047));
         BienvenidaViewPagerActivity.access$202(this.this$0, 0);
         break;
      case 1:
         TealiumHelper.trackView("/bienvenida");
         BienvenidaViewPagerActivity.access$000(this.this$0).setImageDrawable(this.this$0.getResources().getDrawable(2131231047));
         BienvenidaViewPagerActivity.access$100(this.this$0).setImageDrawable(this.this$0.getResources().getDrawable(2131231046));
         BienvenidaViewPagerActivity.access$202(this.this$0, 1);
      }

   }

   public void onPageScrollStateChanged(int state) {
   }
}
