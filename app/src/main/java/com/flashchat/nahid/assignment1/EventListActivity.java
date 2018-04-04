package com.flashchat.nahid.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<Event>();

    EventDbHelper mydb = new EventDbHelper(
            this, " EventDb", null, 8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
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

        events = mydb.getAllEvents();
        if (events.isEmpty()) {
            mydb.insertEvent(new Event("Jonathan Doe","0483765986","Teacher","jonathan@gmail.com", "University of Canberra"));
            mydb.insertEvent(new Event("Mithcel Starc","0558765429","Crickter","James@gmail.com", "Cricket Australia"));
            mydb.insertEvent(new Event("David Warner","0227187649","Engineer","Rafael@gmail.com", "Engineering institute"));
            mydb.insertEvent(new Event("Muhammad Hasan","0448776529","Human Resources","Adam@gmail.com", "UNESCO"));
            events = mydb.getAllEvents();
        }

        EventAdapter adapter = new EventAdapter(
                this, R.layout.my_listview_item, events);


        ListView lv = (ListView) findViewById(R.id.listofstuff);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Event cbrevent = events.get(position);
                        Intent intent = new Intent(view.getContext(), EventActivity.class);
                        intent.putExtra("name", cbrevent.getName());
                        intent.putExtra("contact", cbrevent.getContact());
                        intent.putExtra("occupation", cbrevent.getOccupation());
                        intent.putExtra("mail", cbrevent.getMail());
                        intent.putExtra("id", cbrevent.getid());
                        intent.putExtra("company",cbrevent.getCompany());
                        startActivity(intent);
                    }
                });



    }

    public void gotoEvent_OCR(View v) {
        Intent intent = new Intent(this, EventOCR.class);
        startActivity(intent);
    }
}





