package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuario;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import java.util.List;

public class AdapterAuthCourts extends AdapterAbstractRecycler<AutorizacionesUsuario> {
    public AdapterAuthCourts(Context context, AdapterAbstractRecycler.OnRecyclerClickListener listener, List<AutorizacionesUsuario> listOperaciones) {
        super(context, listener, listOperaciones);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_auth_court, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.textName.setText(((AutorizacionesUsuario) getItem(position)).getNombre() + " " + ((AutorizacionesUsuario) getItem(position)).getApellido1());
        holder.textInitDate.setText(DateUtils.formatDate(((AutorizacionesUsuario) getItem(position)).getFechaInicial(), Constants.DATE_FORMAT_AUTORIZATIONS));
        holder.textFinDate.setText(DateUtils.formatDate(((AutorizacionesUsuario) getItem(position)).getFechaFinal(), Constants.DATE_FORMAT_AUTORIZATIONS));
        holder.textProfile.setText(((AutorizacionesUsuario) getItem(position)).getPerfil());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterAuthCourts.this.mListener.onItemClickListener(position);
            }
        });
    }

    public class ViewHolder extends ViewHolderAbstract {
        public CardView cardView;
        public QTextView textFinDate;
        public QTextView textInitDate;
        public QTextView textName;
        public QTextView textProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.card);
            this.textName = (QTextView) itemView.findViewById(R.id.textName);
            this.textInitDate = (QTextView) itemView.findViewById(R.id.textInitDate);
            this.textFinDate = (QTextView) itemView.findViewById(R.id.textFinDate);
            this.textProfile = (QTextView) itemView.findViewById(R.id.textProfileAut);
        }
    }
}
