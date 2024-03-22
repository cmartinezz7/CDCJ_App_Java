package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.ActivityContratos.1;
import es.santander.justicia.minisJusticia.ActivityContratos.2;
import es.santander.justicia.minisJusticia.adapters.AdapterContratos;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginEntradaDetail;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail;
import es.santander.justicia.minisJusticia.tasks.MergeloginUnicoTask;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityContratos extends AppCompatActivity implements OnRecyclerClickListener, ActivityCallBack {
   private String usuarioRaf;
   private String auxToken;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558436);
      ((TextView)this.findViewById(2131362884)).setText(String.format(this.getString(2131886356), PreferencesHelper.newInstance(this).getString("preference_alias")));
      this.usuarioRaf = this.getIntent().getExtras().getString("extra_user_raf");
      if (this.usuarioRaf != null && !this.usuarioRaf.equals("")) {
         this.findViewById(2131362287).setVisibility(4);
         this.findViewById(2131362287).setClickable(false);
         ((RecyclerView)this.findViewById(2131362620)).setAdapter(new AdapterContratos(this, this.getIntent().getParcelableArrayListExtra("extra_contratcs_list")));
      } else {
         this.getContratosConexion();
      }

   }

   private void getContratosConexion() {
      ContratoEntradaDetail contratoEntradaDetail = new ContratoEntradaDetail();
      contratoEntradaDetail.setToken(this.getIntent().getStringExtra("extra_token_empresas"));
      contratoEntradaDetail.setIndApoderadoDelegado(PreferencesHelper.newInstance(this).getString("preference_apoderado"));
      contratoEntradaDetail.setIndListaRepos(this.getIntent().getStringExtra("extra_lista_reposicion"));
      contratoEntradaDetail.setAliasUsuConexion(PreferencesHelper.newInstance(this).getString("preference_alias"));
      ConnectionBuilder.getContratosConexion(contratoEntradaDetail, this).enqueue(new 1(this, this));
   }

   private void obtenerDatosLogin(ContratoDetail contratoDetail) {
      ConnectionBuilder.obtenerDatosLogin(new ObtenerDatosLoginEntradaDetail(contratoDetail.getAlias(), this.auxToken != null ? this.auxToken : PreferencesHelper.newInstance(this).getString("preference_token_login_unico"), this.usuarioRaf, ""), this).enqueue(new 2(this, this));
   }

   private void mergeLogin(String token) {
      PreferencesHelper.newInstance(this).setString("preference_token_login_unico", token);
      MergeloginUnicoTask mergeloginUnicoTask = new MergeloginUnicoTask(this, token);
      mergeloginUnicoTask.execute(new Object[0]);
   }

   public void onBackClick(View view) {
      this.onBackPressed();
   }

   public void onItemClickListener(int position) {
      this.obtenerDatosLogin((ContratoDetail)((AdapterContratos)((RecyclerView)this.findViewById(2131362620)).getAdapter()).getAllItems().get(position));
   }

   public void onTaskFinished(String taskID, Object result) {
      Log.d("asd", "asd");
      this.startActivity(new Intent(this, HomeActivity.class));
   }

   public boolean dispatchTouchEvent(MotionEvent ev) {
      if (!this.onFilterTouchEventForSecurity(ev)) {
         ViewGroup viewGroup = (ViewGroup)((ViewGroup)this.findViewById(16908290)).getChildAt(0);
         viewGroup.setFilterTouchesWhenObscured(true);
      }

      return super.dispatchTouchEvent(ev);
   }

   public boolean onFilterTouchEventForSecurity(MotionEvent event) {
      boolean touchEventDispatched = true;
      if ((event.getFlags() & 1) == 1 || (event.getFlags() & 2) == 2) {
         touchEventDispatched = false;
      }

      return touchEventDispatched;
   }

   // $FF: synthetic method
   static String access$002(ActivityContratos x0, String x1) {
      return x0.auxToken = x1;
   }

   // $FF: synthetic method
   static String access$102(ActivityContratos x0, String x1) {
      return x0.usuarioRaf = x1;
   }

   // $FF: synthetic method
   static void access$200(ActivityContratos x0, String x1) {
      x0.mergeLogin(x1);
   }
}
