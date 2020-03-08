package co.personal.validtest.sqlite;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class SqliteController {

    private SqliteHelper sqliteHelper;
    Context context;

    public SqliteController(Context mContext){
        this.context = mContext;
        sqliteHelper = new SqliteHelper(context);
    }

    public boolean saveImage(String name, byte[] image){
        ContentValues values = new ContentValues();
        values.put(SqlitePicture.COL_USER_NAME,     name);
        values.put(SqlitePicture.COL_USER_IMAGE,     image);

        return sqliteHelper.insertData(SqlitePicture.TABLE_PICTURE, values);
    }


}

