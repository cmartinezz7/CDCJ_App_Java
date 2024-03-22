package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BLBaseFragment extends Fragment {
    private BLBaseFragmentDataUpdate baseFragmentDataUpdate;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_phone_fragment, container, false);
    }

    private boolean isAddFragment(FragmentManager fragmentManager, Fragment fragmentCompare) {
        if (fragmentManager == null || fragmentManager.getFragments().size() <= 0) {
            return false;
        }
        for (Fragment fragmentTmp : fragmentManager.getFragments()) {
            if (fragmentTmp.equals(fragmentCompare)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAddFragmentID(FragmentManager fragmentManager, Fragment fragmentCompare) {
        if (fragmentManager == null || fragmentManager.getFragments().size() <= 0) {
            return false;
        }
        for (Fragment fragmentTmp : fragmentManager.getFragments()) {
            if (fragmentTmp.getId() == fragmentCompare.getId()) {
                return true;
            }
        }
        return false;
    }

    public void switchFragment(FragmentManager fragmentManager, Fragment fragmentToLoad, Fragment fragmentReplace, int id) {
        BLBaseFragmentDataUpdate bLBaseFragmentDataUpdate;
        boolean isCommit = false;
        boolean isLoadData = true;
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (fragmentReplace != null && isAddFragmentID(fragmentManager, fragmentReplace)) {
                if (!isAddFragment(fragmentManager, fragmentToLoad)) {
                    isLoadData = false;
                }
                ft.replace(id, fragmentToLoad);
                ft.commit();
                isCommit = true;
            }
            if (!isCommit && !isAddFragment(fragmentManager, fragmentToLoad)) {
                ft.add(id, fragmentToLoad);
                ft.commit();
                isLoadData = false;
            }
            if (isLoadData && (bLBaseFragmentDataUpdate = this.baseFragmentDataUpdate) != null) {
                bLBaseFragmentDataUpdate.loadData(fragmentToLoad);
            }
        }
    }

    public void setBaseFragmentDataUpdate(BLBaseFragmentDataUpdate blBaseFragmentDataUpdate) {
        this.baseFragmentDataUpdate = blBaseFragmentDataUpdate;
    }
}
