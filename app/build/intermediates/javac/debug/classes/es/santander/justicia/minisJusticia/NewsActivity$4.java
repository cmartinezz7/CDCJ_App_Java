package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class NewsActivity$4 extends Animation {
   // $FF: synthetic field
   final View val$v;
   // $FF: synthetic field
   final int val$targetHeight;

   NewsActivity$4(View var1, int var2) {
      this.val$v = var1;
      this.val$targetHeight = var2;
   }

   protected void applyTransformation(float interpolatedTime, Transformation t) {
      this.val$v.getLayoutParams().height = interpolatedTime == 1.0F ? -2 : (int)((float)this.val$targetHeight * interpolatedTime);
      this.val$v.requestLayout();
   }

   public boolean willChangeBounds() {
      return true;
   }
}
