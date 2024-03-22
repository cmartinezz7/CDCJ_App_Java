package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class EnciclopediaFragment$3 implements OnClickListener {
   // $FF: synthetic field
   final EnciclopediaFragment this$0;

   EnciclopediaFragment$3(EnciclopediaFragment this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      int childcount = ((LinearLayout)v).getChildCount();
      ImageView imgView;
      int i;
      View childView;
      int childDivider;
      if (v.getTag().toString().contains("level1")) {
         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 0 && childDivider != 2131362098 && (childView.getTag().toString().contains("level2") || childView.getTag().toString().contains("item"))) {
               EnciclopediaFragment.collapse(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231018);
      } else if (v.getTag().toString().contains("level2")) {
         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 0 && childDivider != 2131362098 && (childView.getTag().toString().contains("level3") || childView.getTag().toString().contains("item"))) {
               EnciclopediaFragment.collapse(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231019);
      } else if (v.getTag().toString().contains("level3")) {
         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 0 && childDivider != 2131362098 && (childView.getTag().toString().contains("level4") || childView.getTag().toString().contains("item"))) {
               EnciclopediaFragment.collapse(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231020);
      } else if (v.getTag().toString().contains("level4")) {
         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 0 && childDivider != 2131362098 && (childView.getTag().toString().contains("level4") || childView.getTag().toString().contains("item"))) {
               EnciclopediaFragment.collapse(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231020);
      }

      v.setOnClickListener(EnciclopediaFragment.access$400(this.this$0));
   }
}
