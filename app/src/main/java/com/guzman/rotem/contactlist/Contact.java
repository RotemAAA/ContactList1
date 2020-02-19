package com.guzman.rotem.contactlist;

/**
 * Created by Rotem on 2/9/2020.
 */

public class Contact implements iContactable{
    String fName;
    String lName;
    String address;
    String phoneNumber;
    String hobby;

    public Contact(){}


    public Contact(String fName, String lName, String address, String phoneNumber, String hobby) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}


