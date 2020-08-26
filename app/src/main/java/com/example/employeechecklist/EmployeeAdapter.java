package com.example.employeechecklist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<EmployeeData> {
    List<EmployeeData> employeeList;
    Context context;
    int resource;

    public EmployeeAdapter(@NonNull Context context, int resource, List<EmployeeData> employeeList) {
        super(context, resource, employeeList);
        this.context = context;
        this.resource = resource;
        this.employeeList = employeeList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_row,null,true);
        }
        EmployeeData employeeList=getItem(position);
        ImageView imgProfile=(ImageView)convertView.findViewById(R.id.imgProfile);
        TextView textViewName=(TextView)convertView.findViewById(R.id.txtName);
        TextView textViewCompanyName=(TextView)convertView.findViewById(R.id.txtCompanyName);
        Glide.with(context).load(employeeList.getProfileImage()).into(imgProfile);
        textViewName.setText(employeeList.getName());
        if(employeeList.getCompany() != null) {
            textViewCompanyName.setText(employeeList.getCompany().getName());
        } else {
            textViewCompanyName.setText("Nil");
        }
        return convertView;
    }

}
