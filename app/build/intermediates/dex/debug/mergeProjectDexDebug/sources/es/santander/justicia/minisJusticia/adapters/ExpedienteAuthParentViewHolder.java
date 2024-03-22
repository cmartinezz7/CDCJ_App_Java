package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteAuthParentViewHolder extends ParentViewHolder {
    protected CardView mCard;
    protected ImageView mImageSwipe;
    protected LinearLayout mLinearGlobal;
    protected SwipeLayout mSwipeLayout;
    protected QTextView mTextDate;
    protected QTextView mTextName;
    protected QTextView mTextNumExp;
    protected QTextView mTextState;
    protected QTextView mTextStateC;

    public ExpedienteAuthParentViewHolder(View itemView) {
        super(itemView);
        this.mCard = itemView.findViewById(R.id.card);
        this.mSwipeLayout = itemView.findViewById(R.id.swipe_layout);
        this.mLinearGlobal = (LinearLayout) itemView.findViewById(R.id.linear_card);
        this.mImageSwipe = (ImageView) itemView.findViewById(R.id.image_swipe);
        this.mTextNumExp = (QTextView) itemView.findViewById(R.id.text_num_exp);
        this.mTextDate = (QTextView) itemView.findViewById(R.id.text_date);
        this.mTextState = (QTextView) itemView.findViewById(R.id.text_state);
        this.mTextStateC = (QTextView) itemView.findViewById(R.id.text_state_c);
        this.mTextName = (QTextView) itemView.findViewById(R.id.text_name);
    }
}
