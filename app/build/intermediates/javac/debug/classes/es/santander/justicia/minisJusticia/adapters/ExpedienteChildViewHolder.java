package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import es.santander.justicia.minisJusticia.adapters.ExpedienteChildViewHolder.1;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteChildViewHolder extends ChildViewHolder {
   protected LinearLayout mCard;
   protected RelativeLayout mRelativeGlobal;
   protected QTextView mTextMovements;

   public ExpedienteChildViewHolder(@NonNull View itemView) {
      super(itemView);
      this.mCard = (LinearLayout)itemView.findViewById(2131361981);
      this.mRelativeGlobal = (RelativeLayout)itemView.findViewById(2131362627);
      this.mTextMovements = (QTextView)itemView.findViewById(2131362903);
      this.mTextMovements.setOnClickListener(new 1(this));
   }
}
