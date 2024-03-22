package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.RelativeLayout;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterOperaciones$ViewHolder extends ViewHolderAbstract {
   private QTextView textTitleState;
   private QTextView textNumOperations;
   private QTextView textAmmount;
   private RelativeLayout relativeGlobal;
   // $FF: synthetic field
   final AdapterOperaciones this$0;

   public AdapterOperaciones$ViewHolder(AdapterOperaciones this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.textTitleState = (QTextView)itemView.findViewById(2131362928);
      this.textNumOperations = (QTextView)itemView.findViewById(2131362909);
      this.textAmmount = (QTextView)itemView.findViewById(2131362860);
      this.relativeGlobal = (RelativeLayout)itemView.findViewById(2131362627);
   }

   // $FF: synthetic method
   static QTextView access$000(AdapterOperaciones$ViewHolder x0) {
      return x0.textTitleState;
   }

   // $FF: synthetic method
   static QTextView access$100(AdapterOperaciones$ViewHolder x0) {
      return x0.textNumOperations;
   }

   // $FF: synthetic method
   static QTextView access$200(AdapterOperaciones$ViewHolder x0) {
      return x0.textAmmount;
   }

   // $FF: synthetic method
   static RelativeLayout access$300(AdapterOperaciones$ViewHolder x0) {
      return x0.relativeGlobal;
   }
}
