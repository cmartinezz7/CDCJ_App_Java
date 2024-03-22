package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail;
import es.santander.justicia.minisJusticia.views.QFontButton;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;
import java.util.List;

public class AdapterConsultaExp extends AdapterAbstractRecycler<DatosExpedienteNew> {
    private final int TYPE_CARD_CANCELLED = 3;
    private final int TYPE_CARD_CREATED_CONCLUDED = 2;
    private final int TYPE_CARD_GLOBAL = 4;
    private final int TYPE_CHILD = 8;
    private final int TYPE_LINEAR_CANCELLED = 6;
    private final int TYPE_LINEAR_CREATED_CONCLUDED = 5;
    private final int TYPE_LINEAR_GLOBAL = 7;
    /* access modifiers changed from: private */
    public int mExpandedCard;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public OnActivarClick mOnActivarClick;
    /* access modifiers changed from: private */
    public OnExpandClick mOnExpandClick;

    public interface OnActivarClick {
        void onActivarClickListener(int i);
    }

    public interface OnExpandClick {
        void onItemClickListener(int i, int i2);
    }

    public AdapterConsultaExp(Context context, OnExpandClick onExpandClick, OnActivarClick onActivarClick, List<DatosExpedienteNew> listNews) {
        super(context, (AdapterAbstractRecycler.OnRecyclerClickListener) null, listNews);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mExpandedCard = -1;
        this.mOnExpandClick = onExpandClick;
        this.mOnActivarClick = onActivarClick;
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 2:
                return new ViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente_conc_creat, parent, false));
            case 3:
                return new ViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente_cancel, parent, false));
            case 4:
                return new ViewHolder(this.mInflater.inflate(R.layout.card_consulta_expediente, parent, false));
            case 5:
                return new ViewHolder(this.mInflater.inflate(R.layout.linear_con_exp_conc_creat, parent, false));
            case 6:
                return new ViewHolder(this.mInflater.inflate(R.layout.linear_con_exp_cancel, parent, false));
            case 7:
                return new ViewHolder(this.mInflater.inflate(R.layout.linear_consul_exp, parent, false));
            case 8:
                return new ViewHolder(this.mInflater.inflate(R.layout.linear_expedient_detail_big, parent, false));
            default:
                return null;
        }
    }

    public DetalleExpDatosExpDetail.DetalleExpSaldos getChildItem(int position) {
        return ((DatosExpedienteNew) getItem(position)).getDetalleExpSaldos();
    }

    public int getItemViewType(int position) {
        if (((DatosExpedienteNew) getItem(position)).getSitexp() == null) {
            return 8;
        }
        String sitexp = ((DatosExpedienteNew) getItem(position)).getSitexp();
        char c = 65535;
        int hashCode = sitexp.hashCode();
        if (hashCode != 2081) {
            if (hashCode != 2142) {
                if (hashCode != 2156) {
                    if (hashCode != 2159) {
                        if (hashCode != 2213) {
                            if (hashCode == 2529 && sitexp.equals(Constants.EXP_STATE_OPERATIVE)) {
                                c = 5;
                            }
                        } else if (sitexp.equals(Constants.EXP_STATE_EJECUTED)) {
                            c = 4;
                        }
                    } else if (sitexp.equals(Constants.EXP_STATE_CREATED)) {
                        c = 0;
                    }
                } else if (sitexp.equals(Constants.EXP_STATE_CONCLUDED)) {
                    c = 1;
                }
            } else if (sitexp.equals(Constants.EXP_STATE_CANCELLED)) {
                c = 2;
            }
        } else if (sitexp.equals(Constants.EXP_STATE_OPEN)) {
            c = 3;
        }
        if (c == 0 || c == 1) {
            if (position == this.mExpandedCard) {
                return 5;
            }
            return 2;
        } else if (c != 2) {
            if (c != 3 && c != 4 && c != 5) {
                return position == this.mExpandedCard ? 5 : 2;
            }
            if (position == this.mExpandedCard) {
                return 7;
            }
            return 4;
        } else if (position == this.mExpandedCard) {
            return 6;
        } else {
            return 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x022f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(es.santander.justicia.minisJusticia.adapters.ViewHolderAbstract r18, int r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r18
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$ViewHolder r2 = (es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder) r2
            java.lang.Object r3 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r3 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r3
            boolean r3 = r3.isChild()
            java.lang.String r4 = "EJ"
            java.lang.String r5 = "CR"
            java.lang.String r6 = "CO"
            java.lang.String r7 = "CA"
            java.lang.String r8 = "AB"
            r13 = 2142(0x85e, float:3.002E-42)
            r14 = 2081(0x821, float:2.916E-42)
            r15 = 8
            r9 = 0
            if (r3 != 0) goto L_0x024d
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mTextNumExp
            java.lang.Object r16 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r16 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r16
            java.lang.String r16 = r16.getCodExpediente()
            java.lang.String r10 = es.santander.justicia.utils.CommonUtils.getProceedingFormatted(r16)
            r3.setText(r10)
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mTextDateFirstMov
            java.lang.Object r10 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r10 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r10
            java.lang.String r10 = r10.getPrimov()
            java.lang.String r10 = es.santander.justicia.utils.CommonUtils.getDateFromExp(r10)
            r3.setText(r10)
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mTextDateLastMov
            java.lang.Object r10 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r10 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r10
            java.lang.String r10 = r10.getUltmov()
            java.lang.String r10 = es.santander.justicia.utils.CommonUtils.getDateFromExp(r10)
            r3.setText(r10)
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mTextSituation
            java.lang.Object r10 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r10 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r10
            java.lang.String r10 = r10.getSituacion()
            r3.setText(r10)
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mTextAmount
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.Object r16 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r16 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r16
            es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos r16 = r16.getSaldos()
            java.lang.String r16 = r16.getImpsald()
            java.lang.String r11 = es.santander.justicia.utils.CommonUtils.formatImport(r16)
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r11 = " "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.Object r16 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r16 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r16
            es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos r16 = r16.getSaldos()
            java.lang.String r16 = r16.getCodmon()
            java.lang.String r12 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r16)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.String r10 = r10.toString()
            r3.setText(r10)
            android.widget.LinearLayout r3 = r2.lImpCostas
            r3.setVisibility(r15)
            java.lang.Object r3 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r3 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r3
            java.lang.String r3 = r3.getImpInterCostas()
            if (r3 == 0) goto L_0x010a
            java.lang.Object r3 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r3 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r3
            boolean r3 = r3.isExpanded()
            if (r3 == 0) goto L_0x010a
            es.santander.justicia.minisJusticia.views.QTextView r3 = r2.mImpCostas
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.Object r12 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r12 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r12
            java.lang.String r12 = r12.getImpInterCostas()
            java.lang.String r12 = es.santander.justicia.utils.CommonUtils.formatImport(r12)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.Object r11 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r11 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r11
            es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.Saldos r11 = r11.getSaldos()
            java.lang.String r11 = r11.getCodmon()
            java.lang.String r11 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r11)
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            r3.setText(r10)
            android.widget.LinearLayout r3 = r2.lImpCostas
            r3.setVisibility(r9)
            goto L_0x010f
        L_0x010a:
            android.widget.LinearLayout r3 = r2.lImpCostas
            r3.setVisibility(r15)
        L_0x010f:
            r3 = 0
            java.lang.Object r10 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r10 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r10
            java.lang.String r10 = r10.getSitexp()
            int r11 = r10.hashCode()
            if (r11 == r14) goto L_0x015d
            if (r11 == r13) goto L_0x0155
            r8 = 2156(0x86c, float:3.021E-42)
            if (r11 == r8) goto L_0x014d
            r7 = 2159(0x86f, float:3.025E-42)
            if (r11 == r7) goto L_0x0145
            r6 = 2213(0x8a5, float:3.101E-42)
            if (r11 == r6) goto L_0x013d
            r5 = 2529(0x9e1, float:3.544E-42)
            if (r11 == r5) goto L_0x0133
        L_0x0132:
            goto L_0x0165
        L_0x0133:
            java.lang.String r4 = "OP"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0132
            r15 = 5
            goto L_0x0166
        L_0x013d:
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0132
            r15 = 4
            goto L_0x0166
        L_0x0145:
            boolean r4 = r10.equals(r5)
            if (r4 == 0) goto L_0x0132
            r15 = r9
            goto L_0x0166
        L_0x014d:
            boolean r4 = r10.equals(r6)
            if (r4 == 0) goto L_0x0132
            r15 = 1
            goto L_0x0166
        L_0x0155:
            boolean r4 = r10.equals(r7)
            if (r4 == 0) goto L_0x0132
            r15 = 3
            goto L_0x0166
        L_0x015d:
            boolean r4 = r10.equals(r8)
            if (r4 == 0) goto L_0x0132
            r15 = 2
            goto L_0x0166
        L_0x0165:
            r15 = -1
        L_0x0166:
            if (r15 == 0) goto L_0x01d2
            r4 = 1
            if (r15 == r4) goto L_0x01c0
            r4 = 2
            if (r15 == r4) goto L_0x01ae
            r4 = 3
            if (r15 == r4) goto L_0x019c
            r4 = 4
            if (r15 == r4) goto L_0x018a
            r4 = 5
            if (r15 == r4) goto L_0x0178
            goto L_0x01e4
        L_0x0178:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131231141(0x7f0801a5, float:1.8078355E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131099962(0x7f06013a, float:1.7812292E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
            goto L_0x01e4
        L_0x018a:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131231009(0x7f080121, float:1.8078087E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131099965(0x7f06013d, float:1.7812298E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
            goto L_0x01e4
        L_0x019c:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131231013(0x7f080125, float:1.8078095E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
            goto L_0x01e4
        L_0x01ae:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131230999(0x7f080117, float:1.8078067E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131099962(0x7f06013a, float:1.7812292E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
            goto L_0x01e4
        L_0x01c0:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131231009(0x7f080121, float:1.8078087E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
            goto L_0x01e4
        L_0x01d2:
            android.widget.ImageView r4 = r2.mImageState
            r5 = 2131231074(0x7f080162, float:1.8078219E38)
            r4.setImageResource(r5)
            android.content.Context r4 = r0.mContext
            r5 = 2131100021(0x7f060175, float:1.7812412E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r4, r5)
        L_0x01e4:
            android.widget.LinearLayout r4 = r2.mLinearGlobal
            if (r4 == 0) goto L_0x0203
            android.content.Context r4 = r0.mContext
            r5 = 2131231325(0x7f08025d, float:1.8078728E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            if (r4 == 0) goto L_0x01f8
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.SRC_IN
            r4.setColorFilter(r3, r5)
        L_0x01f8:
            android.widget.ImageView r5 = r2.mImageState
            r5.setBackground(r4)
            android.widget.ImageView r5 = r2.mImageState
            r5.invalidate()
            goto L_0x0208
        L_0x0203:
            android.widget.ImageView r4 = r2.mImageState
            r4.setBackgroundColor(r3)
        L_0x0208:
            com.alexandrius.accordionswipelayout.library.SwipeLayout r4 = r2.mSwipeLayout
            if (r4 == 0) goto L_0x022f
            com.alexandrius.accordionswipelayout.library.SwipeLayout r4 = r2.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$1 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$1
            r5.<init>(r1)
            r4.setOnClickListener(r5)
            android.widget.ImageView r4 = r2.mImageSwipe
            if (r4 == 0) goto L_0x0224
            android.widget.ImageView r4 = r2.mImageSwipe
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$2 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$2
            r5.<init>(r2)
            r4.setOnClickListener(r5)
        L_0x0224:
            com.alexandrius.accordionswipelayout.library.SwipeLayout r4 = r2.mSwipeLayout
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$3 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$3
            r5.<init>(r1)
            r4.setOnSwipeItemClickListener(r5)
            goto L_0x024b
        L_0x022f:
            androidx.cardview.widget.CardView r4 = r2.mCard
            if (r4 == 0) goto L_0x023d
            androidx.cardview.widget.CardView r4 = r2.mCard
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$4 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$4
            r5.<init>(r1)
            r4.setOnClickListener(r5)
        L_0x023d:
            android.widget.LinearLayout r4 = r2.mLinearGlobal
            if (r4 == 0) goto L_0x024b
            android.widget.LinearLayout r4 = r2.mLinearGlobal
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$5 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$5
            r5.<init>(r1)
            r4.setOnClickListener(r5)
        L_0x024b:
            goto L_0x041a
        L_0x024d:
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r3 = r0.getChildItem(r1)
            if (r3 == 0) goto L_0x041a
            r3 = 1
        L_0x0254:
            int r10 = r1 - r3
            java.lang.Object r10 = r0.getItem(r10)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r10 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r10
            boolean r10 = r10.isChild()
            if (r10 == 0) goto L_0x0265
            int r3 = r3 + 1
            goto L_0x0254
        L_0x0265:
            r10 = 0
            int r11 = r1 - r3
            java.lang.Object r11 = r0.getItem(r11)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r11 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r11
            java.lang.String r11 = r11.getSitexp()
            if (r11 == 0) goto L_0x0323
            int r11 = r1 - r3
            java.lang.Object r11 = r0.getItem(r11)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r11 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r11
            java.lang.String r11 = r11.getSitexp()
            int r12 = r11.hashCode()
            if (r12 == r14) goto L_0x02c3
            if (r12 == r13) goto L_0x02bb
            r8 = 2156(0x86c, float:3.021E-42)
            if (r12 == r8) goto L_0x02b3
            r7 = 2159(0x86f, float:3.025E-42)
            if (r12 == r7) goto L_0x02ab
            r6 = 2213(0x8a5, float:3.101E-42)
            if (r12 == r6) goto L_0x02a3
            r5 = 2529(0x9e1, float:3.544E-42)
            if (r12 == r5) goto L_0x0299
        L_0x0298:
            goto L_0x02cb
        L_0x0299:
            java.lang.String r4 = "OP"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0298
            r4 = 4
            goto L_0x02cc
        L_0x02a3:
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0298
            r4 = 5
            goto L_0x02cc
        L_0x02ab:
            boolean r4 = r11.equals(r5)
            if (r4 == 0) goto L_0x0298
            r4 = r9
            goto L_0x02cc
        L_0x02b3:
            boolean r4 = r11.equals(r6)
            if (r4 == 0) goto L_0x0298
            r4 = 1
            goto L_0x02cc
        L_0x02bb:
            boolean r4 = r11.equals(r7)
            if (r4 == 0) goto L_0x0298
            r4 = 2
            goto L_0x02cc
        L_0x02c3:
            boolean r4 = r11.equals(r8)
            if (r4 == 0) goto L_0x0298
            r4 = 3
            goto L_0x02cc
        L_0x02cb:
            r4 = -1
        L_0x02cc:
            if (r4 == 0) goto L_0x02ff
            r5 = 1
            if (r4 == r5) goto L_0x02f4
            r5 = 2
            if (r4 == r5) goto L_0x02f4
            r5 = 3
            if (r4 == r5) goto L_0x02e9
            r5 = 4
            if (r4 == r5) goto L_0x02e9
            r5 = 5
            if (r4 == r5) goto L_0x02de
            goto L_0x0309
        L_0x02de:
            android.content.Context r4 = r0.mContext
            r5 = 2131099965(0x7f06013d, float:1.7812298E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r10 = r4
            goto L_0x0309
        L_0x02e9:
            android.content.Context r4 = r0.mContext
            r5 = 2131099962(0x7f06013a, float:1.7812292E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r10 = r4
            goto L_0x0309
        L_0x02f4:
            android.content.Context r4 = r0.mContext
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r10 = r4
            goto L_0x0309
        L_0x02ff:
            android.content.Context r4 = r0.mContext
            r5 = 2131100021(0x7f060175, float:1.7812412E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r10 = r4
        L_0x0309:
            android.content.Context r4 = r0.mContext
            r5 = 2131231322(0x7f08025a, float:1.8078722E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r5)
            if (r4 == 0) goto L_0x0319
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.SRC_IN
            r4.setColorFilter(r10, r5)
        L_0x0319:
            android.view.View r5 = r2.mViewChild
            r5.setBackground(r4)
            android.view.View r5 = r2.mViewChild
            r5.invalidate()
        L_0x0323:
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountCurrency
            android.content.Context r5 = r0.mContext
            r6 = 2131886121(0x7f120029, float:1.9406812E38)
            java.lang.String r5 = r5.getString(r6)
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r7 = r0.getChildItem(r1)
            java.lang.String r7 = r7.getMoneda()
            r6[r9] = r7
            java.lang.String r5 = java.lang.String.format(r5, r6)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountDay
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getSaldodia()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextIncomPdtCons
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getIngpendconso()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextPdtCons
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getPagopendconso()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextPdtConf
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getPagopendconf()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountCons
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getSaldoconso()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountDisp
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getSaldodisp()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountErr
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getSaldoingerroneo()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextAmountReso
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getSaldoingdeposito()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            es.santander.justicia.minisJusticia.views.QTextView r4 = r2.mTextPrincipal
            es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail$DetalleExpSaldos r5 = r0.getChildItem(r1)
            java.lang.String r5 = r5.getPrincipal()
            java.lang.String r5 = es.santander.justicia.utils.CommonUtils.formatImport(r5)
            r4.setText(r5)
            int r4 = r1 + 1
            int r5 = r17.getItemCount()
            if (r4 >= r5) goto L_0x03f1
            int r4 = r1 + 1
            java.lang.Object r4 = r0.getItem(r4)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r4 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r4
            boolean r4 = r4.isChild()
            if (r4 == 0) goto L_0x0405
        L_0x03f1:
            int r4 = r1 + 1
            int r5 = r17.getItemCount()
            if (r4 != r5) goto L_0x0415
            java.lang.Object r4 = r0.getItem(r1)
            es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew r4 = (es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew) r4
            boolean r4 = r4.isChild()
            if (r4 == 0) goto L_0x0415
        L_0x0405:
            es.santander.justicia.minisJusticia.views.QFontButton r4 = r2.mTextMovements
            r4.setVisibility(r9)
            es.santander.justicia.minisJusticia.views.QFontButton r4 = r2.mTextMovements
            es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$6 r5 = new es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp$6
            r5.<init>(r1)
            r4.setOnClickListener(r5)
            goto L_0x041a
        L_0x0415:
            es.santander.justicia.minisJusticia.views.QFontButton r4 = r2.mTextMovements
            r4.setVisibility(r15)
        L_0x041a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.onBindViewHolder(es.santander.justicia.minisJusticia.adapters.ViewHolderAbstract, int):void");
    }

    public void setExpandedCard(int expandedCard) {
        this.mExpandedCard = expandedCard;
    }

    public ArrayList<DatosExpedienteDetail> getListMovements() {
        ArrayList<DatosExpedienteDetail> movements = new ArrayList<>();
        for (DatosExpedienteNew datosExpedienteNew : this.mListItems) {
            if (datosExpedienteNew.getJnumexp() != null && !datosExpedienteNew.getJnumexp().isEmpty() && datosExpedienteNew.getJproced() != null && !datosExpedienteNew.getJproced().isEmpty() && datosExpedienteNew.getJuzga() != null && !datosExpedienteNew.getJuzga().isEmpty() && datosExpedienteNew.getJuzgori() != null && !datosExpedienteNew.getJuzgori().isEmpty()) {
                movements.add(new DatosExpedienteDetail(datosExpedienteNew.getJanoapex(), datosExpedienteNew.getJnumexp(), datosExpedienteNew.getJproced(), datosExpedienteNew.getJuzga(), datosExpedienteNew.getJuzgori(), datosExpedienteNew.getPrimov(), datosExpedienteNew.getUltmov()));
            }
        }
        return movements;
    }

    public class ViewHolder extends ViewHolderAbstract {
        public LinearLayout lImpCostas;
        public CardView mCard;
        public ImageView mImageState;
        public ImageView mImageSwipe;
        public QTextView mImpCostas;
        public LinearLayout mLinearDetail;
        public LinearLayout mLinearGlobal;
        public RelativeLayout mStateBar;
        public SwipeLayout mSwipeLayout;
        public QTextView mTextAmount;
        public QTextView mTextAmountCons;
        public QTextView mTextAmountCurrency;
        public QTextView mTextAmountDay;
        public QTextView mTextAmountDisp;
        public QTextView mTextAmountErr;
        public QTextView mTextAmountReso;
        public QTextView mTextDateFirstMov;
        public QTextView mTextDateLastMov;
        public QTextView mTextIncomPdtCons;
        public QFontButton mTextMovements;
        public QTextView mTextNumExp;
        public QTextView mTextPdtConf;
        public QTextView mTextPdtCons;
        public QTextView mTextPrincipal;
        public QTextView mTextSituation;
        public View mViewChild;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mCard = itemView.findViewById(R.id.card);
            this.mLinearDetail = (LinearLayout) itemView.findViewById(R.id.linear_detail);
            this.mSwipeLayout = itemView.findViewById(R.id.swipe_layout);
            this.mLinearGlobal = (LinearLayout) itemView.findViewById(R.id.linear_card);
            this.mImageSwipe = (ImageView) itemView.findViewById(R.id.image_swipe);
            this.mImageState = (ImageView) itemView.findViewById(R.id.image_state);
            this.mTextNumExp = (QTextView) itemView.findViewById(R.id.text_num_exp);
            this.mTextDateFirstMov = (QTextView) itemView.findViewById(R.id.text_date_first);
            this.mTextDateLastMov = (QTextView) itemView.findViewById(R.id.text_date_last);
            this.mTextSituation = (QTextView) itemView.findViewById(R.id.text_situation);
            this.mTextAmount = (QTextView) itemView.findViewById(R.id.text_amount);
            this.mImpCostas = (QTextView) itemView.findViewById(R.id.text_impCostas);
            this.lImpCostas = (LinearLayout) itemView.findViewById(R.id.linear_impCostas);
            this.mStateBar = (RelativeLayout) itemView.findViewById(R.id.estadoBar);
            this.mViewChild = itemView.findViewById(R.id.view_color);
            this.mTextAmountCurrency = (QTextView) itemView.findViewById(R.id.text_amount_currency);
            this.mTextAmountDay = (QTextView) itemView.findViewById(R.id.text_amount_day);
            this.mTextIncomPdtCons = (QTextView) itemView.findViewById(R.id.text_income_ptd_cons);
            this.mTextPdtCons = (QTextView) itemView.findViewById(R.id.text_pay_pdt_cons);
            this.mTextPdtConf = (QTextView) itemView.findViewById(R.id.text_pay_pdt_conf);
            this.mTextAmountCons = (QTextView) itemView.findViewById(R.id.text_amount_cons);
            this.mTextAmountDisp = (QTextView) itemView.findViewById(R.id.text_amount_disp);
            this.mTextAmountErr = (QTextView) itemView.findViewById(R.id.text_income_error);
            this.mTextAmountReso = (QTextView) itemView.findViewById(R.id.text_income_resources);
            this.mTextPrincipal = (QTextView) itemView.findViewById(R.id.text_principal);
            this.mTextMovements = (QFontButton) itemView.findViewById(R.id.text_movements);
        }
    }
}
