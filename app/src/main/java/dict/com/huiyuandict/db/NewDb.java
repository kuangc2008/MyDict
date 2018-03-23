package dict.com.huiyuandict.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NewDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cet6-3.sqlite";
    private static final int DATABASE_VERSION = 1;

    public NewDb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"words\"\n(\n    item0 INTEGER,\n    item1 INTEGER,\n    part VARCHAR,\n    unit INTEGER,\n    error VARCHAR,\n    shunxu INTEGER,\n    word VARCHAR,\n    yinbiao VARCHAR,\n    phonetic VARCHAR,\n    shuoming VARCHAR,\n    shuoming2 VARCHAR,\n    shuoming3 VARCHAR,\n    xuexi VARCHAR,\n    bianxing VARCHAR,\n    tongyici VARCHAR,\n    fanyici VARCHAR,\n    liju1en VARCHAR,\n    liju1cn VARCHAR,\n    liju2en VARCHAR,\n    liju2cn VARCHAR,\n    liju3en VARCHAR,\n    liju3cn VARCHAR,\n    changyongduanyu VARCHAR,\n    yingyingshiyi VARCHAR,\n    xiangxishuoming VARCHAR\n)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
