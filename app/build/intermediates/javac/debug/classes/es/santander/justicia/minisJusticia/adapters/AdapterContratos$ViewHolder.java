package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import androidx.cardview.widget.CardView;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterContratos$ViewHolder extends ViewHolderAbstract {
   public QTextView textDoc;
   public QTextView textName;
   public QTextView textCode;
   public CardView cardView;
   // $FF: synthetic field
   final AdapterContratos this$0;

   public AdapterContratos$ViewHolder(AdapterContratos this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.cardView = (CardView)itemView.findViewById(2131361981);
      this.textDoc = (QTextView)itemView.findViewById(2131362803);
      this.textName = (QTextView)itemView.findViewById(2131362809);
      this.textCode = (QTextView)itemView.findViewById(2131362802);
   }
}
