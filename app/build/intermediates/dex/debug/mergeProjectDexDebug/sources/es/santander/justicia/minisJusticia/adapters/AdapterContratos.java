package es.santander.justicia.minisJusticia.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail;
import es.santander.justicia.minisJusticia.views.QTextView;

public class AdapterContratos extends AdapterAbstractRecycler<ContratoDetail> {
    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos, es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler$OnRecyclerClickListener] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdapterContratos(es.santander.justicia.minisJusticia.ActivityContratos r1, java.util.List<es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail> r2) {
        /*
            r0 = this;
            r0.<init>(r1, r1, r2)
            r0.mListItems = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterContratos.<init>(es.santander.justicia.minisJusticia.ActivityContratos, java.util.List):void");
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_contratos, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.textDoc.setText(((ContratoDetail) getItem(position)).getCodDocumento());
        holder.textName.setText(((ContratoDetail) getItem(position)).getAlias());
        holder.textCode.setText(((ContratoDetail) getItem(position)).getContrato().getLoginUnicoCentro().getEmpresa() + ((ContratoDetail) getItem(position)).getContrato().getLoginUnicoCentro().getCentro() + ((ContratoDetail) getItem(position)).getContrato().getProducto() + ((ContratoDetail) getItem(position)).getContrato().getNumeroDeContrato());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterContratos.this.mListener.onItemClickListener(position);
            }
        });
    }

    public class ViewHolder extends ViewHolderAbstract {
        public CardView cardView;
        public QTextView textCode;
        public QTextView textDoc;
        public QTextView textName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.card);
            this.textDoc = (QTextView) itemView.findViewById(R.id.textDoc);
            this.textName = (QTextView) itemView.findViewById(R.id.textName);
            this.textCode = (QTextView) itemView.findViewById(R.id.textCode);
        }
    }
}
