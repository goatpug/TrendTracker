package sjk.trendtracker.db;

import android.provider.BaseColumns;

import static sjk.trendtracker.db.DbContract.EntryContract.COLUMN_NAME_COMMENT;
import static sjk.trendtracker.db.DbContract.EntryContract.COLUMN_NAME_CREATED_AT;
import static sjk.trendtracker.db.DbContract.EntryContract.COLUMN_NAME_MATCH;
import static sjk.trendtracker.db.DbContract.EntryContract.COLUMN_NAME_TREND_ID;

public final class DbContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContract() {}

    public static class TrendContract implements BaseColumns {
        public static final String TABLE_NAME = "trend";
        public static final String COLUMN_NAME_NAME = "name";

        public static final String[] ALL_COLUMNS = {
                _ID,
                COLUMN_NAME_NAME
        };
    }

    public static class EntryContract implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TREND_ID = "trend_id";
        public static final String COLUMN_NAME_CREATED_AT = "created_at";
        public static final String COLUMN_NAME_MATCH = "match";
        public static final String COLUMN_NAME_COMMENT = "comment";

        public static final String[] ALL_COLUMNS = {
                _ID,
                COLUMN_NAME_TREND_ID,
                COLUMN_NAME_MATCH,
                COLUMN_NAME_CREATED_AT,
                COLUMN_NAME_COMMENT
        };
    }
}
