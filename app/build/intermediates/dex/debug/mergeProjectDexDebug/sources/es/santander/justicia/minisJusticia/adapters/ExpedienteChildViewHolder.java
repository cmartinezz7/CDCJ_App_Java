package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QTextView;

public class ExpedienteChildViewHolder extends ChildViewHolder {
    protected LinearLayout mCard;
    protected RelativeLayout mRelativeGlobal;
    protected QTextView mTextMovements;

    public ExpedienteChildViewHolder(View itemView) {
        super(itemView);
        this.mCard = (LinearLayout) itemView.findViewById(R.id.card);
        this.mRelativeGlobal = (RelativeLayout) itemView.findViewById(R.id.relative_global);
        QTextView qTextView = (QTextView) itemView.findViewById(R.id.text_movements);
        this.mTextMovements = qTextView;
        qTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }
}
