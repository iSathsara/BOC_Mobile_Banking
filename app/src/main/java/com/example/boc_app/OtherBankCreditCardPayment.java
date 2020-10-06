package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class OtherBankCreditCardPayment extends AppCompatActivity {

    private Button backToTransMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_credit_card_payment);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        backToTransMenu = (Button) findViewById(R.id.obcp_cancel_btn);

        // go back to transaction menu screen
        backToTransMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

