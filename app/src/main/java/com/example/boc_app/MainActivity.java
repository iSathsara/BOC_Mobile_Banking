package com.example.boc_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        otherBankCreditTransBtn = (Button) findViewById(R.id.other_bnk_credit_btn);
        otherBankCreditTransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchOtherBankCreditPay();
            }
        });

        otherBankAccTransBtn = (Button) findViewById(R.id.other_bnk_acc_btn);
        otherBankAccTransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchOtherBankAccountPay();
            }
        });

    }

    // intent for launch other bank credit card
    private void launchOtherBankCreditPay(){
        Intent intent = new Intent(this, OtherBankCreditCardPayment.class);
        startActivity(intent);
    }

    private void launchOtherBankAccountPay(){
        Intent intent = new Intent(this, OtherBankAccountPayment.class);
        startActivity(intent);
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
        switch (item.getItemId()){
            case R.id.logout:

                // implement function here
                //Toast.makeText(this,"Logout selected",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);

                return true;

            case R.id.help:

                // implement function here
                Toast.makeText(this,"help selected",Toast.LENGTH_LONG).show();
                return true;

            case R.id.logout2:

                // implement function here
                //Toast.makeText(this,"Logout selected",Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, Login.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
