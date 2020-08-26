package com.example.employeechecklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase extends SQLiteOpenHelper {
    private static final String TAG = EmployeeDatabase.class.getCanonicalName();
    public EmployeeDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(Constants.CREATE_TABLE_QUERY);
        } catch (Exception ex){
            Log.d(TAG,ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_QUERY);
        this.onCreate(sqLiteDatabase);
    }

    public void addEmployeeData(EmployeeData employeeData){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.ID,employeeData.getId());
        contentValues.put(Constants.NAME,employeeData.getName());
        contentValues.put(Constants.USER_NAME,employeeData.getUsername());
        contentValues.put(Constants.EMAIL,employeeData.getEmail());
        contentValues.put(Constants.PROFILE_IMAGE,employeeData.getProfileImage());
        contentValues.put(Constants.STREET,employeeData.getAddress().getStreet());
        contentValues.put(Constants.SUITE,employeeData.getAddress().getSuite());
        contentValues.put(Constants.CITY,employeeData.getAddress().getCity());
        contentValues.put(Constants.ZIP_CODE,employeeData.getAddress().getZipcode());
        contentValues.put(Constants.PHONE,employeeData.getPhone());
        contentValues.put(Constants.WEBSITE,employeeData.getWebsite());
        contentValues.put(Constants.COMPANY_NAME,employeeData.getCompany().getName());

        sqLiteDatabase.insert(Constants.TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();

    }

    public List<EmployeeData> getEmployeeCheckList(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(Constants.SELECT_EMPLOYEE_LIST_QUERY,null);
        List<EmployeeData> employeeDataList = new ArrayList<>();
        if(cursor.getCount() > 0){
            if(cursor.moveToFirst()){
                do {
                    EmployeeData employeeData = new EmployeeData();
                    employeeData.setName(cursor.getColumnName(cursor.getColumnIndex(Constants.DB_NAME)));
                    employeeDataList.add(employeeData);
                } while(cursor.moveToNext());
            }
        }
        return employeeDataList;
    }

}
