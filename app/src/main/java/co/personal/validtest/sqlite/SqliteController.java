package co.personal.validtest.sqlite;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import co.personal.validtest.model.Artist;
import co.personal.validtest.model.Picture;

@SuppressWarnings("WeakerAccess")
public class SqliteController {

    private SqliteHelper sqliteHelper;
    Context context;

    public SqliteController(Context mContext){
        this.context = mContext;
        sqliteHelper = new SqliteHelper(context);
    }

    public int getDataExistSqlite() {
        return sqliteHelper.getCountData();
    }


    public boolean checkExistBDSqlite() {
        return sqliteHelper.checkExistBdSqlite();
    }

    public boolean saveToSqlite(List<Picture> data) {
        ContentValues values = new ContentValues();
        int i = 0;
        while (i < data.size()) {
            values.put(SqlitePicture.COL_PICTURE_NAME, data.get(i).getName());
            values.put(SqlitePicture.COL_PICTURE_IMAGE_URL, data.get(i).getImage());
            i = i + 1;
            sqliteHelper.insertData(SqlitePicture.TABLE_PICTURE, values);
        }

        if (i == data.size()) {
            return true;
        }
        return false;
    }

    public List getAllDataSqlite() {
        return sqliteHelper.getAllData();
    }
}

