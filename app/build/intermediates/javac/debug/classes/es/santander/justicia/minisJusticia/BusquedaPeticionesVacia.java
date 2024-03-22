package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.BusquedaPeticionesVacia.1;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;

public class BusquedaPeticionesVacia extends MainActivity {
   private Context context;
   private Button nuevaBusqueda;
   private TextView tvUserName;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558492);
      this.context = this.getBaseContext();
      this.nuevaBusqueda = (Button)this.findViewById(2131361949);
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
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      this.nuevaBusqueda.setOnClickListener(new 1(this));
   }
}
