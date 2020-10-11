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
import android.widget.Spinner;
import android.widget.Toast;

public class OtherBankAccountPayment extends AppCompatActivity {

    private Button backToTransMenu,confirm;
    private String pay,source,amount,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_account_payment);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        backToTransMenu = (Button) findViewById(R.id.obcp_cancel_btn2);
        confirm = (Button) findViewById(R.id.confirmBtn4);

        // go back to transaction menu screen
        backToTransMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

