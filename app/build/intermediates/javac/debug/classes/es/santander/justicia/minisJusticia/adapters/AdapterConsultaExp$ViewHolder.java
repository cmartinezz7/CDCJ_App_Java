package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import es.santander.justicia.minisJusticia.views.QFontButton;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterConsultaExp$ViewHolder extends ViewHolderAbstract {
   public CardView mCard;
   public LinearLayout mLinearDetail;
   public SwipeLayout mSwipeLayout;
   public ImageView mImageSwipe;
   public ImageView mImageState;
   public LinearLayout mLinearGlobal;
   public QTextView mTextNumExp;
   public QTextView mTextDateFirstMov;
   public QTextView mTextDateLastMov;
   public QTextView mTextSituation;
   public QTextView mTextAmount;
   public QTextView mImpCostas;
   public LinearLayout lImpCostas;
   public RelativeLayout mStateBar;
   public View mViewChild;
   public QTextView mTextAmountCurrency;
   public QTextView mTextAmountDay;
   public QTextView mTextIncomPdtCons;
   public QTextView mTextPdtCons;
   public QTextView mTextPdtConf;
   public QTextView mTextAmountCons;
   public QTextView mTextAmountDisp;
   public QTextView mTextAmountErr;
   public QTextView mTextAmountReso;
   public QTextView mTextPrincipal;
   public QFontButton mTextMovements;
   // $FF: synthetic field
   final AdapterConsultaExp this$0;

   public AdapterConsultaExp$ViewHolder(AdapterConsultaExp this$0, View itemView) {
      super(itemView);
      this.this$0 = this$0;
      this.mCard = (CardView)itemView.findViewById(2131361981);
      this.mLinearDetail = (LinearLayout)itemView.findViewById(2131362409);
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
      this.mStateBar = (RelativeLayout)itemView.findViewById(2131362143);
      this.mViewChild = itemView.findViewById(2131363160);
      this.mTextAmountCurrency = (QTextView)itemView.findViewById(2131362863);
      this.mTextAmountDay = (QTextView)itemView.findViewById(2131362864);
      this.mTextIncomPdtCons = (QTextView)itemView.findViewById(2131362895);
      this.mTextPdtCons = (QTextView)itemView.findViewById(2131362913);
      this.mTextPdtConf = (QTextView)itemView.findViewById(2131362912);
      this.mTextAmountCons = (QTextView)itemView.findViewById(2131362862);
      this.mTextAmountDisp = (QTextView)itemView.findViewById(2131362865);
      this.mTextAmountErr = (QTextView)itemView.findViewById(2131362894);
      this.mTextAmountReso = (QTextView)itemView.findViewById(2131362896);
      this.mTextPrincipal = (QTextView)itemView.findViewById(2131362916);
      this.mTextMovements = (QFontButton)itemView.findViewById(2131362903);
   }
}
