package com.example.amithasan.amitnetworkbasedlocation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init1();
    }

    public Button btnstart;

    public void init1()
    {
        btnstart=(Button)findViewById(R.id.button1);
        btnstart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toy= new Intent(HomeActivity.this,MapsActivity.class);
                startActivity(toy);
            }
        });

    }
}
