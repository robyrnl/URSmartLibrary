package id.ac.unri.ursmartlibrary;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homeActivityFragmen extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPagerAdapter mSectionPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        setContentView(R.layout.activity_home_fragmen);

        mSectionPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_storage_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_archive_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_android_black_24dp);
    }

    private void setupViewPager(ViewPager mViewPager) {

        SectionsPagerAdapter adp = new SectionsPagerAdapter(getSupportFragmentManager());
        adp.addFragment(new tabFragment1());
        adp.addFragment(new tabFragment2());
        adp.addFragment(new tabFragment3());
        adp.addFragment(new fragment4());
        mViewPager.setAdapter(adp);

    }
}
