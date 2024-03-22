package es.santander.justicia.minisJusticia;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener;
import es.santander.justicia.utils.CommonUtils;

class SolicitudAccesoActivity$1 implements DrawerListener {
   // $FF: synthetic field
   final SolicitudAccesoActivity this$0;

   SolicitudAccesoActivity$1(SolicitudAccesoActivity this$0) {
      this.this$0 = this$0;
   }

   public void onDrawerSlide(View drawerView, float slideOffset) {
      CommonUtils.hideKeyboard(SolicitudAccesoActivity.access$000(this.this$0));
   }

   public void onDrawerOpened(View drawerView) {
   }

   public void onDrawerClosed(View drawerView) {
   }

   public void onDrawerStateChanged(int newState) {
   }
}
