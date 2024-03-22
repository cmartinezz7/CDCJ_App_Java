package es.santander.branchlocator;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class BLDetailedInformationViewPagerAdapter extends FragmentPagerAdapter {
    private BLAtmDetailedInformationFragment BLAtmDetailedInformationFragment;
    private BLBranchDetailedInformationFragment BLBranchDetailedInformationFragment;
    private Context context;

    public BLDetailedInformationViewPagerAdapter(FragmentManager fragmentManager, Context context2) {
        super(fragmentManager);
        this.context = context2;
    }

    public int getCount() {
        return 2;
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            if (this.BLBranchDetailedInformationFragment == null) {
                this.BLBranchDetailedInformationFragment = new BLBranchDetailedInformationFragment();
            }
            return this.BLBranchDetailedInformationFragment;
        } else if (position != 1) {
            return null;
        } else {
            if (this.BLAtmDetailedInformationFragment == null) {
                this.BLAtmDetailedInformationFragment = new BLAtmDetailedInformationFragment();
            }
            return this.BLAtmDetailedInformationFragment;
        }
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return this.context.getString(R.string.bl_branch);
        }
        if (position != 1) {
            return "";
        }
        return this.context.getString(R.string.bl_atm);
    }
}
