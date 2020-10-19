package com.example.bocApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    private Button loginbtn;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn = (Button) findViewById(R.id.login);

        // go back to transaction menu screen
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMenu();
            }
        });

    }
    private void MainMenu(){
<<<<<<< HEAD:app/src/main/java/com/example/boc_app/Login.java

        EditText usernameEditText = (EditText) findViewById(R.id.username);
        EditText passwordEditText = (EditText) findViewById(R.id.password);

        username = usernameEditText.getText().toString();
        password = passwordEditText.getText().toString();
        if (username.matches("")||password.matches("")) {
            // Show Toast
            Toast.makeText(this, "You did not enter a username or password", Toast.LENGTH_SHORT).show();
            // Show Error on edittext
            usernameEditText.setError("You must enter a username");
            passwordEditText.setError("You must enter a password");
            return;
        }
        if (username.matches("admin")&& password.matches("1234")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "You successfully logged in to the system", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();

=======
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
>>>>>>> e914613b3e831825789596df267bfb24e3869824:app/src/main/java/com/example/bocApp/Login.java
    }


}
