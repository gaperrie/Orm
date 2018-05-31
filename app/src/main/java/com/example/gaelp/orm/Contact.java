package com.example.gaelp.orm;

import com.orm.SugarRecord;

/**
 * Created by gaelp on 18/04/2018.
 */

public class Contact extends SugarRecord {
    String name;
    String firstname;
    String tel;
    String email;

    public Contact() {
    }

    public Contact(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public Contact(String name, String firstname, String tel) {
        this.name = name;
        this.firstname = firstname;
        this.tel = tel;
    }

    public Contact(String name, String firstname, String tel, String email) {
        this.name = name;
        this.firstname = firstname;
        this.tel = tel;
        this.email = email;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
