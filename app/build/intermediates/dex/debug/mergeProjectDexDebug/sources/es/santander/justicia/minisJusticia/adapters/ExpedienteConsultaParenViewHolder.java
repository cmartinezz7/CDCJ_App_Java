package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteConsultaParenViewHolder extends ParentViewHolder {
    protected LinearLayout lImpCostas;
    protected CardView mCard;
    protected ImageView mImageState;
    protected ImageView mImageSwipe;
    protected QTextView mImpCostas;
    protected LinearLayout mLinearGlobal;
    protected SwipeLayout mSwipeLayout;
    protected QTextView mTextAmount;
    protected QTextView mTextDateFirstMov;
    protected QTextView mTextDateLastMov;
    protected QTextView mTextNumExp;
    protected QTextView mTextSituation;

    public ExpedienteConsultaParenViewHolder(View itemView) {
        super(itemView);
        this.mCard = itemView.findViewById(R.id.card);
        this.mSwipeLayout = itemView.findViewById(R.id.swipe_layout);
        this.mLinearGlobal = (LinearLayout) itemView.findViewById(R.id.linear_card);
        this.mImageSwipe = (ImageView) itemView.findViewById(R.id.image_swipe);
        this.mImageState = (ImageView) itemView.findViewById(R.id.image_state);
        this.mTextNumExp = (QTextView) itemView.findViewById(R.id.text_num_exp);
        this.mTextDateFirstMov = (QTextView) itemView.findViewById(R.id.text_date_first);
        this.mTextDateLastMov = (QTextView) itemView.findViewById(R.id.text_date_last);
        this.mTextSituation = (QTextView) itemView.findViewById(R.id.text_situation);
        this.mTextAmount = (QTextView) itemView.findViewById(R.id.text_amount);
        this.mImpCostas = (QTextView) itemView.findViewById(R.id.text_impCostas);
        this.lImpCostas = (LinearLayout) itemView.findViewById(R.id.linear_impCostas);
    }
}
