package com.example.boc_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdPartyTransaction extends AppCompatActivity {

    Button transfer;
    EditText pay,source,amount,desc;
    int childCount;
    String descTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_transaction);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        //get input data
        pay  = findViewById(R.id.pay_txt);
        source = findViewById(R.id.source_txt);
        amount = findViewById(R.id.amount_txt);
        desc = findViewById(R.id.desc_test);
        descTxt=desc.toString();

        transfer = findViewById(R.id.transferBtn);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(desc.getText())){
                    descTxt = "No Notes..!";
                }

                if(TextUtils.isEmpty(pay.getText())){
                   // Toast.makeText(ThirdPartyTransaction.this, "All fields required...", Toast.LENGTH_LONG).show();
                    pay.setError( "Pay field is required!" );
                }
                else if(TextUtils.isEmpty(source.getText())) {
                    source.setError( "Source field is required!" );
                }
                else if(TextUtils.isEmpty(amount.getText())){
                    amount.setError( "Amount field is required!" );
                }
                else {
                    //intent
                    Intent intent = new Intent(getBaseContext(), confirmThirdPatyTransaction.class);
                    intent.putExtra("pay", pay.getText().toString().trim());
                    intent.putExtra("source", source.getText().toString().trim());
                    intent.putExtra("amount", amount.getText().toString().trim());
                    intent.putExtra("desc", descTxt);
                    startActivity(intent);
                }
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

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                return true;

            case R.id.help:

                Toast.makeText(this, "help selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.logout2:

                Intent intent2 = new Intent(this, Login.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
