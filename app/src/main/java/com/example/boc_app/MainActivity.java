package com.example.boc_app;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Button otherBankCreditTransBtn;
    private Button otherBankAccTransBtn;
<<<<<<< HEAD
    private Toolbar toolbar;

=======
    private Button thirdPartyTransaction;
>>>>>>> 73e23f71ec215cca9d099959f9dd40883903ba3e

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar();


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

<<<<<<< HEAD
=======
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
>>>>>>> 73e23f71ec215cca9d099959f9dd40883903ba3e


    // set logout function


}
