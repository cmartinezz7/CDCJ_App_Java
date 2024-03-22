package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.HomeActivity.1;
import es.santander.justicia.minisJusticia.HomeActivity.2;
import es.santander.justicia.minisJusticia.HomeActivity.3;
import es.santander.justicia.minisJusticia.HomeActivity.4;
import es.santander.justicia.minisJusticia.adapters.AdapterExpedientExpandable;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.ExpedientsController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.UserDetailDTO;
import es.santander.justicia.minisJusticia.expedientes.manager.ExpedientesManager;
import es.santander.justicia.minisJusticia.interfaces.ExpedientsCallBack;
import es.santander.justicia.minisJusticia.interfaces.UserDetailCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;
import java.util.Collections;

public class HomeActivity extends MainActivity implements ExpedientsCallBack, UserDetailCallBack {
   private ExpandableListView expListView;
   private TextView tvUserName;
   private ListView lvPeticiones;
   private ExpedientsController expedientsController;
   private AdapterExpedientExpandable expListAdapter;
   private Context context;
   private int selectedGroupPosition = -1;
   private ExpedienteDTO expedientSelected;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getBaseContext();
      this.setNavigationId(2131362040);
      this.setTealiumName("/consulta_expediente");
      this.setContentView(2131558444);
      Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
      ((QFontTextView)this.findViewById(2131361919)).setText(2131886795);
      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, 2131100891), Mode.SRC_IN);
      navigationView.getMenu().getItem(0).setChecked(true);
      FloatingActionButton fab = (FloatingActionButton)this.findViewById(2131362171);
      int miColor = this.getResources().getColor(2131099837);
      ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{miColor});
      fab.setBackgroundTintList(csl);
      fab.setImageResource(2131231147);
      fab.setOnClickListener(new 1(this));
      this.expListView = (ExpandableListView)this.findViewById(2131362168);
      this.expListView.setVisibility(0);
      this.lvPeticiones = (ListView)this.findViewById(2131362451);
      this.lvPeticiones.setVisibility(8);
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      this.expedientsController = new ExpedientsController(this);
      this.showDialog();
      Bundle extra = this.getIntent().getExtras();
      if (extra != null && extra.get("expedientes") != null) {
         ArrayList<ExpedienteDTO> misExpedientes = (ArrayList)extra.get("expedientes");
         this.onFinishGetExpedients(misExpedientes, true, (String)null);
      }

      if (extra != null && extra.getBoolean("busquedaExpedientes")) {
         this.buscarExpedientes(this.getIntent());
      } else {
         this.expedientsController.getExpedients((ExpedienteDTO)null, "", "", "", "", "");
      }

      LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
      closeLayout.setOnClickListener(new 2(this));
   }

   protected void buscarExpedientes(Intent data) {
      Bundle extras = data.getExtras();
      String dateFrom = extras.getString("dateFrom", "");
      String dateTo = extras.getString("dateTo", "");
      String juzga = extras.getString("juzga", "");
      String juzgori = extras.getString("juzgori", "");
      String jproced = extras.getString("jproced", "");
      String jnumexp = extras.getString("jnumexp", "");
      String janoapex = extras.getString("janoapex", "");
      String selectionType = extras.getString("selectionValue", "");
      String situationType = extras.getString("situationValue", "");
      String currencyType = extras.getString("currencyValue", "");
      ExpedienteDTO expedientDTO = new ExpedienteDTO();
      expedientDTO.setJuzga(juzga);
      expedientDTO.setJuzgori(juzgori);
      expedientDTO.setJproced(jproced);
      expedientDTO.setJnumexp(jnumexp);
      expedientDTO.setJanoapex(janoapex);
      this.expedientsController.getExpedients(expedientDTO, dateFrom, dateTo, selectionType, situationType, currencyType);
   }

   private void showDialog() {
      this.progressDialog = new ProgressDialog(this);
      this.progressDialog.setCancelable(false);
      this.progressDialog.setMessage(this.context.getResources().getString(2131886517));
      this.progressDialog.show();
   }

   public void onFinishGetExpedients(ArrayList<ExpedienteDTO> expedientList, boolean success, String errorMessage) {
      if (success && expedientList != null && expedientList.size() > 0) {
         Collections.sort(expedientList, new 3(this));
         ExpedientesManager.getInstance().setExpedientes(expedientList);
         this.expListAdapter = new AdapterExpedientExpandable(this, expedientList, this.expListView);
         this.expListView.setAdapter(this.expListAdapter);
         View footerView = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(2131558626, (ViewGroup)null, false);
         if (this.expListView.getFooterViewsCount() == 0) {
            this.expListView.addFooterView(footerView);
         }

         this.expListView.setOnGroupClickListener(new 4(this));
      } else {
         Intent intent;
         if (expedientList != null && expedientList.isEmpty()) {
            intent = new Intent(this, BusquedaExpedientesVacia.class);
            this.startActivity(intent);
            this.finish();
         } else if (errorMessage.equals("Error al validar el token, El token ha expirado")) {
            Toast.makeText(this.context, errorMessage, 0).show();
            intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
            intent.setFlags(268468224);
            this.startActivity(intent);
            this.finish();
         }
      }

      if (this.progressDialog != null && this.progressDialog.isShowing()) {
         this.progressDialog.dismiss();
      }

   }

   public void onFinishGetExpedientDetail(ExpedienteDTO expedient, boolean success, String errorMessage) {
      this.closeProgressDialog();
      if (expedient != null && expedient.getSaldos() != null && !expedient.getSaldos().isEmpty()) {
         this.expListAdapter.notifyDataSetChanged();
         this.expListView.expandGroup(this.selectedGroupPosition);
      } else if (expedient != null && expedient.getSaldos() != null && expedient.getSaldos().isEmpty()) {
         expedient.setDetail(false);
         CommonUtils.showAlertNoProceedingData(this);
      } else if (errorMessage != null && errorMessage.length() > 5) {
         Toast.makeText(this.getApplicationContext(), errorMessage, 1).show();
      }

   }

   public void onBackPressed() {
   }

   public boolean onCreateOptionsMenu(Menu menu) {
      this.getMenuInflater().inflate(2131623941, menu);
      return true;
   }

   public void onFinishUserDetailData(UserDetailDTO userDetailDTO, boolean success) {
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName.setText(CommonUtils.wordCapitalize(username));
   }

   // $FF: synthetic method
   static int access$002(HomeActivity x0, int x1) {
      return x0.selectedGroupPosition = x1;
   }

   // $FF: synthetic method
   static ExpedienteDTO access$102(HomeActivity x0, ExpedienteDTO x1) {
      return x0.expedientSelected = x1;
   }

   // $FF: synthetic method
   static AdapterExpedientExpandable access$200(HomeActivity x0) {
      return x0.expListAdapter;
   }

   // $FF: synthetic method
   static ExpedienteDTO access$100(HomeActivity x0) {
      return x0.expedientSelected;
   }

   // $FF: synthetic method
   static ExpedientsController access$300(HomeActivity x0) {
      return x0.expedientsController;
   }
}
