package dict.com.huiyuandict.activity;

import com.squareup.sqlbrite.SqlBrite.Query;

import rx.functions.Func1;

final /* synthetic */ class YilanFragment$$Lambda$9 implements Func1 {
    private static final YilanFragment$$Lambda$9 instance = new YilanFragment$$Lambda$9();

    private YilanFragment$$Lambda$9() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return ((Query) obj).run();
    }
}
