package com.ss.eictapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StudentHelper extends SQLiteOpenHelper {
    Context c;
    String sql="create table if not exists "+StudentContact.TABLE_NAME+"" +
            " ( " +StudentContact.ID +" integer primary key , "+StudentContact.NAME+
            " varchar , " +StudentContact.AGE+
            " integer , " +StudentContact.ADDRESS+
            " varchar , " +StudentContact.BRANCH+
            " varchar )";

    public StudentHelper(@Nullable Context context) {
        super(context, StudentContact.DB_NAME, null, StudentContact.DB_VERSION);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        Toast.makeText(c, "Table Created", Toast.LENGTH_SHORT).show();
    }

    public Cursor getRecord(SQLiteDatabase db)
    {
        String data[]={StudentContact.ID, StudentContact.NAME, StudentContact.AGE, StudentContact.ADDRESS, StudentContact.BRANCH};
        Cursor cursor=db.query(StudentContact.TABLE_NAME, data, null, null, null, null, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public long addStudent(SQLiteDatabase db, int id, String name, int age, String address, String branch)
    {
        ContentValues c=new ContentValues();
        c.put(StudentContact.ID, id);
        c.put(StudentContact.NAME, name);
        c.put(StudentContact.AGE, age);
        c.put(StudentContact.ADDRESS, address);
        c.put(StudentContact.BRANCH, branch);
        return db.insert(StudentContact.TABLE_NAME, null, c);
    }
}
