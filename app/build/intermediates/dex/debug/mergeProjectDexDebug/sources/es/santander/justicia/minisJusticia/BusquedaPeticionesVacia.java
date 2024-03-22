package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;

public class BusquedaPeticionesVacia extends MainActivity {
    private Context context;
    private Button nuevaBusqueda;
    private TextView tvUserName;

    /* JADX WARNING: type inference failed for: r9v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener, es.santander.justicia.minisJusticia.BusquedaPeticionesVacia] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_vacia_con_menu);
        this.context = getBaseContext();
        this.nuevaBusqueda = (Button) findViewById(R.id.btnNuevaBusqueda);
        ((QFontTextView) findViewById(R.id.bar_title)).setText(R.string.title_activity_listadoPeticiones);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, findViewById(R.id.toolbar), 2131886647, 2131886646);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(2131362529);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(2).setChecked(true);
        navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, R.color.red), PorterDuff.Mode.SRC_IN);
        String username = "";
        if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
        }
        TextView textView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_user_name);
        this.tvUserName = textView;
        if (textView != null) {
            textView.setText(CommonUtils.wordCapitalize(username));
        }
        this.nuevaBusqueda.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, es.santander.justicia.minisJusticia.BusquedaPeticionesVacia] */
            public void onClick(View v) {
                BusquedaPeticionesVacia.this.finish();
                BusquedaPeticionesVacia.this.startActivity(new Intent(BusquedaPeticionesVacia.this, BusquedaPeticionesActivity.class));
            }
        });
    }
}
