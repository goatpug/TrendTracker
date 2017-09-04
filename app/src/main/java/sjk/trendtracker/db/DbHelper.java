package sjk.trendtracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TrendTracker.db";

    private static final String SQL_CREATE_TREND_TABLE =
            "CREATE TABLE " + DbContract.Trend.TABLE_NAME + " (" +
                    DbContract.Trend._ID + " INTEGER PRIMARY KEY," +
                    DbContract.Trend.COLUMN_NAME_NAME + " TEXT)";

    private static final String SQL_DELETE_TREND_TABLE =
            "DROP TABLE IF EXISTS " + DbContract.Trend.TABLE_NAME;

    private static final String SQL_CREATE_ENTRY_TABLE =
            "CREATE TABLE " + DbContract.Entry.TABLE_NAME + " (" +
                    DbContract.Entry._ID + " INTEGER PRIMARY KEY," +
                    DbContract.Entry.COLUMN_NAME_TREND_ID + " INTEGER," +
                    DbContract.Entry.COLUMN_NAME_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    DbContract.Entry.COLUMN_NAME_MATCH + " INTEGER," +
                    DbContract.Entry.COLUMN_NAME_COMMENT + " TEXT)";

    private static final String SQL_DELETE_ENTRY_TABLE =
            "DROP TABLE IF EXISTS " + DbContract.Entry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TREND_TABLE);
        db.execSQL(SQL_CREATE_ENTRY_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
//        onCreate(db);
    }
}
