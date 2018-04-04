package com.flashchat.nahid.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    String name;
    String contact;
    String occupation;
    String mail;
    String id;
    String company;

    String title;
    String context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
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
/*
        final TextView tvImageTitle = (TextView) findViewById(R.id.textView_name);
        final TextView tvImageTnfo = (TextView) findViewById(R.id.textViewPhone);
        final TextView tvContactTnfo = (TextView) findViewById(R.id.textViewJobTitle);
        final TextView tvEmailTnfo = (TextView) findViewById(R.id.textViewEmail);
        final TextView tvCompanyTnfo = (TextView) findViewById(R.id.editCompany);


        Button editBtn = (Button) findViewById(R.id.button_edit);
        editBtn.setOnClickListener((v) {
            String Title = tvImageTitle.getText().toString();
            String ImageTnfo = tvImageTnfo.getText().toString();

            title = Title;
            context = ImageTnfo;

            Intent ii = new Intent(EventOCR.this, EditActivity.class);
            ii.putExtra("title",name);
            ii.putExtra("contact",contact);
            startActivity(ii);
        }
*/
        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        occupation = extras.getString("occupation");
        contact = extras.getString("contact");
        mail = extras.getString("mail");
        id = extras.getString("id");
        company = extras.getString("company");

        TextView tvs = (TextView) findViewById(R.id.textView_name);
        tvs.setText(name);

        tvs = (TextView) findViewById(R.id.textViewPhone);
        tvs.setText(contact);

        tvs = (TextView) findViewById(R.id.textViewJobTitle);
        tvs.setText(occupation);

        tvs = (TextView) findViewById(R.id.textViewEmail);
        tvs.setText(mail);

        tvs = (TextView) findViewById(R.id.editCompany);
        tvs.setText(company);
    }

    public void gotoEditActivity(View v) {
        Intent intent = new Intent(this, EditActivity.class);

        intent.putExtra("fname", name);
        intent.putExtra("phone",contact);
        intent.putExtra("jobt", occupation);
        intent.putExtra("email",mail);
        intent.putExtra("id", id);
        intent.putExtra("company",company);
        startActivity(intent);
    }

}
