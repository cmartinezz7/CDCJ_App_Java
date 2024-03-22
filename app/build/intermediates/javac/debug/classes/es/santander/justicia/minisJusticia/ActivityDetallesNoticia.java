package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.ActivityDetallesNoticia.1;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;

public class ActivityDetallesNoticia extends MainActivity {
   private NoticiaActualidadDTO newsDetail;
   private Context context;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558454);
      this.context = this.getBaseContext();
      Intent i = this.getIntent();
      Bundle extras = i.getExtras();
      this.setTealiumName("/noticia_detalle");
      if (extras != null) {
         this.newsDetail = (NoticiaActualidadDTO)extras.getParcelable("noticia");
      }

      TextView noticias = (TextView)this.findViewById(2131363082);
      ImageButton buttonBack = (ImageButton)this.findViewById(2131361967);
      noticias.setText("Noticias");
      TextView tvActivityTitle = (TextView)this.findViewById(2131362980);
      tvActivityTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "FiraSans-Medium.ttf"));
      TextView tvTitle = (TextView)this.findViewById(2131362988);
      tvTitle.setText(this.newsDetail.getTituloNoticia());
      tvTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "FiraSans-Medium.ttf"));
      TextView tvDescription = (TextView)this.findViewById(2131362981);
      tvDescription.setText(this.newsDetail.getDescription());
      tvDescription.setTypeface(Typeface.createFromAsset(this.getAssets(), "FiraSans-Regular.ttf"));
      buttonBack.setOnClickListener(new 1(this));
      Button keepReading = (Button)this.findViewById(2131361971);
      keepReading.setTypeface(Typeface.createFromAsset(this.getAssets(), "FiraSans-Medium.ttf"));
      keepReading.setOnClickListener((v) -> {
         TealiumHelper.trackEvent("/noticia_detalle", "noticia_detalle(externo)");
         String url = this.newsDetail.getLink();
         if (!url.startsWith("https://") && !url.startsWith("http://")) {
            url = "http://" + url;
         }

         Intent toEnc = new Intent("android.intent.action.VIEW");
         toEnc.setData(Uri.parse(url));
         this.startActivity(toEnc);
         this.finish();
      });
   }
}
