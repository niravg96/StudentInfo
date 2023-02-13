package com.example.studentinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static  final String DATABASE_NAME = "STUDENT.db";
    public static final String TABLE_NAME = "STUDENT_INFO";
    public static final String columnID ="user_id";
    public static final String columnname ="s_name";
    public static final String columnsurname ="s_surname";
    public static final String columnage ="s_age";
    public static final String columndob ="s_dob";
    public static final String columnmcity ="s_city";
    public static final String columnstate ="s_state";
    public static final String columndegree ="s_degree";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"(" + columnID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + columnname + " TEXT, " + columnsurname + " TEXT, " + columnage + " TEXT, " + columndob + " TEXT, " + columnmcity + " TEXT, " + columnstate + " TEXT, " + columndegree + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean insertdata(String name,String surname,String age,String dob,String city,String state,String degree)
    {
            try
            {
                SQLiteDatabase db= this.getWritableDatabase();
                ContentValues cv =new ContentValues();
                cv.put(columnname,name);
                cv.put(columnsurname,surname);
                cv.put(columnage,age);
                cv.put(columndob,dob);
                cv.put(columnmcity,city);
                cv.put(columnstate,state);
                cv.put(columndegree,degree);

                long result  = db.insert(TABLE_NAME,null,cv);
                if(result == -1)
                {
                    return false;
                }
                else
                {
                    return true;
                }

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                return  false;
            }
    }
    public ArrayList<StudentModel> getAllStudentData()
    {
        ArrayList<StudentModel>list = new ArrayList<>();
        String SQL = "SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst())
        {
            do{
                StudentModel studentModel = new StudentModel();
                studentModel.setId(cursor.getString(0));
                studentModel.setName(cursor.getString(1));
                studentModel.setSurname(cursor.getString(2));
                studentModel.setAge(cursor.getString(3));
                studentModel.setDob(cursor.getString(4));
                studentModel.setCity(cursor.getString(5));
                studentModel.setState(cursor.getString(6));
                studentModel.setDegree(cursor.getString(7));
                list.add(studentModel);
            }while (cursor.moveToNext());
        }
        return list;
    }
    public void deleterecord(String id)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        db.delete(TABLE_NAME,"user_id=?",new String[]{id});
        db.close();
    }
    public void updaterecord(String id,String name_data,String surname_data,String age_data,String dob_data,String city_data,String state_data,String degree_data)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(columnname,name_data);
        cv.put(columnsurname,surname_data);
        cv.put(columnage,age_data);
        cv.put(columndob,dob_data);
        cv.put(columnmcity,city_data);
        cv.put(columnstate,state_data);
        cv.put(columndegree,degree_data);
        db.update(TABLE_NAME,cv,"user_id=?",new String[]{id});
        db.close();

    }
}
