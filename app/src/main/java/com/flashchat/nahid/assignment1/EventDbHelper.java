package com.flashchat.nahid.assignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by nazmulhasan on 1/4/18.
 */

public class EventDbHelper extends SQLiteOpenHelper{
    public static final String TABLE_NAME = "events";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CONTACT = "contact";
    public static final String COLUMN_OCCUPATION = "occupation";
    public static final String COLUMN_MAIL = "mail";
    public static final String COLUMN_COMPANY = "company";

    public EventDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                COLUMN_ID + " integer primary key, " +
                COLUMN_NAME + " text, " +
                COLUMN_CONTACT + " text, " +
                COLUMN_OCCUPATION + " text, " +
                COLUMN_COMPANY + "text, " +
                COLUMN_MAIL + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            Event event = new Event(
                    res.getString(res.getColumnIndex(COLUMN_NAME)),
                    res.getString(res.getColumnIndex(COLUMN_CONTACT)),
                    res.getString(res.getColumnIndex(COLUMN_OCCUPATION)),
                    res.getString(res.getColumnIndex(COLUMN_MAIL)),
                    res.getString(res.getColumnIndex(COLUMN_COMPANY))
            );
            event.setid(res.getString(res.getColumnIndex(COLUMN_ID)));
            eventList.add(event);
            res.moveToNext();
        }
        return eventList;
    }

    //        @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_db_helper);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
    public boolean insertEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, event.getName());
        contentValues.put(COLUMN_CONTACT, event.getContact());
        contentValues.put(COLUMN_OCCUPATION, event.getOccupation());
        contentValues.put(COLUMN_MAIL, event.getMail());
        contentValues.put(COLUMN_COMPANY,event.getCompany());
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }
    public Integer deleteEvent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ? ", new String[]{id});
    }



    public boolean updateEvent(String id, Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, event.getName());
        contentValues.put(COLUMN_CONTACT, event.getContact());
        contentValues.put(COLUMN_OCCUPATION, event.getOccupation());
        contentValues.put(COLUMN_MAIL, event.getMail());
        contentValues.put(COLUMN_COMPANY, event.getCompany());
        db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{id});
        return true;
    }








}



