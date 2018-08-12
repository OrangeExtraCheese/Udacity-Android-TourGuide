package tomaszmarzec.udacity.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.udacity.tomaszmarzec.tourguide.R;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter
{
    private Context mContext;

    public CustomFragmentPagerAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new SportFragment();
            case 1:
                return new MonumentsFragment();
            case 2:
                return new CultureFragment();
            default:
                return new FoodFragment();
        }
    }

    @Override
    public int getCount()
    {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return mContext.getString(R.string.category_sport);
            case 1:
                return mContext.getString(R.string.category_monuments);
            case 2:
                return mContext.getString(R.string.category_culture);
            default:
                return mContext.getString((R.string.category_food));
        }
    }
}
