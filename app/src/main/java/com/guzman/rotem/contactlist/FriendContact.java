package com.guzman.rotem.contactlist;

/**
 * Created by Rotem on 2/13/2020.
 */

public class FriendContact extends Contact implements iContactable{

    public FriendContact() {
    }

    public FriendContact(String fName, String lName, String address, String phoneNumber, String hobby) {
        super(fName, lName, address, phoneNumber, hobby);
    }
}
