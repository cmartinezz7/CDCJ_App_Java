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
import es.santander.justicia.minisJusticia.ListadoPeticionesActivity.1;
import es.santander.justicia.minisJusticia.ListadoPeticionesActivity.2;
import es.santander.justicia.minisJusticia.adapters.AdaptadorListPetitions;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.PetitionController;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.minisJusticia.interfaces.PetitionsCallback;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;

public class ListadoPeticionesActivity extends MainActivity implements PetitionsCallback {
   private Context context;
   private AdaptadorListPetitions lvPeticionesAdapter;
   private PetitionController petitionController;
   private ListView lvPeticiones;
   private TextView tvUserName;
   private ProgressDialog dialog;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getBaseContext();
      this.setNavigationId(2131362421);
      this.setTealiumName("/listado_solicitudes");
      this.setRequestedOrientation(1);
      this.setContentView(2131558455);
      Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
      ((QFontTextView)this.findViewById(2131361919)).setText(2131886797);
      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.getMenu().getItem(2).setChecked(true);
      navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, 2131100891), Mode.SRC_IN);
      FloatingActionButton fab = (FloatingActionButton)this.findViewById(2131362171);
      int miColor = this.getResources().getColor(2131099837);
      ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{miColor});
      fab.setBackgroundTintList(csl);
      fab.setImageResource(2131231147);
      fab.setOnClickListener(new 1(this));
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      this.petitionController = new PetitionController(this);
      this.showDialog();
      Bundle extra = this.getIntent().getExtras();
      if (extra != null && extra.getBoolean("busquedaPeticiones")) {
         this.buscarPeticiones(this.getIntent());
      } else {
         this.petitionController.getPetitions((ExpedienteDTO)null, "", DateUtils.getDateMonthBeforeCurrent((String)null), "", "1");
      }

      LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
      closeLayout.setOnClickListener(new 2(this));
   }

   protected void buscarPeticiones(Intent data) {
      Bundle extras = data.getExtras();
      String dateFrom = extras.getString("dateFrom", "");
      String dateTo = extras.getString("dateTo", "");
      String juzga = extras.getString("juzga", "");
      String juzgori = extras.getString("juzgori", "");
      String jproced = extras.getString("jproced", "");
      String jnumexp = extras.getString("jnumexp", "");
      String janoapex = extras.getString("janoapex", "");
      String stateType = extras.getString("stateValue", "");
      ExpedienteDTO expedientDTO = new ExpedienteDTO();
      expedientDTO.setJuzga(juzga);
      expedientDTO.setJuzgori(juzgori);
      expedientDTO.setJproced(jproced);
      expedientDTO.setJnumexp(jnumexp);
      expedientDTO.setJanoapex(janoapex);
      this.petitionController.getPetitions(expedientDTO, stateType, dateFrom, dateTo, "1");
   }

   private void showDialog() {
      this.dialog = new ProgressDialog(this);
      this.dialog.setCancelable(false);
      this.dialog.setMessage(this.context.getResources().getString(2131886519));
      this.dialog.show();
   }

   public void onBackPressed() {
   }

   public boolean onCreateOptionsMenu(Menu menu) {
      this.getMenuInflater().inflate(2131623941, menu);
      return true;
   }

   public void onFinishGetPetitions(ArrayList<PeticionDTO> petitionList, boolean success, String errorMessage) {
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

      if (success && petitionList != null && petitionList.size() > 0) {
         this.lvPeticionesAdapter = new AdaptadorListPetitions(this.getApplicationContext(), petitionList);
         ExpandableListView lvExpandable = (ExpandableListView)this.findViewById(2131362168);
         lvExpandable.setVisibility(8);
         this.lvPeticiones = (ListView)this.findViewById(2131362451);
         this.lvPeticiones.setVisibility(0);
         View footerView = ((LayoutInflater)this.getSystemService("layout_inflater")).inflate(2131558626, (ViewGroup)null, false);
         if (this.lvPeticiones.getFooterViewsCount() == 0) {
            this.lvPeticiones.addFooterView(footerView);
         }

         if (this.lvPeticionesAdapter != null) {
            this.lvPeticiones.setDividerHeight(20);
            this.lvPeticiones.setAdapter(this.lvPeticionesAdapter);
         }
      } else {
         Intent intent;
         if (success && petitionList != null && petitionList.size() == 0) {
            intent = new Intent(this, BusquedaPeticionesVacia.class);
            this.startActivity(intent);
         } else if (errorMessage.equals("Error al validar el token, El token ha expirado")) {
            Toast.makeText(this.context, errorMessage, 0).show();
            intent = new Intent(this, CommonUtils.getLoginProfesionalesClass(this));
            intent.setFlags(268468224);
            this.startActivity(intent);
            this.finish();
         }
      }

   }
}
