package com.example.boc_app;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class billPayment3 extends AppCompatActivity {


    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment3);


        navigationView = findViewById(R.id.drawerNavigation);
        //change the topbar title
        getSupportActionBar().setTitle("Bill Payments");


        //for side drawer
        drawer = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.dashboard){

                    drawer.closeDrawers();
                }
                return true;
            }
        });
    }

    //menu on top bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    //for selected items on top bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.help) {


            //Toast.makeText(dashboard.this, "Action clicked", Toast.LENGTH_LONG).show();

        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void nextOnClick(View view){

        Intent i = new Intent(this,billPayment4.class);
        startActivity(i);
    }

    public void cancelOnClick(View view){

        Intent i = new Intent(this,dashboard.class);
        startActivity(i);
    }
}
