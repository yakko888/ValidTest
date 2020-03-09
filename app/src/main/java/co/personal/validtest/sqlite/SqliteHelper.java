package co.personal.validtest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.personal.validtest.model.Artist;
import co.personal.validtest.model.Picture;


@SuppressWarnings("WeakerAccess")
public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "valid_database";
    private static final String PATH = "/data/data/co.personal.valid/databases/";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SqliteHelper.class.getSimpleName();

    public SqliteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //  this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SqlitePicture.DB_PICTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SqlitePicture.DB_PICTURE);
        onCreate(db);
    }

    public boolean insertData(String table, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(table, null, values);
        if (result == -1) {
            Log.d(TAG, "Error al guardar los datos");
            return false;
        } else {
            Log.d(TAG, "datos guardados exitosamente");
            return true;
        }
    }

    public int getCountData() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT *from picture",null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count;
    }

    public boolean checkExistBdSqlite() {
        SQLiteDatabase checkDB = null;
        String database_path = PATH + DATABASE_NAME;
        try {
            checkDB = SQLiteDatabase.openDatabase(database_path, null, SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            //Log.e("Error", "No existe la base de datos " + .getMessage());
        }
        return checkDB != null;
    }

    public  ArrayList<Picture> getAllData() {

        ArrayList<Picture> datos = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT *from picture",null);
        if (cursor.moveToFirst()) {
            do {
                datos.add(new Picture(cursor.getString(1),
                        cursor.getString(2)));
            } while(cursor.moveToNext());
            cursor.close();

        }
        db.close();
        return datos;
    }
}
