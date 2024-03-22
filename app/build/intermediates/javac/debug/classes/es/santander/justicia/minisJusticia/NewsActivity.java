package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener;
import com.squareup.picasso.Picasso;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.minisJusticia.NewsActivity.1;
import es.santander.justicia.minisJusticia.NewsActivity.2;
import es.santander.justicia.minisJusticia.NewsActivity.3;
import es.santander.justicia.minisJusticia.NewsActivity.4;
import es.santander.justicia.minisJusticia.NewsActivity.5;
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
import es.santander.justicia.utils.PreferencesHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewsActivity extends MainActivity implements OnClickListener {
   private Context context;
   private Activity activity;
   private static ArrayList<NoticiaActualidadDTO> newsList;
   private static ArrayList<EnciclopediaParentItemDTO> encyclopediaGroupList;
   private static ArrayList<EnciclopediaItemDTO> encyclopediaItemsList;
   private static NoticiaActualidadDTO senteciaDelDia;
   private ProgressDialog dialog;
   private TabLayout tabLayout;
   private RelativeLayout appsSubItems;
   private ImageView rowAppsRecommend;
   private RelativeLayout envRowMenu;
   private RelativeLayout envSubItems;
   private ImageView envArrow;
   private TextView appVersion;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558453);
      TealiumHelper.trackView("/noticia_actual");
      HttpClientSettings settings = new HttpClientSettings();
      this.context = this.getBaseContext();
      this.activity = this;
      URL url = null;

      try {
         url = new URL(MainApplication.getInfo("0ZoS6CmDmUgyX5ZO3fQVTeea46YyotCNzmL7BTxeFVAu9OjbgLItlPUfEApykFJj52XHJt6/kndq51frnpo1cXTvSJy1hS9sHvjhAN3KhhM="));
      } catch (MalformedURLException var13) {
         Log.e("NewsActivity", MainApplication.getInfo("0ZoS6CmDmUgyX5ZO3fQVTeea46YyotCNzmL7BTxeFVAu9OjbgLItlPUfEApykFJj52XHJt6/kndq51frnpo1cXTvSJy1hS9sHvjhAN3KhhM=") + " - IOException", var13);
      }

      settings.setUrl(url);
      settings.setRequestType("GET");
      senteciaDelDia = LoginManager.getInstance().getSsdNews();
      newsList = LoginManager.getInstance().getNewsList();
      Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
      this.setSupportActionBar(toolbar);
      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
      drawer.addDrawerListener(toggle);
      toggle.syncState();
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      navigationView.setNavigationItemSelectedListener(this);
      this.appVersion = (TextView)this.findViewById(2131363108);
      this.appVersion.setText(String.format("V%s", "2.0"));
      this.tabLayout = (TabLayout)this.findViewById(2131362775);
      this.tabLayout.addTab(this.tabLayout.newTab().setText("NOTICIAS \nACTUALIDAD"));
      this.tabLayout.addTab(this.tabLayout.newTab().setText("SENTENCIA \nDEL DÍA"));
      this.tabLayout.addTab(this.tabLayout.newTab().setText("ENCICLOPEDIA \nCIVIL"));
      this.tabLayout.setTabGravity(0);
      this.changeTabsFont();
      RelativeLayout appsRecomendadas = (RelativeLayout)navigationView.findViewById(2131362205);
      this.appsSubItems = (RelativeLayout)navigationView.findViewById(2131362767);
      this.rowAppsRecommend = (ImageView)navigationView.findViewById(2131362274);
      appsRecomendadas.setOnClickListener(this);
      this.envRowMenu = (RelativeLayout)navigationView.findViewById(2131362134);
      this.envSubItems = (RelativeLayout)navigationView.findViewById(2131362135);
      this.envArrow = (ImageView)navigationView.findViewById(2131362136);
      if ("debug".contains("release")) {
         this.envRowMenu.setVisibility(8);
         this.envSubItems.setVisibility(8);
      } else {
         this.setEnviromentsAspect(MainApplication.getAppContext().getEnvironment());
      }

      ViewPager viewPager = (ViewPager)this.findViewById(2131362560);
      NoticiasPagerAdapter adapter = new NoticiasPagerAdapter(this.getSupportFragmentManager(), this.tabLayout.getTabCount());
      viewPager.setAdapter(adapter);
      viewPager.setOffscreenPageLimit(2);
      viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(this.tabLayout));
      viewPager.addOnPageChangeListener(new 1(this));
      Button enterLogin = (Button)this.findViewById(2131361970);
      this.tabLayout.setOnTabSelectedListener(new 2(this, viewPager, enterLogin));
      Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Medium.ttf");
      enterLogin.setTypeface(tf);
      enterLogin.setOnClickListener(new 3(this));
   }

   public boolean onCreateOptionsMenu(Menu menu) {
      this.getMenuInflater().inflate(2131623941, menu);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();
      return id == 2131361874 ? true : super.onOptionsItemSelected(item);
   }

   public static void setSenteciaDelDia(NoticiaActualidadDTO senteciaDelDia) {
      NewsActivity.senteciaDelDia = senteciaDelDia;
   }

   public static NoticiaActualidadDTO getSenteciaDelDia() {
      return senteciaDelDia;
   }

   public void setNewsList(ArrayList<NoticiaActualidadDTO> newsList) {
      NewsActivity.newsList = newsList;
   }

   public static ArrayList<NoticiaActualidadDTO> getNewsList() {
      return newsList;
   }

   public static ArrayList<EnciclopediaItemDTO> getEncyclopediaItemsList() {
      return encyclopediaItemsList;
   }

   public static void setEncyclopediaItemsList(ArrayList<EnciclopediaItemDTO> encyclopediaItemsList) {
      NewsActivity.encyclopediaItemsList = encyclopediaItemsList;
   }

   public static ArrayList<EnciclopediaParentItemDTO> getEncyclopediaGroupList() {
      return encyclopediaGroupList;
   }

   public static void setEncyclopediaGroupList(ArrayList<EnciclopediaParentItemDTO> encyclopediaGroupList) {
      NewsActivity.encyclopediaGroupList = encyclopediaGroupList;
   }

   public void startProgressDialog() {
      this.progressDialog = ProgressDialog.show(this, "Cargando Enciclopedia", "Espere por favor");
   }

   public void stopProgressDialog() {
      this.progressDialog.dismiss();
   }

   public static void expand(View v) {
      v.measure(-1, -2);
      int targetHeight = v.getMeasuredHeight();
      v.getLayoutParams().height = 1;
      v.setVisibility(0);
      Animation a = new 4(v, targetHeight);
      a.setDuration((long)((int)((float)targetHeight / v.getContext().getResources().getDisplayMetrics().density)));
      v.startAnimation(a);
   }

   public static void collapse(View v) {
      int initialHeight = v.getMeasuredHeight();
      Animation a = new 5(v, initialHeight);
      a.setDuration((long)((int)((float)initialHeight / v.getContext().getResources().getDisplayMetrics().density)));
      v.startAnimation(a);
   }

   private void changeTabsFont() {
      Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Regular.ttf");
      ViewGroup vg = (ViewGroup)this.tabLayout.getChildAt(0);
      int tabsCount = vg.getChildCount();

      for(int j = 0; j < tabsCount; ++j) {
         ViewGroup vgTab = (ViewGroup)vg.getChildAt(j);
         int tabChildsCount = vgTab.getChildCount();

         for(int i = 0; i < tabChildsCount; ++i) {
            View tabViewChild = vgTab.getChildAt(i);
            if (tabViewChild instanceof TextView) {
               ((TextView)tabViewChild).setTypeface(tf);
               ((TextView)tabViewChild).setTextColor(this.getResources().getColor(2131100979));
            }
         }
      }

   }

   public void onClick(View v) {
      switch(v.getId()) {
      case 2131362134:
         if (this.envSubItems.getVisibility() == 8) {
            Picasso.get().load(2131231027).into(this.envArrow);
            expand(this.envSubItems);
         } else {
            Picasso.get().load(2131231020).into(this.envArrow);
            collapse(this.envSubItems);
         }
         break;
      case 2131362178:
         Intent intent = null;
         String pls = KeyValueModel.getInstancePermanent().getValue("pls");
         if (pls != null && "P".equals(pls)) {
            intent = new Intent(this, ActivityHelp.class);
         } else {
            intent = new Intent(this, ActivityHelpLetrados.class);
         }

         Bundle bundle = new Bundle();
         bundle.putBoolean("flag_ayuda", true);
         intent.putExtras(bundle);
         intent.putExtra("callingActivity", "NewsActivity");
         this.startActivity(intent);
         break;
      case 2131362205:
         if (this.appsSubItems.getVisibility() == 8) {
            Picasso.get().load(2131231027).into(this.rowAppsRecommend);
            expand(this.appsSubItems);
         } else {
            Picasso.get().load(2131231020).into(this.rowAppsRecommend);
            collapse(this.appsSubItems);
         }
         break;
      case 2131362643:
         TealiumHelper.trackEvent("/menu/apps_recomendadas/censo_letrados", "censo_letrados");

         try {
            this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo("1MEhWjmlX0M0SNjfePQGqejhi1DO3cIu5KHXWVq8r/cX2X5DSLw+H1N94gBEmrjH"))));
         } catch (ActivityNotFoundException var5) {
            Log.e("NewsActivity", "ActivityNotFoundException", var5);
            this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo("1MEhWjmlX0M0SNjfePQGqejhi1DO3cIu5KHXWVq8r/cX2X5DSLw+H1N94gBEmrjH"))));
         }
         break;
      case 2131362644:
         this.changeEnviroment("CERT");
         break;
      case 2131362647:
         this.changeEnviroment("MOCK");
         break;
      case 2131362649:
         this.changeEnviroment("PRE");
         break;
      case 2131362651:
         this.changeEnviroment("PROD");
      }

   }

   public void changeEnviroment(String enviroment) {
      this.setEnviromentsAspect(enviroment);
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      preferencesHelper.setString("documentType", "");
      preferencesHelper.setString("documentNumber", "");
      preferencesHelper.setString("code", "");
      preferencesHelper.setString("authenticationTypeCode", "");
      preferencesHelper.setBoolean("companyMode", false);
      preferencesHelper.setBoolean("rememberMe", false);
      KeyValueModel.getInstancePermanent().insertValue("pls", "", "");
      PreferencesHelper.newInstance(this).clear();
      PreferencesHelper.newInstance(this).setString("preference_environment", enviroment);
      MainApplication.getAppContext().setEnvironment(enviroment);
      Intent intent = new Intent(this, SplashActivity.class);
      intent.addFlags(67108864);
      this.startActivity(intent);
   }

   private void setEnviromentsAspect(String enviroment) {
      TextView row_cert_text = (TextView)this.findViewById(2131362645);
      TextView row_pre_text = (TextView)this.findViewById(2131362650);
      TextView row_ocu_text = (TextView)this.findViewById(2131362648);
      TextView row_pro_text = (TextView)this.findViewById(2131362652);
      row_cert_text.setTextColor(this.getColor(2131100004));
      row_pre_text.setTextColor(this.getColor(2131100004));
      row_ocu_text.setTextColor(this.getColor(2131100004));
      row_pro_text.setTextColor(this.getColor(2131100004));
      byte var7 = -1;
      switch(enviroment.hashCode()) {
      case 79491:
         if (enviroment.equals("PRE")) {
            var7 = 1;
         }
         break;
      case 2064932:
         if (enviroment.equals("CERT")) {
            var7 = 0;
         }
         break;
      case 2371978:
         if (enviroment.equals("MOCK")) {
            var7 = 2;
         }
      }

      switch(var7) {
      case 0:
         row_cert_text.setTextColor(ResourcesCompat.getColor(this.getResources(), 2131099837, (Theme)null));
         break;
      case 1:
         row_pre_text.setTextColor(ResourcesCompat.getColor(this.getResources(), 2131099837, (Theme)null));
         break;
      case 2:
         row_ocu_text.setTextColor(ResourcesCompat.getColor(this.getResources(), 2131099837, (Theme)null));
         break;
      default:
         row_pro_text.setTextColor(ResourcesCompat.getColor(this.getResources(), 2131099837, (Theme)null));
      }

   }
}
