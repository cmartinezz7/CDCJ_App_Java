package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import es.santander.justicia.minisJusticia.views.QTextView;

public class SeizureChildViewHolder extends ChildViewHolder {
   protected LinearLayout mCard;
   protected RelativeLayout mRelativeGlobal;
   protected QTextView mTextNumDoc;
   protected QTextView mTextTitular;
   protected QTextView mTextImporte;
   protected View mViewLaeral;

   public SeizureChildViewHolder(@NonNull View itemView) {
      super(itemView);
      this.mCard = (LinearLayout)itemView.findViewById(2131361981);
      this.mRelativeGlobal = (RelativeLayout)itemView.findViewById(2131362627);
      this.mTextNumDoc = (QTextView)itemView.findViewById(2131362907);
      this.mTextTitular = (QTextView)itemView.findViewById(2131362930);
      this.mTextImporte = (QTextView)itemView.findViewById(2131362893);
      this.mViewLaeral = itemView.findViewById(2131363160);
   }
}
