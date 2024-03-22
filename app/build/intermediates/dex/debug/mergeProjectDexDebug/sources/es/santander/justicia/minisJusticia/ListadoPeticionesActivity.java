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
import es.santander.justicia.minisJusticia.adapters.AdaptadorListPetitions;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.PetitionController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.minisJusticia.interfaces.PetitionsCallback;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;

public class ListadoPeticionesActivity extends MainActivity implements PetitionsCallback {
    private Context context;
    private ProgressDialog dialog;
    private ListView lvPeticiones;
    private AdaptadorListPetitions lvPeticionesAdapter;
    private PetitionController petitionController;
    private TextView tvUserName;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener} */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.app.Activity] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r18) {
        /*
            r17 = this;
            r6 = r17
            super.onCreate(r18)
            android.content.Context r0 = r17.getBaseContext()
            r6.context = r0
            r0 = 2131362421(0x7f0a0275, float:1.8344622E38)
            r6.setNavigationId(r0)
            java.lang.String r0 = "/listado_solicitudes"
            r6.setTealiumName(r0)
            r7 = 1
            r6.setRequestedOrientation(r7)
            r0 = 2131558455(0x7f0d0037, float:1.8742226E38)
            r6.setContentView(r0)
            r0 = 2131362965(0x7f0a0495, float:1.8345725E38)
            android.view.View r0 = r6.findViewById(r0)
            r8 = r0
            androidx.appcompat.widget.Toolbar r8 = (androidx.appcompat.widget.Toolbar) r8
            r0 = 2131361919(0x7f0a007f, float:1.8343604E38)
            android.view.View r0 = r6.findViewById(r0)
            es.santander.justicia.minisJusticia.views.QFontTextView r0 = (es.santander.justicia.minisJusticia.views.QFontTextView) r0
            r1 = 2131886797(0x7f1202cd, float:1.9408183E38)
            r0.setText(r1)
            r0 = 2131362106(0x7f0a013a, float:1.8343983E38)
            android.view.View r0 = r6.findViewById(r0)
            r9 = r0
            androidx.drawerlayout.widget.DrawerLayout r9 = (androidx.drawerlayout.widget.DrawerLayout) r9
            androidx.appcompat.app.ActionBarDrawerToggle r10 = new androidx.appcompat.app.ActionBarDrawerToggle
            r4 = 2131886647(0x7f120237, float:1.9407879E38)
            r5 = 2131886646(0x7f120236, float:1.9407877E38)
            r0 = r10
            r1 = r17
            r2 = r9
            r3 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r9.addDrawerListener(r0)
            r0.syncState()
            r1 = 2131362529(0x7f0a02e1, float:1.8344841E38)
            android.view.View r1 = r6.findViewById(r1)
            com.google.android.material.navigation.NavigationView r1 = (com.google.android.material.navigation.NavigationView) r1
            r1.setNavigationItemSelectedListener(r6)
            android.view.Menu r2 = r1.getMenu()
            r3 = 2
            android.view.MenuItem r2 = r2.getItem(r3)
            r2.setChecked(r7)
            android.view.Menu r2 = r1.getMenu()
            r3 = 4
            android.view.MenuItem r2 = r2.getItem(r3)
            android.graphics.drawable.Drawable r2 = r2.getIcon()
            r3 = 2131100891(0x7f0604db, float:1.7814176E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r6, r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.setColorFilter(r3, r4)
            r2 = 2131362171(0x7f0a017b, float:1.8344115E38)
            android.view.View r2 = r6.findViewById(r2)
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            android.content.res.Resources r3 = r17.getResources()
            r4 = 2131099837(0x7f0600bd, float:1.7812038E38)
            int r3 = r3.getColor(r4)
            android.content.res.ColorStateList r4 = new android.content.res.ColorStateList
            int[][] r5 = new int[r7][]
            r10 = 0
            int[] r11 = new int[r10]
            r5[r10] = r11
            int[] r7 = new int[r7]
            r7[r10] = r3
            r4.<init>(r5, r7)
            r2.setBackgroundTintList(r4)
            r5 = 2131231147(0x7f0801ab, float:1.8078367E38)
            r2.setImageResource(r5)
            es.santander.justicia.minisJusticia.ListadoPeticionesActivity$1 r5 = new es.santander.justicia.minisJusticia.ListadoPeticionesActivity$1
            r5.<init>()
            r2.setOnClickListener(r5)
            java.lang.String r5 = ""
            es.santander.justicia.minisJusticia.login.manager.LoginManager r7 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            if (r7 == 0) goto L_0x00eb
            es.santander.justicia.minisJusticia.login.manager.LoginManager r7 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r7 = r7.getNombreUsuario()
            if (r7 == 0) goto L_0x00eb
            es.santander.justicia.minisJusticia.login.manager.LoginManager r7 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r7 = r7.getNombreUsuario()
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x00e2
            java.lang.String r7 = ""
            goto L_0x00ea
        L_0x00e2:
            es.santander.justicia.minisJusticia.login.manager.LoginManager r7 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r7 = r7.getNombreUsuario()
        L_0x00ea:
            r5 = r7
        L_0x00eb:
            android.view.View r7 = r1.getHeaderView(r10)
            r10 = 2131363086(0x7f0a050e, float:1.834597E38)
            android.view.View r7 = r7.findViewById(r10)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r6.tvUserName = r7
            if (r7 == 0) goto L_0x0103
            java.lang.String r10 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r5)
            r7.setText(r10)
        L_0x0103:
            es.santander.justicia.minisJusticia.controllers.PetitionController r7 = new es.santander.justicia.minisJusticia.controllers.PetitionController
            r7.<init>(r6)
            r6.petitionController = r7
            r17.showDialog()
            android.content.Intent r7 = r17.getIntent()
            android.os.Bundle r7 = r7.getExtras()
            if (r7 == 0) goto L_0x0127
            java.lang.String r10 = "busquedaPeticiones"
            boolean r10 = r7.getBoolean(r10)
            if (r10 == 0) goto L_0x0127
            android.content.Intent r10 = r17.getIntent()
            r6.buscarPeticiones(r10)
            goto L_0x0138
        L_0x0127:
            es.santander.justicia.minisJusticia.controllers.PetitionController r11 = r6.petitionController
            r12 = 0
            r10 = 0
            java.lang.String r14 = es.santander.justicia.utils.DateUtils.getDateMonthBeforeCurrent(r10)
            java.lang.String r13 = ""
            java.lang.String r15 = ""
            java.lang.String r16 = "1"
            r11.getPetitions(r12, r13, r14, r15, r16)
        L_0x0138:
            r10 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r10 = r6.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            es.santander.justicia.minisJusticia.ListadoPeticionesActivity$2 r11 = new es.santander.justicia.minisJusticia.ListadoPeticionesActivity$2
            r11.<init>()
            r10.setOnClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ListadoPeticionesActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void buscarPeticiones(Intent data) {
        Bundle extras = data.getExtras();
        String dateFrom = extras.getString(Constants.DATE_FROM, "");
        String dateTo = extras.getString(Constants.DATE_TO, "");
        String juzga = extras.getString(Constants.EXPEDIENT_JUZGA, "");
        String juzgori = extras.getString(Constants.EXPEDIENT_JUZGORI, "");
        String jproced = extras.getString(Constants.EXPEDIENT_JPROCED, "");
        String jnumexp = extras.getString(Constants.EXPEDIENT_JNUMEXP, "");
        String janoapex = extras.getString(Constants.EXPEDIENT_JANOAPEX, "");
        String stateType = extras.getString(Constants.STATE_VALUE, "");
        ExpedienteDTO expedientDTO = new ExpedienteDTO();
        expedientDTO.setJuzga(juzga);
        expedientDTO.setJuzgori(juzgori);
        expedientDTO.setJproced(jproced);
        expedientDTO.setJnumexp(jnumexp);
        expedientDTO.setJanoapex(janoapex);
        this.petitionController.getPetitions(expedientDTO, stateType, dateFrom, dateTo, "1");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ListadoPeticionesActivity] */
    private void showDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCancelable(false);
        this.dialog.setMessage(this.context.getResources().getString(R.string.loading_movement_list));
        this.dialog.show();
    }

    public void onBackPressed() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ListadoPeticionesActivity] */
    public void onFinishGetPetitions(ArrayList<PeticionDTO> petitionList, boolean success, String errorMessage) {
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (success && petitionList != null && petitionList.size() > 0) {
            this.lvPeticionesAdapter = new AdaptadorListPetitions(getApplicationContext(), petitionList);
            ((ExpandableListView) findViewById(R.id.expandable_list)).setVisibility(8);
            ListView listView = (ListView) findViewById(R.id.lv_expedientes);
            this.lvPeticiones = listView;
            listView.setVisibility(0);
            View footerView = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.list_blank_footer, (ViewGroup) null, false);
            if (this.lvPeticiones.getFooterViewsCount() == 0) {
                this.lvPeticiones.addFooterView(footerView);
            }
            if (this.lvPeticionesAdapter != null) {
                this.lvPeticiones.setDividerHeight(20);
                this.lvPeticiones.setAdapter(this.lvPeticionesAdapter);
            }
        } else if (success && petitionList != null && petitionList.size() == 0) {
            startActivity(new Intent(this, BusquedaPeticionesVacia.class));
        } else if (errorMessage.equals(Constants.TOKEN_TIMEOUT)) {
            Toast.makeText(this.context, errorMessage, 0).show();
            Intent intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
            intent.setFlags(268468224);
            startActivity(intent);
            finish();
        }
    }
}
