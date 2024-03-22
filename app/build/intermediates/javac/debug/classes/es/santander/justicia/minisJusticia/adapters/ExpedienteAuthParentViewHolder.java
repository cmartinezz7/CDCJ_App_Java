package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteAuthParentViewHolder extends ParentViewHolder {
   protected CardView mCard;
   protected SwipeLayout mSwipeLayout;
   protected ImageView mImageSwipe;
   protected LinearLayout mLinearGlobal;
   protected QTextView mTextNumExp;
   protected QTextView mTextDate;
   protected QTextView mTextState;
   protected QTextView mTextStateC;
   protected QTextView mTextName;

   public ExpedienteAuthParentViewHolder(@NonNull View itemView) {
      super(itemView);
      this.mCard = (CardView)itemView.findViewById(2131361981);
      this.mSwipeLayout = (SwipeLayout)itemView.findViewById(2131362772);
      this.mLinearGlobal = (LinearLayout)itemView.findViewById(2131362404);
      this.mImageSwipe = (ImageView)itemView.findViewById(2131362300);
      this.mTextNumExp = (QTextView)itemView.findViewById(2131362908);
      this.mTextDate = (QTextView)itemView.findViewById(2131362878);
      this.mTextState = (QTextView)itemView.findViewById(2131362923);
      this.mTextStateC = (QTextView)itemView.findViewById(2131362924);
      this.mTextName = (QTextView)itemView.findViewById(2131362906);
   }
}
