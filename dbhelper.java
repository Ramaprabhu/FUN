package com.example.shiva.database;

/**
 * Created by Shiva on 9/26/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

public class dbhelper extends SQLiteOpenHelper{
    SQLiteDatabase db;
    public dbhelper(Context context){
        super(context, "Messages.db", null,1);
        db=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE ALBUM(MSG TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS ALBUM ");
        onCreate(db);
    }
    public void insert_album(String Song)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("MSG",Song);
        db.insert("ALBUM",null,contentvalues);
    }

    public Cursor list_album()
    {
        Cursor cursor=this.getReadableDatabase().rawQuery("SELECT * FROM ALBUM",null);
        return cursor;
    }
    public void delete_album()
    {

        db.execSQL("DELETE FROM ALBUM");

    }

}
