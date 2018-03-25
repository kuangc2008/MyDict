package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class YilanFragment$$Lambda$20 implements Func1 {
    private static final YilanFragment$$Lambda$20 instance = new YilanFragment$$Lambda$20();

    private YilanFragment$$Lambda$20() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return YilanFragment.lambda$query1$13((Cursor) obj);
    }
}
