package com.example.gaelp.orm;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by gaelp on 18/04/2018.
 */

public class ReadActivity extends ListActivity {

    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Iterator<Contact> contacts = Contact.findAll(Contact.class);

        while(contacts.hasNext()){
            Contact leContact = contacts.next();
            addItem(leContact.getName(), leContact);
        }

        adapter = new SimpleAdapter(
                this,
                data,
                R.layout.activity_read,
                new String[]{"id","name", "firstname", "tel", "email"},
                new int[]{R.id.read_id, R.id.read_name, R.id.read_firstname, R.id.read_tel, R.id.read_email});
        setListAdapter(adapter);
    }

    private void addItem(String record_name, Contact c) {
        HashMap<String,String> item = new HashMap<>();
        item.put("id", c.getId()+"");
        item.put("name", c.getName());
        item.put("firstname", c.getFirstname());
        item.put("tel", c.getTel());
        item.put("email", c.getEmail());
        data.add(item);
    }
}
