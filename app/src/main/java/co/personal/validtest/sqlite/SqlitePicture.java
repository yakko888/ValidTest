package co.personal.validtest.sqlite;

public class SqlitePicture {

    public static final String TABLE_PICTURE = "picture";
    public static final String COL_USER_ID = " id";
    public static final String COL_USER_NAME = " name";
    public static final String COL_USER_IMAGE = " Image";

    public static final String DB_USER = "CREATE TABLE " + TABLE_PICTURE + "(" + COL_USER_ID + " INTEGER PRIMARY KEY, " + COL_USER_NAME + " TEXT, "
            + COL_USER_IMAGE + " BLOB " + ")";
}
