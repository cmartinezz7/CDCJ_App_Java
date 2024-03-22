package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.R;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.minisJusticia.adapters.NoticiasPagerAdapter;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.activity.SplashActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.EnciclopediaItemDTO;
import es.santander.justicia.minisJusticia.dto.EnciclopediaParentItemDTO;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsActivity extends MainActivity implements View.OnClickListener {
    private static ArrayList<EnciclopediaParentItemDTO> encyclopediaGroupList;
    private static ArrayList<EnciclopediaItemDTO> encyclopediaItemsList;
    private static ArrayList<NoticiaActualidadDTO> newsList;
    private static NoticiaActualidadDTO senteciaDelDia;
    private Activity activity;
    private TextView appVersion;
    private RelativeLayout appsSubItems;
    private Context context;
    private ProgressDialog dialog;
    private ImageView envArrow;
    private RelativeLayout envRowMenu;
    private RelativeLayout envSubItems;
    private ImageView rowAppsRecommend;
    private TabLayout tabLayout;

    /* JADX WARNING: type inference failed for: r12v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener, android.view.View$OnClickListener, es.santander.justicia.minisJusticia.NewsActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        TealiumHelper.trackView("/noticia_actual");
        HttpClientSettings settings = new HttpClientSettings();
        this.context = getBaseContext();
        this.activity = this;
        URL url = null;
        try {
            url = new URL(MainApplication.getInfo(MainApplication.URL_BANNERe));
        } catch (MalformedURLException e) {
            Log.e("NewsActivity", MainApplication.getInfo(MainApplication.URL_BANNERe) + " - IOException", e);
        }
        settings.setUrl(url);
        settings.setRequestType("GET");
        senteciaDelDia = LoginManager.getInstance().getSsdNews();
        newsList = LoginManager.getInstance().getNewsList();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(2131362529);
        navigationView.setNavigationItemSelectedListener(this);
        TextView textView = (TextView) findViewById(R.id.txtVersion);
        this.appVersion = textView;
        textView.setText(String.format("V%s", new Object[]{BuildConfig.VERSION_NAME}));
        TabLayout findViewById = findViewById(R.id.tab_layout);
        this.tabLayout = findViewById;
        findViewById.addTab(findViewById.newTab().setText("NOTICIAS \nACTUALIDAD"));
        TabLayout tabLayout2 = this.tabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText("SENTENCIA \nDEL DÍA"));
        TabLayout tabLayout3 = this.tabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText("ENCICLOPEDIA \nCIVIL"));
        this.tabLayout.setTabGravity(0);
        changeTabsFont();
        this.appsSubItems = (RelativeLayout) navigationView.findViewById(R.id.subItems);
        this.rowAppsRecommend = (ImageView) navigationView.findViewById(R.id.icon_arrow);
        ((RelativeLayout) navigationView.findViewById(R.id.fourthRowmenu)).setOnClickListener(this);
        this.envRowMenu = (RelativeLayout) navigationView.findViewById(R.id.envRowmenu);
        this.envSubItems = (RelativeLayout) navigationView.findViewById(R.id.envSubItems);
        this.envArrow = (ImageView) navigationView.findViewById(R.id.env_icon_arrow);
        if (BuildConfig.BUILD_TYPE.contains("release")) {
            this.envRowMenu.setVisibility(8);
            this.envSubItems.setVisibility(8);
        } else {
            setEnviromentsAspect(MainApplication.getAppContext().getEnvironment());
        }
        final ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new NoticiasPagerAdapter(getSupportFragmentManager(), this.tabLayout.getTabCount()));
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                Log.i("TAG", "position: " + position);
                if (position == 0) {
                    TealiumHelper.trackView("/noticia_actual");
                } else if (position == 1) {
                    TealiumHelper.trackView("/sentencia_dia");
                } else if (position == 2) {
                    TealiumHelper.trackView("/enciclopedia_civil");
                }
            }
        });
        final Button enterLogin = (Button) findViewById(R.id.buttonEnter);
        this.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() != 1) {
                    enterLogin.setVisibility(0);
                } else {
                    enterLogin.setVisibility(8);
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        enterLogin.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), Constants.FIRASANS_MEDIUM));
        enterLogin.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
            /* JADX WARNING: type inference failed for: r3v1, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
            /* JADX WARNING: type inference failed for: r3v2, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
            public void onClick(View v) {
                Intent intent;
                String pls = KeyValueModel.getInstancePermanent().getValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION);
                if (pls != null && ActivityDetalleOperacion.CODIGO_ESTADO_P.equals(pls)) {
                    ? r3 = NewsActivity.this;
                    intent = new Intent(r3, CommonUtils.getLoginProfesionalesClass(r3));
                } else if (pls == null || !"L".equals(pls)) {
                    intent = new Intent(NewsActivity.this, BienvenidaViewPagerActivity.class);
                } else {
                    intent = new Intent(NewsActivity.this, ActivityLoginLetrados.class);
                }
                NewsActivity.this.startActivity(intent);
                NewsActivity.this.finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 2131361874) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setSenteciaDelDia(NoticiaActualidadDTO senteciaDelDia2) {
        senteciaDelDia = senteciaDelDia2;
    }

    public static NoticiaActualidadDTO getSenteciaDelDia() {
        return senteciaDelDia;
    }

    public void setNewsList(ArrayList<NoticiaActualidadDTO> newsList2) {
        newsList = newsList2;
    }

    public static ArrayList<NoticiaActualidadDTO> getNewsList() {
        return newsList;
    }

    public static ArrayList<EnciclopediaItemDTO> getEncyclopediaItemsList() {
        return encyclopediaItemsList;
    }

    public static void setEncyclopediaItemsList(ArrayList<EnciclopediaItemDTO> encyclopediaItemsList2) {
        encyclopediaItemsList = encyclopediaItemsList2;
    }

    public static ArrayList<EnciclopediaParentItemDTO> getEncyclopediaGroupList() {
        return encyclopediaGroupList;
    }

    public static void setEncyclopediaGroupList(ArrayList<EnciclopediaParentItemDTO> encyclopediaGroupList2) {
        encyclopediaGroupList = encyclopediaGroupList2;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
    public void startProgressDialog() {
        this.progressDialog = ProgressDialog.show(this, "Cargando Enciclopedia", "Espere por favor");
    }

    public void stopProgressDialog() {
        this.progressDialog.dismiss();
    }

    public static void expand(final View v) {
        v.measure(-1, -2);
        final int targetHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 1;
        v.setVisibility(0);
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                int i;
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                if (interpolatedTime == 1.0f) {
                    i = -2;
                } else {
                    i = (int) (((float) targetHeight) * interpolatedTime);
                }
                layoutParams.height = i;
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) targetHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1.0f) {
                    v.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int i = initialHeight;
                layoutParams.height = i - ((int) (((float) i) * interpolatedTime));
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) initialHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    private void changeTabsFont() {
        Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), Constants.FIRASANS_REGULAR);
        ViewGroup vg = (ViewGroup) this.tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tf);
                    ((TextView) tabViewChild).setTextColor(getResources().getColor(2131100979));
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.envRowmenu:
                if (this.envSubItems.getVisibility() == 8) {
                    Picasso.get().load(R.drawable.ic_arrow_up_grey).into(this.envArrow);
                    expand(this.envSubItems);
                    return;
                }
                Picasso.get().load(R.drawable.ic_arrow_down_grey).into(this.envArrow);
                collapse(this.envSubItems);
                return;
            case R.id.fifthRowmenu:
                String pls = KeyValueModel.getInstancePermanent().getValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION);
                if (pls == null || !ActivityDetalleOperacion.CODIGO_ESTADO_P.equals(pls)) {
                    intent = new Intent(this, ActivityHelpLetrados.class);
                } else {
                    intent = new Intent(this, ActivityHelp.class);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("flag_ayuda", true);
                intent.putExtras(bundle);
                intent.putExtra("callingActivity", "NewsActivity");
                startActivity(intent);
                return;
            case R.id.fourthRowmenu:
                if (this.appsSubItems.getVisibility() == 8) {
                    Picasso.get().load(R.drawable.ic_arrow_up_grey).into(this.rowAppsRecommend);
                    expand(this.appsSubItems);
                    return;
                }
                Picasso.get().load(R.drawable.ic_arrow_down_grey).into(this.rowAppsRecommend);
                collapse(this.appsSubItems);
                return;
            case R.id.row_censo_letrados:
                TealiumHelper.trackEvent("/menu/apps_recomendadas/censo_letrados", "censo_letrados");
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_LETRADOSe))));
                    return;
                } catch (ActivityNotFoundException anfe) {
                    Log.e("NewsActivity", "ActivityNotFoundException", anfe);
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_LETRADOSe))));
                    return;
                }
            case R.id.row_cert:
                changeEnviroment(MainApplication.ENV_CERT);
                return;
            case R.id.row_ocu:
                changeEnviroment(MainApplication.ENV_MOCK);
                return;
            case R.id.row_pre:
                changeEnviroment(MainApplication.ENV_PRE);
                return;
            case R.id.row_pro:
                changeEnviroment(MainApplication.ENV_PROD);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.NewsActivity] */
    public void changeEnviroment(String enviroment) {
        setEnviromentsAspect(enviroment);
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
        preferencesHelper.setString(Constants.KEY_DOCUMENT_TYPE, "");
        preferencesHelper.setString(Constants.KEY_DOCUMENT_NUMBER, "");
        preferencesHelper.setString("code", "");
        preferencesHelper.setString(Constants.KEY_AUTHENTICATION_TYPE_CODE, "");
        preferencesHelper.setBoolean(Constants.KEY_COMPANY_MODE, false);
        preferencesHelper.setBoolean(Constants.KEY_CHECKBOX_REMEMBER_ME, false);
        KeyValueModel.getInstancePermanent().insertValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION, "", "");
        PreferencesHelper.newInstance(this).clear();
        PreferencesHelper.newInstance(this).setString(Constants.PREFERENCE_ENVIRONMENT, enviroment);
        MainApplication.getAppContext().setEnvironment(enviroment);
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setEnviromentsAspect(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 2131362645(0x7f0a0355, float:1.8345076E38)
            android.view.View r0 = r9.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131362650(0x7f0a035a, float:1.8345087E38)
            android.view.View r1 = r9.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 2131362648(0x7f0a0358, float:1.8345083E38)
            android.view.View r2 = r9.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131362652(0x7f0a035c, float:1.834509E38)
            android.view.View r3 = r9.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131100004(0x7f060164, float:1.7812377E38)
            int r5 = r9.getColor(r4)
            r0.setTextColor(r5)
            int r5 = r9.getColor(r4)
            r1.setTextColor(r5)
            int r5 = r9.getColor(r4)
            r2.setTextColor(r5)
            int r4 = r9.getColor(r4)
            r3.setTextColor(r4)
            int r4 = r10.hashCode()
            r5 = 79491(0x13683, float:1.1139E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L_0x006d
            r5 = 2064932(0x1f8224, float:2.893586E-39)
            if (r4 == r5) goto L_0x0063
            r5 = 2371978(0x24318a, float:3.323849E-39)
            if (r4 == r5) goto L_0x0059
        L_0x0058:
            goto L_0x0077
        L_0x0059:
            java.lang.String r4 = "MOCK"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0058
            r4 = r6
            goto L_0x0078
        L_0x0063:
            java.lang.String r4 = "CERT"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0058
            r4 = 0
            goto L_0x0078
        L_0x006d:
            java.lang.String r4 = "PRE"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x0058
            r4 = r7
            goto L_0x0078
        L_0x0077:
            r4 = -1
        L_0x0078:
            r5 = 0
            r8 = 2131099837(0x7f0600bd, float:1.7812038E38)
            if (r4 == 0) goto L_0x00a6
            if (r4 == r7) goto L_0x009a
            if (r4 == r6) goto L_0x008e
            android.content.res.Resources r4 = r9.getResources()
            int r4 = androidx.core.content.res.ResourcesCompat.getColor(r4, r8, r5)
            r3.setTextColor(r4)
            goto L_0x00b2
        L_0x008e:
            android.content.res.Resources r4 = r9.getResources()
            int r4 = androidx.core.content.res.ResourcesCompat.getColor(r4, r8, r5)
            r2.setTextColor(r4)
            goto L_0x00b2
        L_0x009a:
            android.content.res.Resources r4 = r9.getResources()
            int r4 = androidx.core.content.res.ResourcesCompat.getColor(r4, r8, r5)
            r1.setTextColor(r4)
            goto L_0x00b2
        L_0x00a6:
            android.content.res.Resources r4 = r9.getResources()
            int r4 = androidx.core.content.res.ResourcesCompat.getColor(r4, r8, r5)
            r0.setTextColor(r4)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.NewsActivity.setEnviromentsAspect(java.lang.String):void");
    }
}
