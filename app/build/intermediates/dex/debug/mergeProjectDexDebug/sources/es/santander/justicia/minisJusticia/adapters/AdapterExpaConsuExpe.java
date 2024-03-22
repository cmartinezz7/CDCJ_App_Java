package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail;
import java.util.List;

public class AdapterExpaConsuExpe extends ExpandableRecyclerAdapter<DatosExpedienteResponse, DetalleExpDatosExpDetail.DetalleExpSaldos, ExpedienteConsultaParenViewHolder, ExpedienteChildViewHolder> {
    private final int TYPE_CARD_CANCELLED = 3;
    private final int TYPE_CARD_CREATED_CONCLUDED = 2;
    private final int TYPE_CARD_GLOBAL = 4;
    private final int TYPE_LINEAR_CANCELLED = 6;
    private final int TYPE_LINEAR_CREATED_CONCLUDED = 5;
    private final int TYPE_LINEAR_GLOBAL = 7;
    private Context mContext;
    /* access modifiers changed from: private */
    public OnDetailsClick mDetailListener;
    /* access modifiers changed from: private */
    public int mExpandedCard;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public OnOthersClick mOthersListener;
    private List<DatosExpedienteResponse> mParentList;

    public interface OnDetailsClick {
        void onItemClick(int i);
    }

    public interface OnOthersClick {
        void onItemClickListener(int i, boolean z);
    }

    public AdapterExpaConsuExpe(Context context, List<DatosExpedienteResponse> parentList, OnOthersClick othersListener, OnDetailsClick detailListener) {
        super(parentList);
        this.mParentList = parentList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mExpandedCard = -1;
        this.mOthersListener = othersListener;
        this.mDetailListener = detailListener;
    }

    public ExpedienteConsultaParenViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup, int viewType) {
        switch (viewType) {
            case 2:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente_conc_creat, parentViewGroup, false));
            case 3:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente_cancel, parentViewGroup, false));
            case 4:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente, parentViewGroup, false));
            case 5:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.linear_con_exp_conc_creat, parentViewGroup, false));
            case 6:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.linear_con_exp_cancel, parentViewGroup, false));
            case 7:
                return new ExpedienteConsultaParenViewHolder(this.mInflater.inflate(R.layout.linear_consul_exp, parentViewGroup, false));
            default:
                return null;
        }
    }

    public ExpedienteChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        return new ExpedienteChildViewHolder(this.mInflater.inflate(R.layout.linear_expedient_detail_big, childViewGroup, false));
    }

    public int getChildCount(int parentPosition) {
        return this.mParentList.get(parentPosition).getChildList().size() - 1;
    }

    /* access modifiers changed from: private */
    public DatosExpedienteResponse getParentItem(int parentPosition) {
        return this.mParentList.get(parentPosition);
    }

    public int getChildViewType(int parentPosition, int childPosition) {
        return AdapterExpaConsuExpe.super.getChildViewType(parentPosition, childPosition);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getParentViewType(int r9) {
        /*
            r8 = this;
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r0 = r8.getParentItem(r9)
            java.lang.String r0 = r0.getSitexp()
            int r1 = r0.hashCode()
            r2 = 2081(0x821, float:2.916E-42)
            r3 = 1
            r4 = 4
            r5 = 3
            r6 = 5
            r7 = 2
            if (r1 == r2) goto L_0x005c
            r2 = 2142(0x85e, float:3.002E-42)
            if (r1 == r2) goto L_0x0052
            r2 = 2156(0x86c, float:3.021E-42)
            if (r1 == r2) goto L_0x0048
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x003e
            r2 = 2213(0x8a5, float:3.101E-42)
            if (r1 == r2) goto L_0x0034
            r2 = 2529(0x9e1, float:3.544E-42)
            if (r1 == r2) goto L_0x002a
        L_0x0029:
            goto L_0x0066
        L_0x002a:
            java.lang.String r1 = "OP"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r6
            goto L_0x0067
        L_0x0034:
            java.lang.String r1 = "EJ"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r4
            goto L_0x0067
        L_0x003e:
            java.lang.String r1 = "CR"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = 0
            goto L_0x0067
        L_0x0048:
            java.lang.String r1 = "CO"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r3
            goto L_0x0067
        L_0x0052:
            java.lang.String r1 = "CA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r7
            goto L_0x0067
        L_0x005c:
            java.lang.String r1 = "AB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0029
            r0 = r5
            goto L_0x0067
        L_0x0066:
            r0 = -1
        L_0x0067:
            if (r0 == 0) goto L_0x0086
            if (r0 == r3) goto L_0x0086
            if (r0 == r7) goto L_0x0080
            if (r0 == r5) goto L_0x007a
            if (r0 == r4) goto L_0x007a
            if (r0 == r6) goto L_0x007a
            int r0 = r8.mExpandedCard
            if (r9 != r0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r6 = r7
        L_0x0079:
            return r6
        L_0x007a:
            int r0 = r8.mExpandedCard
            if (r9 != r0) goto L_0x007f
            r4 = 7
        L_0x007f:
            return r4
        L_0x0080:
            int r0 = r8.mExpandedCard
            if (r9 != r0) goto L_0x0085
            r5 = 6
        L_0x0085:
            return r5
        L_0x0086:
            int r0 = r8.mExpandedCard
            if (r9 != r0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r6 = r7
        L_0x008c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.getParentViewType(int):int");
    }

    public boolean isParentViewType(int viewType) {
        Log.d("Silos", "viewType " + viewType);
        switch (viewType) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                Log.d("Silos", "is parent");
                return true;
            default:
                Log.d("Silos", "isn't pareeeeeeent");
                return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindParentViewHolder(final es.santander.justicia.minisJusticia.adapters.ExpedienteConsultaParenViewHolder r9, final int r10, es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r11) {
        /*
            r8 = this;
            es.santander.justicia.minisJusticia.views.QTextView r0 = r9.mTextNumExp
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r1 = r8.getParentItem(r10)
            java.lang.String r1 = r1.getCodExpediente()
            r0.setText(r1)
            es.santander.justicia.minisJusticia.views.QTextView r0 = r9.mTextDateFirstMov
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r1 = r8.getParentItem(r10)
            java.lang.String r1 = r1.getPrimov()
            java.lang.String r1 = es.santander.justicia.utils.CommonUtils.getDateFromExp(r1)
            r0.setText(r1)
            es.santander.justicia.minisJusticia.views.QTextView r0 = r9.mTextDateLastMov
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r1 = r8.getParentItem(r10)
            java.lang.String r1 = r1.getUltmov()
            java.lang.String r1 = es.santander.justicia.utils.CommonUtils.getDateFromExp(r1)
            r0.setText(r1)
            es.santander.justicia.minisJusticia.views.QTextView r0 = r9.mTextSituation
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r1 = r8.getParentItem(r10)
            java.lang.String r1 = r1.getSituacion()
            r0.setText(r1)
            es.santander.justicia.minisJusticia.views.QTextView r0 = r9.mTextAmount
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r2 = r8.getParentItem(r10)
            es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos r2 = r2.getSaldos()
            java.lang.String r2 = r2.getImpsald()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " "
            java.lang.StringBuilder r1 = r1.append(r2)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r2 = r8.getParentItem(r10)
            es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos r2 = r2.getSaldos()
            java.lang.String r2 = r2.getCodmon()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse r0 = r8.getParentItem(r10)
            java.lang.String r0 = r0.getSitexp()
            int r1 = r0.hashCode()
            r2 = 2081(0x821, float:2.916E-42)
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == r2) goto L_0x00cc
            r2 = 2142(0x85e, float:3.002E-42)
            if (r1 == r2) goto L_0x00c2
            r2 = 2156(0x86c, float:3.021E-42)
            if (r1 == r2) goto L_0x00b8
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x00ae
            r2 = 2213(0x8a5, float:3.101E-42)
            if (r1 == r2) goto L_0x00a4
            r2 = 2529(0x9e1, float:3.544E-42)
            if (r1 == r2) goto L_0x009a
        L_0x0099:
            goto L_0x00d6
        L_0x009a:
            java.lang.String r1 = "OP"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = r3
            goto L_0x00d7
        L_0x00a4:
            java.lang.String r1 = "EJ"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = r4
            goto L_0x00d7
        L_0x00ae:
            java.lang.String r1 = "CR"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x00d7
        L_0x00b8:
            java.lang.String r1 = "CO"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = r7
            goto L_0x00d7
        L_0x00c2:
            java.lang.String r1 = "CA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = r5
            goto L_0x00d7
        L_0x00cc:
            java.lang.String r1 = "AB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0099
            r0 = r6
            goto L_0x00d7
        L_0x00d6:
            r0 = -1
        L_0x00d7:
            if (r0 == 0) goto L_0x014f
            r1 = 2131099963(0x7f06013b, float:1.7812294E38)
            r2 = 2131231001(0x7f080119, float:1.807807E38)
            if (r0 == r7) goto L_0x013e
            if (r0 == r6) goto L_0x0127
            if (r0 == r5) goto L_0x0113
            r1 = 2131099965(0x7f06013d, float:1.7812298E38)
            if (r0 == r4) goto L_0x0102
            if (r0 == r3) goto L_0x00ee
            goto L_0x0166
        L_0x00ee:
            android.widget.ImageView r0 = r9.mImageState
            r2 = 2131231139(0x7f0801a3, float:1.807835E38)
            r0.setImageResource(r2)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r2 = r8.mContext
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r0.setBackgroundColor(r1)
            goto L_0x0166
        L_0x0102:
            android.widget.ImageView r0 = r9.mImageState
            r0.setImageResource(r2)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r2 = r8.mContext
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r0.setBackgroundColor(r1)
            goto L_0x0166
        L_0x0113:
            android.widget.ImageView r0 = r9.mImageState
            r2 = 2131231076(0x7f080164, float:1.8078223E38)
            r0.setImageResource(r2)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r2 = r8.mContext
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r0.setBackgroundColor(r1)
            goto L_0x0166
        L_0x0127:
            android.widget.ImageView r0 = r9.mImageState
            r1 = 2131230998(0x7f080116, float:1.8078065E38)
            r0.setImageResource(r1)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r1 = r8.mContext
            r2 = 2131099962(0x7f06013a, float:1.7812292E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setBackgroundColor(r1)
            goto L_0x0166
        L_0x013e:
            android.widget.ImageView r0 = r9.mImageState
            r0.setImageResource(r2)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r2 = r8.mContext
            int r1 = androidx.core.content.ContextCompat.getColor(r2, r1)
            r0.setBackgroundColor(r1)
            goto L_0x0166
        L_0x014f:
            android.widget.ImageView r0 = r9.mImageState
            r1 = 2131231073(0x7f080161, float:1.8078217E38)
            r0.setImageResource(r1)
            android.widget.ImageView r0 = r9.mImageState
            android.content.Context r1 = r8.mContext
            r2 = 2131099964(0x7f06013c, float:1.7812296E38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
            r0.setBackgroundColor(r1)
        L_0x0166:
            com.alexandrius.accordionswipelayout.library.SwipeLayout r0 = r9.mSwipeLayout
            if (r0 == 0) goto L_0x019a
            com.alexandrius.accordionswipelayout.library.SwipeLayout r0 = r9.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$1 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$1
            r1.<init>(r10)
            r0.setOnClickListener(r1)
            androidx.cardview.widget.CardView r0 = r9.mCard
            if (r0 == 0) goto L_0x0182
            androidx.cardview.widget.CardView r0 = r9.mCard
            es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$2 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$2
            r1.<init>(r10)
            r0.setOnClickListener(r1)
        L_0x0182:
            android.widget.LinearLayout r0 = r9.mLinearGlobal
            if (r0 == 0) goto L_0x0190
            android.widget.LinearLayout r0 = r9.mLinearGlobal
            es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$3 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$3
            r1.<init>(r10)
            r0.setOnClickListener(r1)
        L_0x0190:
            com.alexandrius.accordionswipelayout.library.SwipeLayout r0 = r9.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$4 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$4
            r1.<init>(r10)
            r0.setOnSwipeItemClickListener(r1)
        L_0x019a:
            android.widget.ImageView r0 = r9.mImageSwipe
            if (r0 == 0) goto L_0x01a8
            android.widget.ImageView r0 = r9.mImageSwipe
            es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$5 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe$5
            r1.<init>(r9)
            r0.setOnClickListener(r1)
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.onBindParentViewHolder(es.santander.justicia.minisJusticia.adapters.ExpedienteConsultaParenViewHolder, int, es.santander.justicia.minisJusticia.models.responses.DatosExpedienteResponse):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getResourceOperative(int r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r8.hashCode()
            r2 = 2142(0x85e, float:3.002E-42)
            r3 = 2
            r4 = 1
            r5 = -1
            if (r1 == r2) goto L_0x0029
            r2 = 2156(0x86c, float:3.021E-42)
            if (r1 == r2) goto L_0x001f
            r2 = 2159(0x86f, float:3.025E-42)
            if (r1 == r2) goto L_0x0015
        L_0x0014:
            goto L_0x0033
        L_0x0015:
            java.lang.String r1 = "CR"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0014
            r1 = r4
            goto L_0x0034
        L_0x001f:
            java.lang.String r1 = "CO"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r1 = "CA"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0014
            r1 = r3
            goto L_0x0034
        L_0x0033:
            r1 = r5
        L_0x0034:
            if (r1 == 0) goto L_0x0049
            if (r1 == r4) goto L_0x0049
            if (r1 == r3) goto L_0x003b
            goto L_0x0057
        L_0x003b:
            android.content.Context r1 = r6.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903068(0x7f03001c, float:1.7412944E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
            goto L_0x0057
        L_0x0049:
            android.content.Context r1 = r6.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903072(0x7f030020, float:1.7412952E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
        L_0x0057:
            if (r0 == 0) goto L_0x006c
            int r1 = r0.getResourceId(r7, r5)
            r2 = 2131886114(0x7f120022, float:1.9406798E38)
            if (r1 == r2) goto L_0x006a
            r2 = 2131886301(0x7f1200dd, float:1.9407177E38)
            if (r1 == r2) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            r2 = 5
            return r2
        L_0x006a:
            r2 = 6
            return r2
        L_0x006c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaConsuExpe.getResourceOperative(int, java.lang.String):int");
    }

    public void onBindChildViewHolder(ExpedienteChildViewHolder childViewHolder, int parentPosition, int childPosition, DetalleExpDatosExpDetail.DetalleExpSaldos child) {
        if (child.getIngpendconso() == null) {
            childViewHolder.mCard.setVisibility(8);
            return;
        }
        childViewHolder.mCard.setVisibility(0);
        childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != getChildCount(parentPosition) ? R.drawable.back_expedient_child : R.drawable.back_expedient_last_child));
        childViewHolder.mTextMovements.setVisibility(0);
    }
}
