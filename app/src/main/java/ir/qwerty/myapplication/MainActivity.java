package ir.qwerty.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.squareup.picasso.Picasso;

import ir.qwerty.myapplication.fragment.LocationFragment;
import ir.qwerty.myapplication.fragment.MessageFragment;
import ir.qwerty.myapplication.fragment.NewsFragment;
import ir.qwerty.myapplication.fragment.ReportFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.aa);
        PrimaryDrawerItem message = new PrimaryDrawerItem().withIdentifier(1).withName("پبام");
        SecondaryDrawerItem sendmessage = new SecondaryDrawerItem().withIdentifier(2).withName("ارسال پیام");
        PrimaryDrawerItem report = new PrimaryDrawerItem().withIdentifier(3).withName("گزارش");
        SecondaryDrawerItem sendreport = new SecondaryDrawerItem().withIdentifier(4).withName("ارسال گزارش");
        PrimaryDrawerItem location = new PrimaryDrawerItem().withIdentifier(5).withName("موقعیت");
        SecondaryDrawerItem news = new SecondaryDrawerItem().withIdentifier(6).withName("اخبار");
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withSelectionListEnabledForSingleProfile(false)
                .withHeaderBackground(R.drawable.drawer_background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background))
                )
                .build();

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        message,
                        sendmessage,
                        report,
                        sendreport,
                        location,
                        news
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return false;
                    }
                })
                .withSelectedItem(-1)
                .build();

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                Picasso.get().load(uri).placeholder(placeholder).into(imageView);
            }

            @Override
            public void cancel(ImageView imageView) {
                Picasso.get().cancelRequest(imageView);
            }
        });

        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("گزارش", ReportFragment.class)
                .add("پیام", MessageFragment.class)
                .add("اخبار", NewsFragment.class)
                .add("موقعیت", LocationFragment.class)
                .create());

        ViewPager viewPager = findViewById(R.id.viewPagerMainActivity);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewSmartTabLayout = findViewById(R.id.smartTab);
        viewSmartTabLayout.setViewPager(viewPager);

    }
}
