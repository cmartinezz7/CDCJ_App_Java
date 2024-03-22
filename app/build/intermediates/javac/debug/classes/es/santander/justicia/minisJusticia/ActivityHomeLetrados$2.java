package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

class ActivityHomeLetrados$2 extends ActionBarDrawerToggle {
   // $FF: synthetic field
   final ActivityHomeLetrados this$0;

   ActivityHomeLetrados$2(ActivityHomeLetrados this$0, Activity arg0, DrawerLayout arg1, Toolbar arg2, int arg3, int arg4) {
      super(arg0, arg1, arg2, arg3, arg4);
      this.this$0 = this$0;
   }

   public void onDrawerClosed(View drawerView) {
      super.onDrawerClosed(drawerView);
      this.this$0.invalidateOptionsMenu();
   }

   public void onDrawerOpened(View drawerView) {
      super.onDrawerOpened(drawerView);
      this.this$0.invalidateOptionsMenu();
   }

   public void onDrawerSlide(View drawerView, float slideOffset) {
      super.onDrawerSlide(drawerView, slideOffset);
      this.this$0.findViewById(2131362410).setTranslationX(slideOffset * (float)drawerView.getWidth());
      this.this$0.invalidateOptionsMenu();
   }
}
