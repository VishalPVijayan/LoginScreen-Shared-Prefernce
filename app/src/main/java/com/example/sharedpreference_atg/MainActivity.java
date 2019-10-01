package com.example.sharedpreference_atg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnRegister,btnLogin;
    CheckBox cbRememberCredentials;

    private SharedPreferences sharedPreferences;
    public static final String PREFERENCE_NAME ="Preferences_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(PREFERENCE_NAME,MODE_PRIVATE);

        BindWidgets();
        WidgetEventListerner();



    }

    private void WidgetEventListerner() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!edtUsername.getText().toString().equals("")&& edtPassword.getText().toString().equals("")){
                    Log.i("Username",edtUsername.getText().toString().trim());
                    Log.i("Password",edtUsername.getText().toString().trim());

                    Context context = getApplication();
                    String string = "Username :" +edtUsername.getText().toString()+
                    "\nPassword :" +edtPassword.getText().toString();

                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, string , duration);

                   String UserName = edtUsername.getText().toString().trim();
                   String PassWord = edtPassword.getText().toString().trim();


                   if(TextUtils.isEmpty(UserName)){
                       edtUsername.setError("Username can't be blank.");
                       Log.i("Username","is empty");
                   }
                }
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register Activity under Progress", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void BindWidgets() {
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cbRememberCredentials = (CheckBox) findViewById(R.id.cbRememberCredentials);
    }
}
