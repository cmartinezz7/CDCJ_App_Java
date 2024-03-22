package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.LinearLayout;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterSelectrTribunal$ViewHolder extends ViewHolderAbstract {
   private LinearLayout linearGlobal;
   private View viewSelcted;
   private QTextView textTribunalName;
   private QTextView textRelationType;
   private QTextView textCharge;
   private QTextView textInitDate;
   private QTextView textEndDate;
   // $FF: synthetic field
   final AdapterSelectrTribunal this$0;

   public AdapterSelectrTribunal$ViewHolder(AdapterSelectrTribunal this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.linearGlobal = (LinearLayout)itemView.findViewById(2131362411);
      this.viewSelcted = itemView.findViewById(2131363168);
      this.textTribunalName = (QTextView)itemView.findViewById(2131362947);
      this.textRelationType = (QTextView)itemView.findViewById(2131362919);
      this.textCharge = (QTextView)itemView.findViewById(2131362877);
      this.textInitDate = (QTextView)itemView.findViewById(2131362897);
      this.textEndDate = (QTextView)itemView.findViewById(2131362885);
   }

   // $FF: synthetic method
   static LinearLayout access$000(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.linearGlobal;
   }

   // $FF: synthetic method
   static View access$100(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.viewSelcted;
   }

   // $FF: synthetic method
   static QTextView access$200(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.textTribunalName;
   }

   // $FF: synthetic method
   static QTextView access$300(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.textRelationType;
   }

   // $FF: synthetic method
   static QTextView access$400(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.textCharge;
   }

   // $FF: synthetic method
   static QTextView access$500(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.textInitDate;
   }

   // $FF: synthetic method
   static QTextView access$600(AdapterSelectrTribunal$ViewHolder x0) {
      return x0.textEndDate;
   }
}
