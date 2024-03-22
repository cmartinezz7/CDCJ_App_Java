package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterListaMovimientos$ViewHolder extends ViewHolderAbstract {
   public ImageView imageSate;
   public RelativeLayout relativeGlobal;
   public QTextView textTypeMovement;
   public QTextView textId;
   public QTextView textDate;
   public QTextView textAmount;
   public QTextView textState;
   // $FF: synthetic field
   final AdapterListaMovimientos this$0;

   public AdapterListaMovimientos$ViewHolder(AdapterListaMovimientos this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.relativeGlobal = (RelativeLayout)itemView.findViewById(2131362627);
      this.imageSate = (ImageView)itemView.findViewById(2131362299);
      this.textTypeMovement = (QTextView)itemView.findViewById(2131362926);
      this.textId = (QTextView)itemView.findViewById(2131362891);
      this.textDate = (QTextView)itemView.findViewById(2131362878);
      this.textAmount = (QTextView)itemView.findViewById(2131362861);
      this.textState = (QTextView)itemView.findViewById(2131362923);
   }
}
