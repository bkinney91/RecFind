package com.recfind.bryce.recfind;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;

import java.util.Vector;

public class ListActivity extends ActionBarActivity {
    Vector<RecItems> list = new Vector<RecItems>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.show();
        recContainer rC = (recContainer)getApplication();
        Vector<RecItems> RecList = new Vector<RecItems>();
        RecList = rC.getList();
        String[] titleArray = new String[RecList.size()];
        for(int i=0;i<RecList.size();i++){
            RecItems temp = (RecItems)RecList.get(i);
            String title = temp.getTitle();
            titleArray[i] = title;
            Log.w("title Array init:",title);
        }

        ArrayAdapter recAdapter = new ArrayAdapter<String>(this, R.layout.listview, titleArray);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(recAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                recContainer rC = (recContainer)getApplication();
                Vector<RecItems> list3 = new Vector<RecItems>();
                list3 = rC.getList();
                int selectID = list3.get(position).getID();
                String message = Integer.toString(selectID);
                Intent intent = new Intent(ListActivity.this, ViewActivity.class);
                intent.putExtra("id", message);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainMenuIntent = new Intent(ListActivity.this, MainMenu.class);
        startActivity(mainMenuIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu_list, menu);
        return true;
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_list, menu);
        //return super.onCreateOptionsMenu(menu);
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
