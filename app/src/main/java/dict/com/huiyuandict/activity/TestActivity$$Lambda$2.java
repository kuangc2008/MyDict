package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class TestActivity$$Lambda$2 implements Func1 {
    private final TestActivity arg$1;

    private TestActivity$$Lambda$2(TestActivity testActivity) {
        this.arg$1 = testActivity;
    }

    public static Func1 lambdaFactory$(TestActivity testActivity) {
        return new TestActivity$$Lambda$2(testActivity);
    }

    public Object call(Object obj) {
        return TestActivity.lambda$onCreate$0(this.arg$1, (Cursor) obj);
    }
}
