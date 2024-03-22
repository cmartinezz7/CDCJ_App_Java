package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.tasks.PetitionsListTask;

public class RequestCorrectlyPopupFragment extends Fragment {
    private ImageView closeButton;
    private Context context;

    public static RequestCorrectlyPopupFragment newInstance() {
        return new RequestCorrectlyPopupFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        RequestCorrectlyPopupFragment.super.onCreate(savedInstanceState);
        this.context = getActivity().getBaseContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solicitud_acceso_feedback, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestCorrectlyPopupFragment.this.showRequestList();
            }
        });
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        RequestCorrectlyPopupFragment.super.onViewCreated(view, savedInstanceState);
        this.closeButton = (ImageView) view.findViewById(R.id.iv_close);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        RequestCorrectlyPopupFragment.super.onActivityCreated(savedInstanceState);
        this.closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestCorrectlyPopupFragment.this.showRequestList();
            }
        });
    }

    /* access modifiers changed from: private */
    public void showRequestList() {
        new PetitionsListTask(getActivity()).execute(new Object[0]);
    }
}
