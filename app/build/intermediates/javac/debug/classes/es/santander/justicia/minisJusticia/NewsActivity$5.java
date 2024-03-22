package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class NewsActivity$5 extends Animation {
   // $FF: synthetic field
   final View val$v;
   // $FF: synthetic field
   final int val$initialHeight;

   NewsActivity$5(View var1, int var2) {
      this.val$v = var1;
      this.val$initialHeight = var2;
   }

   protected void applyTransformation(float interpolatedTime, Transformation t) {
      if (interpolatedTime == 1.0F) {
         this.val$v.setVisibility(8);
      } else {
         this.val$v.getLayoutParams().height = this.val$initialHeight - (int)((float)this.val$initialHeight * interpolatedTime);
         this.val$v.requestLayout();
      }

   }

   public boolean willChangeBounds() {
      return true;
   }
}
