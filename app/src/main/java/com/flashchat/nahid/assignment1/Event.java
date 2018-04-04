package com.flashchat.nahid.assignment1;

/**
 * Created by nazmulhasan on 1/4/18.
 */

public class Event {

    String name;
    String contact;
    String occupation;
    String id;
    String company;
    String mail;

    public Event(String name, String contact, String occuation, String mail, String company) {
        this.name = name;
        this.contact = contact;
        this.occupation = occuation;
        this.company = company;
        this.mail = mail;
    }

    public String getName(){
        return this.name;
    }

    public String getContact(){
        return this.contact;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getMail(){
        return this.mail;
    }

    public String getid(){
        return this.id;
    }

    public String getCompany() { return this.company;

    }
    public void setid(String id)
    {
        this.id = id;
    }

    public String toString(){
        return name;
    }
}
