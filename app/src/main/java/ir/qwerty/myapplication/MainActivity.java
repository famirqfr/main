package ir.qwerty.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import ir.qwerty.myapplication.fragment.LocationFragment;
import ir.qwerty.myapplication.fragment.MessageFragment;
import ir.qwerty.myapplication.fragment.ReportFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.aa);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("hello");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("bye");

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("sey good")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .build();

        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("پیام", MessageFragment.class)
                .add("گزارش", ReportFragment.class)
                .add("اخبار", MessageFragment.class)
                .add("موقعیت", LocationFragment.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewPagerMainActivity);
        viewPager.setAdapter(adapter);


        SmartTabLayout viewSmartTabLayout = findViewById(R.id.smartTab);
        viewSmartTabLayout.setViewPager(viewPager);

    }



}
