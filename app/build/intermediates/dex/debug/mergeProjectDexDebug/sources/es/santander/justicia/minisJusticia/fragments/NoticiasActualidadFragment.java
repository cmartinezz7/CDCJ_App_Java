package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityDetallesNoticia;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import java.util.ArrayList;

public class NoticiasActualidadFragment extends Fragment {
    private Activity activity;
    private ListView newsListView;

    public static NoticiasActualidadFragment getInstance(Bundle params) {
        return new NoticiasActualidadFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.activity = getActivity();
        new ArrayList();
        ArrayList<NoticiaActualidadDTO> news = NewsActivity.getNewsList();
        View rootview = inflater.inflate(R.layout.fragment_tab_noticias_actual, container, false);
        this.newsListView = (ListView) rootview.findViewById(R.id.news_list);
        this.newsListView.setAdapter(new AdaptadorListaNoticias(news, this.activity));
        this.newsListView.setEmptyView(rootview.findViewById(R.id.empty));
        this.newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoticiaActualidadDTO newsDetail = (NoticiaActualidadDTO) parent.getItemAtPosition(position);
                new Bundle().putParcelable("noticia", newsDetail);
                Intent intent = new Intent(NoticiasActualidadFragment.this.getActivity(), ActivityDetallesNoticia.class);
                intent.putExtra("noticia", newsDetail);
                NoticiasActualidadFragment.this.startActivity(intent);
            }
        });
        return rootview;
    }
}
