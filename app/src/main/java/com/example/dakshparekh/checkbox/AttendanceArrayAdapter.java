package com.example.dakshparekh.checkbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class AttendanceArrayAdapter extends ArrayAdapter<Attendance> {

    CheckBox checkBox;
    TextView textView;
    private LayoutInflater inflater;

    public AttendanceArrayAdapter(Context context, List<Attendance> attendanceList) {
        super(context, R.layout.simplerow, R.id.rowTextView, attendanceList);
        inflater = LayoutInflater.from(context);
    }
    public View getview(int position, View convertView, ViewGroup parent){
        Attendance attendance = (Attendance) this.getItem(position);
        CheckBox checkBox;
        TextView textView;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.simplerow, null);
            textView = convertView.findViewById(R.id.rowTextView);
            checkBox = convertView.findViewById(R.id.checkbox01);

            convertView.setTag(new AttendanceViewHolder(textView, checkBox));
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Attendance attendance = (Attendance) cb.getTag();
                    attendance.setChecked(cb.isChecked());

                }
            });
        }
         else{
            AttendanceViewHolder viewHolder = (AttendanceViewHolder) convertView.getTag();
            checkBox=viewHolder.getCheckBox();
            textView=viewHolder.getTextView();
        }
        checkBox.setTag(attendance);

        checkBox.setChecked(attendance.isChecked());
        textView.setText(attendance.getName());
        return convertView;

        }
}


