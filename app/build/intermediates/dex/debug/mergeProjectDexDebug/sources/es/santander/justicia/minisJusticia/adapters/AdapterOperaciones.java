package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.responses.OperacionGlobal;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.InitConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdapterOperaciones extends AdapterAbstractRecycler<OperacionGlobal> {
    public static final int TYPE_DONE = 2;
    public static final int TYPE_PENDING = 1;
    private int mType;
    private ArrayList<SpinnerValuesDTO> operations = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_OPERATIONS);

    public AdapterOperaciones(Context context, AdapterAbstractRecycler.OnRecyclerClickListener listener, List<OperacionGlobal> listNews, int type) {
        super(context, listener, listNews);
        this.mType = type;
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.card_operations, parent, false));
    }

    public void onBindViewHolder(ViewHolderAbstract holderAbstract, final int position) {
        ViewHolder holder = (ViewHolder) holderAbstract;
        holder.textTitleState.setText(CommonUtils.capitalize(getOperationDescription(((OperacionGlobal) getItem(position)).getTipoOpe())));
        holder.textNumOperations.setText(((OperacionGlobal) getItem(position)).getTotalOperaciones());
        holder.textAmmount.setText(CommonUtils.formatImport(((OperacionGlobal) getItem(position)).getImporte()) + " " + CommonUtils.getCurrencySymbol(((OperacionGlobal) getItem(position)).getCodmon()));
        holder.relativeGlobal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterOperaciones.this.mListener.onItemClickListener(position);
            }
        });
    }

    private String getOperationDescription(String code) {
        if (this.mType == 2) {
            Iterator<SpinnerValuesDTO> it = this.operations.iterator();
            while (it.hasNext()) {
                SpinnerValuesDTO spinnerValuesDTO = it.next();
                if (spinnerValuesDTO.getCode().equals(code)) {
                    return spinnerValuesDTO.getValueToShow();
                }
            }
            return "";
        }
        char c = 65535;
        int hashCode = code.hashCode();
        if (hashCode != 457319128) {
            if (hashCode != 457319140) {
                if (hashCode == 457324868 && code.equals(FragmentOperations.PTE_ING)) {
                    c = 2;
                }
            } else if (code.equals(FragmentOperations.PTE_CON)) {
                c = 1;
            }
        } else if (code.equals(FragmentOperations.PTE_COB)) {
            c = 0;
        }
        if (c == 0) {
            return this.mContext.getString(R.string.pdt_cobro);
        }
        if (c == 1) {
            return this.mContext.getString(R.string.pdt_conf);
        }
        if (c != 2) {
            return "";
        }
        return this.mContext.getString(R.string.pdt_ing);
    }

    public class ViewHolder extends ViewHolderAbstract {
        /* access modifiers changed from: private */
        public RelativeLayout relativeGlobal;
        /* access modifiers changed from: private */
        public QTextView textAmmount;
        /* access modifiers changed from: private */
        public QTextView textNumOperations;
        /* access modifiers changed from: private */
        public QTextView textTitleState;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textTitleState = (QTextView) itemView.findViewById(R.id.text_title_state);
            this.textNumOperations = (QTextView) itemView.findViewById(R.id.text_operations);
            this.textAmmount = (QTextView) itemView.findViewById(R.id.text_ammount);
            this.relativeGlobal = (RelativeLayout) itemView.findViewById(R.id.relative_global);
        }
    }
}
