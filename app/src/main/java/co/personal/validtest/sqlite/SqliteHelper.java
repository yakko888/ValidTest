package co.personal.validtest.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


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
        /*db.execSQL(SqlitePicture.DB_USER);*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

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
}
