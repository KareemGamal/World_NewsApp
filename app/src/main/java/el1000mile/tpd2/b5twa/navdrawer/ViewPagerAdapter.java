package el1000mile.tpd2.b5twa.navdrawer;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by KeMoOoOoO on 9/18/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    String [] Fragments = {"Top" , "Latest" };
    public ViewPagerAdapter(FragmentManager fm , Context AppContext) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {

            case 0 :
                return new Top_Fragment();

            case 1:
                return  new Latest_Frag();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return Fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Fragments[position];
    }
}
