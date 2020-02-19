package com.guzman.rotem.contactlist;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ContactListActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout firstContact, secondContact, thirdContact, fourthContact, fifthContact, sixthContact;



    View.OnClickListener listener;



    int currntIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

//       Contact currentContact = getSingleContact();
//        Contact contact1 = new Contact("name1", "lname1", "address1", "number1", "hobby1");


        final ArrayList<Contact> list = getContactList(30);
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.single_contact_layout, null);
            LinearLayout containter = findViewById(R.id.container);
//            setContentView(view);
            containter.addView(view);
            TextView contactName = view.findViewById(R.id.contact_name);
            TextView colorKey = view.findViewById(R.id.colorKeyTV);

            contactName.setText(list.get(i).fName + " " + list.get(i).lName);

            currntIndex = i;
            String currntFirstName = list.get(i).fName;
            String currentLastName = list.get(i).lName;
            String currentAddress = list.get(i).address;
            String currentPhone = list.get(i).phoneNumber;
            String currentHobby = list.get(i).hobby;

            int currentColor;

            if (list.get(i) instanceof FamilyContact)
            {
                currentColor = R.color.colorFamilyContact;
            }
            else if (list.get(i) instanceof FriendContact)
            {
                currentColor = R.color.colorFriendContact;
            }
            else {
                currentColor = R.color.colorWorkContact;
            }

            colorKey.setBackgroundColor(getResources().getColor(currentColor));


            final int temp = i;
            listener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ContactListActivity.this, ContactActivity.class);

                    Log.i("", String.valueOf(currntIndex));
                     intent.putExtra("firstName", list.get(temp).fName);
                     intent.putExtra("lastName", list.get(temp).lName);
                     intent.putExtra("address", list.get(temp).address);
                     intent.putExtra("phoneNumber", list.get(temp).phoneNumber);
                     intent.putExtra("hobby", list.get(temp).hobby);

                        startActivity(intent);

                }
            };


            view.setOnClickListener(listener);


        }

//        TextView firstName = findViewById(R.id.fName1);
//        firstName.setText(list.get(0).fName);
//
//
//        findViewById(R.id.firstContact).setOnClickListener(this);
//        secondContact = findViewById(R.id.secondContact);
//        thirdContact = findViewById(R.id.thirdContact);
//        fourthContact = findViewById(R.id.forthContact);
//        fifthContact = findViewById(R.id.fifthContact);
//        sixthContact = findViewById(R.id.sixthContact);


//
//        firstContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "1st", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        secondContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "2st", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        thirdContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "3st", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        fourthContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "4st", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        fifthContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "5st", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        sixthContact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ContactListActivity.this, "6st", Toast.LENGTH_LONG).show();
//            }
//        });
    }
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.firstContact:
//                Toast.makeText(ContactListActivity.this, "1st", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.secondContact:
//                Toast.makeText(ContactListActivity.this, "2nd", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.thirdContact:
//                Toast.makeText(ContactListActivity.this, "3rd", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.forthContact:
//                Toast.makeText(ContactListActivity.this, "4th", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.fifthContact:
//                Toast.makeText(ContactListActivity.this, "5th", Toast.LENGTH_LONG).show();
//                break;
//
//            case R.id.sixthContact:
//                Toast.makeText(ContactListActivity.this, "6th", Toast.LENGTH_LONG).show();
//                break;
//            default: Toast.makeText(ContactListActivity.this, "No Contact", Toast.LENGTH_LONG).show();
//
//
//        }
//    }

    private Contact getSingleContact(){
        return new Contact("name1", "lname1", "address1", "number1", "hobby1");
    }

    private Contact getCustomContact(String fName, String lName, String address, String phone, String hobby){
        int rand = new Random().nextInt(3);
        Contact contact = null;
        switch (rand){
            case 0:
                contact = new FriendContact(fName, lName, address, phone, hobby);
            break;
            case 1:
                contact = new FamilyContact(fName, lName, address, phone, hobby);
                break;
            case 2:
                contact = new WorkContact(fName, lName, address, phone, hobby);
                break;



        }

        return contact;
    }

    private Contact getCustomContact(){
        Contact customContact = new Contact("name1", "lname1", "address1", "number1", "hobby1");
        return customContact;
    }

    private ArrayList<Contact> getContactList(int listLength){
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        for (int i = 0; i < listLength; i++) {
            contactList.add(getCustomContact("name" + i,  "lname" + i, "address" + i, "number" + i, "hobby" + i));
        }
        return contactList;
    }


    @Override
    public void onClick(View view) {

    }
}
