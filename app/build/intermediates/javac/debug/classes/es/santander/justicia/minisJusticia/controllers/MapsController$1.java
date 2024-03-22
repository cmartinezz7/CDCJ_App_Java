package es.santander.justicia.minisJusticia.controllers;

import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.model.CameraPosition;

class MapsController$1 implements OnCameraIdleListener {
   // $FF: synthetic field
   final CameraPosition[] val$mPreviousCameraPosition;
   // $FF: synthetic field
   final MapsController this$0;

   MapsController$1(MapsController this$0, CameraPosition[] var2) {
      this.this$0 = this$0;
      this.val$mPreviousCameraPosition = var2;
   }

   public void onCameraIdle() {
      CameraPosition position = MapsController.access$000(this.this$0).getCameraPosition();
      if (this.val$mPreviousCameraPosition[0] == null || this.val$mPreviousCameraPosition[0].zoom != position.zoom) {
         this.val$mPreviousCameraPosition[0] = MapsController.access$000(this.this$0).getCameraPosition();
         MapsController.access$100(this.this$0).cluster();
      }

   }
}
