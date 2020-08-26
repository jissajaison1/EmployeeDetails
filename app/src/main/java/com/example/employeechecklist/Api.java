package com.example.employeechecklist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL ="https://www.mocky.io/v2/";

    @GET("5d565297300000680030a986")
    Call<List<EmployeeData>> getEmployeeDetails();

}
