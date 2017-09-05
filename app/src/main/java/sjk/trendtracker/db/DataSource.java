package sjk.trendtracker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;

import java.util.ArrayList;
import java.util.List;

import sjk.trendtracker.db.model.Trend;

public class DataSource {
    // Database fields
    private SQLiteDatabase mDatabase;
    private DbHelper mDbHelper;

    public DataSource(Context context) {
        mDbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public Trend createTrend(String name) {
        ContentValues values = new ContentValues();
        values.put(DbContract.TrendContract.COLUMN_NAME_NAME, name);
        long insertId = mDatabase.insert(DbContract.TrendContract.TABLE_NAME, null,
                values);
        Cursor cursor = mDatabase.query(DbContract.TrendContract.TABLE_NAME,
                DbContract.TrendContract.ALL_COLUMNS,
                DbContract.TrendContract._ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Trend newTrend = cursorToTrend(cursor);
        cursor.close();
        return newTrend;
    }

    public void deleteTrend(Trend trend) {
        long id = trend.getId();
        System.out.println("Trend deleted with id: " + id);
        mDatabase.delete(DbContract.TrendContract.TABLE_NAME, DbContract.TrendContract._ID
                + " = " + id, null);
    }

    public List<Trend> getAllTrends() {
        List<Trend> trends = new ArrayList<>();

        Cursor cursor = mDatabase.query(DbContract.TrendContract.TABLE_NAME,
                DbContract.TrendContract.ALL_COLUMNS,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Trend trend = cursorToTrend(cursor);
            trends.add(trend);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return trends;
    }

    private Trend cursorToTrend(Cursor cursor) {
        Trend trend = new Trend();
        trend.setId(cursor.getInt(0));
        trend.setName(cursor.getString(1));
        return trend;
    }

    public void deleteAll() {
        mDatabase.delete(DbContract.EntryContract.TABLE_NAME, null, null);
        mDatabase.delete(DbContract.TrendContract.TABLE_NAME, null, null);
    }
}
