package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.ViewPagerDetalleMovimientoAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;

public class DetalleMovimientoActivity extends MainActivity {
    /* access modifiers changed from: private */
    public ImageView bullet1;
    /* access modifiers changed from: private */
    public ImageView bullet2;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public int currentPage = -1;
    private MovementItemDTO movementItemDTO;
    private TextView txtExpediente;
    private TextView txtMandamiento;
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_movimiento);
        this.context = getBaseContext();
        setTealiumName("/detalle_movimiento");
        initUi();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        int i;
        super.onResume();
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && (i = this.currentPage) != 1) {
            viewPager2.setCurrentItem(i);
        }
    }

    private void initUi() {
        Bundle extra = getIntent().getExtras();
        this.movementItemDTO = (MovementItemDTO) extra.getSerializable("movimiento");
        String nroExpediente = extra.getString("expediente");
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText("Detalle movimientos");
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetalleMovimientoActivity.this.finish();
            }
        });
        this.txtExpediente = (TextView) findViewById(R.id.txt_movimiento_expediente);
        this.txtMandamiento = (TextView) findViewById(R.id.txt_movimiento_mandamiento);
        this.txtExpediente.setText(CommonUtils.getProceedingFormatted(nroExpediente));
        this.txtMandamiento.setText(this.movementItemDTO.getSerieYMandamiento());
        this.bullet1 = (ImageView) findViewById(R.id.iv_bullet1);
        this.bullet2 = (ImageView) findViewById(R.id.iv_bullet2);
        this.bullet1.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bullet_active_white));
        this.bullet2.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bullet_inactive_white));
        setPager();
        if (extra.getString(Constants.MOTIVE_ANULATION) != null) {
            showMotive(extra.getString(Constants.MOTIVE_ANULATION));
        }
    }

    private void setPager() {
        ViewPager findViewById = findViewById(R.id.container_viewpager_detalle);
        this.viewPager = findViewById;
        findViewById.setAdapter(new ViewPagerDetalleMovimientoAdapter(getSupportFragmentManager(), this.movementItemDTO));
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (position == 0) {
                    DetalleMovimientoActivity.this.bullet1.setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.this.context, R.drawable.ic_bullet_active_white));
                    DetalleMovimientoActivity.this.bullet2.setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.this.context, R.drawable.ic_bullet_inactive_white));
                    int unused = DetalleMovimientoActivity.this.currentPage = 0;
                } else if (position == 1) {
                    DetalleMovimientoActivity.this.bullet1.setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.this.context, R.drawable.ic_bullet_inactive_white));
                    DetalleMovimientoActivity.this.bullet2.setImageDrawable(ContextCompat.getDrawable(DetalleMovimientoActivity.this.context, R.drawable.ic_bullet_active_white));
                    int unused2 = DetalleMovimientoActivity.this.currentPage = 1;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void showMotive(String motive) {
        findViewById(R.id.linearMotive).setVisibility(0);
        ((TextView) findViewById(R.id.textMotive)).setText(motive);
        findViewById(R.id.buttonAuthorize).setVisibility(0);
    }
}
