package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.utils.Constants;

public class ActivityDetallesNoticia extends MainActivity {
    private Context context;
    private NoticiaActualidadDTO newsDetail;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        this.context = getBaseContext();
        Bundle extras = getIntent().getExtras();
        setTealiumName("/noticia_detalle");
        if (extras != null) {
            this.newsDetail = (NoticiaActualidadDTO) extras.getParcelable("noticia");
        }
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText("Noticias");
        ((TextView) findViewById(R.id.tvActivityTitle)).setTypeface(Typeface.createFromAsset(getAssets(), Constants.FIRASANS_MEDIUM));
        TextView tvTitle = (TextView) findViewById(2131362988);
        tvTitle.setText(this.newsDetail.getTituloNoticia());
        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(), Constants.FIRASANS_MEDIUM));
        TextView tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvDescription.setText(this.newsDetail.getDescription());
        tvDescription.setTypeface(Typeface.createFromAsset(getAssets(), Constants.FIRASANS_REGULAR));
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityDetallesNoticia.this.finish();
            }
        });
        Button keepReading = (Button) findViewById(R.id.buttonKeepReading);
        keepReading.setTypeface(Typeface.createFromAsset(getAssets(), Constants.FIRASANS_MEDIUM));
        keepReading.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ActivityDetallesNoticia.this.lambda$onCreate$0$ActivityDetallesNoticia(view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ActivityDetallesNoticia(View v) {
        TealiumHelper.trackEvent("/noticia_detalle", "noticia_detalle(externo)");
        String url = this.newsDetail.getLink();
        if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        Intent toEnc = new Intent("android.intent.action.VIEW");
        toEnc.setData(Uri.parse(url));
        startActivity(toEnc);
        finish();
    }
}
