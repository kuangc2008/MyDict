package dict.com.huiyuandict.activity;

import com.squareup.sqlbrite.SqlBrite.Query;

import rx.functions.Func1;

final /* synthetic */ class TestActivity$$Lambda$1 implements Func1 {
    private static final TestActivity$$Lambda$1 instance = new TestActivity$$Lambda$1();

    private TestActivity$$Lambda$1() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return ((Query) obj).run();
    }
}
