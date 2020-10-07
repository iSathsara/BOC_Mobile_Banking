package com.example.boc_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class billPayment extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    Spinner customer;
    Button next,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payment);

        next = findViewById(R.id.payBill);
       // next.setOnClickListener((View.OnClickListener) this);
        customer = findViewById(R.id.customer);
        ArrayAdapter<CharSequence> sequence = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        sequence.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customer.setAdapter(sequence);
        customer.setOnItemSelectedListener(this);

        navigationView = findViewById(R.id.drawerNavigation);
        //change the topbar title
        getSupportActionBar().setTitle("Bill Payments");


        //for side drawer
        drawer = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.dashboard){

                    drawer.closeDrawers();
                }
                return true;
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(billPayment.this,billPayment2.class);
                startActivity(i);

            }
        });
    }

    //menu on top bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    //for selected items on top bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.help) {


            //Toast.makeText(dashboard.this, "Action clicked", Toast.LENGTH_LONG).show();
            
        }

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onItemSelected(AdapterView<?> parent, View view,int pos, long id){

        String item = parent.getItemAtPosition(pos).toString();
        if(!item.equals("Select")){

            Toast.makeText(billPayment.this, item, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void nextOnClick(View view){

        Intent i = new Intent(this,billPayment2.class);
        startActivity(i);
    }

    public void cancelOnClick(View view){

        Intent i = new Intent(this,dashboard.class);
        startActivity(i);
    }

}
