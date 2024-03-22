package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.views.QTextView;
import java.util.List;

public class AdapterPendintOperations extends AdapterAbstractRecycler<String> {
    public AdapterPendintOperations(Context context, AdapterAbstractRecycler.OnRecyclerClickListener listener, List<String> listNews) {
        super(context, listener, listNews);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_operations, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract holder, int position) {
    }

    public class ViewHolder extends ViewHolderAbstract {
        private QTextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            this.text = (QTextView) itemView.findViewById(2131362800);
        }
    }
}
