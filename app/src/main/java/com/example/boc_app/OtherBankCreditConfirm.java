package com.example.boc_app;

import androidx.appcompat.app.AlertDialog;
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

public class OtherBankCreditConfirm extends AppCompatActivity {

    private Button confirmBtn;
    //private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_bank_credit_confirm);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        confirmBtn = findViewById(R.id.obcp_prcd_btn);
        //cancelBtn = findViewById(R.id.obcp_prcd_cancel_btn);

        /*cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        }); */

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
                        // redirect to dashboard
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


    // intent for launch other transaction
    private void launchOtherTransaction(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // intent for back to form
    private void goBack(){
        Intent intent = new Intent(this, OtherBankCreditCardPayment.class);
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
