package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.minisJusticia.BienvenidaViewPagerActivity.1;
import es.santander.justicia.minisJusticia.adapters.AdaptadorPagerPantallaBienvenida;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;

public class BienvenidaViewPagerActivity extends MainActivity {
   private ViewPager viewPager;
   private ImageView bullet1;
   private ImageView bullet2;
   private int currentPage = -1;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/resumenApp");
      this.setContentView(2131558429);
      this.getWindow().setFlags(1024, 1024);
      this.bullet1 = (ImageView)this.findViewById(2131362338);
      this.bullet2 = (ImageView)this.findViewById(2131362339);
      this.viewPager = (ViewPager)this.findViewById(2131362042);
      this.viewPager.setAdapter(new AdaptadorPagerPantallaBienvenida(this.getSupportFragmentManager()));
      this.viewPager.setOnPageChangeListener(new 1(this));
   }

   protected void onResume() {
      super.onResume();
      if (this.viewPager != null && this.currentPage != 1) {
         this.viewPager.setCurrentItem(this.currentPage);
      }

   }

   // $FF: synthetic method
   static ImageView access$000(BienvenidaViewPagerActivity x0) {
      return x0.bullet1;
   }

   // $FF: synthetic method
   static ImageView access$100(BienvenidaViewPagerActivity x0) {
      return x0.bullet2;
   }

   // $FF: synthetic method
   static int access$202(BienvenidaViewPagerActivity x0, int x1) {
      return x0.currentPage = x1;
   }
}
