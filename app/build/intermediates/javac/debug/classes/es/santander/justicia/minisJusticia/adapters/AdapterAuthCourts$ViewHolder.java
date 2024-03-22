package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import androidx.cardview.widget.CardView;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterAuthCourts$ViewHolder extends ViewHolderAbstract {
   public QTextView textName;
   public QTextView textInitDate;
   public QTextView textFinDate;
   public QTextView textProfile;
   public CardView cardView;
   // $FF: synthetic field
   final AdapterAuthCourts this$0;

   public AdapterAuthCourts$ViewHolder(AdapterAuthCourts this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.cardView = (CardView)itemView.findViewById(2131361981);
      this.textName = (QTextView)itemView.findViewById(2131362809);
      this.textInitDate = (QTextView)itemView.findViewById(2131362807);
      this.textFinDate = (QTextView)itemView.findViewById(2131362806);
      this.textProfile = (QTextView)itemView.findViewById(2131362811);
   }
}
