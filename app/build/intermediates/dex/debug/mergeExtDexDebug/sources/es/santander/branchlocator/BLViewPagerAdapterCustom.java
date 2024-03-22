package es.santander.branchlocator;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class BLViewPagerAdapterCustom extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList();
    private int mCurrentPosition = -1;
    private List<String> titlesList = new ArrayList();

    BLViewPagerAdapterCustom(FragmentManager fm) {
        super(fm);
    }

    /* access modifiers changed from: package-private */
    public void addFragment(Fragment fragment, String title) {
        this.fragmentList.add(fragment);
        this.titlesList.add(title);
    }

    public Fragment getItem(int arg0) {
        return this.fragmentList.get(arg0);
    }

    public int getCount() {
        return this.fragmentList.size();
    }

    public CharSequence getPageTitle(int position) {
        return this.titlesList.get(position);
    }

    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        BLViewPagerAdapterCustom.super.setPrimaryItem(container, position, object);
        if (container instanceof BLViewPager) {
            Fragment fragment = (Fragment) object;
            BLViewPager pager = (BLViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                if (position != this.mCurrentPosition) {
                    this.mCurrentPosition = position;
                }
                pager.onPageChanged(fragment.getView());
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("ViewPager is not a BLViewPager");
    }
}
