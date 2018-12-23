package com.example.hp.navigationdraw;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    android.app.FragmentManager fragmentManager = getFragmentManager();
    ListView lv;
    View alwaysAppearingView;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=(ListView)findViewById(R.id.Plants);

        lv.setOnItemClickListener(this);

        ArrayList<String> arrayPlants = new ArrayList<>();
        arrayPlants.addAll(Arrays.asList(getResources().getStringArray(R.array.array_Plants)));


        adapter = new ArrayAdapter<>(
                Main2Activity.this, android.R.layout.simple_list_item_1,arrayPlants);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();
        lv.setEnabled(true);
        searchView.setQueryHint("Enter the name here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //lv.setEnabled(true);
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //we can do anything to get search result here.............................
                //Toast.makeText(getApplicationContext(),newText,Toast.LENGTH_SHORT).show();
                adapter.getFilter().filter(newText);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);

    }
    Fragment fragment=null;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i==0)
        {
            Intent intent=new Intent(view.getContext(),firstactivityplant.class);
            startActivity(intent);
        }
        if(i==1)
        {
            Intent intent=new Intent(view.getContext(),secondactivityplant.class);
            startActivity(intent);
        }
        if(i==2)
        {
            Intent intent=new Intent(view.getContext(),thirdactivityplant.class);
            startActivity(intent);
        }
        if(i==3)
        {
            Intent intent=new Intent(view.getContext(),fourthactivityplant.class);
            startActivity(intent);
        }
        if(i==4)
        {
            Intent intent=new Intent(view.getContext(),fifthactivityplant.class);
            startActivity(intent);
        }
    }
}
