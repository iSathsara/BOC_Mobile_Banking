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
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {


    private Button otherBankCreditTransBtn;
    private Button otherBankAccTransBtn;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Button thirdPartyTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Transacrions");

        // setting up toolbar
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
                    startActivity(new Intent(MainActivity.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.transaction){
                    //startActivity(new Intent(MainActivity.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.profile){
                    //startActivity(new Intent(MainActivity.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.more){
                    //startActivity(new Intent(MainActivity.this, dashboard.class));
                    drawer.closeDrawers();
                }


                return true;
            }
        });

        otherBankCreditTransBtn = findViewById(R.id.other_bnk_credit_btn);
        otherBankCreditTransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchOtherBankCreditPay();
            }
        });

        otherBankAccTransBtn = findViewById(R.id.other_bnk_acc_btn);
        otherBankAccTransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchOtherBankAccountPay();
            }
        });

        thirdPartyTransaction = (Button) findViewById(R.id.third_prty_boc_btn);
        thirdPartyTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchThirdPartyAccountTransfer();
            }
        });


    }

    // close naviation drawer when clicks on back button

    // intent for launch other bank credit card
    private void launchOtherBankCreditPay(){
        Intent intent = new Intent(this, OtherBankCreditCardPayment.class);
        startActivity(intent);
    }

    private void launchOtherBankAccountPay(){
        Intent intent = new Intent(this, OtherBankAccountPayment.class);
        startActivity(intent);
    }

    private void launchThirdPartyAccountTransfer(){
        Intent intent = new Intent(this, ThirdPartyTransaction.class);
        startActivity(intent);
    }

    // set logout icon in app bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    // options in menu bar
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.help) {


        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//>>>>>>> 73e23f71ec215cca9d099959f9dd40883903ba3e


    // set logout function


}
