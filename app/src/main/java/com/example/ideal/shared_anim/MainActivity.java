package com.example.ideal.shared_anim;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


import java.util.ArrayList;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String[]> values = new ArrayList<String[]>();
        values.add(new String[]{"Android", "Java", getString(R.string.android),'#' + Integer.toHexString(getResources().getColor(R.color.colorAccent))});
        values.add(new String[]{"iOS", "Swift", getString(R.string.ios),'#' + Integer.toHexString(getResources().getColor(R.color.colorPrimary))});
        values.add(new String[]{"Xamarin", "C#",getString(R.string.xamarin),'#' + Integer.toHexString(getResources().getColor(R.color.colorPrimaryDark))});
        values.add(new String[]{"PhoneGap", "HTML CSS and JScript",getString(R.string.phonegap),'#' + Integer.toHexString(getResources().getColor(R.color.colorPrimary))});


        ListView listView = (ListView) findViewById(R.id.list_view);

       // CustomAdapter adapter = new CustomAdapter(this,values);
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("array",values.get(position));
                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                view,   // Starting view
                                transitionName    // The String
                        );

                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
    }
}
