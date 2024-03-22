package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import java.util.ArrayList;

public class MovementListAdapter extends ArrayAdapter<MovementItemDTO> {
    private final Context context;
    /* access modifiers changed from: private */
    public ArrayList<MovementItemDTO> filteredList;
    /* access modifiers changed from: private */
    public ArrayList<MovementItemDTO> movementList;
    private MovementsFilter movementsFilter;

    public class ViewHolder {
        /* access modifiers changed from: private */
        public QFontTextView fecha;
        /* access modifiers changed from: private */
        public QFontTextView mandamientoPago;
        /* access modifiers changed from: private */
        public QFontTextView saldo;
        /* access modifiers changed from: private */
        public QFontTextView status;
        /* access modifiers changed from: private */
        public ImageView statusImg;
        /* access modifiers changed from: private */
        public QFontTextView tipoMovimiento;

        public ViewHolder() {
        }
    }

    public MovementListAdapter(Context context2, ArrayList<MovementItemDTO> movementList2) {
        super(context2, 0, movementList2);
        this.context = context2;
        this.movementList = movementList2;
        this.filteredList = movementList2;
        getFilter();
    }

    public int getCount() {
        return this.filteredList.size();
    }

    public MovementItemDTO getItem(int i) {
        return this.filteredList.get(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: es.santander.justicia.minisJusticia.adapters.MovementListAdapter$ViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            es.santander.justicia.minisJusticia.dto.MovementItemDTO r0 = r8.getItem((int) r9)
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter$ViewHolder r1 = new es.santander.justicia.minisJusticia.adapters.MovementListAdapter$ViewHolder
            r1.<init>()
            r2 = 0
            if (r10 != 0) goto L_0x0065
            android.content.Context r3 = r8.context
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r4 = 2131558734(0x7f0d014e, float:1.8742792E38)
            android.view.View r10 = r3.inflate(r4, r11, r2)
            r3 = 2131363078(0x7f0a0506, float:1.8345955E38)
            android.view.View r3 = r10.findViewById(r3)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = (es.santander.justicia.minisJusticia.views.QFontTextView) r3
            es.santander.justicia.minisJusticia.views.QFontTextView unused = r1.tipoMovimiento = r3
            r3 = 2131363014(0x7f0a04c6, float:1.8345825E38)
            android.view.View r3 = r10.findViewById(r3)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = (es.santander.justicia.minisJusticia.views.QFontTextView) r3
            es.santander.justicia.minisJusticia.views.QFontTextView unused = r1.fecha = r3
            r3 = 2131363025(0x7f0a04d1, float:1.8345847E38)
            android.view.View r3 = r10.findViewById(r3)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = (es.santander.justicia.minisJusticia.views.QFontTextView) r3
            es.santander.justicia.minisJusticia.views.QFontTextView unused = r1.mandamientoPago = r3
            r3 = 2131363049(0x7f0a04e9, float:1.8345896E38)
            android.view.View r3 = r10.findViewById(r3)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = (es.santander.justicia.minisJusticia.views.QFontTextView) r3
            es.santander.justicia.minisJusticia.views.QFontTextView unused = r1.saldo = r3
            r3 = 2131363060(0x7f0a04f4, float:1.8345918E38)
            android.view.View r3 = r10.findViewById(r3)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = (es.santander.justicia.minisJusticia.views.QFontTextView) r3
            es.santander.justicia.minisJusticia.views.QFontTextView unused = r1.status = r3
            r3 = 2131362355(0x7f0a0233, float:1.8344488E38)
            android.view.View r3 = r10.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            android.widget.ImageView unused = r1.statusImg = r3
            r10.setTag(r1)
            goto L_0x006c
        L_0x0065:
            java.lang.Object r3 = r10.getTag()
            r1 = r3
            es.santander.justicia.minisJusticia.adapters.MovementListAdapter$ViewHolder r1 = (es.santander.justicia.minisJusticia.adapters.MovementListAdapter.ViewHolder) r1
        L_0x006c:
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = r1.tipoMovimiento
            java.lang.String r4 = r0.getDesctipomod()
            r5 = 1
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x00a3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r0.getDesctipomod()
            java.lang.String r7 = r7.substring(r2, r5)
            java.lang.String r7 = r7.toUpperCase()
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r7 = r0.getDesctipomod()
            java.lang.String r7 = r7.substring(r5)
            java.lang.String r7 = r7.toLowerCase()
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            goto L_0x00a4
        L_0x00a3:
            r4 = r6
        L_0x00a4:
            r3.setText(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = r1.fecha
            java.lang.String r4 = r0.getJfechare()
            if (r4 == 0) goto L_0x00b6
            java.lang.String r4 = r0.getJfechare()
            goto L_0x00b7
        L_0x00b6:
            r4 = r6
        L_0x00b7:
            r3.setText(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = r1.mandamientoPago
            java.lang.String r4 = r0.getSerieYMandamiento()
            if (r4 == 0) goto L_0x00c9
            java.lang.String r4 = r0.getSerieYMandamiento()
            goto L_0x00ca
        L_0x00c9:
            r4 = r6
        L_0x00ca:
            r3.setText(r4)
            java.lang.String r3 = r0.getImporte()
            if (r3 == 0) goto L_0x010c
            java.lang.String r3 = r0.getImporte()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x010c
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = r1.saldo
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r0.getImporte()
            java.lang.String r7 = es.santander.justicia.utils.CommonUtils.formatImport(r7)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r7 = " "
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r7 = r0.getCodmon()
            java.lang.String r7 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r7)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            r3.setText(r4)
            goto L_0x0113
        L_0x010c:
            es.santander.justicia.minisJusticia.views.QFontTextView r3 = r1.saldo
            r3.setText(r6)
        L_0x0113:
            es.santander.justicia.minisJusticia.enums.MovementStatusEnum r3 = r0.getMovementStatus()
            if (r3 == 0) goto L_0x020b
            es.santander.justicia.minisJusticia.views.QFontTextView r4 = r1.status
            java.lang.String r7 = r3.getName()
            if (r7 == 0) goto L_0x0127
            java.lang.String r6 = r3.getName()
        L_0x0127:
            r4.setText(r6)
            int[] r4 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.AnonymousClass1.$SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum
            int r6 = r3.ordinal()
            r4 = r4[r6]
            if (r4 == r5) goto L_0x01c8
            r5 = 2
            if (r4 == r5) goto L_0x0185
            r2 = 3
            if (r4 == r2) goto L_0x013c
        L_0x013a:
            goto L_0x0227
        L_0x013c:
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.status
            r4 = 4
            r2.setVisibility(r4)
            android.widget.ImageView r2 = r1.statusImg
            r2.setVisibility(r4)
            java.lang.String r2 = r0.getImporte()     // Catch:{ Exception -> 0x017c }
            double r4 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x017c }
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x016a
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.saldo     // Catch:{ Exception -> 0x017c }
            android.content.Context r6 = r8.context     // Catch:{ Exception -> 0x017c }
            r7 = 2131100022(0x7f060176, float:1.7812414E38)
            int r6 = androidx.core.content.ContextCompat.getColor(r6, r7)     // Catch:{ Exception -> 0x017c }
            r2.setTextColor(r6)     // Catch:{ Exception -> 0x017c }
            goto L_0x017a
        L_0x016a:
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.saldo     // Catch:{ Exception -> 0x017c }
            android.content.Context r6 = r8.context     // Catch:{ Exception -> 0x017c }
            r7 = 2131100023(0x7f060177, float:1.7812416E38)
            int r6 = androidx.core.content.ContextCompat.getColor(r6, r7)     // Catch:{ Exception -> 0x017c }
            r2.setTextColor(r6)     // Catch:{ Exception -> 0x017c }
        L_0x017a:
            goto L_0x0227
        L_0x017c:
            r2 = move-exception
            java.lang.String r4 = "ExpedientsController"
            java.lang.String r5 = "Error parseo datos"
            android.util.Log.e(r4, r5, r2)
            goto L_0x013a
        L_0x0185:
            es.santander.justicia.minisJusticia.views.QFontTextView r4 = r1.status
            r4.setVisibility(r2)
            android.widget.ImageView r4 = r1.statusImg
            r4.setVisibility(r2)
            android.widget.ImageView r2 = r1.statusImg
            android.content.Context r4 = r8.context
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setColorFilter(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.status
            android.content.Context r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setTextColor(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.saldo
            android.content.Context r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setTextColor(r4)
            android.widget.ImageView r2 = r1.statusImg
            r4 = 2131231049(0x7f080149, float:1.8078168E38)
            r2.setImageResource(r4)
            goto L_0x0227
        L_0x01c8:
            es.santander.justicia.minisJusticia.views.QFontTextView r4 = r1.status
            r4.setVisibility(r2)
            android.widget.ImageView r4 = r1.statusImg
            r4.setVisibility(r2)
            android.widget.ImageView r2 = r1.statusImg
            android.content.Context r4 = r8.context
            r5 = 2131100021(0x7f060175, float:1.7812412E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setColorFilter(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.status
            android.content.Context r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setTextColor(r4)
            es.santander.justicia.minisJusticia.views.QFontTextView r2 = r1.saldo
            android.content.Context r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setTextColor(r4)
            android.widget.ImageView r2 = r1.statusImg
            r4 = 2131231140(0x7f0801a4, float:1.8078353E38)
            r2.setImageResource(r4)
            goto L_0x0227
        L_0x020b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Operacion sin estado -> jnuoper: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = r0.getJnuoper()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "MovementListAdapter"
            android.util.Log.i(r4, r2)
        L_0x0227:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.MovementListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: es.santander.justicia.minisJusticia.adapters.MovementListAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum;

        static {
            int[] iArr = new int[MovementStatusEnum.values().length];
            $SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum = iArr;
            try {
                iArr[MovementStatusEnum.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum[MovementStatusEnum.EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$es$santander$justicia$minisJusticia$enums$MovementStatusEnum[MovementStatusEnum.EXECUTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Filter getFilter() {
        if (this.movementsFilter == null) {
            this.movementsFilter = new MovementsFilter(this, (AnonymousClass1) null);
        }
        return this.movementsFilter;
    }

    private class MovementsFilter extends Filter {
        private MovementsFilter() {
        }

        /* synthetic */ MovementsFilter(MovementListAdapter x0, AnonymousClass1 x1) {
            this();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01ea  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x020a  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0161  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r29) {
            /*
                r28 = this;
                r1 = r28
                android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
                r0.<init>()
                r2 = r0
                if (r29 == 0) goto L_0x022b
                int r0 = r29.length()
                if (r0 != 0) goto L_0x0013
                r1 = r2
                goto L_0x022c
            L_0x0013:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r3 = r0
                java.lang.String r0 = r29.toString()
                java.lang.String r4 = ":"
                java.lang.String[] r4 = r0.split(r4)
                r0 = 0
                r5 = r4[r0]
                r0 = 1
                r6 = r4[r0]
                r0 = 2
                r7 = r4[r0]
                r0 = 3
                r8 = r4[r0]
                r0 = 4
                r9 = r4[r0]
                r0 = 5
                r10 = r4[r0]
                java.lang.String r11 = "null"
                boolean r0 = r5.equals(r11)
                if (r0 == 0) goto L_0x0076
                boolean r0 = r6.equals(r11)
                if (r0 == 0) goto L_0x0076
                boolean r0 = r7.equals(r11)
                if (r0 == 0) goto L_0x0076
                boolean r0 = r8.equals(r11)
                if (r0 == 0) goto L_0x0076
                boolean r0 = r9.equals(r11)
                if (r0 == 0) goto L_0x0076
                boolean r0 = r10.equals(r11)
                if (r0 == 0) goto L_0x0076
                es.santander.justicia.minisJusticia.adapters.MovementListAdapter r0 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.this
                java.util.ArrayList r0 = r0.movementList
                r2.values = r0
                es.santander.justicia.minisJusticia.adapters.MovementListAdapter r0 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.this
                java.util.ArrayList r0 = r0.movementList
                int r0 = r0.size()
                r2.count = r0
                r27 = r2
                r2 = r1
                r1 = r27
                goto L_0x0242
            L_0x0076:
                es.santander.justicia.minisJusticia.adapters.MovementListAdapter r0 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.this
                java.util.ArrayList r0 = r0.movementList
                java.util.Iterator r12 = r0.iterator()
            L_0x0080:
                boolean r0 = r12.hasNext()
                if (r0 == 0) goto L_0x0219
                java.lang.Object r0 = r12.next()
                r13 = r0
                es.santander.justicia.minisJusticia.dto.MovementItemDTO r13 = (es.santander.justicia.minisJusticia.dto.MovementItemDTO) r13
                r14 = 0
                java.lang.String r15 = r13.getJfechare()
                java.lang.String r16 = r13.getJimpnomi()
                r17 = r4
                java.lang.String r4 = r13.getImporte()
                r18 = r12
                java.lang.String r12 = r13.getMoneda()
                java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
                r19 = r14
                java.lang.String r14 = "dd/MM/yyyy"
                r0.<init>(r14)
                r14 = r0
                boolean r0 = r5.equals(r11)
                java.lang.String r1 = "ParseException"
                r20 = r2
                java.lang.String r2 = "performFiltering"
                if (r0 != 0) goto L_0x0100
                boolean r0 = r6.equals(r11)
                if (r0 != 0) goto L_0x0100
                java.util.Date r0 = r14.parse(r5)     // Catch:{ ParseException -> 0x00f7 }
                java.util.Date r21 = r14.parse(r15)     // Catch:{ ParseException -> 0x00f7 }
                r22 = r21
                java.util.Date r21 = r14.parse(r6)     // Catch:{ ParseException -> 0x00f7 }
                r23 = r21
                r21 = r3
                r3 = r22
                r22 = r13
                r13 = r23
                boolean r23 = r3.before(r13)     // Catch:{ ParseException -> 0x00f5 }
                if (r23 == 0) goto L_0x00e2
                boolean r23 = r3.after(r0)     // Catch:{ ParseException -> 0x00f5 }
                if (r23 != 0) goto L_0x00f2
            L_0x00e2:
                boolean r23 = r3.equals(r0)     // Catch:{ ParseException -> 0x00f5 }
                if (r23 != 0) goto L_0x00f2
                boolean r1 = r3.equals(r13)     // Catch:{ ParseException -> 0x00f5 }
                if (r1 == 0) goto L_0x00ef
                goto L_0x00f2
            L_0x00ef:
                r1 = r19
                goto L_0x00f3
            L_0x00f2:
                r1 = 1
            L_0x00f3:
                goto L_0x015f
            L_0x00f5:
                r0 = move-exception
                goto L_0x00fc
            L_0x00f7:
                r0 = move-exception
                r21 = r3
                r22 = r13
            L_0x00fc:
                android.util.Log.e(r2, r1, r0)
                goto L_0x015a
            L_0x0100:
                r21 = r3
                r22 = r13
                boolean r0 = r5.equals(r11)
                if (r0 != 0) goto L_0x012f
                boolean r0 = r6.equals(r11)
                if (r0 == 0) goto L_0x012f
                java.util.Date r0 = r14.parse(r5)     // Catch:{ ParseException -> 0x012a }
                java.util.Date r3 = r14.parse(r15)     // Catch:{ ParseException -> 0x012a }
                boolean r13 = r3.equals(r0)     // Catch:{ ParseException -> 0x012a }
                if (r13 != 0) goto L_0x0128
                boolean r1 = r3.after(r0)     // Catch:{ ParseException -> 0x012a }
                if (r1 == 0) goto L_0x0125
                goto L_0x0128
            L_0x0125:
                r1 = r19
                goto L_0x0129
            L_0x0128:
                r1 = 1
            L_0x0129:
                goto L_0x015f
            L_0x012a:
                r0 = move-exception
                android.util.Log.e(r2, r1, r0)
                goto L_0x015a
            L_0x012f:
                boolean r0 = r5.equals(r11)
                if (r0 == 0) goto L_0x015d
                boolean r0 = r6.equals(r11)
                if (r0 != 0) goto L_0x015d
                java.util.Date r0 = r14.parse(r6)     // Catch:{ ParseException -> 0x0155 }
                java.util.Date r3 = r14.parse(r15)     // Catch:{ ParseException -> 0x0155 }
                boolean r13 = r3.equals(r0)     // Catch:{ ParseException -> 0x0155 }
                if (r13 != 0) goto L_0x0153
                boolean r1 = r3.before(r0)     // Catch:{ ParseException -> 0x0155 }
                if (r1 == 0) goto L_0x0150
                goto L_0x0153
            L_0x0150:
                r1 = r19
                goto L_0x0154
            L_0x0153:
                r1 = 1
            L_0x0154:
                goto L_0x015f
            L_0x0155:
                r0 = move-exception
                android.util.Log.e(r2, r1, r0)
            L_0x015a:
                r1 = r19
                goto L_0x015f
            L_0x015d:
                r0 = 1
                r1 = r0
            L_0x015f:
                if (r1 == 0) goto L_0x01d0
                r1 = 0
                boolean r0 = r7.equals(r11)
                if (r0 != 0) goto L_0x018d
                boolean r0 = r8.equals(r11)
                if (r0 != 0) goto L_0x018d
                double r2 = java.lang.Double.parseDouble(r7)
                double r23 = java.lang.Double.parseDouble(r16)
                double r25 = java.lang.Double.parseDouble(r8)
                int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
                if (r0 <= 0) goto L_0x0182
                int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
                if (r0 < 0) goto L_0x018a
            L_0x0182:
                int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x018a
                int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
                if (r0 != 0) goto L_0x018c
            L_0x018a:
                r0 = 1
                r1 = r0
            L_0x018c:
                goto L_0x01d0
            L_0x018d:
                boolean r0 = r7.equals(r11)
                if (r0 != 0) goto L_0x01a8
                boolean r0 = r8.equals(r11)
                if (r0 == 0) goto L_0x01a8
                double r2 = java.lang.Double.parseDouble(r7)
                double r23 = java.lang.Double.parseDouble(r16)
                int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
                if (r0 < 0) goto L_0x01a7
                r0 = 1
                r1 = r0
            L_0x01a7:
                goto L_0x01d0
            L_0x01a8:
                boolean r0 = r7.equals(r11)
                if (r0 == 0) goto L_0x01c3
                boolean r0 = r8.equals(r11)
                if (r0 != 0) goto L_0x01c3
                double r2 = java.lang.Double.parseDouble(r8)
                double r23 = java.lang.Double.parseDouble(r16)
                int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
                if (r0 > 0) goto L_0x01c2
                r0 = 1
                r1 = r0
            L_0x01c2:
                goto L_0x01d0
            L_0x01c3:
                boolean r0 = r7.equals(r11)
                if (r0 == 0) goto L_0x01c2
                boolean r0 = r8.equals(r11)
                if (r0 == 0) goto L_0x01c2
                r1 = 1
            L_0x01d0:
                if (r1 == 0) goto L_0x01e8
                r1 = 0
                boolean r0 = r9.equals(r11)
                if (r0 != 0) goto L_0x01e1
                boolean r0 = r4.equals(r9)
                if (r0 == 0) goto L_0x01e1
                r1 = 1
                goto L_0x01e8
            L_0x01e1:
                boolean r0 = r9.equals(r11)
                if (r0 == 0) goto L_0x01e8
                r1 = 1
            L_0x01e8:
                if (r1 == 0) goto L_0x0200
                r1 = 0
                boolean r0 = r10.equals(r11)
                if (r0 != 0) goto L_0x01f9
                boolean r0 = r12.equals(r10)
                if (r0 == 0) goto L_0x01f9
                r1 = 1
                goto L_0x0200
            L_0x01f9:
                boolean r0 = r10.equals(r11)
                if (r0 == 0) goto L_0x0200
                r1 = 1
            L_0x0200:
                if (r1 == 0) goto L_0x020a
                r2 = r21
                r3 = r22
                r2.add(r3)
                goto L_0x020e
            L_0x020a:
                r2 = r21
                r3 = r22
            L_0x020e:
                r1 = r28
                r3 = r2
                r4 = r17
                r12 = r18
                r2 = r20
                goto L_0x0080
            L_0x0219:
                r20 = r2
                r2 = r3
                r17 = r4
                r1 = r20
                r1.values = r2
                int r0 = r2.size()
                r1.count = r0
                r2 = r28
                goto L_0x0242
            L_0x022b:
                r1 = r2
            L_0x022c:
                r2 = r28
                es.santander.justicia.minisJusticia.adapters.MovementListAdapter r0 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.this
                java.util.ArrayList r0 = r0.movementList
                r1.values = r0
                es.santander.justicia.minisJusticia.adapters.MovementListAdapter r0 = es.santander.justicia.minisJusticia.adapters.MovementListAdapter.this
                java.util.ArrayList r0 = r0.movementList
                int r0 = r0.size()
                r1.count = r0
            L_0x0242:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.MovementListAdapter.MovementsFilter.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            ArrayList unused = MovementListAdapter.this.filteredList = (ArrayList) results.values;
            MovementListAdapter.this.notifyDataSetChanged();
        }
    }
}
