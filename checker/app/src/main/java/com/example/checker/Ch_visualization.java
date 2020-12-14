package com.example.checker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class Ch_visualization extends AppCompatActivity {
    private LineChart lineChart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch_visualization);

        lineChart1 = (LineChart)findViewById(R.id.linechart1);

        List<Entry> entries1 =  new ArrayList<>();
        int i = 0;
        while (i <= 100){
            entries1.add(new Entry(i, i+i*i));
            i++;
        }

        LineDataSet lineDataSet1 = new LineDataSet(entries1, "온도");
        lineDataSet1.setLineWidth(2);
        lineDataSet1.setCircleRadius(2);
        lineDataSet1.setCircleColor(Color.parseColor("#FFFF0000"));
//        lineDataSet1.setCircleColorHole(Color.BLUE);
        lineDataSet1.setColor(Color.parseColor("#FFFFFF00"));
//        lineDataSet1.setDrawCircleHole(true);
        lineDataSet1.setDrawCircles(true);
        lineDataSet1.setDrawHorizontalHighlightIndicator(false);
        lineDataSet1.setDrawHighlightIndicators(false);
        lineDataSet1.setDrawValues(false);

        LineData lineData1 = new LineData(lineDataSet1);
        lineChart1.setData(lineData1);
    }

}