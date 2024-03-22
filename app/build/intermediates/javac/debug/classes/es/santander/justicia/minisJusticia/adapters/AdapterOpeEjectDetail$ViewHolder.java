package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterOpeEjectDetail$ViewHolder extends ViewHolderAbstract {
   private QTextView textNumExp;
   private QTextView textTitular;
   private QTextView textNMandamiento;
   private QTextView textDate;
   private QTextView textAmmount;
   private ImageView imageSwipe;
   private ImageView imageState;
   private SwipeLayout swipeLayout;
   // $FF: synthetic field
   final AdapterOpeEjectDetail this$0;

   public AdapterOpeEjectDetail$ViewHolder(AdapterOpeEjectDetail this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.textNumExp = (QTextView)itemView.findViewById(2131362908);
      this.textTitular = (QTextView)itemView.findViewById(2131362930);
      this.textNMandamiento = (QTextView)itemView.findViewById(2131362904);
      this.textDate = (QTextView)itemView.findViewById(2131362878);
      this.textAmmount = (QTextView)itemView.findViewById(2131362860);
      this.imageSwipe = (ImageView)itemView.findViewById(2131362300);
      this.imageState = (ImageView)itemView.findViewById(2131362299);
      this.swipeLayout = (SwipeLayout)itemView.findViewById(2131362772);
   }

   // $FF: synthetic method
   static QTextView access$000(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.textNumExp;
   }

   // $FF: synthetic method
   static QTextView access$100(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.textTitular;
   }

   // $FF: synthetic method
   static QTextView access$200(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.textNMandamiento;
   }

   // $FF: synthetic method
   static QTextView access$300(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.textDate;
   }

   // $FF: synthetic method
   static QTextView access$400(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.textAmmount;
   }

   // $FF: synthetic method
   static ImageView access$500(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.imageSwipe;
   }

   // $FF: synthetic method
   static SwipeLayout access$600(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.swipeLayout;
   }

   // $FF: synthetic method
   static ImageView access$700(AdapterOpeEjectDetail$ViewHolder x0) {
      return x0.imageState;
   }
}
