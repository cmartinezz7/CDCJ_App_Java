package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BLBranchNewsAndWarningsFragment extends BLBaseInfoFragment {
    private BLTextView txtNews;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_news_and_warnings_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            setData(getParentFragment().getBranch());
        } else if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            setData(getParentFragment().getAtm());
        }
    }

    private void setupUi(View view) {
        this.txtNews = (BLTextView) view.findViewById(R.id.txt_news);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi branch) {
        this.txtNews.setText(branch.getNewsAndNotices(getContext()));
    }
}
