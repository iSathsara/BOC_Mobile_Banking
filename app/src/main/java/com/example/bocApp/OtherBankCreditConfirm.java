package com.example.bocApp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
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

public class OtherBankCreditConfirm extends AppCompatActivity {

    private Button confirmBtn;
    //private Button cancelBtn;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_credit_confirm);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setTitle("Transactions");

        confirmBtn = findViewById(R.id.obcp_prcd_btn);
        //cancelBtn = findViewById(R.id.obcp_prcd_cancel_btn);

        /*cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        }); */

        navigationView = findViewById(R.id.drawerNavigation);
        toolbar = findViewById(R.id.toolbar);

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
                    startActivity(new Intent(OtherBankCreditConfirm.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.transaction){
                    startActivity(new Intent(OtherBankCreditConfirm.this, MainActivity.class));
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

        // set onclick listener to Continue button
        confirmBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(OtherBankCreditConfirm.this);

                alert.setTitle("SUCCESSFUL");
                alert.setIcon(R.drawable.transaction_okay);
                alert.setMessage("The amount is transferred successfully");
                alert.setPositiveButton("DONE", null);
                alert.setNegativeButton("Another Transaction", null);

                AlertDialog dialog = alert.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_design);

                // this will change the default behaviour of buttons
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchDashboard();
                    }
                });

                // this will change the default behaviour of buttons
                Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        launchOtherTransaction();
                    }
                });


            }
        });

    }

    private void launchDashboard(){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

    // intent for launch other transaction
    private void launchOtherTransaction(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // intent for back to form


    // set logout icon in app bar
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
                Toast.makeText(this, "Logout selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.help:

                // implement function here
                Toast.makeText(this, "help selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.logout2:

                // implement function here
                Toast.makeText(this, "Logout selected", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
