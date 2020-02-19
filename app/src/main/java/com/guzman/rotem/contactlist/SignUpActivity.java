package com.guzman.rotem.contactlist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText myFirstNameET, myLastNameET, myEmailET, myPasswordET;
    TextView tv;
    Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        myFirstNameET = findViewById(R.id.my_first_name_et);
        myLastNameET = findViewById(R.id.my_last_name_et);
        myEmailET = findViewById(R.id.my_email_et);
        myPasswordET = findViewById(R.id.my_password_et);
        signUpBtn = findViewById(R.id.sign_up_btn);
        tv = findViewById(R.id.tv);


        final SharedPreferences pref = getSharedPreferences("FirstPreference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("MyFirstName", myFirstNameET.getText().toString());
                editor.putString("MyLastName", myLastNameET.getText().toString());
                editor.putString("MyEmail", myEmailET.getText().toString());
                editor.putString("MyPassword", myPasswordET.getText().toString());

                boolean isOK = editor.commit();

                if (isOK){
                    String firstName = pref.getString("MyFirstName", "String not found");

                    String secondName = pref.getString("MyLastName", "String not found");
                    String email = pref.getString("MyEmail", "String not found");
                    String password = pref.getString("MyPassword", "String not found");

                    TextView tv = findViewById(R.id.tv);
                    tv.setText(firstName);

                }

                String empty = "";
                if (myFirstNameET.toString() != empty){
                    Intent intent = new Intent(SignUpActivity.this, ContactListActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Please Register...", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
