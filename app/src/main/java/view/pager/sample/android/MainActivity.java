package view.pager.sample.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    public static int NUM_PAGES = 5;
    private ArrayList<ImageData> imageDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSampleData();

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    private void addSampleData() {
        if (imageDataArrayList == null) {
            imageDataArrayList = new ArrayList<>();
        }
        imageDataArrayList.add(new ImageData(0, "https://i.stack.imgur.com/xNaWy.jpg?s=32&g=1"));
        imageDataArrayList.add(new ImageData(1, "https://i.stack.imgur.com/tKsDb.png"));
        imageDataArrayList.add(new ImageData(2, "https://i.stack.imgur.com/HaNbK.jpg?s=32&g=1"));
        imageDataArrayList.add(new ImageData(3, "https://i.stack.imgur.com/L2y0o.png?s=32&g=1"));
        imageDataArrayList.add(new ImageData(4, "https://i.stack.imgur.com/CUCWs.jpg?s=32&g=1"));
    }

    class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ScreenSlidePageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AppConstants.BUNDLE_KEY_IMAGE_OPENED, position);
            bundle.putParcelableArrayList(AppConstants.BUNDLE_KEY_IMAGE_DATA_ARRAY, imageDataArrayList);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return MainActivity.NUM_PAGES;
        }
    }
}