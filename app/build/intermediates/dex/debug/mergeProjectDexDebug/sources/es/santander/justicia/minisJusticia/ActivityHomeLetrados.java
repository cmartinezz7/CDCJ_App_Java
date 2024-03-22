package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import es.santander.branchlocator.BLUtils;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility;
import es.santander.justicia.minisJusticia.fragments.FragmentAdvices;
import es.santander.justicia.minisJusticia.fragments.FragmentAuhtJuzgados;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp;
import es.santander.justicia.minisJusticia.fragments.FragmentBuscadorJuzgados;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew;
import es.santander.justicia.minisJusticia.fragments.FragmentHelp;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations;
import es.santander.justicia.minisJusticia.models.responses.detalleUsuario.DetalleUsuario;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.Locale;

public class ActivityHomeLetrados extends ActivityAbstractLetrados {
    public static final String USER_DETAIL_READY = "user-detail-ready";
    public boolean mConnIsRunning;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToogle;
    private ImageView mEdit;
    /* access modifiers changed from: private */
    public ListView mListDrawer;
    /* access modifiers changed from: private */
    public QTextView mTextLogOut;
    private QFontTextView mTextTitleToolbar;
    private Toolbar mToolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_letrados);
        initComponents();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ActionBarDrawerToggle actionBarDrawerToggle = this.mDrawerToogle;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.syncState();
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ActionBarDrawerToggle actionBarDrawerToggle = this.mDrawerToogle;
        if (actionBarDrawerToggle != null) {
            actionBarDrawerToggle.onConfigurationChanged(newConfig);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityHomeLetrados] */
    private void initComponents() {
        RetrofitUtility.updateToken = PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_TOKEN_SSO);
        this.mToolbar = findViewById(R.id.toolbar);
        this.mDrawerLayout = findViewById(R.id.drawer_layout);
        this.mListDrawer = (ListView) findViewById(R.id.list_drawer);
        this.mTextLogOut = (QTextView) findViewById(R.id.text_logout);
        this.mEdit = (ImageView) findViewById(R.id.img_edit);
        this.mTextTitleToolbar = (QFontTextView) findViewById(R.id.text_toolbar_title);
        this.mTextLogOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityHomeLetrados.this.logout();
            }
        });
        initDrawer();
        getCall();
        replaceFragment(R.string.menu_advice, (Bundle) null);
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityHomeLetrados] */
    private void initDrawer() {
        this.mListDrawer.addHeaderView(getLayoutInflater().inflate(R.layout.header_drawer_letrados, (ViewGroup) null));
        this.mListDrawer.setAdapter(new AdapterDrawerLetrados(this));
        AnonymousClass2 r3 = new ActionBarDrawerToggle(this, this.mDrawerLayout, this.mToolbar, 2131886126, 2131886126) {
            public void onDrawerClosed(View drawerView) {
                ActivityHomeLetrados.super.onDrawerClosed(drawerView);
                ActivityHomeLetrados.this.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                ActivityHomeLetrados.super.onDrawerOpened(drawerView);
                ActivityHomeLetrados.this.invalidateOptionsMenu();
            }

            public void onDrawerSlide(View drawerView, float slideOffset) {
                ActivityHomeLetrados.super.onDrawerSlide(drawerView, slideOffset);
                ActivityHomeLetrados.this.findViewById(R.id.linear_drawer_container).setTranslationX(((float) drawerView.getWidth()) * slideOffset);
                ActivityHomeLetrados.this.invalidateOptionsMenu();
            }
        };
        this.mDrawerToogle = r3;
        this.mDrawerLayout.addDrawerListener(r3);
        this.mListDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((AdapterDrawerLetrados) ((HeaderViewListAdapter) ActivityHomeLetrados.this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(i - 1);
                ActivityHomeLetrados.this.mTextLogOut.setSelected(false);
                if (ActivityHomeLetrados.this.mListDrawer.getAdapter().getItemId(i) == 2131886573) {
                    BLUtils.launchBranchLocator(ActivityHomeLetrados.this.getContext(), false, true);
                    ActivityHomeLetrados.this.simulateClick(0);
                    return;
                }
                ActivityHomeLetrados activityHomeLetrados = ActivityHomeLetrados.this;
                activityHomeLetrados.replaceFragment((int) activityHomeLetrados.mListDrawer.getAdapter().getItemId(i), (Bundle) null);
            }
        });
    }

    public void onSelectTribunalClick(View v) {
        startActivity(new Intent(getBaseContext(), ActivitySelectTribunal.class));
    }

    public void simulateClick(int i) {
        ListView listView = this.mListDrawer;
        listView.performItemClick(listView.getRootView(), i, 0);
    }

    public void loadAuthFromAdvices() {
        ((AdapterDrawerLetrados) ((HeaderViewListAdapter) this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(getResources().obtainTypedArray(R.array.drawer_letrados), R.string.menu_expedients_auth));
        this.mTextLogOut.setSelected(false);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_FILTER, "PE");
        replaceFragment(R.string.menu_expedients_auth, bundle);
    }

    public void loadOperationsFromAdvices() {
        ((AdapterDrawerLetrados) ((HeaderViewListAdapter) this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(getResources().obtainTypedArray(R.array.drawer_letrados), R.string.menu_operations_pending));
        this.mTextLogOut.setSelected(false);
        replaceFragment(R.string.menu_operations_pending, (Bundle) null);
    }

    public void loadFromAuthJuz() {
        ((AdapterDrawerLetrados) ((HeaderViewListAdapter) this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(getResources().obtainTypedArray(R.array.drawer_letrados), R.string.menu_court_auth));
        this.mTextLogOut.setSelected(false);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_FILTER, "PE");
        replaceFragment(R.string.menu_court_auth, bundle);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(getString(R.string.menu_find_office));
        if (fragment != null && fragment.isVisible()) {
            fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityHomeLetrados] */
    private void getCall() {
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            DetalleUsuario detalleUsuario = (DetalleUsuario) extra.getSerializable(Constants.USER_DETAIL);
            ((QTextView) this.mListDrawer.findViewById(R.id.text_name)).setText(String.format("%s %s %s", new Object[]{capitalizeFirstLetter(detalleUsuario.getNombreUsuario()), capitalizeFirstLetter(detalleUsuario.getApellidoPrimero()), capitalizeFirstLetter(detalleUsuario.getApellidoSegundo())}));
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(USER_DETAIL_READY));
        }
    }

    private String capitalizeFirstLetter(String name) {
        if (name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT);
    }

    /* access modifiers changed from: private */
    public void replaceFragment(int fragmentId, Bundle args) {
        if (fragmentId == -1) {
            fragmentId = R.string.menu_advice;
        }
        getSupportFragmentManager().beginTransaction().replace(2131362041, PlaceholderFragment.newInstance(fragmentId, args), getString(fragmentId)).commit();
        this.mDrawerLayout.closeDrawer(3);
    }

    public void onSectionAttached(int section) {
        if (section == 2131886584) {
            this.mTextTitleToolbar.setText(getString(R.string.oper_eject_title));
        } else {
            QFontTextView qFontTextView = this.mTextTitleToolbar;
            if (qFontTextView != null) {
                qFontTextView.setText(getString(section));
            }
        }
        if (section != 2131886568) {
            ImageView imageView = this.mEdit;
            if (imageView != null) {
                imageView.setVisibility(4);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mEdit;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public static abstract class PlaceholderFragment extends Fragment {
        public static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber, Bundle args) {
            PlaceholderFragment fragment;
            switch (sectionNumber) {
                case R.string.menu_advice:
                    fragment = new FragmentAdvices();
                    break;
                case R.string.menu_court_auth:
                    fragment = new FragmentAuhtJuzgados();
                    break;
                case R.string.menu_expedients_auth:
                    fragment = new FragmentAuthExp();
                    break;
                case R.string.menu_expedients_query:
                    fragment = new FragmentConsultaExpNew();
                    break;
                case R.string.menu_find_tribunal:
                    fragment = new FragmentBuscadorJuzgados();
                    break;
                case R.string.menu_help_letrados:
                    fragment = new FragmentHelp();
                    break;
                case R.string.menu_operations_done:
                case R.string.menu_operations_pending:
                    fragment = new FragmentOperations();
                    break;
                default:
                    fragment = new FragmentAdvices();
                    break;
            }
            if (args == null) {
                args = new Bundle();
            }
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_home_listados, container, false);
        }

        public void onAttach(Context context) {
            ActivityHomeLetrados.super.onAttach(context);
            ((ActivityHomeLetrados) context).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
}
