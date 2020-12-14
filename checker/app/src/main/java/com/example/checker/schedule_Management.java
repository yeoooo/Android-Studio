package com.example.checker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class schedule_Management extends AppCompatActivity implements Serializable {

    EditText et_startDate;
    EditText et_endDate, et_scheduleName, et_scheduleCont;
    TimePicker alarmPicker;
    Button btn_back, btn_confirm;
    String hour,minute;
    RecyclerView rv;
    private LinearLayoutManager llm;
    private RvAdapter adapter;
    private ArrayList<Ch_schedule> scheduleList;
    RadioGroup rbg;


    public Ch_schedule create_Schedule(String schedule_name, String schedule_content, String schedule_startTime, String alarmTime, String schedule_endTime, boolean is_improve) {////각 정보를 입력하고 체크리스트에 추가

        Ch_schedule sc = new Ch_schedule(schedule_name.toString(), schedule_content.toString(), schedule_startTime.toString(), alarmTime, schedule_endTime.toString(), is_improve);
//        sc.setSchedule_name(schedule_name.toString());
//        sc.setSchedule_content(schedule_content.toString());
//        sc.setSchedule_startTime(schedule_startTime.toString());
//        sc.setAlarmTime(alarmTime.toString());
//        sc.setIs_improve(is_improve);
//        sc.setSchedule_endTime(schedule_endTime.toString());


        return sc;
    }

    public ArrayList get_ScList(){
        return scheduleList;
    }


    public void delete_Schedule(int index) {//일정 삭제
        if(scheduleList.isEmpty()) {
            System.out.print("지울 스케쥴이 존재하지 않습니다!");
        }else scheduleList.remove(index);
        System.out.print("삭제 완료");
    }

    public void modify_Schedule(int index, String contents, String st_Time, String end_Time, boolean is_improve) {
        get_schedule(index).schedule_content = contents;
        get_schedule(index).schedule_startTime = st_Time;
        get_schedule(index).schedule_endTime = end_Time;
        get_schedule(index).is_improve = is_improve;
    }//스케줄 수정

    public Ch_schedule get_schedule(int index) {//선택한 스케쥴을 반환

        return (Ch_schedule)scheduleList.get(index);

    }

    public ArrayList get_scheduleList(){return scheduleList;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule__management);
        alarmPicker = (TimePicker)findViewById(R.id.alarmPicker);
        et_scheduleName = (EditText)findViewById(R.id.scheduleName);
        et_scheduleCont = (EditText)findViewById(R.id.scheduleCont);
        et_endDate = (EditText)findViewById(R.id.et_endDate);
        et_startDate =(EditText)findViewById(R.id.et_startDate);
        alarmPicker = (TimePicker)findViewById(R.id.alarmPicker);
        btn_confirm = (Button)findViewById(R.id.btn_confirm);
        btn_back= (Button)findViewById(R.id.btn_back);
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(this);
        scheduleList = new ArrayList<>();
        rbg = (RadioGroup)findViewById(R.id.rbg);

        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = rbg.getCheckedRadioButtonId();

                Toast.makeText(schedule_Management.this, id+"", Toast.LENGTH_SHORT).show();

            }
        });


        adapter = new RvAdapter(scheduleList);

//        Toast.makeText(getApplicationContext(),rv.toString(), Toast.LENGTH_SHORT).show();



        final Calendar cal = Calendar.getInstance();

        et_startDate.setOnClickListener(new View.OnClickListener() {//시작 날짜
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(schedule_Management.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {


                        String msg = String.format("%d/%d/%d", year, month+1, date);
                        et_startDate.setText(msg);
//                        Toast.makeText(schedule_Management.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));


                dialog.show();

            }
        });

        et_endDate.setOnClickListener(new View.OnClickListener() {//종료 날짜
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(schedule_Management.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {


                        String msg = String.format("%d/%d/%d", year, month+1, date);
                        et_endDate.setText(msg);
//                        Toast.makeText(schedule_Management.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));


                dialog.show();

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = alarmPicker.getHour() + "";
            minute = alarmPicker.getMinute() + "";
        } else {
            hour = alarmPicker.getCurrentHour() + "";
            minute = alarmPicker.getCurrentMinute() + "";
        }
        alarmPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                Toast.makeText(getApplicationContext(),  hour + "시"+" " + min+ "분", Toast.LENGTH_LONG).show();

            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(schedule_Management.this, schedule_Activity.class);
                startActivity(intent);
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v) {
                //확인 버튼을 누르면 생성한 객체를 intent와 함께 날려줌

                Intent intent = new Intent(schedule_Management.this, schedule_Activity.class);

                Ch_schedule tempSchedule = create_Schedule(et_scheduleName.getText().toString(), et_scheduleCont.getText().toString(), et_startDate.getText().toString(),
                        hour+":"+minute, et_endDate.getText().toString(), false);

                intent.putExtra("scheduleData", tempSchedule);//인텐에 schedule 객체를 담아서 보냄
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}