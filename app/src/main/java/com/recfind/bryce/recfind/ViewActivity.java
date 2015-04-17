package com.recfind.bryce.recfind;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;


public class ViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        RecItems currentItem = new RecItems();
        Intent intent = getIntent();
        String intentID = intent.getStringExtra("id");
        int id = Integer.parseInt(intentID);
        recContainer rC = (recContainer)getApplication();
        Vector<RecItems> RecList = new Vector<RecItems>();
        RecList = rC.getList();
        for(int i =0;i<RecList.size();i++){
            if(id == RecList.get(i).getID()){
                currentItem = RecList.get(i);
            }
        }
        TextView title = (TextView) findViewById(R.id.displayTitle);
        title.setText(currentItem.getTitle());
        TextView category = (TextView) findViewById(R.id.displayCategory);
        category.setText(currentItem.getCategory());
        TextView address = (TextView) findViewById(R.id.displayAddress);
        address.setText(currentItem.getAddress());
        TextView cost = (TextView) findViewById(R.id.displayCost);
        cost.setText(Double.toString(currentItem.getCost()));
        TextView hours = (TextView) findViewById(R.id.displayHours);
        hours.setText(currentItem.getHours());
        Vector<String> comments = new Vector<String>();
        comments = currentItem.getComments();
        String[] commentArray = new String[comments.size()];
        for(int i=0;i<comments.size();i++){
            String comment = comments.get(i);
            commentArray[i] = comment;
        }
        ArrayAdapter commentAdapter = new ArrayAdapter<String>(this, R.layout.listview, commentArray);
        ListView listView = (ListView)findViewById(R.id.commentsList);
        listView.setAdapter(commentAdapter);
    }

    public void onBackPressed() {
        Intent listActivity = new Intent(ViewActivity.this, ListActivity.class);
        startActivity(listActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
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
