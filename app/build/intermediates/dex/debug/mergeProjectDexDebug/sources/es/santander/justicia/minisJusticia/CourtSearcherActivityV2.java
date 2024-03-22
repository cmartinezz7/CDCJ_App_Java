package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class CourtSearcherActivityV2 extends MainActivity {
    private Button btnSearch;
    private Context context;
    private String judicialEnvironmentSelected = "";
    private String provinceSelected = "";
    /* access modifiers changed from: private */
    public Spinner spnJudicialEnvironment;
    /* access modifiers changed from: private */
    public Spinner spnProvince;
    private TextView tvUserName;

    /* JADX WARNING: type inference failed for: r12v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener, es.santander.justicia.minisJusticia.CourtSearcherActivityV2] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/busqueda_juzgado");
        this.context = getBaseContext();
        setContentView(R.layout.activity_court_searcher_v2);
        setNavigationId(R.id.localizar_juzgados);
        ((QFontTextView) findViewById(R.id.text_toolbar_title)).setText(R.string.court_searcher_title);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, findViewById(R.id.toolbar), 2131886647, 2131886646);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(2131362529);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(3).setChecked(true);
        navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, R.color.red), PorterDuff.Mode.SRC_IN);
        this.spnProvince = (Spinner) findViewById(R.id.spn_province);
        this.spnJudicialEnvironment = (Spinner) findViewById(R.id.spn_judicial_environment);
        ArrayAdapter<SpinnerValuesDTO> spnProvinceAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_PROVINCES));
        spnProvinceAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnProvince.setAdapter(spnProvinceAdapter);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_JUDICIAL_ENVIRONMENT));
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnJudicialEnvironment.setAdapter(arrayAdapter);
        Button button = (Button) findViewById(R.id.btn_search);
        this.btnSearch = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.CourtSearcherActivityV2] */
            public void onClick(View v) {
                Intent intent = new Intent(CourtSearcherActivityV2.this, CourtListActivity.class);
                intent.putExtra(Constants.PROVINCE, ((SpinnerValuesDTO) CourtSearcherActivityV2.this.spnProvince.getSelectedItem()).getCode());
                intent.putExtra(Constants.JUDICIAL_ENVIRONMENT, ((SpinnerValuesDTO) CourtSearcherActivityV2.this.spnJudicialEnvironment.getSelectedItem()).getCode());
                CourtSearcherActivityV2.this.startActivity(intent);
            }
        });
        String username = "";
        if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
        }
        TextView textView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_user_name);
        this.tvUserName = textView;
        if (textView != null) {
            textView.setText(CommonUtils.wordCapitalize(username));
        }
        ((LinearLayout) findViewById(R.id.close_session)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CourtSearcherActivityV2.this.logout();
            }
        });
    }
}
