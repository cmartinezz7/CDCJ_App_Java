package es.santander.justicia.minisJusticia.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import es.santander.justicia.utils.CommonUtils;

class FragmentAuthExp$9 implements OnClickListener {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$9(FragmentAuthExp this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      switch(view.getId()) {
      case 2131362858:
         ((RelativeLayout)view.getParent().getParent()).performClick();
         CommonUtils.showOperativaPopUp(this.this$0.getActivity(), this.this$0.getView(), this.this$0, true, 2131886705, FragmentAuthExp.access$600(this.this$0));
         break;
      case 2131362866:
         ((RelativeLayout)view.getParent().getParent()).performClick();
         CommonUtils.showOperativaPopUp(this.this$0.getActivity(), this.this$0.getView(), this.this$0, false, 2131886707, FragmentAuthExp.access$600(this.this$0));
         break;
      case 2131362883:
         ((RelativeLayout)view.getParent().getParent()).performClick();
         CommonUtils.showOperativaPopUp(this.this$0.getActivity(), this.this$0.getView(), this.this$0, true, 2131886712, FragmentAuthExp.access$600(this.this$0));
      }

   }
}
