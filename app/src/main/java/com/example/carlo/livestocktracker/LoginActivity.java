package com.example.carlo.livestocktracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Carlo on 3/4/2017.
 */

public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeBasicSignIn();

    }

    private void initializeBasicSignIn() {
        Button button = (Button) findViewById(R.id.button_signIn);
//        final EditText email = (EditText) findViewById(R.id.input_email);
//        final EditText password = (EditText) findViewById(R.id.input_password);
//        final TextView invalidLogin = (TextView) findViewById(R.id.error_unauthorized);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
