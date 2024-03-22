package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.ExpedientsController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.UserDetailDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.interfaces.ExpedientsCallBack;
import es.santander.justicia.minisJusticia.interfaces.UserDetailCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HomeActivity extends MainActivity implements ExpedientsCallBack, UserDetailCallBack {
    private Context context;
    /* access modifiers changed from: private */
    public AdapterExpedientExpandable expListAdapter;
    private ExpandableListView expListView;
    /* access modifiers changed from: private */
    public ExpedienteDTO expedientSelected;
    /* access modifiers changed from: private */
    public ExpedientsController expedientsController;
    private ListView lvPeticiones;
    /* access modifiers changed from: private */
    public int selectedGroupPosition = -1;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener} */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.app.Activity] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r19) {
        /*
            r18 = this;
            r6 = r18
            super.onCreate(r19)
            android.content.Context r0 = r18.getBaseContext()
            r6.context = r0
            r0 = 2131362040(0x7f0a00f8, float:1.834385E38)
            r6.setNavigationId(r0)
            java.lang.String r0 = "/consulta_expediente"
            r6.setTealiumName(r0)
            r0 = 2131558444(0x7f0d002c, float:1.8742204E38)
            r6.setContentView(r0)
            r0 = 2131362965(0x7f0a0495, float:1.8345725E38)
            android.view.View r0 = r6.findViewById(r0)
            r7 = r0
            androidx.appcompat.widget.Toolbar r7 = (androidx.appcompat.widget.Toolbar) r7
            r0 = 2131361919(0x7f0a007f, float:1.8343604E38)
            android.view.View r0 = r6.findViewById(r0)
            es.santander.justicia.minisJusticia.views.QFontTextView r0 = (es.santander.justicia.minisJusticia.views.QFontTextView) r0
            r1 = 2131886795(0x7f1202cb, float:1.9408179E38)
            r0.setText(r1)
            r0 = 2131362106(0x7f0a013a, float:1.8343983E38)
            android.view.View r0 = r6.findViewById(r0)
            r8 = r0
            androidx.drawerlayout.widget.DrawerLayout r8 = (androidx.drawerlayout.widget.DrawerLayout) r8
            androidx.appcompat.app.ActionBarDrawerToggle r9 = new androidx.appcompat.app.ActionBarDrawerToggle
            r4 = 2131886647(0x7f120237, float:1.9407879E38)
            r5 = 2131886646(0x7f120236, float:1.9407877E38)
            r0 = r9
            r1 = r18
            r2 = r8
            r3 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.addDrawerListener(r0)
            r0.syncState()
            r1 = 2131362529(0x7f0a02e1, float:1.8344841E38)
            android.view.View r1 = r6.findViewById(r1)
            com.google.android.material.navigation.NavigationView r1 = (com.google.android.material.navigation.NavigationView) r1
            r1.setNavigationItemSelectedListener(r6)
            android.view.Menu r2 = r1.getMenu()
            r3 = 4
            android.view.MenuItem r2 = r2.getItem(r3)
            android.graphics.drawable.Drawable r2 = r2.getIcon()
            r3 = 2131100891(0x7f0604db, float:1.7814176E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r6, r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.setColorFilter(r3, r4)
            android.view.Menu r2 = r1.getMenu()
            r3 = 0
            android.view.MenuItem r2 = r2.getItem(r3)
            r4 = 1
            r2.setChecked(r4)
            r2 = 2131362171(0x7f0a017b, float:1.8344115E38)
            android.view.View r2 = r6.findViewById(r2)
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            android.content.res.Resources r5 = r18.getResources()
            r9 = 2131099837(0x7f0600bd, float:1.7812038E38)
            int r5 = r5.getColor(r9)
            android.content.res.ColorStateList r9 = new android.content.res.ColorStateList
            int[][] r10 = new int[r4][]
            int[] r11 = new int[r3]
            r10[r3] = r11
            int[] r11 = new int[r4]
            r11[r3] = r5
            r9.<init>(r10, r11)
            r2.setBackgroundTintList(r9)
            r10 = 2131231147(0x7f0801ab, float:1.8078367E38)
            r2.setImageResource(r10)
            es.santander.justicia.minisJusticia.HomeActivity$1 r10 = new es.santander.justicia.minisJusticia.HomeActivity$1
            r10.<init>()
            r2.setOnClickListener(r10)
            r10 = 2131362168(0x7f0a0178, float:1.8344109E38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.ExpandableListView r10 = (android.widget.ExpandableListView) r10
            r6.expListView = r10
            r10.setVisibility(r3)
            r10 = 2131362451(0x7f0a0293, float:1.8344683E38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.ListView r10 = (android.widget.ListView) r10
            r6.lvPeticiones = r10
            r11 = 8
            r10.setVisibility(r11)
            java.lang.String r10 = ""
            es.santander.justicia.minisJusticia.login.manager.LoginManager r11 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            if (r11 == 0) goto L_0x0105
            es.santander.justicia.minisJusticia.login.manager.LoginManager r11 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r11 = r11.getNombreUsuario()
            if (r11 == 0) goto L_0x0105
            es.santander.justicia.minisJusticia.login.manager.LoginManager r11 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r11 = r11.getNombreUsuario()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x00fc
            java.lang.String r11 = ""
            goto L_0x0104
        L_0x00fc:
            es.santander.justicia.minisJusticia.login.manager.LoginManager r11 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r11 = r11.getNombreUsuario()
        L_0x0104:
            r10 = r11
        L_0x0105:
            android.view.View r3 = r1.getHeaderView(r3)
            r11 = 2131363086(0x7f0a050e, float:1.834597E38)
            android.view.View r3 = r3.findViewById(r11)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r6.tvUserName = r3
            if (r3 == 0) goto L_0x011d
            java.lang.String r11 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r10)
            r3.setText(r11)
        L_0x011d:
            es.santander.justicia.minisJusticia.controllers.ExpedientsController r3 = new es.santander.justicia.minisJusticia.controllers.ExpedientsController
            r3.<init>(r6)
            r6.expedientsController = r3
            r18.showDialog()
            android.content.Intent r3 = r18.getIntent()
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x0143
            java.lang.String r11 = "expedientes"
            java.lang.Object r12 = r3.get(r11)
            if (r12 == 0) goto L_0x0143
            java.lang.Object r11 = r3.get(r11)
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            r12 = 0
            r6.onFinishGetExpedients(r11, r4, r12)
        L_0x0143:
            if (r3 == 0) goto L_0x0155
            java.lang.String r4 = "busquedaExpedientes"
            boolean r4 = r3.getBoolean(r4)
            if (r4 == 0) goto L_0x0155
            android.content.Intent r4 = r18.getIntent()
            r6.buscarExpedientes(r4)
            goto L_0x0165
        L_0x0155:
            es.santander.justicia.minisJusticia.controllers.ExpedientsController r11 = r6.expedientsController
            r12 = 0
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            r11.getExpedients(r12, r13, r14, r15, r16, r17)
        L_0x0165:
            r4 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r4 = r6.findViewById(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            es.santander.justicia.minisJusticia.HomeActivity$2 r11 = new es.santander.justicia.minisJusticia.HomeActivity$2
            r11.<init>()
            r4.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.HomeActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void buscarExpedientes(Intent data) {
        Bundle extras = data.getExtras();
        String dateFrom = extras.getString(Constants.DATE_FROM, "");
        String dateTo = extras.getString(Constants.DATE_TO, "");
        String juzga = extras.getString(Constants.EXPEDIENT_JUZGA, "");
        String juzgori = extras.getString(Constants.EXPEDIENT_JUZGORI, "");
        String jproced = extras.getString(Constants.EXPEDIENT_JPROCED, "");
        String jnumexp = extras.getString(Constants.EXPEDIENT_JNUMEXP, "");
        String janoapex = extras.getString(Constants.EXPEDIENT_JANOAPEX, "");
        String selectionType = extras.getString(Constants.SELECTION_VALUE, "");
        String situationType = extras.getString(Constants.SITUATION_VALUE, "");
        String currencyType = extras.getString(Constants.CURRENCY_VALUE, "");
        ExpedienteDTO expedientDTO = new ExpedienteDTO();
        expedientDTO.setJuzga(juzga);
        expedientDTO.setJuzgori(juzgori);
        expedientDTO.setJproced(jproced);
        expedientDTO.setJnumexp(jnumexp);
        expedientDTO.setJanoapex(janoapex);
        ExpedienteDTO expedienteDTO = expedientDTO;
        this.expedientsController.getExpedients(expedientDTO, dateFrom, dateTo, selectionType, situationType, currencyType);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.HomeActivity] */
    private void showDialog() {
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setCancelable(false);
        this.progressDialog.setMessage(this.context.getResources().getString(R.string.loading_expedient_list));
        this.progressDialog.show();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.HomeActivity, android.app.Activity] */
    public void onFinishGetExpedients(ArrayList<ExpedienteDTO> expedientList, boolean success, String errorMessage) {
        if (success && expedientList != null && expedientList.size() > 0) {
            Collections.sort(expedientList, new Comparator<ExpedienteDTO>() {
                public int compare(ExpedienteDTO o1, ExpedienteDTO o2) {
                    return o1.getCodExpediente().compareTo(o2.getCodExpediente());
                }
            });
            ExpedientesManager.getInstance().setExpedientes(expedientList);
            AdapterExpedientExpandable adapterExpedientExpandable = new AdapterExpedientExpandable(this, expedientList, this.expListView);
            this.expListAdapter = adapterExpedientExpandable;
            this.expListView.setAdapter(adapterExpedientExpandable);
            View footerView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.list_blank_footer, (ViewGroup) null, false);
            if (this.expListView.getFooterViewsCount() == 0) {
                this.expListView.addFooterView(footerView);
            }
            this.expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    int unused = HomeActivity.this.selectedGroupPosition = groupPosition;
                    HomeActivity homeActivity = HomeActivity.this;
                    ExpedienteDTO unused2 = homeActivity.expedientSelected = (ExpedienteDTO) homeActivity.expListAdapter.getGroup(groupPosition);
                    HomeActivity.this.expedientSelected.setExpanded(parent.isGroupExpanded(groupPosition));
                    if (!HomeActivity.this.expedientSelected.isDetail()) {
                        HomeActivity.this.showProgressDialog((int) R.string.loading_expDetail);
                        HomeActivity.this.expedientsController.getExpedientDetail(HomeActivity.this.expedientSelected);
                        HomeActivity.this.expListAdapter.notifyDataSetChanged();
                        return true;
                    } else if (HomeActivity.this.expedientSelected.getSaldos() == null || HomeActivity.this.expedientSelected.getSaldos().isEmpty()) {
                        HomeActivity.this.expListAdapter.notifyDataSetChanged();
                        return true;
                    } else {
                        HomeActivity.this.expListAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
            });
        } else if (expedientList != null && expedientList.isEmpty()) {
            startActivity(new Intent(this, BusquedaExpedientesVacia.class));
            finish();
        } else if (errorMessage.equals(Constants.TOKEN_TIMEOUT)) {
            Toast.makeText(this.context, errorMessage, 0).show();
            Intent intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
        }
        if (this.progressDialog != null && this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.justicia.minisJusticia.HomeActivity, android.app.Activity] */
    public void onFinishGetExpedientDetail(ExpedienteDTO expedient, boolean success, String errorMessage) {
        closeProgressDialog();
        if (expedient != null && expedient.getSaldos() != null && !expedient.getSaldos().isEmpty()) {
            this.expListAdapter.notifyDataSetChanged();
            this.expListView.expandGroup(this.selectedGroupPosition);
        } else if (expedient != null && expedient.getSaldos() != null && expedient.getSaldos().isEmpty()) {
            expedient.setDetail(false);
            CommonUtils.showAlertNoProceedingData(this);
        } else if (errorMessage != null && errorMessage.length() > 5) {
            Toast.makeText(getApplicationContext(), errorMessage, 1).show();
        }
    }

    public void onBackPressed() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    public void onFinishUserDetailData(UserDetailDTO userDetailDTO, boolean success) {
        String username = "";
        if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
        }
        this.tvUserName.setText(CommonUtils.wordCapitalize(username));
    }
}
