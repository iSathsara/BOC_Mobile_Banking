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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class OtherBankAccountPayment extends AppCompatActivity {

<<<<<<< HEAD:app/src/main/java/com/example/boc_app/OtherBankAccountPayment.java
    private Button backToTransMenu,confirm;
    private String pay,source,amount,description;
=======
    private Button backToTransMenu;
    private Button ConfirmBtn;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
>>>>>>> e914613b3e831825789596df267bfb24e3869824:app/src/main/java/com/example/bocApp/OtherBankAccountPayment.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_account_payment);
        getSupportActionBar().setTitle("Transactions");

<<<<<<< HEAD:app/src/main/java/com/example/boc_app/OtherBankAccountPayment.java
        backToTransMenu = (Button) findViewById(R.id.obcp_cancel_btn2);
        confirm = (Button) findViewById(R.id.confirmBtn4);
=======
        navigationView = findViewById(R.id.drawerNavigation);
>>>>>>> e914613b3e831825789596df267bfb24e3869824:app/src/main/java/com/example/bocApp/OtherBankAccountPayment.java

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
                    startActivity(new Intent(OtherBankAccountPayment.this, dashboard.class));
                    drawer.closeDrawers();
                }

                if(id == R.id.transaction){
                    startActivity(new Intent(OtherBankAccountPayment.this, MainActivity.class));
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

<<<<<<< HEAD:app/src/main/java/com/example/boc_app/OtherBankAccountPayment.java
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOtherBankTrans();
            }
        });

    }

    private void confirmOtherBankTrans(){

        EditText payEditText = (EditText) findViewById(R.id.obpay);
        EditText sourceEditText = (EditText) findViewById(R.id.obsource);
        EditText amountEditText = (EditText) findViewById(R.id.obammount);
        EditText descriptionEditText = (EditText) findViewById(R.id.obdescription);

        pay = payEditText.getText().toString();
        source = sourceEditText.getText().toString();
        amount = amountEditText.getText().toString();
        description = descriptionEditText.getText().toString();

        if (pay.matches("")||source.matches("")||amount.matches("")||description.matches("")) {
            // Show Toast
            Toast.makeText(this, "You must enter details", Toast.LENGTH_SHORT).show();
            // Show Error on edittext
            payEditText.setError("You must enter a pay");
            sourceEditText.setError("You must enter a source");
            amountEditText.setError("You must enter a ammount");
            descriptionEditText.setError("You must enter a description");
            return;
        }

        Intent intent = new Intent(this, confirmOtherBankTranssaction.class);
        intent.putExtra("Pay",pay);
        intent.putExtra("Source",source);
        intent.putExtra("Amount",amount);
        intent.putExtra("Description",description);

        startActivity(intent);
=======

        //backToTransMenu = (Button) findViewById(R.id.obcp_cancel_btn2);

>>>>>>> e914613b3e831825789596df267bfb24e3869824:app/src/main/java/com/example/bocApp/OtherBankAccountPayment.java
    }





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
}

