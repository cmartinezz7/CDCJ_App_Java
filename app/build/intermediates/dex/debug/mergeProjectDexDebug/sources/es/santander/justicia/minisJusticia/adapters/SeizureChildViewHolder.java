package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QTextView;

public class SeizureChildViewHolder extends ChildViewHolder {
    protected LinearLayout mCard;
    protected RelativeLayout mRelativeGlobal;
    protected QTextView mTextImporte;
    protected QTextView mTextNumDoc;
    protected QTextView mTextTitular;
    protected View mViewLaeral;

    public SeizureChildViewHolder(View itemView) {
        super(itemView);
        this.mCard = (LinearLayout) itemView.findViewById(R.id.card);
        this.mRelativeGlobal = (RelativeLayout) itemView.findViewById(R.id.relative_global);
        this.mTextNumDoc = (QTextView) itemView.findViewById(R.id.text_num_doc);
        this.mTextTitular = (QTextView) itemView.findViewById(R.id.text_titular);
        this.mTextImporte = (QTextView) itemView.findViewById(R.id.text_importe);
        this.mViewLaeral = itemView.findViewById(R.id.view_color);
    }
}
