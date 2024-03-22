package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;

public class BusquedaMovimientosVaciaDesdeBuscador extends MainActivity {
    private Context context;
    private Button nuevaBusqueda;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busqueda_movimientos_vacia);
        this.context = getBaseContext();
        this.nuevaBusqueda = (Button) findViewById(R.id.btnNuevaBusqueda);
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText("Lista de Movimientos");
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.BusquedaMovimientosVaciaDesdeBuscador, android.content.Context] */
            public void onClick(View v) {
                BusquedaMovimientosVaciaDesdeBuscador.this.finish();
                BusquedaMovimientosVaciaDesdeBuscador.this.startActivity(new Intent(BusquedaMovimientosVaciaDesdeBuscador.this, MovementsSearchActivity.class));
            }
        });
        this.nuevaBusqueda.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.BusquedaMovimientosVaciaDesdeBuscador, android.content.Context] */
            public void onClick(View v) {
                BusquedaMovimientosVaciaDesdeBuscador.this.finish();
                BusquedaMovimientosVaciaDesdeBuscador.this.startActivity(new Intent(BusquedaMovimientosVaciaDesdeBuscador.this, MovementsSearchActivity.class));
            }
        });
    }
}
