package com.guzman.rotem.contactlist;

/**
 * Created by Rotem on 2/13/2020.
 */

public class WorkContact extends Contact implements iContactable{
    public WorkContact() {
    }

    public WorkContact(String fName, String lName, String address, String phoneNumber, String hobby) {
        super(fName, lName, address, phoneNumber, hobby);
    }
}
