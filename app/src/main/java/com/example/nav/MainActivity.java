package com.example.nav;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
// imporime vajalikud asjad
public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
// Vajalike muutujate lisamine
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.nav_action); // Otsib nav actionit projektis
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close); // Lisab võimalise Open ja Close

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        // you will be able to see the back navigation button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab
        fragmentTransaction.add(R.id.main_container, new HomeFragment()); // Muudab pildi Home fragmentiks
        fragmentTransaction.commit();

        getSupportActionBar().setTitle("Home fragment"); // Muudab tiitli Home fragmentiks

        navigationView = (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // Meetod

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){ // Switchib itemid
                    case R.id.nav_home_fragment: // Kui valitakse home fragment
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Home fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new HomeFragment()); // Muudab pildi Home fragmenti vastu
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home fragment"); // Muudab tiitli Home fragmentiks
                        item.setChecked(true); // item saab kontrollitud ja muudetakse trueks
                        mDrawerLayout.closeDrawers(); // mDrawerLayout sulgetakse
                        break; // Peatab home fragmenti
                    case R.id.nav_email_fragment: // Kui valitakse email fragment
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // email Fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new EmailFragment()); // Muudab pildi Email fragmentiks
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Email fragment"); // Muudab tiitli Email fragmentiks
                        item.setChecked(true); // item saab kontrollitud ja muudetakse trueks
                        mDrawerLayout.closeDrawers(); // mDrawerLayout sulgetakse
                        break; // Peatab email fragmenti
                    case R.id.nav_calendar_fragment: // Kui valitakse calendar fragment
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new CalenderFragment()); // Muudab pildi Calender Fragmenti vastu
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Calendar fragment"); // Muudab tiitli Calendar fragmentiks
                        item.setChecked(true); // item saab kontrollitud ja muudetakse trueks
                        mDrawerLayout.closeDrawers(); // mDrawerLayout sulgetakse
                        break; // Peatab calender fragmenti
                }
                return true; // Väljastab true
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){  // Kui mToggle valitakse siis väljastatakse true
            return true;
        }
        return super.onOptionsItemSelected(item); // Kui ei valita siis returnib super.onOptionsItemSelected(item)
    }
}


