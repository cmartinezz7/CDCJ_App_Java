package es.santander.justicia.minisJusticia;

import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;

class NewsActivity$2 implements OnTabSelectedListener {
   // $FF: synthetic field
   final ViewPager val$viewPager;
   // $FF: synthetic field
   final Button val$enterLogin;
   // $FF: synthetic field
   final NewsActivity this$0;

   NewsActivity$2(NewsActivity this$0, ViewPager var2, Button var3) {
      this.this$0 = this$0;
      this.val$viewPager = var2;
      this.val$enterLogin = var3;
   }

   public void onTabSelected(Tab tab) {
      this.val$viewPager.setCurrentItem(tab.getPosition());
      if (tab.getPosition() != 1) {
         this.val$enterLogin.setVisibility(0);
      } else {
         this.val$enterLogin.setVisibility(8);
      }

   }

   public void onTabUnselected(Tab tab) {
   }

   public void onTabReselected(Tab tab) {
   }
}
