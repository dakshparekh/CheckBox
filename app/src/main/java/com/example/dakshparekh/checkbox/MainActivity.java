package com.example.dakshparekh.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    Button buttonok;
    private ListView m = null;
    private Attendance[] attendance = null;
    private ArrayAdapter<Attendance> listAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m =findViewById(R.id.mainListView);
        buttonok=findViewById(R.id.ok);

        buttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Attendance attendance = listAdapter.getItem(i);
                attendance.toggleChecked();
                AttendanceViewHolder viewHolder = (AttendanceViewHolder) view.getTag();
                viewHolder.getCheckBox().setChecked(attendance.isChecked());
            }
        });

        attendance = (Attendance[]) getLastNonConfigurationInstance();
        if(attendance==null){
            attendance = new Attendance[]{
                    new Attendance("70011016100"), new Attendance("70011015143"), new Attendance("70011015107")};

            }

           ArrayList<Attendance> saplist = new ArrayList<>();
           saplist.addAll(Arrays.asList(attendance));
            listAdapter = new AttendanceArrayAdapter(this, saplist);
           m.setAdapter(listAdapter);
        }
        public Object onRetainNonConfigurationInstance(){
        return attendance;
    }
}
