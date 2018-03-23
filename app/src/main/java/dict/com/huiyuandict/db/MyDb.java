package dict.com.huiyuandict.db;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDb extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "textDb.sqlite";
    private static final int DATABASE_VERSION = 1;

    public MyDb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
}
