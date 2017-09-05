package sjk.trendtracker.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TrendTracker.db";

    private static final String SQL_CREATE_TREND_TABLE =
            "CREATE TABLE " + DbContract.TrendContract.TABLE_NAME + " (" +
                    DbContract.TrendContract._ID + " INTEGER PRIMARY KEY," +
                    DbContract.TrendContract.COLUMN_NAME_NAME + " TEXT)";

    private static final String SQL_CREATE_ENTRY_TABLE =
            "CREATE TABLE " + DbContract.EntryContract.TABLE_NAME + " (" +
                    DbContract.EntryContract._ID + " INTEGER PRIMARY KEY," +
                    DbContract.EntryContract.COLUMN_NAME_TREND_ID + " INTEGER," +
                    DbContract.EntryContract.COLUMN_NAME_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP," +
                    DbContract.EntryContract.COLUMN_NAME_MATCH + " INTEGER," +
                    DbContract.EntryContract.COLUMN_NAME_COMMENT + " TEXT)";

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
