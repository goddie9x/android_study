package com.god.study;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameField;
    private EditText passwordField;
    private Button loginBtn;
    private final int REQUEST_LOGOUT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBtn = (Button) findViewById(R.id.login_btn);
        usernameField = (EditText) findViewById(R.id.username_field);
        passwordField =(EditText) findViewById(R.id.password_field);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLogoutActivity();
            }
        });
    }
    protected  void OpenLogoutActivity(){
        Intent intent = new Intent(MainActivity.this,LogoutActivity.class);
        intent.putExtra("username",usernameField.getText().toString());
        intent.putExtra("password",passwordField.getText().toString());
        startActivityForResult(intent,REQUEST_LOGOUT_CODE);
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle crrBundle = data.getExtras();
        switch (resultCode){
            case REQUEST_LOGOUT_CODE:{
                if(resultCode == RESULT_OK){
                    Toast.makeText(this, data.getExtras().getString("message"),
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}