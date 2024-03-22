package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.DatosOperacion;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterListaMovimientos extends AdapterAbstractRecycler<DatosOperacion> {
    public AdapterListaMovimientos(Context context, List<DatosOperacion> listOperaciones) {
        super(context, (AdapterAbstractRecycler.OnRecyclerClickListener) context, listOperaciones);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_lista_movimientos, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.textTypeMovement.setText(CommonUtils.capitalize(((DatosOperacion) getItem(position)).getDesctipomod()));
        holder.textId.setText(((DatosOperacion) getItem(position)).getSerieYMandamiento());
        holder.textDate.setText(CommonUtils.getDateFromExp(((DatosOperacion) getItem(position)).getJfechare()));
        holder.relativeGlobal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AdapterListaMovimientos.this.mListener.onItemClickListener(position);
            }
        });
        if (((DatosOperacion) getItem(position)).getJimpnomi() != null && !((DatosOperacion) getItem(position)).getJimpnomi().isEmpty()) {
            holder.imageSate.setVisibility(8);
            holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion) getItem(position)).getJimpnomi()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion) getItem(position)).getCodmon()));
            holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, ((DatosOperacion) getItem(position)).getJimpnomi().startsWith("-") ? R.color.lista_movimientos_rojo : R.color.lista_movimientos_verde));
            holder.textState.setVisibility(8);
        } else if (((DatosOperacion) getItem(position)).getJimppend() != null && !((DatosOperacion) getItem(position)).getJimppend().isEmpty()) {
            holder.imageSate.setVisibility(0);
            holder.imageSate.setImageResource(R.drawable.ic_pendiente_movimiento);
            holder.imageSate.setColorFilter(ContextCompat.getColor(this.mContext, R.color.lista_movimientos_amarillo));
            holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion) getItem(position)).getJimppend()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion) getItem(position)).getCodmon()));
            holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, R.color.lista_movimientos_amarillo));
            holder.textState.setVisibility(0);
            holder.textState.setText(this.mContext.getString(R.string.movement_pendiente));
            holder.textState.setTextColor(ContextCompat.getColor(this.mContext, R.color.lista_movimientos_amarillo));
        } else if (((DatosOperacion) getItem(position)).getJimpcaduca() != null && !((DatosOperacion) getItem(position)).getJimpcaduca().isEmpty()) {
            holder.imageSate.setVisibility(0);
            holder.imageSate.setImageResource(R.drawable.ic_caducado);
            holder.imageSate.setColorFilter(ContextCompat.getColor(this.mContext, R.color.text_color));
            holder.textAmount.setText(CommonUtils.formatImport(((DatosOperacion) getItem(position)).getJimpcaduca()) + " " + CommonUtils.getCurrencySymbol(((DatosOperacion) getItem(position)).getCodmon()));
            holder.textAmount.setTextColor(ContextCompat.getColor(this.mContext, R.color.labelExpediente));
            holder.textState.setVisibility(0);
            holder.textState.setText(this.mContext.getString(R.string.movement_caducado));
            holder.textState.setTextColor(ContextCompat.getColor(this.mContext, R.color.labelExpediente));
        }
    }

    public class ViewHolder extends ViewHolderAbstract {
        public ImageView imageSate;
        public RelativeLayout relativeGlobal;
        public QTextView textAmount;
        public QTextView textDate;
        public QTextView textId;
        public QTextView textState;
        public QTextView textTypeMovement;

        public ViewHolder(View itemView) {
            super(itemView);
            this.relativeGlobal = (RelativeLayout) itemView.findViewById(R.id.relative_global);
            this.imageSate = (ImageView) itemView.findViewById(R.id.image_state);
            this.textTypeMovement = (QTextView) itemView.findViewById(R.id.text_tipo_movement);
            this.textId = (QTextView) itemView.findViewById(R.id.text_id);
            this.textDate = (QTextView) itemView.findViewById(R.id.text_date);
            this.textAmount = (QTextView) itemView.findViewById(R.id.text_amount);
            this.textState = (QTextView) itemView.findViewById(R.id.text_state);
        }
    }
}
