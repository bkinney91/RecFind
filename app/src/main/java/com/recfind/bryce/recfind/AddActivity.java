package com.recfind.bryce.recfind;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Vector;


public class AddActivity extends ActionBarActivity {
    private String[] options;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Spinner categories = (Spinner)findViewById(R.id.categories);
        this.options = new String[] {
                "Sports","Hiking","Camping","Motorcycling", "Racing", "Photography",
                "Skateboarding","Surfing","Bicycling","Shooting","Parks","Leisure"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        categories.setAdapter(adapter);

        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View z){
                recContainer rC = (recContainer)getApplication();
                Vector<RecItems> RecList = new Vector<RecItems>();
                RecList = rC.getList();
                RecItems tempItem = new RecItems();
                EditText title = (EditText)findViewById(R.id.titleInput);
                tempItem.addTitle(title.getText().toString());
                EditText address = (EditText)findViewById(R.id.addressInput);
                tempItem.addAddress(address.getText().toString());
                EditText cost = (EditText)findViewById(R.id.costInput);
                String costText = cost.getText().toString();
                tempItem.addCost(Double.parseDouble(costText));
                EditText hours = (EditText)findViewById(R.id.hoursInput);
                tempItem.addHours(hours.getText().toString());
                Intent mainMenuIntent = new Intent(AddActivity.this, MainMenu.class);
                Spinner categories = (Spinner)findViewById(R.id.categories);
                String category = categories.getSelectedItem().toString();
                tempItem.addCategory(category);
                RecList.add(tempItem);
                rC.setList(RecList);
                startActivity(mainMenuIntent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainMenuIntent = new Intent(AddActivity.this, MainMenu.class);
        startActivity(mainMenuIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);

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
