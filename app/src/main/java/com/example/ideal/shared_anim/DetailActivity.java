package com.example.ideal.shared_anim;

import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String[] array= getIntent().getStringArrayExtra("array");

        RelativeLayout rl= (RelativeLayout)findViewById(R.id.layout);
        rl.setBackgroundColor(Color.parseColor(array[3]));

        TextView textView= (TextView)findViewById(R.id.heading);
        textView.setText(array[0]);
        TextView type= (TextView)findViewById(R.id.language);
        type.setText(array[1]);
        TextView desc=(TextView)findViewById(R.id.desc);
        desc.setText(array[2]);

    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }
}
