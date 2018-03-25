package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class YilanFragment$$Lambda$15 implements Func1 {
    private static final YilanFragment$$Lambda$15 instance = new YilanFragment$$Lambda$15();

    private YilanFragment$$Lambda$15() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return YilanFragment.lambda$query2$10((Cursor) obj);
    }
}
