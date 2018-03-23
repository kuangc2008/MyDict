package dict.com.huiyuandict.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import net.nashlegend.anypref.AnyPref;

import dict.com.huiyuandict.data.Book;
import dict.com.huiyuandict.data.Conf;


public class Cet extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "cet4-1.sqlite";
    private static final int DATABASE_VERSION = 1;

    public Cet(Context context) {
        super(context, getStr(context), null, 1);
    }

    public static String getStr(Context cOntext) {
        Debug.waitForDebugger();
        String str;
        if (((Conf) AnyPref.get(Conf.class)).getBooks() == null) {
            str = DATABASE_NAME;
        } else {
            str = ((Book) ((Conf) AnyPref.get(Conf.class)).getBooks().get(((Conf) AnyPref.get(Conf.class)).getSelectId())).getId();
        }
        return str;
    }


}
