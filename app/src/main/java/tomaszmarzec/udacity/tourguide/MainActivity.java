//Package renamed because "udacity" folder in it caused error in Butterknife
package tomaszmarzec.udacity.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.udacity.tomaszmarzec.tourguide.R;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);

        CustomFragmentPagerAdapter fragmentPagerAdapter = new CustomFragmentPagerAdapter(
                getSupportFragmentManager(), this);
        viewPager.setAdapter(fragmentPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);


        //When user switches tab, cancelToast method from LocationAdapter is called to clear toast message.
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LocationAdapter.cancelToast();
            }

            @Override
            public void onPageSelected(int position) {
                LocationAdapter.cancelToast();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                LocationAdapter.cancelToast();
            }
        });

    }
}
