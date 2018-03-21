package com.example.amithasan.amitgpslocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGetLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetLoc=(Button)findViewById(R.id.btnGetLoc);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"permission not GRANTED",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        }
        btnGetLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GPStracker g=new GPStracker(getApplicationContext());
                Location l=g.getLocation();
                if (l!=null){
                    double lat=l.getLatitude();
                    double lon=l.getLongitude();
                    Toast.makeText(getApplicationContext(),"Lattitude:"+lat+"\n Longitude:"+lon,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
