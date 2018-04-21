package com.example.dakshparekh.checkbox;


import android.widget.CheckBox;
import android.widget.TextView;

import java.util.zip.CheckedInputStream;

public class AttendanceViewHolder {

    private CheckBox checkedBox;
    private TextView textView;
    public AttendanceViewHolder(){
    }
    public AttendanceViewHolder(TextView textView, CheckBox checkBox){
        this.checkedBox = checkBox;
        this.textView = textView;
    }
    public CheckBox getCheckBox(){
        return checkedBox;
    }
    public void setCheckBox(CheckBox checkBox){
        this.checkedBox=checkBox;
    }
    public TextView getTextView(){
        return textView;
    }
    public void setTextView(TextView textView){
        this.textView = textView;
    }

}
