package es.santander.justicia.minisJusticia.adapters;

import android.app.Activity;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import java.util.ArrayList;
import java.util.List;

public class AdapterExpedientExpandable extends BaseExpandableListAdapter {
    public String barra;
    /* access modifiers changed from: private */
    public Activity context;
    public ContextCompat contextCompact;
    private ExpandableListView expandableListView;
    private ArrayList<ExpedienteDTO> listaExpedientes;
    /* access modifiers changed from: private */
    public String numExpediente;
    /* access modifiers changed from: private */
    public ArrayList<String> spinnerData;

    public class ChildViewHolder {
        /* access modifiers changed from: private */
        public Button btnListaMovimientos;
        /* access modifiers changed from: private */
        public TextView tvIngresoPendiente;
        /* access modifiers changed from: private */
        public TextView tvPagoPendiente;
        /* access modifiers changed from: private */
        public TextView tvPagoPendienteConfirmar;
        /* access modifiers changed from: private */
        public TextView tvPrincipal;
        /* access modifiers changed from: private */
        public TextView tvSaldoConsolidado;
        /* access modifiers changed from: private */
        public TextView tvSaldoDia;
        /* access modifiers changed from: private */
        public TextView tvSaldoDisponible;
        /* access modifiers changed from: private */
        public TextView tvSaldoErroneo;
        /* access modifiers changed from: private */
        public TextView tvSaldoRecursos;
        /* access modifiers changed from: private */
        public TextView tvTitulo;

        public ChildViewHolder() {
        }
    }

    public class GroupViewHolder {
        /* access modifiers changed from: private */
        public RelativeLayout RLbarra;
        /* access modifiers changed from: private */
        public ImageView imicon;
        /* access modifiers changed from: private */
        public TextView labelIntCostas;
        /* access modifiers changed from: private */
        public LinearLayout lnrBackground;
        /* access modifiers changed from: private */
        public TextView tvSaldoExpediente;
        /* access modifiers changed from: private */
        public TextView tvdateUltMov;
        /* access modifiers changed from: private */
        public TextView tvidSaldoExpediente;
        /* access modifiers changed from: private */
        public TextView tvintCostas;
        /* access modifiers changed from: private */
        public TextView tvndatePrimerMov;
        /* access modifiers changed from: private */
        public TextView tvnumExpediente;
        /* access modifiers changed from: private */
        public TextView tvsituacionExpediente;
        private RelativeLayout viewDivider;

        public GroupViewHolder() {
        }
    }

    public AdapterExpedientExpandable(Activity context2, ArrayList<ExpedienteDTO> listaExpedientes2, ExpandableListView expListView) {
        this.context = context2;
        this.listaExpedientes = listaExpedientes2;
        this.expandableListView = expListView;
    }

    public List<SaldoDTO> getSaldos(ExpedienteDTO expedienteDTO) {
        List<SaldoDTO> saldos = null;
        if (expedienteDTO.isDetail()) {
            saldos = expedienteDTO.getSaldos();
        }
        if (saldos == null) {
            return new ArrayList<>();
        }
        return saldos;
    }

