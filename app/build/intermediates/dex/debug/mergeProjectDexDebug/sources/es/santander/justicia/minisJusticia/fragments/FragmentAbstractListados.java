package es.santander.justicia.minisJusticia.fragments;

import android.graphics.Rect;
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
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import java.util.ArrayList;

public abstract class FragmentAbstractListados<T> extends ActivityHomeLetrados.PlaceholderFragment {
    protected Button mButtonNew;
    private Button mButtonNewSearch;
    protected FloatingActionButton mFabSearch;
    protected ArrayList<T> mItems;
    protected RecyclerView mRecycler;
    protected SwipeRefreshLayout mSwipeConainer;
    protected RelativeLayout relativeNoResults;

    /* access modifiers changed from: protected */
    public abstract void initUi(View view);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_listados, container, false);
        this.mFabSearch = rootView.findViewById(R.id.fab_button);
        this.mButtonNew = (Button) rootView.findViewById(R.id.buttonNew);
        this.relativeNoResults = (RelativeLayout) rootView.findViewById(R.id.layout_no_result);
        this.mButtonNewSearch = (Button) rootView.findViewById(R.id.button_nueva_busqueda);
        RecyclerView findViewById = rootView.findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(false);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecycler.addItemDecoration(new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                FragmentAbstractListados.super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 0, 0, (FragmentAbstractListados.this.mFabSearch.getVisibility() == 0 && state.getItemCount() + -1 == parent.getChildAdapterPosition(view)) ? FragmentAbstractListados.this.mFabSearch.getHeight() + 50 : 0);
            }
        });
        initUi(rootView);
        this.mButtonNewSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentAbstractListados.this.mFabSearch.performClick();
            }
        });
        return rootView;
    }

    /* access modifiers changed from: protected */
    public void handleResultsVisibility() {
        ArrayList<T> arrayList = this.mItems;
        if (arrayList == null || arrayList.isEmpty()) {
            this.mRecycler.setVisibility(8);
            this.relativeNoResults.setVisibility(0);
            this.mFabSearch.setVisibility(8);
            TealiumHelper.trackView("/sin_expediente");
            return;
        }
        this.mRecycler.setVisibility(0);
        this.relativeNoResults.setVisibility(8);
        this.mFabSearch.setVisibility(0);
    }

    private void setPullToRefresh() {
        this.mSwipeConainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
            }
        });
        this.mSwipeConainer.setColorSchemeResources(new int[]{R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary});
    }
}
