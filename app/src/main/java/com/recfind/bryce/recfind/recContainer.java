package com.recfind.bryce.recfind;

import android.app.Application;

import java.util.Vector;

/**
 * Created by Bryce on 4/8/2015.
 */
public class recContainer extends Application {
    private Vector<RecItems> recList;



    public Vector getList(){
        return this.recList;
    }
    public void setList(Vector v){
        recList = v;
    }
    public void addRecItem(RecItems r){
        this.recList.add(r);
    }

}
