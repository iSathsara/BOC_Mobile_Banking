package com.example.bocApp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class OtherBankCreditCardPayment extends AppCompatActivity {

    //private Button backToTransMenu;
    private Button continueButton;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_credit_card_payment);
        getSupportActionBar().setTitle("Transactions");


        continueButton = (Button) findViewById(R.id.obcp_cont_btn);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.drawerNavigation);

        //for side drawer
        drawer = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this,drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.dashboard){
                    startActivity(new Intent(OtherBankCreditCardPayment.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.transaction){
                    startActivity(new Intent(OtherBankCreditCardPayment.this, MainActivity.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.profile){
                    //startActivity(new Intent(MainActivity.this, myprofile.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.more){
                    //startActivity(new Intent(MainActivity.this, more.class));
                    drawer.closeDrawers();
                }
                return true;
            }
        });

        // go to confirm the transaction
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoConfirm();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    // set logout function
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:

                // implement function here
                //Toast.makeText(this, "Logout selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                return true;

            case R.id.help:

                // implement function here
                Toast.makeText(this, "help selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.logout2:

                // implement function here
                //Toast.makeText(this, "Logout selected", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, Login.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    // method to goto confirm transaction
    private void gotoConfirm(){
        Intent intent = new Intent(this, OtherBankCreditConfirm.class);
        startActivity(intent);
    }

    // set logout icon in app bar





}

