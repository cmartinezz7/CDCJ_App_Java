package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class EnciclopediaFragment$1 extends Animation {
   // $FF: synthetic field
   final View val$v;
   // $FF: synthetic field
   final int val$targetHeight;

   EnciclopediaFragment$1(View var1, int var2) {
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
