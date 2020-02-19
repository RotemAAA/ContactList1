package com.guzman.rotem.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView firtsNameTV, lastNameTV, addressTV, phoneTV, hobbyTV, colorkey;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //int contactId = getIntent().getExtras().getInt("contactName");


        firtsNameTV = findViewById(R.id.first_name_tv);
        lastNameTV = findViewById(R.id.last_name_tv);
        addressTV = findViewById(R.id.address_tv);
        phoneTV = findViewById(R.id.phone_tv);
        hobbyTV = findViewById(R.id.hobby_tv);
        colorkey = findViewById(R.id.colorKeyTV);

        firtsNameTV.setText((getIntent().getStringExtra("firstName")));
        lastNameTV.setText(getIntent().getStringExtra("lastName"));
        addressTV.setText(getIntent().getStringExtra("address"));
        phoneTV.setText(getIntent().getStringExtra("phoneNumber"));
        hobbyTV.setText(getIntent().getStringExtra("hobby"));


    }
}
