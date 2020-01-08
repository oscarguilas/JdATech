package com.example.jdatech;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class LoginActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    public EditText login_,password_;
    public Button acceptButton;
    public TextView titulo_;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_ = this.findViewById(R.id.loginBox);
        password_ = this.findViewById(R.id.passwordBox);
        acceptButton = this.findViewById(R.id.button);
        titulo_ = this.findViewById(R.id.tituloTextView);
    }

    //"Dummy" data login, database will be implemented at a later time
    public void letMeIn(View view){ //Logs in, onClick for the login button
        //Checks if login = "login" and password = "pass"
        if(login_.getText().toString().equals("login") && password_.getText().toString().equals("pass")){
            //Tries to open MainActivity.java
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);

            finish();
            startActivity(intent);
        }
    }

}
