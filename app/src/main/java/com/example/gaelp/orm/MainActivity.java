package com.example.gaelp.orm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCreate;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = (Button) findViewById(R.id.create);
        btnRead = (Button) findViewById(R.id.read);

        btnCreate.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent iCreate = new Intent(this, CreateActivity.class);
        Intent iRead = new Intent(this, ReadActivity.class);

        if(view.getId()==R.id.create)
            startActivity(iCreate);
        if(view.getId()==R.id.read)
            startActivity(iRead);
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("NB_CLICK", 1);
    }
}
