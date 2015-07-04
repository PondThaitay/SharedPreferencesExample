package com.wisdomlanna.sharedpreferencesexample;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    LogUser logUser;

    EditText name;
    EditText email;

    Button btnSave;
    Button btnGet;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logUser = new LogUser(getApplicationContext());

        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnClear = (Button) findViewById(R.id.btnClear);

        final boolean flagLogin = true;

        logUser.getPrf();
        if(!logUser.flagLogin){
            Log.e("STATE", logUser.flagLogin+ "");
            //return;
        } else {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            startActivity(intent);
            finish();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logUser.savePrf(name.getText().toString(), email.getText().toString(), flagLogin);
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logUser.clearPrf();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logUser.getPrf();
                name.setText(logUser.name);
                email.setText(logUser.email);
            }
        });
    }
}