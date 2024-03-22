package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganoAsignadoDetail;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.List;

public class AdapterSelectrTribunal extends AdapterAbstractRecycler<ConsultaOrganoAsignadoDetail> {
    private boolean makeAnimation;

    public AdapterSelectrTribunal(Context context, List<ConsultaOrganoAsignadoDetail> listNews) {
        super(context, (AdapterAbstractRecycler.OnRecyclerClickListener) context, listNews);
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_select_tribunal, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        ViewHolder holder = (ViewHolder) abstractHolder;
        holder.linearGlobal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterSelectrTribunal.this.mListener.onItemClickListener(position);
            }
        });
        if (PreferencesHelper.newInstance(this.mContext).getString(Constants.PREFERECENCE_USER) == null || PreferencesHelper.newInstance(this.mContext).getString(Constants.PREFERECENCE_USER).isEmpty() || position != 0) {
            holder.viewSelcted.setVisibility(8);
        } else {
            holder.viewSelcted.setVisibility(0);
        }
        holder.textTribunalName.setText(((ConsultaOrganoAsignadoDetail) getItem(position)).getCodUo() + " " + ((ConsultaOrganoAsignadoDetail) getItem(position)).getDesUo());
        holder.textRelationType.setText(((ConsultaOrganoAsignadoDetail) getItem(position)).getDesTipRelacion());
        holder.textCharge.setText(((ConsultaOrganoAsignadoDetail) getItem(position)).getDesCargo());
        holder.textInitDate.setText(CommonUtils.getDateFromExp(((ConsultaOrganoAsignadoDetail) getItem(position)).getFecInicio()));
        holder.textEndDate.setText(CommonUtils.getDateFromExp(((ConsultaOrganoAsignadoDetail) getItem(position)).getFecFin()));
        if (position == 0 && this.makeAnimation) {
            animate(holder, R.anim.up_to_down);
            setMakeAnimation(false);
        }
    }

    public void setMakeAnimation(boolean value) {
        this.makeAnimation = value;
    }

    private void animate(RecyclerView.ViewHolder viewHolder, int animation) {
        viewHolder.itemView.setAnimation(AnimationUtils.loadAnimation(this.mContext, animation));
    }

    public class ViewHolder extends ViewHolderAbstract {
        /* access modifiers changed from: private */
        public LinearLayout linearGlobal;
        /* access modifiers changed from: private */
        public QTextView textCharge;
        /* access modifiers changed from: private */
        public QTextView textEndDate;
        /* access modifiers changed from: private */
        public QTextView textInitDate;
        /* access modifiers changed from: private */
        public QTextView textRelationType;
        /* access modifiers changed from: private */
        public QTextView textTribunalName;
        /* access modifiers changed from: private */
        public View viewSelcted;

        public ViewHolder(View itemView) {
            super(itemView);
            this.linearGlobal = (LinearLayout) itemView.findViewById(R.id.linear_global);
            this.viewSelcted = itemView.findViewById(R.id.view_tribunal_selected);
            this.textTribunalName = (QTextView) itemView.findViewById(R.id.text_tribunal_name);
            this.textRelationType = (QTextView) itemView.findViewById(R.id.text_relaction_type);
            this.textCharge = (QTextView) itemView.findViewById(R.id.text_charge);
            this.textInitDate = (QTextView) itemView.findViewById(R.id.text_init_date);
            this.textEndDate = (QTextView) itemView.findViewById(R.id.text_end_date);
        }
    }
}
