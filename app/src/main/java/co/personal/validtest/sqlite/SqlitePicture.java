package co.personal.validtest.sqlite;

public class SqlitePicture {

    public static final String TABLE_PICTURE = "picture";
    public static final String COL_PICTURE_ID = " id";
    public static final String COL_PICTURE_NAME = " name";
    public static final String COL_PICTURE_IMAGE_URL = " Image";

    public static final String DB_PICTURE = "CREATE TABLE " + TABLE_PICTURE + "(" + COL_PICTURE_ID + " INTEGER PRIMARY KEY, " + COL_PICTURE_NAME + " TEXT, "
            + COL_PICTURE_IMAGE_URL + " TEXT " + ")";
}
