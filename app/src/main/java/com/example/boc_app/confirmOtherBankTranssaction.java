package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class confirmOtherBankTranssaction extends AppCompatActivity {

    private Button confirm, cancel;
    private String pay,source,amount,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_other_bank_transsaction);

        pay = getIntent().getStringExtra("Pay");
        source = getIntent().getStringExtra("Source");
        amount = getIntent().getStringExtra("Amount");
        description = getIntent().getStringExtra("Description");

        EditText payText = (EditText) findViewById(R.id.pay2);
        EditText sourceText = (EditText) findViewById(R.id.source2);
        EditText amountText = (EditText) findViewById(R.id.amount2);
        EditText descriptionText = (EditText) findViewById(R.id.description2);

        payText.setText(pay);
        sourceText.setText(source);
        amountText.setText(amount);
        descriptionText.setText(description);



        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        confirm = findViewById(R.id.confirmBtn2);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmIntent();
            }
        });

        cancel = findViewById(R.id.cancelBtn2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelIntent();
            }
        });

    }

    private void confirmIntent(){
        Intent intent = new Intent(this, SuccessMsgOtherAccountTransaction.class);
        startActivity(intent);
    }

    private void cancelIntent(){
        Intent intent = new Intent(this, MainActivity.class);
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

