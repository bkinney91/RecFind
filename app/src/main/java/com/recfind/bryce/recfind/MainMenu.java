package com.recfind.bryce.recfind;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Vector;


public class MainMenu extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Initialize RecList with test data
        recContainer rC = (recContainer)getApplication();
        Vector<RecItems> RecList = new Vector<RecItems>();
        //RecList = rC.getList();
        if(rC.getList() == null) {
            RecItems tempItem = new RecItems();
            tempItem.addTitle("Basketball");
            tempItem.addAddress("123 Fake Street");
            tempItem.addCategory("Sports");
            tempItem.addCost(0.0);
            tempItem.addID(1);
            tempItem.addComment("Nice place to play basketball, has water fountains and lights at night");
            tempItem.addComment("Lots of pick up games on weekends");
            tempItem.addHours("Monday thru Saturday 8am to 10pm");
            RecList.add(tempItem);
            rC.setList(RecList);
        }
        ImageButton viewButton = (ImageButton)findViewById(R.id.view);
        viewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent listIntent = new Intent(MainMenu.this, ListActivity.class);
                startActivity(listIntent);
                finish();
            }
        });
        ImageButton addButton = (ImageButton)findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View z){
                Intent addIntent = new Intent(MainMenu.this, AddActivity.class);
                startActivity(addIntent);
                finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
