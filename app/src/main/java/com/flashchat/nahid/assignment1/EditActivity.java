package com.flashchat.nahid.assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {


    String name;
    String contact;
    String occupation;
    String mail;
    String id;
    String company;

    EditText name_1;
    EditText contact_1;
    EditText occupation_1;
    EditText mail_1;
    EditText company_1;

    ArrayList<Event> events = new ArrayList<Event>();
    EventDbHelper mydb = new EventDbHelper(
            this, " EventDb", null, 8);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        contact = extras.getString("contact");
        occupation = extras.getString("occupation");
        mail = extras.getString("mail");
        id = extras.getString("id");
        company =extras.getString("company");


        name_1 = (EditText) findViewById(R.id.editTextTitle);
        name_1.setText(name);

        company_1 = (EditText) findViewById(R.id.editTextPhone);
        company_1.setText(contact);

        occupation_1 = (EditText) findViewById(R.id.editTextJob);
        occupation_1.setText(occupation);

        mail_1 = (EditText) findViewById(R.id.editTextEmail);
        mail_1.setText(mail);

        company_1 = (EditText) findViewById(R.id.editCompany);
        company_1.setText(company);

    }

}
