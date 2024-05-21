package com.pollub.app51;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private NavigationView nv;
    TextView t;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.activity_main);
        abdt = new ActionBarDrawerToggle(this, dl, 0, 0);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        replaceFragment(new MotorFragment());

        nv.setNavigationItemSelectedListener(new
         NavigationView.OnNavigationItemSelectedListener() {
             public boolean onNavigationItemSelected(MenuItem item) {
                 int id = item.getItemId();
                 item.setChecked(true);
                 switch(id) {
                     case R.id.Motor:

                         replaceFragment(new MotorFragment());


                         break;

                     case R.id.Hokey:
                         replaceFragment(new HokeyFragment());break;


                     case R.id.Golf:
                         replaceFragment(new GolfFragment());break;


                     default:
                         return true;
                 }

                 return false;
             }
         });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(abdt.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item); }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