    public Object getChild(int groupPosition, int childPosition) {
        List<SaldoDTO> saldos = getSaldos(this.listaExpedientes.get(groupPosition));
        if (saldos != null) {
            return saldos.get(childPosition);
        }
        return null;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) childPosition;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$ChildViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getChildView(final int r9, int r10, boolean r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.getChild(r9, r10)
            es.santander.justicia.minisJusticia.dto.SaldoDTO r0 = (es.santander.justicia.minisJusticia.dto.SaldoDTO) r0
            es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$ChildViewHolder r1 = new es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$ChildViewHolder
            r1.<init>()
            r2 = 0
            if (r12 != 0) goto L_0x00a3
            android.app.Activity r3 = r8.context
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r4 = 2131558732(0x7f0d014c, float:1.8742788E38)
            android.view.View r12 = r3.inflate(r4, r13, r2)
            r3 = 2131361946(0x7f0a009a, float:1.8343659E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            android.widget.Button unused = r1.btnListaMovimientos = r3
            r3 = 2131363080(0x7f0a0508, float:1.8345959E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvTitulo = r3
            r3 = 2131363046(0x7f0a04e6, float:1.834589E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvSaldoDia = r3
            r3 = 2131363023(0x7f0a04cf, float:1.8345843E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvIngresoPendiente = r3
            r3 = 2131363032(0x7f0a04d8, float:1.8345861E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvPagoPendiente = r3
            r3 = 2131363033(0x7f0a04d9, float:1.8345863E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvPagoPendienteConfirmar = r3
            r3 = 2131363045(0x7f0a04e5, float:1.8345888E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvSaldoConsolidado = r3
            r3 = 2131363047(0x7f0a04e7, float:1.8345892E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvSaldoDisponible = r3
            r3 = 2131363050(0x7f0a04ea, float:1.8345898E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvSaldoRecursos = r3
            r3 = 2131363048(0x7f0a04e8, float:1.8345894E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvSaldoErroneo = r3
            r3 = 2131363036(0x7f0a04dc, float:1.834587E38)
            android.view.View r3 = r12.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.widget.TextView unused = r1.tvPrincipal = r3
            r12.setTag(r1)
            goto L_0x00aa
        L_0x00a3:
            java.lang.Object r3 = r12.getTag()
            r1 = r3
            es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$ChildViewHolder r1 = (es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.ChildViewHolder) r1
        L_0x00aa:
            android.widget.TextView r3 = r1.tvTitulo
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "CANTIDADES EN "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r0.getMoneda()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvSaldoDia
            java.lang.String r4 = r0.getSaldodia()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvIngresoPendiente
            java.lang.String r4 = r0.getIngpendconso()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvPagoPendiente
            java.lang.String r4 = r0.getPagopendconso()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvPagoPendienteConfirmar
            java.lang.String r4 = r0.getPagopendconf()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvSaldoConsolidado
            java.lang.String r4 = r0.getSaldoconso()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvSaldoDisponible
            java.lang.String r4 = r0.getSaldodisp()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvSaldoRecursos
            java.lang.String r4 = r0.getSaldoingdeposito()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvSaldoErroneo
            java.lang.String r4 = r0.getSaldoingerroneo()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            android.widget.TextView r3 = r1.tvPrincipal
            java.lang.String r4 = r0.getPrincipal()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r3.setText(r4)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r3 = r8.listaExpedientes
            java.lang.Object r3 = r3.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r3 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r3
            java.lang.String r3 = r3.getSituacion()
            if (r11 == 0) goto L_0x0165
            android.widget.Button r4 = r1.btnListaMovimientos
            r4.setVisibility(r2)
            goto L_0x016e
        L_0x0165:
            android.widget.Button r2 = r1.btnListaMovimientos
            r4 = 8
            r2.setVisibility(r4)
        L_0x016e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Expdiente visualizado: "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "ExpedienteExtensible"
            android.util.Log.i(r4, r2)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r2 = r8.listaExpedientes
            java.lang.Object r2 = r2.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r2 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r2
            java.lang.String r2 = r2.getCodExpediente()
            r8.numExpediente = r2
            android.widget.Button r2 = r1.btnListaMovimientos
            es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$1 r4 = new es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$1
            r4.<init>(r9)
            r2.setOnClickListener(r4)
            r8.barra = r3
            r2 = 2131362143(0x7f0a015f, float:1.8344058E38)
            android.view.View r2 = r12.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r4 = r8.barra
            java.util.Locale r5 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "CREADO"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x01d5
            android.app.Activity r4 = r8.context
            r5 = 2131100021(0x7f060175, float:1.7812412E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setBackgroundColor(r4)
            goto L_0x025f
        L_0x01d5:
            java.lang.String r4 = r8.barra
            java.util.Locale r5 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "CONCLUIDO"
            boolean r4 = r4.equals(r5)
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            if (r4 == 0) goto L_0x01f2
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setBackgroundColor(r4)
            goto L_0x025f
        L_0x01f2:
            java.lang.String r4 = r8.barra
            java.util.Locale r6 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r6)
            java.lang.String r6 = "ABIERTO"
            boolean r4 = r4.equals(r6)
            r6 = 2131099962(0x7f06013a, float:1.7812292E38)
            if (r4 == 0) goto L_0x020f
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            r2.setBackgroundColor(r4)
            goto L_0x025f
        L_0x020f:
            java.lang.String r4 = r8.barra
            java.util.Locale r7 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r7)
            java.lang.String r7 = "CANCELADO"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0229
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setBackgroundColor(r4)
            goto L_0x025f
        L_0x0229:
            java.lang.String r4 = r8.barra
            java.util.Locale r5 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "EJECUTADO"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0246
            android.app.Activity r4 = r8.context
            r5 = 2131099965(0x7f06013d, float:1.7812298E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setBackgroundColor(r4)
            goto L_0x025f
        L_0x0246:
            java.lang.String r4 = r8.barra
            java.util.Locale r5 = java.util.Locale.ENGLISH
            java.lang.String r4 = r4.toUpperCase(r5)
            java.lang.String r5 = "OPERATIVO"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x025f
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            r2.setBackgroundColor(r4)
        L_0x025f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.getChildView(int, int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int getChildrenCount(int groupPosition) {
        return getSaldos(this.listaExpedientes.get(groupPosition)).size();
    }

    public Object getGroup(int groupPosition) {
        return this.listaExpedientes.get(groupPosition);
    }

    public int getGroupCount() {
        return this.listaExpedientes.size();
    }

    public long getGroupId(int groupPosition) {
        return (long) groupPosition;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$GroupViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getGroupView(int r9, boolean r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            r8 = this;
            es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$GroupViewHolder r0 = new es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$GroupViewHolder
            r0.<init>()
            r1 = 0
            if (r11 != 0) goto L_0x009d
            android.app.Activity r2 = r8.context
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131558731(0x7f0d014b, float:1.8742786E38)
            android.view.View r11 = r2.inflate(r3, r12, r1)
            r2 = 2131363028(0x7f0a04d4, float:1.8345853E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvnumExpediente = r2
            r2 = 2131363006(0x7f0a04be, float:1.8345809E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvndatePrimerMov = r2
            r2 = 2131363007(0x7f0a04bf, float:1.834581E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvdateUltMov = r2
            r2 = 2131363053(0x7f0a04ed, float:1.8345904E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvsituacionExpediente = r2
            r2 = 2131362998(0x7f0a04b6, float:1.8345792E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvSaldoExpediente = r2
            r2 = 2131363020(0x7f0a04cc, float:1.8345837E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvidSaldoExpediente = r2
            r2 = 2131362438(0x7f0a0286, float:1.8344657E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            android.widget.LinearLayout unused = r0.lnrBackground = r2
            r2 = 2131362284(0x7f0a01ec, float:1.8344344E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.widget.ImageView unused = r0.imicon = r2
            r2 = 2131362143(0x7f0a015f, float:1.8344058E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            android.widget.RelativeLayout unused = r0.RLbarra = r2
            r2 = 2131363021(0x7f0a04cd, float:1.834584E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.tvintCostas = r2
            r2 = 2131362989(0x7f0a04ad, float:1.8345774E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.widget.TextView unused = r0.labelIntCostas = r2
            r11.setTag(r0)
            goto L_0x00a4
        L_0x009d:
            java.lang.Object r2 = r11.getTag()
            r0 = r2
            es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable$GroupViewHolder r0 = (es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.GroupViewHolder) r0
        L_0x00a4:
            if (r10 != 0) goto L_0x00ac
            android.widget.ExpandableListView r2 = r8.expandableListView
            r2.setDividerHeight(r1)
            goto L_0x00b3
        L_0x00ac:
            android.widget.ExpandableListView r2 = r8.expandableListView
            r3 = -19
            r2.setDividerHeight(r3)
        L_0x00b3:
            android.widget.ExpandableListView r2 = r8.expandableListView
            r2.setFooterDividersEnabled(r1)
            android.widget.TextView r2 = r0.tvnumExpediente
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r3 = r8.listaExpedientes
            java.lang.Object r3 = r3.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r3 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r3
            java.lang.String r3 = r3.getCodExpediente()
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.getProceedingFormatted(r3)
            r2.setText(r3)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r2 = r8.listaExpedientes
            java.lang.Object r2 = r2.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r2 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r2
            java.lang.String r2 = r2.getPrimov()
            java.lang.String r2 = r2.toString()
            android.widget.TextView r3 = r0.tvndatePrimerMov
            java.lang.String r4 = es.santander.justicia.utils.DateUtils.formatDate(r2)
            r3.setText(r4)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r3 = r8.listaExpedientes
            java.lang.Object r3 = r3.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r3 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r3
            java.lang.String r3 = r3.getUltmov()
            java.lang.String r3 = r3.toString()
            android.widget.TextView r4 = r0.tvdateUltMov
            java.lang.String r5 = es.santander.justicia.utils.DateUtils.formatDate(r3)
            r4.setText(r5)
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            boolean r4 = r4.isExpanded()
            if (r4 != 0) goto L_0x018d
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getIntCostas()
            if (r4 == 0) goto L_0x018d
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getIntCostas()
            java.lang.String r5 = ""
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 != 0) goto L_0x018d
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getIntCostas()
            java.lang.String r5 = " "
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 != 0) goto L_0x018d
            android.widget.TextView r4 = r0.tvintCostas
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r6 = r8.listaExpedientes
            java.lang.Object r6 = r6.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r6 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r6
            java.lang.String r6 = r6.getIntCostas()
            java.lang.String r6 = es.santander.justicia.utils.CommonUtils.formatImport(r6)
            r5[r1] = r6
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r6 = r8.listaExpedientes
            java.lang.Object r6 = r6.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r6 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r6
            java.lang.String r6 = r6.getCodmon()
            java.lang.String r6 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r6)
            r7 = 1
            r5[r7] = r6
            java.lang.String r6 = "%s %s"
            java.lang.String r5 = java.lang.String.format(r6, r5)
            r4.setText(r5)
            android.widget.TextView r4 = r0.tvintCostas
            r4.setVisibility(r1)
            android.widget.TextView r4 = r0.labelIntCostas
            r4.setVisibility(r1)
            goto L_0x019d
        L_0x018d:
            android.widget.TextView r1 = r0.tvintCostas
            r4 = 8
            r1.setVisibility(r4)
            android.widget.TextView r1 = r0.labelIntCostas
            r1.setVisibility(r4)
        L_0x019d:
            android.widget.TextView r1 = r0.tvsituacionExpediente
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getSituacion()
            r1.setText(r4)
            android.widget.TextView r1 = r0.tvSaldoExpediente
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getSaldo()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.formatImport(r4)
            r1.setText(r4)
            android.widget.TextView r1 = r0.tvidSaldoExpediente
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            java.lang.Object r4 = r4.get(r9)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r4 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r4
            java.lang.String r4 = r4.getCodmon()
            java.lang.String r4 = es.santander.justicia.utils.CommonUtils.getCurrencySymbol(r4)
            r1.setText(r4)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r8.spinnerData = r1
            r1 = 0
        L_0x01e6:
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r4 = r8.listaExpedientes
            int r4 = r4.size()
            if (r1 >= r4) goto L_0x0202
            java.util.ArrayList<java.lang.String> r4 = r8.spinnerData
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.ExpedienteDTO> r5 = r8.listaExpedientes
            java.lang.Object r5 = r5.get(r1)
            es.santander.justicia.minisJusticia.dto.ExpedienteDTO r5 = (es.santander.justicia.minisJusticia.dto.ExpedienteDTO) r5
            java.lang.String r5 = r5.getCodExpediente()
            r4.add(r5)
            int r1 = r1 + 1
            goto L_0x01e6
        L_0x0202:
            android.widget.TextView r1 = r0.tvsituacionExpediente
            java.lang.CharSequence r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            r8.barra = r1
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r4)
            java.lang.String r4 = "CREADO"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x023a
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r4 = r8.context
            r5 = 2131100021(0x7f060175, float:1.7812412E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r1.setBackgroundColor(r4)
            android.widget.ImageView r1 = r0.imicon
            r4 = 2131231074(0x7f080162, float:1.8078219E38)
            r1.setImageResource(r4)
            goto L_0x0309
        L_0x023a:
            java.lang.String r1 = r8.barra
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r4)
            java.lang.String r4 = "CONCLUIDO"
            boolean r1 = r1.equals(r4)
            r4 = 2131231009(0x7f080121, float:1.8078087E38)
            r5 = 2131100947(0x7f060513, float:1.781429E38)
            if (r1 == 0) goto L_0x0266
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r6 = r8.context
            int r5 = androidx.core.content.ContextCompat.getColor(r6, r5)
            r1.setBackgroundColor(r5)
            android.widget.ImageView r1 = r0.imicon
            r1.setImageResource(r4)
            goto L_0x0309
        L_0x0266:
            java.lang.String r1 = r8.barra
            java.util.Locale r6 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r6)
            java.lang.String r6 = "ABIERTO"
            boolean r1 = r1.equals(r6)
            r6 = 2131099962(0x7f06013a, float:1.7812292E38)
            if (r1 == 0) goto L_0x0292
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            r1.setBackgroundColor(r4)
            android.widget.ImageView r1 = r0.imicon
            r4 = 2131230999(0x7f080117, float:1.8078067E38)
            r1.setImageResource(r4)
            goto L_0x0309
        L_0x0292:
            java.lang.String r1 = r8.barra
            java.util.Locale r7 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r7)
            java.lang.String r7 = "CANCELADO"
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x02ba
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r1.setBackgroundColor(r4)
            android.widget.ImageView r1 = r0.imicon
            r4 = 2131231013(0x7f080125, float:1.8078095E38)
            r1.setImageResource(r4)
            goto L_0x0309
        L_0x02ba:
            java.lang.String r1 = r8.barra
            java.util.Locale r5 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r5)
            java.lang.String r5 = "EJECUTADO"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x02e2
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r5 = r8.context
            r6 = 2131099965(0x7f06013d, float:1.7812298E38)
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)
            r1.setBackgroundColor(r5)
            android.widget.ImageView r1 = r0.imicon
            r1.setImageResource(r4)
            goto L_0x0309
        L_0x02e2:
            java.lang.String r1 = r8.barra
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r1 = r1.toUpperCase(r4)
            java.lang.String r4 = "OPERATIVO"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0309
            android.widget.RelativeLayout r1 = r0.RLbarra
            android.app.Activity r4 = r8.context
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            r1.setBackgroundColor(r4)
            android.widget.ImageView r1 = r0.imicon
            r4 = 2131231141(0x7f0801a5, float:1.8078355E38)
            r1.setImageResource(r4)
        L_0x0309:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable.getGroupView(int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
        TealiumHelper.trackEvent("/consulta_expediente", "consulta_expediente (expandir)");
    }
}
