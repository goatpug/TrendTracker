package sjk.trendtracker.db;

import android.provider.BaseColumns;

public final class DbContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContract() {}

    public static class Trend implements BaseColumns {
        public static final String TABLE_NAME = "trend";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TREND_ID = "trend_id";
        public static final String COLUMN_NAME_CREATED_AT = "created_at";
        public static final String COLUMN_NAME_MATCH = "match";
        public static final String COLUMN_NAME_COMMENT = "comment";
    }
}
