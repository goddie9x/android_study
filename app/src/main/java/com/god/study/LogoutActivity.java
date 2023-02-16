package com.god.study;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LogoutActivity extends AppCompatActivity {
    private TextView usernameLabel;
    private TextView passwordLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        usernameLabel = (TextView)findViewById(R.id.username);
        passwordLabel = (TextView)findViewById(R.id.password);
        Intent intent = getIntent();
        Bundle crrBundle = intent.getExtras();
        if(!crrBundle.isEmpty()){
            String username = crrBundle.getString("username");
            String password = crrBundle.getString("password");

            if(username!=null){
                usernameLabel.setText(username);
            }
            if(password!=null){
                passwordLabel.setText(password);
            }
        }
    }
    @Override
    public void finish(){
        Intent data = new Intent();
        data.putExtra("message", "Logged out");
        setResult(RESULT_OK, data);
        super.finish();
    }
}