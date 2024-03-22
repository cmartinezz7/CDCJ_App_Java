package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdaptadorPagerPantallaBienvenida;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;

public class BienvenidaViewPagerActivity extends MainActivity {
    /* access modifiers changed from: private */
    public ImageView bullet1;
    /* access modifiers changed from: private */
    public ImageView bullet2;
    /* access modifiers changed from: private */
    public int currentPage = -1;
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/resumenApp");
        setContentView(R.layout.activity_bienvenida);
        getWindow().setFlags(1024, 1024);
        this.bullet1 = (ImageView) findViewById(R.id.iv_bullet1);
        this.bullet2 = (ImageView) findViewById(R.id.iv_bullet2);
        ViewPager findViewById = findViewById(R.id.container_viewpager);
        this.viewPager = findViewById;
        findViewById.setAdapter(new AdaptadorPagerPantallaBienvenida(getSupportFragmentManager()));
        this.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                if (position == 0) {
                    TealiumHelper.trackView("/resumenApp");
                    BienvenidaViewPagerActivity.this.bullet1.setImageDrawable(BienvenidaViewPagerActivity.this.getResources().getDrawable(R.drawable.ic_bullet_active_white));
                    BienvenidaViewPagerActivity.this.bullet2.setImageDrawable(BienvenidaViewPagerActivity.this.getResources().getDrawable(R.drawable.ic_bullet_inactive_white));
                    int unused = BienvenidaViewPagerActivity.this.currentPage = 0;
                } else if (position == 1) {
                    TealiumHelper.trackView("/bienvenida");
                    BienvenidaViewPagerActivity.this.bullet1.setImageDrawable(BienvenidaViewPagerActivity.this.getResources().getDrawable(R.drawable.ic_bullet_inactive_white));
                    BienvenidaViewPagerActivity.this.bullet2.setImageDrawable(BienvenidaViewPagerActivity.this.getResources().getDrawable(R.drawable.ic_bullet_active_white));
                    int unused2 = BienvenidaViewPagerActivity.this.currentPage = 1;
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
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
}
