package com.example.gaelp.orm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gaelp on 18/04/2018.
 */

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    TextView tName;
    TextView tFirstname;
    TextView tTel;
    TextView tEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        btnSave = (Button) findViewById(R.id.save);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent iSave = new Intent(this,MainActivity.class);

        tName = (EditText) findViewById(R.id.name);
        tFirstname = (EditText) findViewById(R.id.firstname);
        tTel = (EditText) findViewById(R.id.tel);
        tEmail = (EditText) findViewById(R.id.email);

        if(view.getId() == R.id.save) {
           Contact c1 = new Contact(tName.getText().toString(), tFirstname.getText().toString(), tTel.getText().toString(), tEmail.getText().toString());
           c1.save();
           startActivity(iSave);
        }
    }
}
