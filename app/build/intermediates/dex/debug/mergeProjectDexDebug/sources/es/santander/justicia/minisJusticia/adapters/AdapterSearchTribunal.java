package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterSearchTribunal extends AdapterAbstractRecycler<DatosJuzgado> {
    public AdapterSearchTribunal(Context context, List<DatosJuzgado> listNews) {
        super(context, (AdapterAbstractRecycler.OnRecyclerClickListener) context, listNews);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_tribunals, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.relativeGlobal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterSearchTribunal.this.mListener.onItemClickListener(position);
            }
        });
        holder.textTilte.setText(CommonUtils.wordCapitalize(((DatosJuzgado) getItem(position)).getNombreOrganismo()));
        holder.textEntorno.setText(CommonUtils.wordCapitalize(((DatosJuzgado) getItem(position)).getEntornoJudicial()));
        holder.textState.setText(((DatosJuzgado) getItem(position)).getEstado());
        holder.textProvince.setText(CommonUtils.wordCapitalize(((DatosJuzgado) getItem(position)).getProvincia()));
    }

    public class ViewHolder extends ViewHolderAbstract {
        /* access modifiers changed from: private */
        public RelativeLayout relativeGlobal;
        /* access modifiers changed from: private */
        public QTextView textEntorno;
        /* access modifiers changed from: private */
        public QTextView textProvince;
        /* access modifiers changed from: private */
        public QTextView textState;
        /* access modifiers changed from: private */
        public QTextView textTilte;

        public ViewHolder(View itemView) {
            super(itemView);
            this.relativeGlobal = (RelativeLayout) itemView.findViewById(R.id.relative_global);
            this.textTilte = (QTextView) itemView.findViewById(R.id.text_title);
            this.textEntorno = (QTextView) itemView.findViewById(R.id.text_entorno);
            this.textState = (QTextView) itemView.findViewById(R.id.text_state);
            this.textProvince = (QTextView) itemView.findViewById(R.id.text_province);
        }
    }
}
