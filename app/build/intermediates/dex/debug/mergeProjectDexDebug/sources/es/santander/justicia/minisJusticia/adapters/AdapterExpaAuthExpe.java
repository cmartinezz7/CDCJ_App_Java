package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.models.ExpedienteDetailLetrados;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterExpaAuthExpe extends ExpandableRecyclerAdapter<BuscarPeticionesAcceso, ExpedienteDetailLetrados, ExpedienteAuthParentViewHolder, ExpedienteChildViewHolder> {
    private final int TYPE_CARD_ACCEPT = 1;
    private final int TYPE_CARD_BAJA = 4;
    private final int TYPE_CARD_DENIE = 2;
    private final int TYPE_CARD_PENDING = 3;
    private final int TYPE_LINEAR_ACCPET = 5;
    private final int TYPE_LINEAR_BAJA = 8;
    private final int TYPE_LINEAR_DENIE = 6;
    private final int TYPE_LINEAR_PENDING = 7;
    private Context mContext;
    private int mExpandedCard;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public OnOthersClick mOthersListener;
    private List<BuscarPeticionesAcceso> mParentList;

    public interface OnOthersClick {
        void onItemClickListener(int i, int i2);
    }

    public AdapterExpaAuthExpe(Context context, List<BuscarPeticionesAcceso> parentList, OnOthersClick othersListener) {
        super(parentList);
        this.mParentList = parentList;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mExpandedCard = -1;
        this.mOthersListener = othersListener;
    }

    public ExpedienteAuthParentViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup, int viewType) {
        switch (viewType) {
            case 1:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.card_auth_exp_accept, parentViewGroup, false));
            case 2:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.card_auth_exp_dnied, parentViewGroup, false));
            case 3:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.card_auth_exp_pendres, parentViewGroup, false));
            case 4:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.card_auth_exp_baja, parentViewGroup, false));
            case 5:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.linear_auth_exp_accept, parentViewGroup, false));
            case 6:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.linear_auth_exp_dnied, parentViewGroup, false));
            case 7:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.linear_auth_exp_pendres, parentViewGroup, false));
            case 8:
                return new ExpedienteAuthParentViewHolder(this.mInflater.inflate(R.layout.linear_auth_exp_baja, parentViewGroup, false));
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
    public BuscarPeticionesAcceso getParentItem(int parentPosition) {
        return this.mParentList.get(parentPosition);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getParentViewType(int r8) {
        /*
            r7 = this;
            es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso r0 = r7.getParentItem(r8)
            java.lang.String r0 = r0.getCodEstadoActualExp()
            int r1 = r0.hashCode()
            r2 = 2091(0x82b, float:2.93E-42)
            r3 = -1
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == r2) goto L_0x003f
            r2 = 2111(0x83f, float:2.958E-42)
            if (r1 == r2) goto L_0x0035
            r2 = 2177(0x881, float:3.05E-42)
            if (r1 == r2) goto L_0x002b
            r2 = 2549(0x9f5, float:3.572E-42)
            if (r1 == r2) goto L_0x0021
        L_0x0020:
            goto L_0x0049
        L_0x0021:
            java.lang.String r1 = "PE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0020
            r0 = r5
            goto L_0x004a
        L_0x002b:
            java.lang.String r1 = "DE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0020
            r0 = r6
            goto L_0x004a
        L_0x0035:
            java.lang.String r1 = "BA"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0020
            r0 = r4
            goto L_0x004a
        L_0x003f:
            java.lang.String r1 = "AL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            goto L_0x004a
        L_0x0049:
            r0 = r3
        L_0x004a:
            if (r0 == 0) goto L_0x0068
            if (r0 == r6) goto L_0x0062
            if (r0 == r5) goto L_0x005c
            if (r0 == r4) goto L_0x0053
            return r3
        L_0x0053:
            int r0 = r7.mExpandedCard
            if (r8 != r0) goto L_0x005a
            r0 = 8
            goto L_0x005b
        L_0x005a:
            r0 = 4
        L_0x005b:
            return r0
        L_0x005c:
            int r0 = r7.mExpandedCard
            if (r8 != r0) goto L_0x0061
            r4 = 7
        L_0x0061:
            return r4
        L_0x0062:
            int r0 = r7.mExpandedCard
            if (r8 != r0) goto L_0x0067
            r5 = 6
        L_0x0067:
            return r5
        L_0x0068:
            int r0 = r7.mExpandedCard
            if (r8 != r0) goto L_0x006d
            r6 = 5
        L_0x006d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.getParentViewType(int):int");
    }

    public boolean isParentViewType(int viewType) {
        switch (viewType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public void onBindParentViewHolder(final ExpedienteAuthParentViewHolder parentViewHolder, final int parentPosition, BuscarPeticionesAcceso parent) {
        parentViewHolder.mTextNumExp.setText(CommonUtils.formatExpedientWithSpaces(getParentItem(parentPosition).getCodJuzDest(), getParentItem(parentPosition).getCodJuzOri(), getParentItem(parentPosition).getCodProced(), getParentItem(parentPosition).getNumExpediente(), getParentItem(parentPosition).getAnioApertura()));
        parentViewHolder.mTextDate.setText(CommonUtils.getDateFromExp(getParentItem(parentPosition).getFecDeLaPeticion()));
        parentViewHolder.mTextState.setText(getParentItem(parentPosition).getDesEstadoPeticion());
        parentViewHolder.mTextStateC.setText(getParentItem(parentPosition).getDesEstadoActualExp());
        parentViewHolder.mTextName.setText(getParentItem(parentPosition).getNombre() + (CommonUtils.isNotNullNotBlackNotStringNull(getParentItem(parentPosition).getApellido1()) ? " " + getParentItem(parentPosition).getApellido1() : ""));
        parentViewHolder.mSwipeLayout.setOnSwipeItemClickListener(new SwipeLayout.OnSwipeItemClickListener() {
            public void onSwipeItemClick(boolean b, int i) {
                AdapterExpaAuthExpe adapterExpaAuthExpe = AdapterExpaAuthExpe.this;
                ExpedienteAuthParentViewHolder expedienteAuthParentViewHolder = parentViewHolder;
                adapterExpaAuthExpe.closeParent(expedienteAuthParentViewHolder, expedienteAuthParentViewHolder.mImageSwipe);
                OnOthersClick access$300 = AdapterExpaAuthExpe.this.mOthersListener;
                AdapterExpaAuthExpe adapterExpaAuthExpe2 = AdapterExpaAuthExpe.this;
                access$300.onItemClickListener(adapterExpaAuthExpe2.getResourceOperative(i, adapterExpaAuthExpe2.getParentItem(parentPosition).getCodEstadoActualExp()), parentPosition);
            }
        });
        parentViewHolder.mImageSwipe.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
                parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, parentViewHolder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0f : view.getX() - 1000.0f, view.getY(), 0));
                if (!parentViewHolder.mSwipeLayout.isExpanded()) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, view.getX() + 1000.0f, view.getY(), 0));
                            parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, view.getX() + 1000.0f, view.getY(), 0));
                        }
                    }, 100);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void closeParent(ExpedienteAuthParentViewHolder parentViewHolder, View view) {
        parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
        parentViewHolder.mSwipeLayout.onTouch(parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, parentViewHolder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0f : view.getX() - 1000.0f, view.getY(), 0));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getResourceOperative(int r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            int r1 = r10.hashCode()
            r2 = 2091(0x82b, float:2.93E-42)
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = -1
            if (r1 == r2) goto L_0x0039
            r2 = 2111(0x83f, float:2.958E-42)
            if (r1 == r2) goto L_0x002f
            r2 = 2177(0x881, float:3.05E-42)
            if (r1 == r2) goto L_0x0025
            r2 = 2549(0x9f5, float:3.572E-42)
            if (r1 == r2) goto L_0x001b
        L_0x001a:
            goto L_0x0043
        L_0x001b:
            java.lang.String r1 = "PE"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x001a
            r1 = r5
            goto L_0x0044
        L_0x0025:
            java.lang.String r1 = "DE"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x001a
            r1 = r6
            goto L_0x0044
        L_0x002f:
            java.lang.String r1 = "BA"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x001a
            r1 = r4
            goto L_0x0044
        L_0x0039:
            java.lang.String r1 = "AL"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x001a
            r1 = r3
            goto L_0x0044
        L_0x0043:
            r1 = r7
        L_0x0044:
            if (r1 == 0) goto L_0x0077
            if (r1 == r6) goto L_0x0069
            if (r1 == r5) goto L_0x005b
            if (r1 == r4) goto L_0x004d
            goto L_0x0085
        L_0x004d:
            android.content.Context r1 = r8.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903070(0x7f03001e, float:1.7412948E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
            goto L_0x0085
        L_0x005b:
            android.content.Context r1 = r8.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903075(0x7f030023, float:1.7412958E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
            goto L_0x0085
        L_0x0069:
            android.content.Context r1 = r8.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903074(0x7f030022, float:1.7412956E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
            goto L_0x0085
        L_0x0077:
            android.content.Context r1 = r8.mContext
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2130903067(0x7f03001b, float:1.7412942E38)
            android.content.res.TypedArray r0 = r1.obtainTypedArray(r2)
        L_0x0085:
            if (r0 == 0) goto L_0x0095
            int r1 = r0.getResourceId(r9, r7)
            switch(r1) {
                case 2131886110: goto L_0x0094;
                case 2131886149: goto L_0x0093;
                case 2131886376: goto L_0x0092;
                case 2131886590: goto L_0x0091;
                case 2131886668: goto L_0x008f;
                default: goto L_0x008e;
            }
        L_0x008e:
            goto L_0x0095
        L_0x008f:
            r2 = 4
            return r2
        L_0x0091:
            return r4
        L_0x0092:
            return r6
        L_0x0093:
            return r5
        L_0x0094:
            return r3
        L_0x0095:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpaAuthExpe.getResourceOperative(int, java.lang.String):int");
    }

    public void onBindChildViewHolder(ExpedienteChildViewHolder childViewHolder, int parentPosition, int childPosition, ExpedienteDetailLetrados child) {
        childViewHolder.mRelativeGlobal.setBackground(ContextCompat.getDrawable(this.mContext, childPosition != getChildCount(parentPosition) ? R.drawable.back_expedient_child : R.drawable.back_expedient_last_child));
    }
}
