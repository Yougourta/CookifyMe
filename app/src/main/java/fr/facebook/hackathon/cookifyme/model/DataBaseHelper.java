package fr.facebook.hackathon.cookifyme.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String TAG="DataBaseHelper";
    public static final String DATABASE_NAME = "ingredients.db";
    public static final String TABLE_NAME = "ingridient";
    public static final String NAME_COLUMN = "name";
    public static final String IMAGEURL_COLUMN = "imageUrl";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE "+ TABLE_NAME + "(name TEXT PRIMARY KEY, imageUrl TEXT)"

        );
        Log.d(TAG, "onCreate: done");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: called");
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
        this.onCreate(db);
    }

    /*
    Insert example:

        if(!dataBase.insertIngredient("Apple", "foo")){
            Log.d(TAG, "onCreate: Failed to insert");
        }

    */
    public boolean insertIngredient(String name, String imageUrl){
        Log.d(TAG, "insertIngredient: started");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME_COLUMN, name);
        contentValues.put(IMAGEURL_COLUMN, imageUrl);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result!= -1){
            return true;
        }else{
            return false;
        }

    }

    public void deleteDB(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
    }


    /*
    *  Get all example
    *  Cursor c = dataBase.getAllData();
        if(c.getCount() == 0){
            Log.d(TAG, "onCreate: Nothing in the table");
        }else{
            StringBuffer buffer = new StringBuffer();
            while(c.moveToNext()){
                buffer.append("Name: "+c.getString(0)+"/n");
                buffer.append("URL: "+c.getString(1)+"/n/n");
            }
           System.out.println(buffer.toString());
        }
    *
    * */
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        return res;
    }
}
