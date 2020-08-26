package com.example.employeechecklist;

public class Constants {
    public static final String DB_NAME = "EmployeeChecklist";
    public static final String TABLE_NAME = "Employee";
    public static final int DB_VERSION = 1;

    public static final String DROP_QUERY = "DROP TABLE IF EXIST " + TABLE_NAME;

    public static final String SELECT_EMPLOYEE_LIST_QUERY = "SELECT * FROM " + TABLE_NAME;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String USER_NAME = "userName";
    public static final String EMAIL = "email";
    public static final String PROFILE_IMAGE = "profileImage";
    public static final String STREET = "street";
    public static final String SUITE = "suite";
    public static final String CITY = "city";
    public static final String ZIP_CODE = "zipCode";
    public static final String PHONE = "phone";
    public static final String WEBSITE = "website";
    public static final String COMPANY_NAME = "companyName";


    public static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "" +
            "(" + ID + " INTEGER PRIMARY KEY," +
            NAME + " TEXT not null," +
            USER_NAME + " TEXT not null," +
            EMAIL + " TEXT not null," +
            PROFILE_IMAGE + " TEXT not null," +
            STREET + " TEXT not null," +
            SUITE + " TEXT not null," +
            CITY + " TEXT not null," +
            ZIP_CODE + " TEXT not null," +
            PHONE + " TEXT not null," +
            WEBSITE + " TEXT not null," +
            COMPANY_NAME + " TEXT not null)";

}
