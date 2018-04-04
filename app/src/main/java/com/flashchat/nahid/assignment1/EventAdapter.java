package com.flashchat.nahid.assignment1;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flashchat.nahid.assignment1.Event;
import com.flashchat.nahid.assignment1.R;

import java.util.ArrayList;

/**
 * Created by nazmulhasan on 1/4/18.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    //ArrayList<Event> events;
    ArrayList<Event> events = new ArrayList<Event>();

    public EventAdapter(Context context, int resource, ArrayList<Event> objects) {
        super(context, resource, objects);
        events = objects;
    }



    public View getView(int position, View convertView, ViewGroup parent){

    //public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).
                inflate(R.layout.my_listview_item, parent, false);
    }
        Event event = events.get(position);
        // Event events = events.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        icon.setImageResource(R.drawable.contacts);

        TextView title = (TextView) convertView.findViewById(R.id.textViewTitle);
        title.setText(event.getName());

        if (position % 2 == 0){
        convertView.setBackgroundColor(Color.parseColor("#ccffff"));
    }else{
        convertView.setBackgroundColor(Color.parseColor("#ffffe6"));
    }
        return convertView;
}

    public static Bitmap convertByteArrayToBitmap(
            byte[] byteArrayToBeConvertedIntoBitMap)
    {
        return BitmapFactory.decodeByteArray(
                byteArrayToBeConvertedIntoBitMap, 0,
                byteArrayToBeConvertedIntoBitMap.length);
    }
}

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).
//                    inflate(R.layout.listviewitem, parent, false);
//        }
//
//        Event event = events.get(position);
//
//        ImageView icon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
//        icon.setImageResource(R.drawable.contacts);
//
//        TextView title = (TextView) convertView.findViewById(R.id.textViewTitle);
//        title.setText(event.getName());
//
//        if (position % 2 == 0) {
//            convertView.setBackgroundColor(Color.parseColor("#ccffff"));
//        } else {
//            convertView.setBackgroundColor(Color.parseColor("#ffffe6"));
//        }
//
//
//        return convertView;
//    }
//}
//
