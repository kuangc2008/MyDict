package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class YilanFragment$$Lambda$10 implements Func1 {
    private static final YilanFragment$$Lambda$10 instance = new YilanFragment$$Lambda$10();

    private YilanFragment$$Lambda$10() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return YilanFragment.lambda$query3$7((Cursor) obj);
    }
}
