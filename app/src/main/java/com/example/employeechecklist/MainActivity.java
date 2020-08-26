package com.example.employeechecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lstEmployee;
    EmployeeAdapter employeeAdapter;
    List<EmployeeData> employeeDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstEmployee = findViewById(R.id.lstEmployee);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<EmployeeData>> call = api.getEmployeeDetails();
        call.enqueue(new Callback<List<EmployeeData>>() {
            @Override
            public void onResponse(Call<List<EmployeeData>> call, Response<List<EmployeeData>> response) {
                if(response != null){
                    employeeDataList = response.body();
                    if(employeeDataList != null){
                        employeeAdapter=new EmployeeAdapter(getApplicationContext(),R.layout.list_row,employeeDataList);
                        lstEmployee.setAdapter(employeeAdapter);
                    } else {
                        Toast.makeText(getApplicationContext(),"employeeDataList is null",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"response is null",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeData>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        lstEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "selectedItem" + i, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), EmployeeDetailsActivity.class);
                String itemValue = (String) lstEmployee.getItemAtPosition(i);
                intent.putExtra("SelectedItem",itemValue);
                startActivity(intent);
            }
        });
    }

}