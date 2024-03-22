package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

class EnciclopediaFragment$4 implements OnClickListener {
   // $FF: synthetic field
   final EnciclopediaFragment this$0;

   EnciclopediaFragment$4(EnciclopediaFragment this$0) {
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
            if (childView.getVisibility() == 8 && childDivider != 2131362098 && (childView.getTag().toString().contains("level2") || childView.getTag().toString().contains("item"))) {
               EnciclopediaFragment.expand(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231025);
      } else if (v.getTag().toString().contains("level2")) {
         this.this$0.expandLevel(v, 2);

         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 8 && childDivider != 2131362098 && (v.getTag().toString().contains("level3") || v.getTag().toString().contains("item"))) {
               EnciclopediaFragment.expand(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231026);
      } else if (v.getTag().toString().contains("level3")) {
         this.this$0.expandLevel(v, 3);

         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 8 && childDivider != 2131362098 && (v.getTag().toString().contains("level4") || v.getTag().toString().contains("item"))) {
               EnciclopediaFragment.expand(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231027);
      } else if (v.getTag().toString().contains("level4")) {
         this.this$0.expandLevel(v, 4);

         for(i = 2; i < childcount; ++i) {
            childView = ((LinearLayout)v).getChildAt(i);
            childDivider = childView.getId();
            if (childView.getVisibility() == 8 && childDivider != 2131362098 && (v.getTag().toString().contains("level5") || v.getTag().toString().contains("item"))) {
               EnciclopediaFragment.expand(childView);
            }
         }

         imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
         imgView.setImageResource(2131231027);
      }

      v.setOnClickListener(EnciclopediaFragment.access$500(this.this$0));
   }
}
