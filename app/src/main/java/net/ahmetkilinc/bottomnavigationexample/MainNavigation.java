package net.ahmetkilinc.bottomnavigationexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainNavigation extends AppCompatActivity {

    private TextView mTextMessage;

    private ActionBar toolbar;
    private Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    toolbar.setTitle("Home");
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    toolbar.setTitle("Dashboard");
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    toolbar.setTitle("Notifications");
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        toolbar = getSupportActionBar();

        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());

        //mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void loadFragment(Fragment fragment) {

        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
