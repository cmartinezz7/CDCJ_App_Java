package es.santander.justicia.minisJusticia;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class DetalleMovimientoActivity$2 implements OnPageChangeListener {
   // $FF: synthetic field
   final DetalleMovimientoActivity this$0;

   DetalleMovimientoActivity$2(DetalleMovimientoActivity this$0) {
      this.this$0 = this$0;
   }

   public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
   }

   public void onPageSelected(int position) {
      switch(position) {
      case 0:
         DetalleMovimientoActivity.access$100(this.this$0).setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.access$000(this.this$0), 2131231046));
         DetalleMovimientoActivity.access$200(this.this$0).setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.access$000(this.this$0), 2131231047));
         DetalleMovimientoActivity.access$302(this.this$0, 0);
         break;
      case 1:
         DetalleMovimientoActivity.access$100(this.this$0).setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.access$000(this.this$0), 2131231047));
         DetalleMovimientoActivity.access$200(this.this$0).setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.access$000(this.this$0), 2131231046));
         DetalleMovimientoActivity.access$302(this.this$0, 1);
      }

   }

   public void onPageScrollStateChanged(int state) {
   }
}
