package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.utils.Constants;

public class SentenciaFragment extends Fragment {
    private Activity activity;
    private View rootview;
    /* access modifiers changed from: private */
    public NoticiaActualidadDTO ssdNews;
    private TextView tvDescription;
    private TextView tvTitle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.activity = getActivity();
        this.rootview = inflater.inflate(R.layout.fragment_tab_sentencia, container, false);
        this.ssdNews = NewsActivity.getSenteciaDelDia();
        this.tvDescription = (TextView) this.rootview.findViewById(R.id.tvDescription);
        this.tvTitle = (TextView) this.rootview.findViewById(2131362988);
        NoticiaActualidadDTO noticiaActualidadDTO = this.ssdNews;
        if (noticiaActualidadDTO != null) {
            this.tvDescription.setText(Html.fromHtml(noticiaActualidadDTO.getDescription()).toString());
            this.tvTitle.setText(Html.fromHtml(this.ssdNews.getTituloNoticia()).toString());
            ((Button) this.rootview.findViewById(R.id.buttonKeepReading)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TealiumHelper.trackEvent("/sentencia_dia", "sentencia_dia(externo)");
                    String url = SentenciaFragment.this.ssdNews.getLink();
                    if (!url.startsWith("https://") && !url.startsWith("http://")) {
                        url = "http://" + url;
                    }
                    Intent toEnc = new Intent("android.intent.action.VIEW");
                    toEnc.setData(Uri.parse(url));
                    SentenciaFragment.this.startActivity(toEnc);
                }
            });
        }
        this.tvTitle.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), Constants.FIRASANS_MEDIUM));
        this.tvDescription.setTypeface(Typeface.createFromAsset(this.activity.getAssets(), Constants.FIRASANS_REGULAR));
        return this.rootview;
    }
}
