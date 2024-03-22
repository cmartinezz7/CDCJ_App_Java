package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.PlaceholderFragment;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.fragments.FragmentAbstractListados.1;
import es.santander.justicia.minisJusticia.fragments.FragmentAbstractListados.2;
import es.santander.justicia.minisJusticia.fragments.FragmentAbstractListados.3;
import java.util.ArrayList;

public abstract class FragmentAbstractListados<T> extends PlaceholderFragment {
   protected RecyclerView mRecycler;
   protected SwipeRefreshLayout mSwipeConainer;
   protected ArrayList<T> mItems;
   protected FloatingActionButton mFabSearch;
   protected Button mButtonNew;
   protected RelativeLayout relativeNoResults;
   private Button mButtonNewSearch;

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate(2131558575, container, false);
      this.mFabSearch = (FloatingActionButton)rootView.findViewById(2131362172);
      this.mButtonNew = (Button)rootView.findViewById(2131361972);
      this.relativeNoResults = (RelativeLayout)rootView.findViewById(2131362367);
      this.mButtonNewSearch = (Button)rootView.findViewById(2131361975);
      this.mRecycler = (RecyclerView)rootView.findViewById(2131362622);
      this.mRecycler.setHasFixedSize(false);
      this.mRecycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
      this.mRecycler.addItemDecoration(new 1(this));
      this.initUi(rootView);
      this.mButtonNewSearch.setOnClickListener(new 2(this));
      return rootView;
   }

   protected abstract void initUi(View var1);

   protected void handleResultsVisibility() {
      if (this.mItems != null && !this.mItems.isEmpty()) {
         this.mRecycler.setVisibility(0);
         this.relativeNoResults.setVisibility(8);
         this.mFabSearch.setVisibility(0);
      } else {
         this.mRecycler.setVisibility(8);
         this.relativeNoResults.setVisibility(0);
         this.mFabSearch.setVisibility(8);
         TealiumHelper.trackView("/sin_expediente");
      }

   }

   private void setPullToRefresh() {
      this.mSwipeConainer.setOnRefreshListener(new 3(this));
      this.mSwipeConainer.setColorSchemeResources(new int[]{2131099876, 2131099876, 2131099876, 2131099876});
   }
}
