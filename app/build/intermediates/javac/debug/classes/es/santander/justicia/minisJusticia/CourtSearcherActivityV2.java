package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.CourtSearcherActivityV2.1;
import es.santander.justicia.minisJusticia.CourtSearcherActivityV2.2;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class CourtSearcherActivityV2 extends MainActivity {
   private Context context;
   private Spinner spnProvince;
   private Spinner spnJudicialEnvironment;
   private Button btnSearch;
   private TextView tvUserName;
   private String provinceSelected = "";
   private String judicialEnvironmentSelected = "";

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/busqueda_juzgado");
      this.context = this.getBaseContext();
      this.setContentView(2131558437);
      this.setNavigationId(2131362445);
      Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
      QFontTextView toolbarTitle = (QFontTextView)this.findViewById(2131362931);
      toolbarTitle.setText(2131886360);
      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      navigationView.setNavigationItemSelectedListener(this);
      navigationView.getMenu().getItem(3).setChecked(true);
      navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, 2131100891), Mode.SRC_IN);
      this.spnProvince = (Spinner)this.findViewById(2131362736);
      this.spnJudicialEnvironment = (Spinner)this.findViewById(2131362732);
      ArrayList<SpinnerValuesDTO> provinces = SpinnerContentModel.getSpinnerValues("spnProvinces");
      ArrayAdapter<SpinnerValuesDTO> spnProvinceAdapter = new ArrayAdapter(this, 2131558752, 2131362922, provinces);
      spnProvinceAdapter.setDropDownViewResource(2131558753);
      this.spnProvince.setAdapter(spnProvinceAdapter);
      ArrayList<SpinnerValuesDTO> judicialEnvironments = SpinnerContentModel.getSpinnerValues("spnJudicialEnv");
      ArrayAdapter<SpinnerValuesDTO> spnJudicialEnvironmentAdapter = new ArrayAdapter(this, 2131558752, 2131362922, judicialEnvironments);
      spnJudicialEnvironmentAdapter.setDropDownViewResource(2131558753);
      this.spnJudicialEnvironment.setAdapter(spnJudicialEnvironmentAdapter);
      this.btnSearch = (Button)this.findViewById(2131361960);
      this.btnSearch.setOnClickListener(new 1(this));
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
      closeLayout.setOnClickListener(new 2(this));
   }

   // $FF: synthetic method
   static Spinner access$000(CourtSearcherActivityV2 x0) {
      return x0.spnProvince;
   }

   // $FF: synthetic method
   static Spinner access$100(CourtSearcherActivityV2 x0) {
      return x0.spnJudicialEnvironment;
   }
}
