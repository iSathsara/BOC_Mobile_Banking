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
    private Toolbar toolbar;


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



    // set logout function


}
