package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.1;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.2;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.3;
import es.santander.justicia.minisJusticia.adapters.ViewPagerDetalleMovimientoAdapter;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.requests.resolverAutorizacion.AutorizacionRetrocesionDto;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityDetalleMovimiento extends ActivityAbstractLetrados implements DialogSolicitudCalback, PopUpActionDone {
   private ViewPager viewPager;
   private ImageView bullet1;
   private ImageView bullet2;
   private int currentPage = -1;
   private Context context;
   private MovementItemDTO movementItemDTO;
   private TextView txtExpediente;
   private TextView txtMandamiento;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558440);
      this.context = this.getBaseContext();
      this.getMovement();
   }

   private void showMovementInfo(String nroExpediente, String anulationMotive) {
      this.txtExpediente = (TextView)this.findViewById(2131363128);
      this.txtMandamiento = (TextView)this.findViewById(2131363129);
      this.txtExpediente.setText(CommonUtils.getProceedingFormatted(nroExpediente));
      this.txtMandamiento.setText(this.movementItemDTO.getSerieYMandamiento());
      this.bullet1 = (ImageView)this.findViewById(2131362338);
      this.bullet2 = (ImageView)this.findViewById(2131362339);
      this.bullet1.setImageDrawable(ContextCompat.getDrawable(this.context, 2131231046));
      this.bullet2.setImageDrawable(ContextCompat.getDrawable(this.context, 2131231047));
      this.viewPager = (ViewPager)this.findViewById(2131362043);
      this.viewPager.setAdapter(new ViewPagerDetalleMovimientoAdapter(this.getSupportFragmentManager(), this.movementItemDTO));
      this.viewPager.setOnPageChangeListener(new 1(this));
   }

   private void getMovement() {
      Bundle extra = this.getIntent().getExtras();
      if (extra != null) {
         if (extra.containsKey("movimiento")) {
            this.movementItemDTO = (MovementItemDTO)extra.getSerializable("movimiento");
            this.showMovementInfo(extra.getString("expediente"), (String)null);
         } else {
            ((TextView)this.findViewById(2131362816)).setText(this.getString(2131886146));
            this.getMovementFromServer(extra.getString("extra_operacion"), extra.getString("extra_organismo"));
         }
      }

   }

   protected void onResume() {
      super.onResume();
      if (this.viewPager != null && this.currentPage != 1) {
         this.viewPager.setCurrentItem(this.currentPage);
      }

   }

   protected void onStart() {
      super.onStart();
      TealiumHelper.trackView("/detalle_movimiento");
   }

   public void acceptOrDeny(boolean accept) {
      CommonUtils.showOperativaPopUp(this, this.findViewById(16908290), this, true, accept ? 2131886108 : 2131886375, 0);
   }

   public void onOperativaClicked(String motive, String pass, int textResource, int position) {
      switch(textResource) {
      case 2131886108:
         this.resolverAutorizacion(new AutorizacionRetrocesionDto(this.getIntent().getExtras().getString("extra_operacion"), this.getIntent().getExtras().getString("extra_organismo"), "T", motive), pass);
         break;
      case 2131886375:
         this.resolverAutorizacion(new AutorizacionRetrocesionDto(this.getIntent().getExtras().getString("extra_operacion"), this.getIntent().getExtras().getString("extra_organismo"), "R", motive), pass);
      }

   }

   public void onPopUpClosed() {
      this.onBackPressed();
   }

   private void getMovementFromServer(String numOper, String juzga) {
      ConnectionBuilder.getDetalleMovimientoCall(numOper, PreferencesHelper.newInstance(this).getString("preference_cod_uo")).enqueue(new 2(this, this, juzga));
   }

   private void resolverAutorizacion(AutorizacionRetrocesionDto autorizacionRetrocesionDto, String firma) {
      TealiumHelper.trackEvent("/autorizacion_retrocesion", "autorizacion retrocesion(firmar)");
      ConnectionBuilder.getResolverAutorizacon(autorizacionRetrocesionDto, firma).enqueue(new 3(this, this));
   }

   // $FF: synthetic method
   static Context access$000(ActivityDetalleMovimiento x0) {
      return x0.context;
   }

   // $FF: synthetic method
   static ImageView access$100(ActivityDetalleMovimiento x0) {
      return x0.bullet1;
   }

   // $FF: synthetic method
   static ImageView access$200(ActivityDetalleMovimiento x0) {
      return x0.bullet2;
   }

   // $FF: synthetic method
   static int access$302(ActivityDetalleMovimiento x0, int x1) {
      return x0.currentPage = x1;
   }

   // $FF: synthetic method
   static MovementItemDTO access$402(ActivityDetalleMovimiento x0, MovementItemDTO x1) {
      return x0.movementItemDTO = x1;
   }

   // $FF: synthetic method
   static void access$500(ActivityDetalleMovimiento x0, String x1, String x2) {
      x0.showMovementInfo(x1, x2);
   }
}
