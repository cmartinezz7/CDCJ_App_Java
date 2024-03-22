package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.ActivityHelp.1;
import es.santander.justicia.minisJusticia.ActivityHelp.2;
import es.santander.justicia.minisJusticia.ActivityHelp.3;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.UserDetailDTO;
import es.santander.justicia.minisJusticia.interfaces.UserDetailCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.AnimationUtil;
import es.santander.justicia.utils.CommonUtils;

public class ActivityHelp extends MainActivity implements OnClickListener, UserDetailCallBack {
   private Activity mActivity;
   private LinearLayout lnrEmpresasExpandable;
   private LinearLayout lnrSelectExpandable;
   private LinearLayout lnrBancaPrivadaExpandable;
   private LinearLayout lnrSuperlineaExpandable;
   private LinearLayout lnrSelect;
   private LinearLayout lnrBancaPrivada;
   private LinearLayout lnrEmpresas;
   private RelativeLayout lnrSuperlinea;
   private RelativeLayout appsSubItems;
   private AnimationUtil animationUtil;
   private ImageView img_superlinea;
   private ImageView img_select;
   private ImageView img_banca_privada;
   private ImageView img_empresas;
   private ImageView rowAppsRecommend;
   private TextView txt_superlinea1;
   private TextView txt_superlinea2;
   private TextView txt_superlinea_tarjeta1;
   private TextView txt_superlinea_tarjeta2;
   private TextView txt_select1;
   private TextView txt_select2;
   private TextView txt_select_tarjeta1;
   private TextView txt_select_tarjeta2;
   private TextView txt_bp1;
   private TextView txt_bp2;
   private TextView txt_bp_tarjeta1;
   private TextView txt_bp_tarjeta2;
   private TextView txt_empresas1;
   private TextView txt_empresas2;
   private TextView txt_empresas_tarjeta1;
   private TextView txt_empresas_tarjeta2;
   private TextView tvUserName;
   private String Twiter;
   private String Facebook;
   private String callingActivity;
   private ImageView ic_tw_superlinea;
   private ImageView ic_tw_select;
   private ImageView ic_tw_banca_privada;
   private ImageView ic_tw_empresas;
   private ImageView ic_fb_superlinea;
   private ImageView ic_fb_select;
   private ImageView ic_fb_banca_privada;
   private ImageView ic_fb_empresas;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setTealiumName("/ayuda");
      this.setRequestedOrientation(1);
      this.setContentView(2131558603);
      this.setNavigationId(2131361913);
      this.mActivity = this;
      Bundle bundle = this.getIntent().getExtras();
      Boolean flag = bundle.getBoolean("flag_ayuda");
      this.callingActivity = bundle.getString("callingActivity");
      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      TextView tv_title = (TextView)this.findViewById(2131362170);
      NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
      if (flag) {
         tv_title.setText("Datos de contacto");
         btnBack.setVisibility(0);
         navigationView.setVisibility(8);
      } else {
         tv_title.setText("Datos de contacto");
         navigationView.setVisibility(0);
         btnBack.setVisibility(8);
         Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
         DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
         drawer.addDrawerListener(toggle);
         toggle.syncState();
         navigationView.setNavigationItemSelectedListener(this);
         ((LinearLayout)this.findViewById(2131362033)).setVisibility(0);
         navigationView.bringToFront();
         navigationView.getMenu().getItem(5).setChecked(true);
         navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, 2131100891), Mode.SRC_IN);
      }

      btnBack.setOnClickListener(new 1(this));
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
      if (this.tvUserName != null) {
         this.tvUserName.setText(CommonUtils.wordCapitalize(username));
      }

      this.Facebook = KeyValueModel.getInstance().getValue("aInfo.", "facebookURL");
      this.Twiter = KeyValueModel.getInstance().getValue("aInfo.", "twitterURL");
      this.ic_fb_superlinea = (ImageView)this.findViewById(2131362262);
      this.ic_fb_select = (ImageView)this.findViewById(2131362261);
      this.ic_fb_banca_privada = (ImageView)this.findViewById(2131362259);
      this.ic_fb_empresas = (ImageView)this.findViewById(2131362260);
      this.ic_tw_superlinea = (ImageView)this.findViewById(2131362272);
      this.ic_tw_select = (ImageView)this.findViewById(2131362271);
      this.ic_tw_banca_privada = (ImageView)this.findViewById(2131362269);
      this.ic_tw_empresas = (ImageView)this.findViewById(2131362270);
      this.lnrSuperlineaExpandable = (LinearLayout)this.findViewById(2131362437);
      this.lnrSelectExpandable = (LinearLayout)this.findViewById(2131362435);
      this.lnrBancaPrivadaExpandable = (LinearLayout)this.findViewById(2131362431);
      this.lnrEmpresasExpandable = (LinearLayout)this.findViewById(2131362433);
      this.lnrSuperlinea = (RelativeLayout)this.findViewById(2131362436);
      this.lnrSelect = (LinearLayout)this.findViewById(2131362434);
      this.lnrEmpresas = (LinearLayout)this.findViewById(2131362432);
      this.lnrBancaPrivada = (LinearLayout)this.findViewById(2131362430);
      this.img_superlinea = (ImageView)this.findViewById(2131362268);
      this.img_select = (ImageView)this.findViewById(2131362267);
      this.img_empresas = (ImageView)this.findViewById(2131362258);
      this.img_banca_privada = (ImageView)this.findViewById(2131362257);
      this.img_superlinea.setImageResource(2131231018);
      this.img_select.setImageResource(2131231018);
      this.img_empresas.setImageResource(2131231018);
      this.img_banca_privada.setImageResource(2131231018);
      this.txt_superlinea1 = (TextView)this.findViewById(2131363104);
      this.txt_superlinea2 = (TextView)this.findViewById(2131363105);
      this.txt_superlinea_tarjeta1 = (TextView)this.findViewById(2131363106);
      this.txt_superlinea_tarjeta2 = (TextView)this.findViewById(2131363107);
      this.txt_select1 = (TextView)this.findViewById(2131363098);
      this.txt_select2 = (TextView)this.findViewById(2131363099);
      this.txt_select_tarjeta1 = (TextView)this.findViewById(2131363100);
      this.txt_select_tarjeta2 = (TextView)this.findViewById(2131363101);
      this.txt_empresas1 = (TextView)this.findViewById(2131363094);
      this.txt_empresas2 = (TextView)this.findViewById(2131363095);
      this.txt_empresas_tarjeta1 = (TextView)this.findViewById(2131363096);
      this.txt_empresas_tarjeta2 = (TextView)this.findViewById(2131363097);
      this.txt_bp1 = (TextView)this.findViewById(2131363089);
      this.txt_bp2 = (TextView)this.findViewById(2131363090);
      this.txt_bp_tarjeta1 = (TextView)this.findViewById(2131363091);
      this.txt_bp_tarjeta2 = (TextView)this.findViewById(2131363092);
      TextView tv_ant_aqui = (TextView)this.findViewById(2131362999);
      LinearLayout btn_aqui = (LinearLayout)this.findViewById(2131362439);
      if (LoginManager.getInstance().getUser() == null) {
         btn_aqui.setVisibility(0);
      } else {
         btn_aqui.setVisibility(8);
      }

      tv_ant_aqui.setOnClickListener(new 2(this));
      String[] names = new String[]{"superlinea1", "superlinea2", "tarjeta1", "tarjeta2"};
      TextView[] textViews1 = new TextView[]{this.txt_superlinea1, this.txt_superlinea2, this.txt_superlinea_tarjeta1, this.txt_superlinea_tarjeta2};
      this.getData("supernet", names, textViews1);
      TextView[] textViews2 = new TextView[]{this.txt_select1, this.txt_select2, this.txt_select_tarjeta1, this.txt_select_tarjeta2};
      this.getData("select", names, textViews2);
      TextView[] textViews3 = new TextView[]{this.txt_empresas1, this.txt_empresas2, this.txt_empresas_tarjeta1, this.txt_empresas_tarjeta2};
      this.getData("retail", names, textViews3);
      TextView[] textViews4 = new TextView[]{this.txt_bp1, this.txt_bp2, this.txt_bp_tarjeta1, this.txt_bp_tarjeta2};
      this.getData("pb", names, textViews4);
      this.animationUtil = new AnimationUtil();
      this.lnrSuperlinea.setOnClickListener(this);
      this.lnrSelect.setOnClickListener(this);
      this.lnrEmpresas.setOnClickListener(this);
      this.lnrBancaPrivada.setOnClickListener(this);
      this.ic_fb_superlinea.setOnClickListener(this);
      this.ic_fb_superlinea.setOnClickListener(this);
      this.ic_fb_banca_privada.setOnClickListener(this);
      this.ic_fb_empresas.setOnClickListener(this);
      this.ic_tw_superlinea.setOnClickListener(this);
      this.ic_tw_superlinea.setOnClickListener(this);
      this.ic_tw_banca_privada.setOnClickListener(this);
      this.ic_tw_empresas.setOnClickListener(this);
      LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
      closeLayout.setOnClickListener(new 3(this));
   }

   private void getData(String type, String[] names, TextView[] textViews) {
      int i = 0;
      String[] var5 = names;
      int var6 = names.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String name = var5[var7];
         String value = KeyValueModel.getInstance().getValue("aInfo.", type + "." + name);
         if (CommonUtils.isNotNullNotBlack(value)) {
            textViews[i].setText(value);
         }

         ++i;
      }

   }

   private void getIntent(String url) {
      TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
      Intent i = new Intent("android.intent.action.VIEW");
      i.setData(Uri.parse(url));
      this.startActivity(i);
   }

   public void onBackPressed() {
      super.onBackPressed();
   }

   public boolean onCreateOptionsMenu(Menu menu) {
      this.getMenuInflater().inflate(2131623941, menu);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();
      return super.onOptionsItemSelected(item);
   }

   public void onClick(View v) {
      AnimationUtil var10000;
      switch(v.getId()) {
      case 2131362259:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Facebook);
         break;
      case 2131362260:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Facebook);
         break;
      case 2131362261:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Facebook);
         break;
      case 2131362262:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Facebook);
         break;
      case 2131362269:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Twiter);
         break;
      case 2131362270:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Twiter);
         break;
      case 2131362271:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Twiter);
         break;
      case 2131362272:
         TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
         this.getIntent(this.Twiter);
         break;
      case 2131362430:
         if (this.lnrBancaPrivadaExpandable.getVisibility() == 8) {
            var10000 = this.animationUtil;
            AnimationUtil.verticalExpand(this.lnrBancaPrivadaExpandable);
            this.img_banca_privada.setImageResource(2131231025);
         } else {
            var10000 = this.animationUtil;
            AnimationUtil.verticalCollapse(this.lnrBancaPrivadaExpandable);
            this.img_banca_privada.setImageResource(2131231018);
         }
         break;
      case 2131362432:
         if (this.lnrEmpresasExpandable.getVisibility() == 8) {
            var10000 = this.animationUtil;
            AnimationUtil.verticalExpand(this.lnrEmpresasExpandable);
            this.img_empresas.setImageResource(2131231025);
         } else {
            var10000 = this.animationUtil;
            AnimationUtil.verticalCollapse(this.lnrEmpresasExpandable);
            this.img_empresas.setImageResource(2131231018);
         }
         break;
      case 2131362434:
         if (this.lnrSelectExpandable.getVisibility() == 8) {
            var10000 = this.animationUtil;
            AnimationUtil.verticalExpand(this.lnrSelectExpandable);
            this.img_select.setImageResource(2131231025);
         } else {
            var10000 = this.animationUtil;
            AnimationUtil.verticalCollapse(this.lnrSelectExpandable);
            this.img_select.setImageResource(2131231018);
         }
         break;
      case 2131362436:
         if (this.lnrSuperlineaExpandable.getVisibility() == 8) {
            var10000 = this.animationUtil;
            AnimationUtil.verticalExpand(this.lnrSuperlineaExpandable);
            this.img_superlinea.setImageResource(2131231025);
         } else {
            var10000 = this.animationUtil;
            AnimationUtil.verticalCollapse(this.lnrSuperlineaExpandable);
            this.img_superlinea.setImageResource(2131231018);
         }
      }

   }

   public void onFinishUserDetailData(UserDetailDTO userDetailDTO, boolean success) {
      String username = "";
      if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
         username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
      }

      this.tvUserName.setText(CommonUtils.wordCapitalize(username));
   }
}
