package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.minisJusticia.fragments.NoticiasActualidadFragment.1;
import java.util.ArrayList;

public class NoticiasActualidadFragment extends Fragment {
   private ListView newsListView;
   private Activity activity;

   public static NoticiasActualidadFragment getInstance(Bundle params) {
      return new NoticiasActualidadFragment();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      this.activity = this.getActivity();
      new ArrayList();
      ArrayList<NoticiaActualidadDTO> news = NewsActivity.getNewsList();
      View rootview = inflater.inflate(2131558580, container, false);
      this.newsListView = (ListView)rootview.findViewById(2131362539);
      AdaptadorListaNoticias adapter = new AdaptadorListaNoticias(news, this.activity);
      this.newsListView.setAdapter(adapter);
      this.newsListView.setEmptyView(rootview.findViewById(2131362127));
      this.newsListView.setOnItemClickListener(new 1(this));
      return rootview;
   }
}
