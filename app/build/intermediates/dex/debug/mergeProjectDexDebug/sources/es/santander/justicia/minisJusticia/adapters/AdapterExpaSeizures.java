package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.models.responses.seizures.Embargo;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoDetail;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterExpaSeizures extends ExpandableRecyclerAdapter<Embargo, EmbargoDetail, SeizureParentViewHolder, SeizureChildViewHolder> {
    public static final String BA = "BA";
    public static final String EN = "EN";
    public static final String ER = "ER";
    public static final String FRA = "FRA";
    public static final String PA = "PA";
    public static final String PE = "PE";
    public static final String PP = "PP";
    public static final String PR = "PR";
    public static final String RA = "RA";
    public static final String RE = "RE";
    public static final String RX = "RX";
    public static final String SE = "SE";
    private final int TYPE_CARD = 3;
    private final int TYPE_LINEAR = 4;
    private Context mContext;
    /* access modifiers changed from: private */
    public int mExpandedCard;
    private LayoutInflater mInflater;
    private List<Embargo> mParentList;
    /* access modifiers changed from: private */
    public OnBajaClickListener onBajaClickListener;

    public interface OnBajaClickListener {
        void onBajaClick(int i);
    }

    public AdapterExpaSeizures(Context context, List<Embargo> parentList) {
        super(parentList);
        this.mParentList = parentList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mExpandedCard = -1;
        this.onBajaClickListener = (OnBajaClickListener) context;
    }

    public SeizureParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup, int viewType) {
        if (viewType == 3) {
            return new SeizureParentViewHolder(this.mInflater.inflate(R.layout.card_seizures, parentViewGroup, false));
        }
        if (viewType != 4) {
            return null;
        }
        return new SeizureParentViewHolder(this.mInflater.inflate(R.layout.linear_seizure, parentViewGroup, false));
    }

    public SeizureChildViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        return new SeizureChildViewHolder(this.mInflater.inflate(R.layout.linear_seizure_detail, childViewGroup, false));
    }

    public int getChildCount(int parentPosition) {
        return this.mParentList.get(parentPosition).getChildList().size() - 1;
    }

    public int getParentViewType(int parentPosition) {
        return parentPosition == this.mExpandedCard ? 4 : 3;
    }

    public boolean isParentViewType(int viewType) {
        return viewType == 4 || viewType == 3;
    }

    public int getItemViewType(int flatPosition) {
        Log.d("Silos", "itemViewType: " + AdapterExpaSeizures.super.getItemViewType(flatPosition));
        return AdapterExpaSeizures.super.getItemViewType(flatPosition);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindParentViewHolder(final es.santander.justicia.minisJusticia.adapters.SeizureParentViewHolder r11, final int r12, es.santander.justicia.minisJusticia.models.responses.seizures.Embargo r13) {
        /*
            r10 = this;
            com.alexandrius.accordionswipelayout.library.SwipeLayout r0 = r11.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$1 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$1
            r1.<init>(r12)
            r0.setOnClickListener(r1)
            android.widget.ImageView r0 = r11.mImageSwipe
            es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$2 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$2
            r1.<init>(r11)
            r0.setOnClickListener(r1)
            com.alexandrius.accordionswipelayout.library.SwipeLayout r0 = r11.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$3 r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures$3
            r1.<init>()
            r0.setOnSwipeItemClickListener(r1)
            r0 = 8
            es.santander.justicia.minisJusticia.views.QTextView r1 = r11.mTextExpediente     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = r13.getCodigoJuzgadoDestino()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = r13.getCodigoJuzgadoOrigen()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r4 = r13.getCodigoProcedimiento()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r5 = r13.getNumeroExpediente()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r6 = r13.getAnoAperturaExpediente()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = es.santander.justicia.utils.CommonUtils.formatExpedientWithSpaces(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0237 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0237 }
            es.santander.justicia.minisJusticia.views.QTextView r1 = r11.mTextFechaAlta     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = r13.getFechaAltaRegistro()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = es.santander.justicia.utils.CommonUtils.getDateFromExp(r2)     // Catch:{ Exception -> 0x0237 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0237 }
            es.santander.justicia.minisJusticia.views.QTextView r1 = r11.mTextTipoEmbargo     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = r13.getCodigoTipoEmbargo()     // Catch:{ Exception -> 0x0237 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0237 }
            es.santander.justicia.minisJusticia.views.QTextView r1 = r11.mTextSituacion     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = r13.getDescEstado()     // Catch:{ Exception -> 0x0237 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0237 }
            es.santander.justicia.minisJusticia.views.QTextView r1 = r11.mTextImporte     // Catch:{ Exception -> 0x0237 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0237 }
            r2.<init>()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = r13.getImporteTotalEmbargo()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.formatImport(r3)     // Catch:{ Exception -> 0x0237 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = " "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = r13.getCodigoMoneda()     // Catch:{ Exception -> 0x0237 }
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r3)     // Catch:{ Exception -> 0x0237 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0237 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0237 }
            r1.setText(r2)     // Catch:{ Exception -> 0x0237 }
            r1 = 0
            java.lang.String r2 = r13.getCodigoEstado()     // Catch:{ Exception -> 0x0237 }
            r3 = -1
            int r4 = r2.hashCode()     // Catch:{ Exception -> 0x0237 }
            r5 = 1
            r6 = 0
            switch(r4) {
                case 2111: goto L_0x010c;
                case 2217: goto L_0x0102;
                case 2221: goto L_0x00f8;
                case 2545: goto L_0x00ed;
                case 2549: goto L_0x00e3;
                case 2560: goto L_0x00d8;
                case 2562: goto L_0x00cd;
                case 2607: goto L_0x00c3;
                case 2611: goto L_0x00b9;
                case 2630: goto L_0x00af;
                case 2642: goto L_0x00a4;
                case 69877: goto L_0x0099;
                default: goto L_0x0097;
            }     // Catch:{ Exception -> 0x0237 }
        L_0x0097:
            goto L_0x0115
        L_0x0099:
            java.lang.String r4 = "FRA"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 7
            goto L_0x0115
        L_0x00a4:
            java.lang.String r4 = "SE"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 3
            goto L_0x0115
        L_0x00af:
            java.lang.String r4 = "RX"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 5
            goto L_0x0115
        L_0x00b9:
            java.lang.String r4 = "RE"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = r0
            goto L_0x0115
        L_0x00c3:
            java.lang.String r4 = "RA"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 6
            goto L_0x0115
        L_0x00cd:
            java.lang.String r4 = "PR"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 10
            goto L_0x0115
        L_0x00d8:
            java.lang.String r4 = "PP"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 9
            goto L_0x0115
        L_0x00e3:
            java.lang.String r4 = "PE"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 2
            goto L_0x0115
        L_0x00ed:
            java.lang.String r4 = "PA"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 11
            goto L_0x0115
        L_0x00f8:
            java.lang.String r4 = "ER"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = r5
            goto L_0x0115
        L_0x0102:
            java.lang.String r4 = "EN"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = 4
            goto L_0x0115
        L_0x010c:
            java.lang.String r4 = "BA"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0097
            r3 = r6
        L_0x0115:
            r2 = 2131100979(0x7f060533, float:1.7814355E38)
            r4 = 2131231009(0x7f080121, float:1.8078087E38)
            r7 = 2131231073(0x7f080161, float:1.8078217E38)
            r8 = 2131099962(0x7f06013a, float:1.7812292E38)
            r9 = 2131099963(0x7f06013b, float:1.7812294E38)
            switch(r3) {
                case 0: goto L_0x01f8;
                case 1: goto L_0x01de;
                case 2: goto L_0x01c4;
                case 3: goto L_0x01aa;
                case 4: goto L_0x018d;
                case 5: goto L_0x018d;
                case 6: goto L_0x018d;
                case 7: goto L_0x018d;
                case 8: goto L_0x0167;
                case 9: goto L_0x014c;
                case 10: goto L_0x014c;
                case 11: goto L_0x0129;
                default: goto L_0x0127;
            }     // Catch:{ Exception -> 0x0237 }
        L_0x0127:
            goto L_0x0212
        L_0x0129:
            android.content.Context r3 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r8)     // Catch:{ Exception -> 0x0237 }
            r1 = r3
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3.setImageResource(r4)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            android.content.Context r4 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r2 = androidx.core.content.ContextCompat.getColor(r4, r2)     // Catch:{ Exception -> 0x0237 }
            r3.setColorFilter(r2)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x014c:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r8)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3 = 2131231074(0x7f080162, float:1.8078219E38)
            r2.setImageResource(r3)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x0167:
            android.content.Context r3 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            r5 = 2131099965(0x7f06013d, float:1.7812298E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r5)     // Catch:{ Exception -> 0x0237 }
            r1 = r3
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3.setImageResource(r4)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            android.content.Context r4 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r2 = androidx.core.content.ContextCompat.getColor(r4, r2)     // Catch:{ Exception -> 0x0237 }
            r3.setColorFilter(r2)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x018d:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            r3 = 2131100021(0x7f060175, float:1.7812412E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3 = 2131231141(0x7f0801a5, float:1.8078355E38)
            r2.setImageResource(r3)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r5)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x01aa:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r9)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3 = 2131231139(0x7f0801a3, float:1.807835E38)
            r2.setImageResource(r3)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x01c4:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            r3 = 2131099964(0x7f06013c, float:1.7812296E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r2.setImageResource(r7)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x01de:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            r3 = 2131100006(0x7f060166, float:1.7812381E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r2.setImageResource(r7)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
            goto L_0x0212
        L_0x01f8:
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r9)     // Catch:{ Exception -> 0x0237 }
            r1 = r2
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3 = 2131231075(0x7f080163, float:1.807822E38)
            r2.setImageResource(r3)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r2 = r11.mImageSwipe     // Catch:{ Exception -> 0x0237 }
            r2.setVisibility(r0)     // Catch:{ Exception -> 0x0237 }
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout     // Catch:{ Exception -> 0x0237 }
            r2.setSwipeEnabled(r6)     // Catch:{ Exception -> 0x0237 }
        L_0x0212:
            android.widget.LinearLayout r2 = r11.mLinear     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0231
            android.content.Context r2 = r10.mContext     // Catch:{ Exception -> 0x0237 }
            r3 = 2131231325(0x7f08025d, float:1.8078728E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r2, r3)     // Catch:{ Exception -> 0x0237 }
            if (r2 == 0) goto L_0x0226
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN     // Catch:{ Exception -> 0x0237 }
            r2.setColorFilter(r1, r3)     // Catch:{ Exception -> 0x0237 }
        L_0x0226:
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3.setBackground(r2)     // Catch:{ Exception -> 0x0237 }
            android.widget.ImageView r3 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r3.invalidate()     // Catch:{ Exception -> 0x0237 }
            goto L_0x0236
        L_0x0231:
            android.widget.ImageView r2 = r11.mImageLateral     // Catch:{ Exception -> 0x0237 }
            r2.setBackgroundColor(r1)     // Catch:{ Exception -> 0x0237 }
        L_0x0236:
            goto L_0x0253
        L_0x0237:
            r1 = move-exception
            java.lang.String r2 = "AdapterExpaSeizures"
            java.lang.String r3 = "error datos"
            android.util.Log.d(r2, r3)
            android.widget.ImageView r2 = r11.mImageLateral
            r2.setVisibility(r0)
            android.widget.ImageView r2 = r11.mImageLateral
            r2.setVisibility(r0)
            android.widget.ImageView r2 = r11.mImageSwipe
            r2.setVisibility(r0)
            com.alexandrius.accordionswipelayout.library.SwipeLayout r2 = r11.mSwipeLayout
            r2.setVisibility(r0)
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.onBindParentViewHolder(es.santander.justicia.minisJusticia.adapters.SeizureParentViewHolder, int, es.santander.justicia.minisJusticia.models.responses.seizures.Embargo):void");
    }

    public void onBindChildViewHolder(SeizureChildViewHolder childViewHolder, int parentPosition, int childPosition, EmbargoDetail child) {
        childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != getChildCount(parentPosition) ? R.drawable.back_expedient_child : R.drawable.back_expedient_last_child));
        childViewHolder.mTextNumDoc.setText(child.getDocument());
        childViewHolder.mTextTitular.setText(child.getNombre());
        childViewHolder.mTextImporte.setText(CommonUtils.formatImport(child.getImporte()) + " " + CommonUtils.getCurrencySymbol(this.mParentList.get(parentPosition).getCodigoMoneda()));
        int currentStateColor = 0;
        String codigoEstado = ((Embargo) getParentList().get(parentPosition)).getCodigoEstado();
        char c = 65535;
        switch (codigoEstado.hashCode()) {
            case 2111:
                if (codigoEstado.equals("BA")) {
                    c = 0;
                    break;
                }
                break;
            case 2217:
                if (codigoEstado.equals(EN)) {
                    c = 4;
                    break;
                }
                break;
            case 2221:
                if (codigoEstado.equals(ER)) {
                    c = 2;
                    break;
                }
                break;
            case 2545:
                if (codigoEstado.equals(PA)) {
                    c = 10;
                    break;
                }
                break;
            case 2549:
                if (codigoEstado.equals("PE")) {
                    c = 3;
                    break;
                }
                break;
            case 2560:
                if (codigoEstado.equals(PP)) {
                    c = 9;
                    break;
                }
                break;
            case 2562:
                if (codigoEstado.equals(PR)) {
                    c = 11;
                    break;
                }
                break;
            case 2607:
                if (codigoEstado.equals(RA)) {
                    c = 6;
                    break;
                }
                break;
            case 2611:
                if (codigoEstado.equals(RE)) {
                    c = 8;
                    break;
                }
                break;
            case 2630:
                if (codigoEstado.equals(RX)) {
                    c = 5;
                    break;
                }
                break;
            case 2642:
                if (codigoEstado.equals(SE)) {
                    c = 1;
                    break;
                }
                break;
            case 69877:
                if (codigoEstado.equals(FRA)) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                currentStateColor = ContextCompat.getColor(this.mContext, R.color.text_color);
                break;
            case 2:
            case 3:
                currentStateColor = ContextCompat.getColor(this.mContext, R.color.lista_movimientos_rojo);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                currentStateColor = ContextCompat.getColor(this.mContext, R.color.lista_movimientos_pte);
                break;
            case 9:
            case 10:
            case 11:
                currentStateColor = ContextCompat.getColor(this.mContext, R.color.expOperativo);
                break;
        }
        Drawable stateBackgroundDrawable = ContextCompat.getDrawable(this.mContext, R.drawable.white_bc_bottom_left_rounded);
        if (stateBackgroundDrawable != null) {
            stateBackgroundDrawable.setColorFilter(currentStateColor, PorterDuff.Mode.SRC_IN);
        }
        childViewHolder.mViewLaeral.setBackground(stateBackgroundDrawable);
        childViewHolder.mViewLaeral.invalidate();
    }
}
