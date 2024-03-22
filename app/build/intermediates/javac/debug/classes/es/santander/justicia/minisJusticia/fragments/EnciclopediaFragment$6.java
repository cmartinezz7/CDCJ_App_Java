package es.santander.justicia.minisJusticia.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class EnciclopediaFragment$6 extends AnimatorListenerAdapter {
   // $FF: synthetic field
   final boolean val$show;
   // $FF: synthetic field
   final EnciclopediaFragment this$0;

   EnciclopediaFragment$6(EnciclopediaFragment this$0, boolean var2) {
      this.this$0 = this$0;
      this.val$show = var2;
   }

   public void onAnimationEnd(Animator animation) {
      EnciclopediaFragment.access$600(this.this$0).setVisibility(this.val$show ? 0 : 8);
   }
}
