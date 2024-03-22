package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.BusquedaMovimientosVacia.1;
import es.santander.justicia.minisJusticia.BusquedaMovimientosVacia.2;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;

public class BusquedaMovimientosVacia extends MainActivity {
   private Context context;
   private Button nuevaBusqueda;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558491);
      this.context = this.getBaseContext();
      this.nuevaBusqueda = (Button)this.findViewById(2131361949);
      TextView toolbarTitle = (TextView)this.findViewById(2131363082);
      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      toolbarTitle.setText(this.getString(2131886597));
      btnBack.setOnClickListener(new 1(this));
      this.nuevaBusqueda.setOnClickListener(new 2(this));
   }
}
