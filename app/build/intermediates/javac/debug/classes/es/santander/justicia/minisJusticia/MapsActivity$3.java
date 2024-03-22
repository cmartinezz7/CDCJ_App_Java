package es.santander.justicia.minisJusticia;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;

class MapsActivity$3 implements OnClickListener {
   // $FF: synthetic field
   final MapsActivity this$0;

   MapsActivity$3(MapsActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(DialogInterface paramDialogInterface, int paramInt) {
      Intent myIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      this.this$0.startActivity(myIntent);
   }
}
