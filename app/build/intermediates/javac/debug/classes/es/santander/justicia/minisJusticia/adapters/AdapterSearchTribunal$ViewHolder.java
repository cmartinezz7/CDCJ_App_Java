package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.RelativeLayout;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterSearchTribunal$ViewHolder extends ViewHolderAbstract {
   private RelativeLayout relativeGlobal;
   private QTextView textTilte;
   private QTextView textEntorno;
   private QTextView textState;
   private QTextView textProvince;
   // $FF: synthetic field
   final AdapterSearchTribunal this$0;

   public AdapterSearchTribunal$ViewHolder(AdapterSearchTribunal this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.relativeGlobal = (RelativeLayout)itemView.findViewById(2131362627);
      this.textTilte = (QTextView)itemView.findViewById(2131362927);
      this.textEntorno = (QTextView)itemView.findViewById(2131362886);
      this.textState = (QTextView)itemView.findViewById(2131362923);
      this.textProvince = (QTextView)itemView.findViewById(2131362917);
   }

   // $FF: synthetic method
   static RelativeLayout access$000(AdapterSearchTribunal$ViewHolder x0) {
      return x0.relativeGlobal;
   }

   // $FF: synthetic method
   static QTextView access$100(AdapterSearchTribunal$ViewHolder x0) {
      return x0.textTilte;
   }

   // $FF: synthetic method
   static QTextView access$200(AdapterSearchTribunal$ViewHolder x0) {
      return x0.textEntorno;
   }

   // $FF: synthetic method
   static QTextView access$300(AdapterSearchTribunal$ViewHolder x0) {
      return x0.textState;
   }

   // $FF: synthetic method
   static QTextView access$400(AdapterSearchTribunal$ViewHolder x0) {
      return x0.textProvince;
   }
}
