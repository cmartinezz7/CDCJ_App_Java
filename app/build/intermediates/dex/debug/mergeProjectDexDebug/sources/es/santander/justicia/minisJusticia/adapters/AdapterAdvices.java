package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.avisos.Avisos;
import es.santander.justicia.minisJusticia.views.QTextView;
import java.util.List;

public class AdapterAdvices extends AdapterAbstractRecycler<Avisos> {
    public AdapterAdvices(Context context, AdapterAbstractRecycler.OnRecyclerClickListener listener, List<Avisos> listaAdvices) {
        super(context, listener, listaAdvices);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_advices, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.text.setText(((Avisos) getItem(position)).getDesAviso());
        holder.text.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterAdvices.this.mListener.onItemClickListener(position);
            }
        });
    }

    public class ViewHolder extends ViewHolderAbstract {
        /* access modifiers changed from: private */
        public QTextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            this.text = (QTextView) itemView.findViewById(2131362800);
        }
    }
}
