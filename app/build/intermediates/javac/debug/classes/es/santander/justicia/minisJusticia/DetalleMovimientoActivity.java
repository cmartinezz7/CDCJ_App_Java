package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.minisJusticia.DetalleMovimientoActivity.1;
import es.santander.justicia.minisJusticia.DetalleMovimientoActivity.2;
import es.santander.justicia.minisJusticia.adapters.ViewPagerDetalleMovimientoAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.utils.CommonUtils;

public class DetalleMovimientoActivity extends MainActivity {
   private ViewPager viewPager;
   private ImageView bullet1;
   private ImageView bullet2;
   private int currentPage = -1;
   private Context context;
   private MovementItemDTO movementItemDTO;
   private TextView txtExpediente;
   private TextView txtMandamiento;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558555);
      this.context = this.getBaseContext();
      this.setTealiumName("/detalle_movimiento");
      this.initUi();
   }

   protected void onResume() {
      super.onResume();
      if (this.viewPager != null && this.currentPage != 1) {
         this.viewPager.setCurrentItem(this.currentPage);
      }

   }

   private void initUi() {
      Bundle extra = this.getIntent().getExtras();
      this.movementItemDTO = (MovementItemDTO)extra.getSerializable("movimiento");
      String nroExpediente = extra.getString("expediente");
      TextView juzgados = (TextView)this.findViewById(2131363082);
      juzgados.setText("Detalle movimientos");
      ImageButton button = (ImageButton)this.findViewById(2131361967);
      button.setOnClickListener(new 1(this));
      this.txtExpediente = (TextView)this.findViewById(2131363128);
      this.txtMandamiento = (TextView)this.findViewById(2131363129);
      this.txtExpediente.setText(CommonUtils.getProceedingFormatted(nroExpediente));
      this.txtMandamiento.setText(this.movementItemDTO.getSerieYMandamiento());
      this.bullet1 = (ImageView)this.findViewById(2131362338);
      this.bullet2 = (ImageView)this.findViewById(2131362339);
      this.bullet1.setImageDrawable(ContextCompat.getDrawable(this.context, 2131231046));
      this.bullet2.setImageDrawable(ContextCompat.getDrawable(this.context, 2131231047));
      this.setPager();
      if (extra.getString("motiveAnulation") != null) {
         this.showMotive(extra.getString("motiveAnulation"));
      }

   }

   private void setPager() {
      this.viewPager = (ViewPager)this.findViewById(2131362043);
      this.viewPager.setAdapter(new ViewPagerDetalleMovimientoAdapter(this.getSupportFragmentManager(), this.movementItemDTO));
      this.viewPager.setOnPageChangeListener(new 2(this));
   }

   private void showMotive(String motive) {
      this.findViewById(2131362400).setVisibility(0);
      ((TextView)this.findViewById(2131362808)).setText(motive);
      this.findViewById(2131361966).setVisibility(0);
   }

   // $FF: synthetic method
   static Context access$000(DetalleMovimientoActivity x0) {
      return x0.context;
   }

   // $FF: synthetic method
   static ImageView access$100(DetalleMovimientoActivity x0) {
      return x0.bullet1;
   }

   // $FF: synthetic method
   static ImageView access$200(DetalleMovimientoActivity x0) {
      return x0.bullet2;
   }

   // $FF: synthetic method
   static int access$302(DetalleMovimientoActivity x0, int x1) {
      return x0.currentPage = x1;
   }
}
