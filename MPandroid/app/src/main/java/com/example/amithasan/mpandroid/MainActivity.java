package com.example.amithasan.mpandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LineChart lineChart;
    Button btn;
    EditText valueY;
    ArrayList<Entry> yData=new ArrayList<>();
    ArrayList<String> xData=new ArrayList<>();
    int i=0,x=0;
    String xd="x"+0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        btn=(Button)findViewById(R.id.updatebtn);
        valueY=(EditText)findViewById(R.id.yValues);

        lineChart =(LineChart)findViewById(R.id.line_chart);

        drawLineChart(0,xd);

        setSupportActionBar(toolbar);

    }

    public void drawLineChart(int yValues,String xValues){


            yData.add(new Entry(yValues,i));

            xData.add(xValues);


        //ArrayList<ILineDataSet> lineDataSet = new ArrayList<>();
        LineDataSet lineDataSet = new LineDataSet(yData,"Y data");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawCubic(true);
        lineDataSet.setDrawValues(true);

        LineData lineData=new LineData(xData,lineDataSet);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }
    public void btnClick(View view){
        int y=Integer.parseInt(valueY.getText().toString().trim());
        xd="x"+x;
        drawLineChart(y,xd);
        i++;
        x=x+5;
    }

}
