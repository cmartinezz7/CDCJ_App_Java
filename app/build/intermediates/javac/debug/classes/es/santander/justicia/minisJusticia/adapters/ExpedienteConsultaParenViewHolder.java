package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteConsultaParenViewHolder extends ParentViewHolder {
   protected CardView mCard;
   protected SwipeLayout mSwipeLayout;
   protected ImageView mImageSwipe;
   protected ImageView mImageState;
   protected LinearLayout mLinearGlobal;
   protected QTextView mTextNumExp;
   protected QTextView mTextDateFirstMov;
   protected QTextView mTextDateLastMov;
   protected QTextView mTextSituation;
   protected QTextView mTextAmount;
   protected QTextView mImpCostas;
   protected LinearLayout lImpCostas;

   public ExpedienteConsultaParenViewHolder(@NonNull View itemView) {
      super(itemView);
      this.mCard = (CardView)itemView.findViewById(2131361981);
      this.mSwipeLayout = (SwipeLayout)itemView.findViewById(2131362772);
      this.mLinearGlobal = (LinearLayout)itemView.findViewById(2131362404);
      this.mImageSwipe = (ImageView)itemView.findViewById(2131362300);
      this.mImageState = (ImageView)itemView.findViewById(2131362299);
      this.mTextNumExp = (QTextView)itemView.findViewById(2131362908);
      this.mTextDateFirstMov = (QTextView)itemView.findViewById(2131362879);
      this.mTextDateLastMov = (QTextView)itemView.findViewById(2131362881);
      this.mTextSituation = (QTextView)itemView.findViewById(2131362921);
      this.mTextAmount = (QTextView)itemView.findViewById(2131362861);
      this.mImpCostas = (QTextView)itemView.findViewById(2131362892);
      this.lImpCostas = (LinearLayout)itemView.findViewById(2131362412);
   }
}
