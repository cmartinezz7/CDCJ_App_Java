package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.UserDetailDTO;
import es.santander.justicia.minisJusticia.interfaces.UserDetailCallBack;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.AnimationUtil;
import es.santander.justicia.utils.CommonUtils;

public class ActivityHelp extends MainActivity implements View.OnClickListener, UserDetailCallBack {
    private String Facebook;
    private String Twiter;
    private AnimationUtil animationUtil;
    private RelativeLayout appsSubItems;
    private String callingActivity;
    private ImageView ic_fb_banca_privada;
    private ImageView ic_fb_empresas;
    private ImageView ic_fb_select;
    private ImageView ic_fb_superlinea;
    private ImageView ic_tw_banca_privada;
    private ImageView ic_tw_empresas;
    private ImageView ic_tw_select;
    private ImageView ic_tw_superlinea;
    private ImageView img_banca_privada;
    private ImageView img_empresas;
    private ImageView img_select;
    private ImageView img_superlinea;
    private LinearLayout lnrBancaPrivada;
    private LinearLayout lnrBancaPrivadaExpandable;
    private LinearLayout lnrEmpresas;
    private LinearLayout lnrEmpresasExpandable;
    private LinearLayout lnrSelect;
    private LinearLayout lnrSelectExpandable;
    private RelativeLayout lnrSuperlinea;
    private LinearLayout lnrSuperlineaExpandable;
    private Activity mActivity;
    private ImageView rowAppsRecommend;
    private TextView tvUserName;
    private TextView txt_bp1;
    private TextView txt_bp2;
    private TextView txt_bp_tarjeta1;
    private TextView txt_bp_tarjeta2;
    private TextView txt_empresas1;
    private TextView txt_empresas2;
    private TextView txt_empresas_tarjeta1;
    private TextView txt_empresas_tarjeta2;
    private TextView txt_select1;
    private TextView txt_select2;
    private TextView txt_select_tarjeta1;
    private TextView txt_select_tarjeta2;
    private TextView txt_superlinea1;
    private TextView txt_superlinea2;
    private TextView txt_superlinea_tarjeta1;
    private TextView txt_superlinea_tarjeta2;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener} */
    /* JADX WARNING: type inference failed for: r1v133, types: [android.app.Activity] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r21) {
        /*
            r20 = this;
            r6 = r20
            super.onCreate(r21)
            java.lang.String r0 = "/ayuda"
            r6.setTealiumName(r0)
            r7 = 1
            r6.setRequestedOrientation(r7)
            r0 = 2131558603(0x7f0d00cb, float:1.8742526E38)
            r6.setContentView(r0)
            r0 = 2131361913(0x7f0a0079, float:1.8343592E38)
            r6.setNavigationId(r0)
            r6.mActivity = r6
            android.content.Intent r0 = r20.getIntent()
            android.os.Bundle r8 = r0.getExtras()
            java.lang.String r0 = "flag_ayuda"
            boolean r0 = r8.getBoolean(r0)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = "callingActivity"
            java.lang.String r0 = r8.getString(r0)
            r6.callingActivity = r0
            r0 = 2131361967(0x7f0a00af, float:1.8343701E38)
            android.view.View r0 = r6.findViewById(r0)
            r10 = r0
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            r0 = 2131362170(0x7f0a017a, float:1.8344113E38)
            android.view.View r0 = r6.findViewById(r0)
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 2131362529(0x7f0a02e1, float:1.8344841E38)
            android.view.View r0 = r6.findViewById(r0)
            r12 = r0
            com.google.android.material.navigation.NavigationView r12 = (com.google.android.material.navigation.NavigationView) r12
            boolean r0 = r9.booleanValue()
            r13 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            java.lang.String r1 = "Datos de contacto"
            r14 = 8
            r5 = 0
            if (r0 == 0) goto L_0x006d
            r11.setText(r1)
            r10.setVisibility(r5)
            r12.setVisibility(r14)
            r15 = r5
            goto L_0x00dd
        L_0x006d:
            r11.setText(r1)
            r12.setVisibility(r5)
            r10.setVisibility(r14)
            r0 = 2131362965(0x7f0a0495, float:1.8345725E38)
            android.view.View r0 = r6.findViewById(r0)
            r16 = r0
            androidx.appcompat.widget.Toolbar r16 = (androidx.appcompat.widget.Toolbar) r16
            r0 = 2131362106(0x7f0a013a, float:1.8343983E38)
            android.view.View r0 = r6.findViewById(r0)
            r4 = r0
            androidx.drawerlayout.widget.DrawerLayout r4 = (androidx.drawerlayout.widget.DrawerLayout) r4
            androidx.appcompat.app.ActionBarDrawerToggle r17 = new androidx.appcompat.app.ActionBarDrawerToggle
            r18 = 2131886647(0x7f120237, float:1.9407879E38)
            r19 = 2131886646(0x7f120236, float:1.9407877E38)
            r0 = r17
            r1 = r20
            r2 = r4
            r3 = r16
            r14 = r4
            r4 = r18
            r15 = r5
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            r14.addDrawerListener(r0)
            r0.syncState()
            r12.setNavigationItemSelectedListener(r6)
            android.view.View r1 = r6.findViewById(r13)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.setVisibility(r15)
            r12.bringToFront()
            android.view.Menu r1 = r12.getMenu()
            r2 = 5
            android.view.MenuItem r1 = r1.getItem(r2)
            r1.setChecked(r7)
            android.view.Menu r1 = r12.getMenu()
            r2 = 4
            android.view.MenuItem r1 = r1.getItem(r2)
            android.graphics.drawable.Drawable r1 = r1.getIcon()
            r2 = 2131100891(0x7f0604db, float:1.7814176E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r6, r2)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            r1.setColorFilter(r2, r3)
        L_0x00dd:
            es.santander.justicia.minisJusticia.ActivityHelp$1 r0 = new es.santander.justicia.minisJusticia.ActivityHelp$1
            r0.<init>()
            r10.setOnClickListener(r0)
            java.lang.String r0 = ""
            es.santander.justicia.minisJusticia.login.manager.LoginManager r1 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            if (r1 == 0) goto L_0x0111
            es.santander.justicia.minisJusticia.login.manager.LoginManager r1 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r1 = r1.getNombreUsuario()
            if (r1 == 0) goto L_0x0111
            es.santander.justicia.minisJusticia.login.manager.LoginManager r1 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r1 = r1.getNombreUsuario()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0108
            java.lang.String r1 = ""
            goto L_0x0110
        L_0x0108:
            es.santander.justicia.minisJusticia.login.manager.LoginManager r1 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            java.lang.String r1 = r1.getNombreUsuario()
        L_0x0110:
            r0 = r1
        L_0x0111:
            android.view.View r1 = r12.getHeaderView(r15)
            r2 = 2131363086(0x7f0a050e, float:1.834597E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.tvUserName = r1
            if (r1 == 0) goto L_0x0129
            java.lang.String r2 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r0)
            r1.setText(r2)
        L_0x0129:
            es.santander.justicia.minisJusticia.models.KeyValueModel r1 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()
            java.lang.String r2 = "aInfo."
            java.lang.String r3 = "facebookURL"
            java.lang.String r1 = r1.getValue(r2, r3)
            r6.Facebook = r1
            es.santander.justicia.minisJusticia.models.KeyValueModel r1 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()
            java.lang.String r3 = "twitterURL"
            java.lang.String r1 = r1.getValue(r2, r3)
            r6.Twiter = r1
            r1 = 2131362262(0x7f0a01d6, float:1.83443E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_fb_superlinea = r1
            r1 = 2131362261(0x7f0a01d5, float:1.8344298E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_fb_select = r1
            r1 = 2131362259(0x7f0a01d3, float:1.8344294E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_fb_banca_privada = r1
            r1 = 2131362260(0x7f0a01d4, float:1.8344296E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_fb_empresas = r1
            r1 = 2131362272(0x7f0a01e0, float:1.834432E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_tw_superlinea = r1
            r1 = 2131362271(0x7f0a01df, float:1.8344318E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_tw_select = r1
            r1 = 2131362269(0x7f0a01dd, float:1.8344314E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_tw_banca_privada = r1
            r1 = 2131362270(0x7f0a01de, float:1.8344316E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.ic_tw_empresas = r1
            r1 = 2131362437(0x7f0a0285, float:1.8344655E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrSuperlineaExpandable = r1
            r1 = 2131362435(0x7f0a0283, float:1.834465E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrSelectExpandable = r1
            r1 = 2131362431(0x7f0a027f, float:1.8344642E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrBancaPrivadaExpandable = r1
            r1 = 2131362433(0x7f0a0281, float:1.8344646E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrEmpresasExpandable = r1
            r1 = 2131362436(0x7f0a0284, float:1.8344653E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r6.lnrSuperlinea = r1
            r1 = 2131362434(0x7f0a0282, float:1.8344648E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrSelect = r1
            r1 = 2131362432(0x7f0a0280, float:1.8344644E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrEmpresas = r1
            r1 = 2131362430(0x7f0a027e, float:1.834464E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r6.lnrBancaPrivada = r1
            r1 = 2131362268(0x7f0a01dc, float:1.8344312E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.img_superlinea = r1
            r1 = 2131362267(0x7f0a01db, float:1.834431E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.img_select = r1
            r1 = 2131362258(0x7f0a01d2, float:1.8344292E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.img_empresas = r1
            r1 = 2131362257(0x7f0a01d1, float:1.834429E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r6.img_banca_privada = r1
            android.widget.ImageView r1 = r6.img_superlinea
            r2 = 2131231018(0x7f08012a, float:1.8078105E38)
            r1.setImageResource(r2)
            android.widget.ImageView r1 = r6.img_select
            r1.setImageResource(r2)
            android.widget.ImageView r1 = r6.img_empresas
            r1.setImageResource(r2)
            android.widget.ImageView r1 = r6.img_banca_privada
            r1.setImageResource(r2)
            r1 = 2131363104(0x7f0a0520, float:1.8346007E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_superlinea1 = r1
            r1 = 2131363105(0x7f0a0521, float:1.834601E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_superlinea2 = r1
            r1 = 2131363106(0x7f0a0522, float:1.8346011E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_superlinea_tarjeta1 = r1
            r1 = 2131363107(0x7f0a0523, float:1.8346013E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_superlinea_tarjeta2 = r1
            r1 = 2131363098(0x7f0a051a, float:1.8345995E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_select1 = r1
            r1 = 2131363099(0x7f0a051b, float:1.8345997E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_select2 = r1
            r1 = 2131363100(0x7f0a051c, float:1.8346E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_select_tarjeta1 = r1
            r1 = 2131363101(0x7f0a051d, float:1.8346001E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_select_tarjeta2 = r1
            r1 = 2131363094(0x7f0a0516, float:1.8345987E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_empresas1 = r1
            r1 = 2131363095(0x7f0a0517, float:1.834599E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_empresas2 = r1
            r1 = 2131363096(0x7f0a0518, float:1.8345991E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_empresas_tarjeta1 = r1
            r1 = 2131363097(0x7f0a0519, float:1.8345993E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_empresas_tarjeta2 = r1
            r1 = 2131363089(0x7f0a0511, float:1.8345977E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_bp1 = r1
            r1 = 2131363090(0x7f0a0512, float:1.834598E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_bp2 = r1
            r1 = 2131363091(0x7f0a0513, float:1.8345981E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_bp_tarjeta1 = r1
            r1 = 2131363092(0x7f0a0514, float:1.8345983E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.txt_bp_tarjeta2 = r1
            r1 = 2131362999(0x7f0a04b7, float:1.8345794E38)
            android.view.View r1 = r6.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 2131362439(0x7f0a0287, float:1.8344659E38)
            android.view.View r2 = r6.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            es.santander.justicia.minisJusticia.login.manager.LoginManager r3 = es.santander.justicia.minisJusticia.login.manager.LoginManager.getInstance()
            es.santander.justicia.minisJusticia.common.dto.UserDTO r3 = r3.getUser()
            if (r3 != 0) goto L_0x0306
            r2.setVisibility(r15)
            goto L_0x030b
        L_0x0306:
            r3 = 8
            r2.setVisibility(r3)
        L_0x030b:
            es.santander.justicia.minisJusticia.ActivityHelp$2 r3 = new es.santander.justicia.minisJusticia.ActivityHelp$2
            r3.<init>()
            r1.setOnClickListener(r3)
            java.lang.String r3 = "superlinea1"
            java.lang.String r4 = "superlinea2"
            java.lang.String r5 = "tarjeta1"
            java.lang.String r14 = "tarjeta2"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r14}
            r4 = 4
            android.widget.TextView[] r5 = new android.widget.TextView[r4]
            android.widget.TextView r4 = r6.txt_superlinea1
            r5[r15] = r4
            android.widget.TextView r4 = r6.txt_superlinea2
            r5[r7] = r4
            android.widget.TextView r4 = r6.txt_superlinea_tarjeta1
            r14 = 2
            r5[r14] = r4
            android.widget.TextView r4 = r6.txt_superlinea_tarjeta2
            r16 = 3
            r5[r16] = r4
            r4 = r5
            java.lang.String r5 = "supernet"
            r6.getData(r5, r3, r4)
            r5 = 4
            android.widget.TextView[] r13 = new android.widget.TextView[r5]
            android.widget.TextView r5 = r6.txt_select1
            r13[r15] = r5
            android.widget.TextView r5 = r6.txt_select2
            r13[r7] = r5
            android.widget.TextView r5 = r6.txt_select_tarjeta1
            r13[r14] = r5
            android.widget.TextView r5 = r6.txt_select_tarjeta2
            r13[r16] = r5
            r5 = r13
            java.lang.String r13 = "select"
            r6.getData(r13, r3, r5)
            r13 = 4
            android.widget.TextView[] r14 = new android.widget.TextView[r13]
            android.widget.TextView r13 = r6.txt_empresas1
            r14[r15] = r13
            android.widget.TextView r13 = r6.txt_empresas2
            r14[r7] = r13
            android.widget.TextView r13 = r6.txt_empresas_tarjeta1
            r19 = 2
            r14[r19] = r13
            android.widget.TextView r13 = r6.txt_empresas_tarjeta2
            r14[r16] = r13
            r13 = r14
            java.lang.String r14 = "retail"
            r6.getData(r14, r3, r13)
            r14 = 4
            android.widget.TextView[] r14 = new android.widget.TextView[r14]
            android.widget.TextView r7 = r6.txt_bp1
            r14[r15] = r7
            android.widget.TextView r7 = r6.txt_bp2
            r15 = 1
            r14[r15] = r7
            android.widget.TextView r7 = r6.txt_bp_tarjeta1
            r15 = 2
            r14[r15] = r7
            android.widget.TextView r7 = r6.txt_bp_tarjeta2
            r14[r16] = r7
            r7 = r14
            java.lang.String r14 = "pb"
            r6.getData(r14, r3, r7)
            es.santander.justicia.utils.AnimationUtil r14 = new es.santander.justicia.utils.AnimationUtil
            r14.<init>()
            r6.animationUtil = r14
            android.widget.RelativeLayout r14 = r6.lnrSuperlinea
            r14.setOnClickListener(r6)
            android.widget.LinearLayout r14 = r6.lnrSelect
            r14.setOnClickListener(r6)
            android.widget.LinearLayout r14 = r6.lnrEmpresas
            r14.setOnClickListener(r6)
            android.widget.LinearLayout r14 = r6.lnrBancaPrivada
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_fb_superlinea
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_fb_superlinea
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_fb_banca_privada
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_fb_empresas
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_tw_superlinea
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_tw_superlinea
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_tw_banca_privada
            r14.setOnClickListener(r6)
            android.widget.ImageView r14 = r6.ic_tw_empresas
            r14.setOnClickListener(r6)
            r14 = 2131362033(0x7f0a00f1, float:1.8343835E38)
            android.view.View r14 = r6.findViewById(r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            es.santander.justicia.minisJusticia.ActivityHelp$3 r15 = new es.santander.justicia.minisJusticia.ActivityHelp$3
            r15.<init>()
            r14.setOnClickListener(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityHelp.onCreate(android.os.Bundle):void");
    }

    private void getData(String type, String[] names, TextView[] textViews) {
        int i = 0;
        int length = names.length;
        for (int i2 = 0; i2 < length; i2++) {
            String value = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, type + "." + names[i2]);
            if (CommonUtils.isNotNullNotBlack(value)) {
                textViews[i].setText(value);
            }
            i++;
        }
    }

    private void getIntent(String url) {
        TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
        Intent i = new Intent("android.intent.action.VIEW");
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ic_fb_banca_privada:
                TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                getIntent(this.Facebook);
                return;
            case R.id.ic_fb_empresas:
                TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                getIntent(this.Facebook);
                return;
            case R.id.ic_fb_select:
                TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                getIntent(this.Facebook);
                return;
            case R.id.ic_fb_superlinea:
                TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                getIntent(this.Facebook);
                return;
            default:
                switch (id) {
                    case R.id.ic_tw_banca_privada:
                        TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                        getIntent(this.Twiter);
                        return;
                    case R.id.ic_tw_empresas:
                        TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                        getIntent(this.Twiter);
                        return;
                    case R.id.ic_tw_select:
                        TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                        getIntent(this.Twiter);
                        return;
                    case R.id.ic_tw_superlinea:
                        TealiumHelper.trackEvent("/ayuda", "ayuda (redes sociales)");
                        getIntent(this.Twiter);
                        return;
                    default:
                        switch (id) {
                            case R.id.lnrBancaPrivada:
                                if (this.lnrBancaPrivadaExpandable.getVisibility() == 8) {
                                    AnimationUtil.verticalExpand(this.lnrBancaPrivadaExpandable);
                                    this.img_banca_privada.setImageResource(R.drawable.ic_arrow_up_blue);
                                    return;
                                }
                                AnimationUtil.verticalCollapse(this.lnrBancaPrivadaExpandable);
                                this.img_banca_privada.setImageResource(R.drawable.ic_arrow_down_blue);
                                return;
                            case R.id.lnrEmpresas:
                                if (this.lnrEmpresasExpandable.getVisibility() == 8) {
                                    AnimationUtil.verticalExpand(this.lnrEmpresasExpandable);
                                    this.img_empresas.setImageResource(R.drawable.ic_arrow_up_blue);
                                    return;
                                }
                                AnimationUtil.verticalCollapse(this.lnrEmpresasExpandable);
                                this.img_empresas.setImageResource(R.drawable.ic_arrow_down_blue);
                                return;
                            case R.id.lnrSelect:
                                if (this.lnrSelectExpandable.getVisibility() == 8) {
                                    AnimationUtil.verticalExpand(this.lnrSelectExpandable);
                                    this.img_select.setImageResource(R.drawable.ic_arrow_up_blue);
                                    return;
                                }
                                AnimationUtil.verticalCollapse(this.lnrSelectExpandable);
                                this.img_select.setImageResource(R.drawable.ic_arrow_down_blue);
                                return;
                            case R.id.lnrSuperlinea:
                                if (this.lnrSuperlineaExpandable.getVisibility() == 8) {
                                    AnimationUtil.verticalExpand(this.lnrSuperlineaExpandable);
                                    this.img_superlinea.setImageResource(R.drawable.ic_arrow_up_blue);
                                    return;
                                }
                                AnimationUtil.verticalCollapse(this.lnrSuperlineaExpandable);
                                this.img_superlinea.setImageResource(R.drawable.ic_arrow_down_blue);
                                return;
                            default:
                                return;
                        }
                }
        }
    }

    public void onFinishUserDetailData(UserDetailDTO userDetailDTO, boolean success) {
        String username = "";
        if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
        }
        this.tvUserName.setText(CommonUtils.wordCapitalize(username));
    }
}
