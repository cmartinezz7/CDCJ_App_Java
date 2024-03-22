package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;
import es.santander.justicia.R;

public class ExpedientsListFragment extends ListFragment {
    private Context context;

    public static ExpedientsListFragment newInstance(String param1, String param2) {
        return new ExpedientsListFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        ExpedientsListFragment.super.onCreate(savedInstanceState);
        this.context = getActivity().getBaseContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expedients_list, container, false);
    }
}
