package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QTextView;

public class SeizureParentViewHolder extends ParentViewHolder {
    protected CardView mCard;
    protected ImageView mImageLateral;
    protected ImageView mImageSwipe;
    protected LinearLayout mLinear;
    protected LinearLayout mLinearGlobal;
    protected SwipeLayout mSwipeLayout;
    protected QTextView mTextExpediente;
    protected QTextView mTextFechaAlta;
    protected QTextView mTextImporte;
    protected QTextView mTextSituacion;
    protected QTextView mTextTipoEmbargo;

    public SeizureParentViewHolder(View itemView) {
        super(itemView);
        this.mCard = itemView.findViewById(R.id.card);
        this.mSwipeLayout = itemView.findViewById(R.id.swipe_layout);
        this.mLinearGlobal = (LinearLayout) itemView.findViewById(R.id.linear_card);
        this.mImageSwipe = (ImageView) itemView.findViewById(R.id.image_swipe);
        this.mLinear = (LinearLayout) itemView.findViewById(2131362393);
        this.mTextExpediente = (QTextView) itemView.findViewById(R.id.text_expediente);
        this.mTextFechaAlta = (QTextView) itemView.findViewById(R.id.text_fecha);
        this.mTextTipoEmbargo = (QTextView) itemView.findViewById(R.id.text_tipo);
        this.mTextSituacion = (QTextView) itemView.findViewById(R.id.text_situacion);
        this.mTextImporte = (QTextView) itemView.findViewById(R.id.text_importe);
        this.mImageLateral = (ImageView) itemView.findViewById(R.id.image_lateral);
    }
}
