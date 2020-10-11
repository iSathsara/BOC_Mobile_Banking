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
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class confirmThirdPatyTransaction extends AppCompatActivity {

    private Button confirm,cancel;
    EditText pay,source,amount,desc;
    ThirdPartyTransactionClass tTransClass;
    String descbody,childCountTxt,payTxt,sourceTxt,amountTxt,descTxt;
    int childCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_third_paty_transaction);

        // setting up toolbar
        Toolbar trans_toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(trans_toolbar);
        getSupportActionBar().setTitle("Transactions");

        //get input data
        pay  = findViewById(R.id.pay_txt);
        source = findViewById(R.id.source_txt);
        amount = findViewById(R.id.amount_txt);
        desc = findViewById(R.id.desc_test);

        payTxt= getIntent().getStringExtra("pay");
        sourceTxt= getIntent().getStringExtra("source");
        amountTxt= getIntent().getStringExtra("amount");
        descTxt= getIntent().getStringExtra("desc");

        pay.setText(payTxt);
        source.setText(sourceTxt);
        amount.setText(amountTxt);
        desc.setText(descTxt);

        confirm = findViewById(R.id.confirmBtn);
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /*

                ---database code

                boolean check = validateForm();

                if (check) {

                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("ThirdPartyTransactionClass");

                    tTransClass.setPayAcoount(pay.getText().toString().trim());
                    tTransClass.setSourceAccount(source.getText().toString().trim());
                    tTransClass.setAmount(amount.getText().toString().trim());
                    tTransClass.setDesc(desc.getText().toString().trim());
                    //tTransClass.setChild(childCount+1);

                    System.out.println(pay.getText().toString().trim()+""+source.getText().toString().trim()+childCount);

                    dbRef.child("trans1").setValue(tTransClass);
                    Toast.makeText(confirmThirdPatyTransaction.this, pay.getText().toString().trim(), Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(confirmThirdPatyTransaction.this, "Check the empty fields...", Toast.LENGTH_LONG).show();
                }

                */

                AlertDialog.Builder alert = new AlertDialog.Builder(confirmThirdPatyTransaction.this);

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
                        cancelIntent();
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

        cancel = findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelIntent();
            }
        });
    }


    private void cancelIntent(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void launchOtherTransaction(){
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

    //form validation
    private boolean validateForm(){

        if(desc.toString().isEmpty()){
            descbody = "No Notes!";
        }else{
            descbody = desc.getText().toString();
        }


        if(pay.toString().isEmpty()){
            return false;
        }
        else if(pay.toString().isEmpty()){
            return false;
        }
        else if(amount.toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }

    }

}
