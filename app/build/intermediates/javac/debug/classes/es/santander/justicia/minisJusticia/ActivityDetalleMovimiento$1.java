package es.santander.justicia.minisJusticia;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class ActivityDetalleMovimiento$1 implements OnPageChangeListener {
   // $FF: synthetic field
   final ActivityDetalleMovimiento this$0;

   ActivityDetalleMovimiento$1(ActivityDetalleMovimiento this$0) {
      this.this$0 = this$0;
   }

   public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
   }

   public void onPageSelected(int position) {
      switch(position) {
      case 0:
         ActivityDetalleMovimiento.access$100(this.this$0).setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.access$000(this.this$0), 2131231046));
         ActivityDetalleMovimiento.access$200(this.this$0).setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.access$000(this.this$0), 2131231047));
         ActivityDetalleMovimiento.access$302(this.this$0, 0);
         break;
      case 1:
         ActivityDetalleMovimiento.access$100(this.this$0).setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.access$000(this.this$0), 2131231047));
         ActivityDetalleMovimiento.access$200(this.this$0).setImageDrawable(ContextCompat.getDrawable(ActivityDetalleMovimiento.access$000(this.this$0), 2131231046));
         ActivityDetalleMovimiento.access$302(this.this$0, 1);
      }

   }

   public void onPageScrollStateChanged(int state) {
   }
}
