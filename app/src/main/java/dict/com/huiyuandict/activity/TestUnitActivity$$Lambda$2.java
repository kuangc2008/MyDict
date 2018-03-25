package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class TestUnitActivity$$Lambda$2 implements Func1 {
    private static final TestUnitActivity$$Lambda$2 instance = new TestUnitActivity$$Lambda$2();

    private TestUnitActivity$$Lambda$2() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return TestUnitActivity.lambda$initData$0((Cursor) obj);
    }
}
