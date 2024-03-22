package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.minisJusticia.fragments.SentenciaFragment.1;

public class SentenciaFragment extends Fragment {
   private TextView tvDescription;
   private TextView tvTitle;
   private View rootview;
   private Activity activity;
   private NoticiaActualidadDTO ssdNews;

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      this.activity = this.getActivity();
      this.rootview = inflater.inflate(2131558581, container, false);
      this.ssdNews = NewsActivity.getSenteciaDelDia();
      this.tvDescription = (TextView)this.rootview.findViewById(2131362981);
      this.tvTitle = (TextView)this.rootview.findViewById(2131362988);
      if (this.ssdNews != null) {
         this.tvDescription.setText(Html.fromHtml(this.ssdNews.getDescription()).toString());
         this.tvTitle.setText(Html.fromHtml(this.ssdNews.getTituloNoticia()).toString());
         Button keepReading = (Button)this.rootview.findViewById(2131361971);
         keepReading.setOnClickListener(new 1(this));
      }

      Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Medium.ttf");
      this.tvTitle.setTypeface(tf);
      tf = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Regular.ttf");
      this.tvDescription.setTypeface(tf);
      return this.rootview;
   }

   // $FF: synthetic method
   static NoticiaActualidadDTO access$000(SentenciaFragment x0) {
      return x0.ssdNews;
   }
}
