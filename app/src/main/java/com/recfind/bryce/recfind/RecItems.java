package com.recfind.bryce.recfind;

import android.graphics.drawable.Drawable;
import android.widget.RatingBar;

import java.util.Vector;

/**
 * Created by Bryce on 4/7/2015.
 */
public class RecItems {
    String title = "Title";
    String address = "123 Fake Street";
    RatingBar recRating;
    String category;
    Double cost;
    String hours;
    Vector<String> comments = new Vector<String>();
    Vector<Drawable> photos = new Vector<Drawable>();
    int id;

    public void addTitle(String s){
        title = s;
    }

    public void addAddress(String s){
        address = s;
    }

    public void addCategory(String s){
        category = s;
    }
    public void addCost(Double d){
        cost = d;
    }
    public void addPhotos(Drawable a){
        photos.add(a);
    }
    public void addHours(String s){ hours = s;}
    public void addID(int i){ id = i;}
    public RecItems getItem(){
        return this;
    }
    public String getTitle(){
        return this.title;
    }
    public int getID(){
        return id;
    }
    public String getAddress(){ return address;}
    public String getCategory(){ return category;}
    public String getHours(){ return hours;}
    public Vector getComments(){ return comments;}
    public void addComment(String s) {this.comments.add(s);}
    public double getCost(){ return cost;}

}
