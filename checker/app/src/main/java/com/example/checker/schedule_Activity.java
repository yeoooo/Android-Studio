package com.example.checker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;


public class schedule_Activity extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager llm;
    private RvAdapter adapter;
    private FloatingActionButton img_btn_addSchedule;
    private ArrayList<Ch_schedule> scheduleList;//Ch_schedule로 변경해야함
    private Ch_schedule schedule;

//    private void checkIntent(Intent intent){
//        Intent intent  = intent2;

//        if(s != null){
//                schedule = (Ch_schedule)intent.getSerializableExtra("schedule");
//            scheduleList.add(schedule);
//            if(schedule != null){
//                Toast.makeText(this, schedule.getSchedule_name(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        scheduleList = new ArrayList<>();

        rv = (RecyclerView) findViewById(R.id.rv);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        adapter = new RvAdapter(scheduleList);
        rv.setAdapter(adapter);

//        Intent intent = getIntent();
//        checkIntent(intent);





        fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(schedule_Activity.this, schedule_Management.class);
                        startActivityForResult(intent, 1000);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== 1000) {
            if (resultCode != Activity.RESULT_OK) {
                return;
            }
            Ch_schedule sc = (Ch_schedule)data.getSerializableExtra("scheduleData");
            scheduleList.add(sc);
            adapter.notifyDataSetChanged();
        }




    }


}
