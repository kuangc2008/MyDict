package dict.com.huiyuandict.activity;

import java.util.List;

import rx.functions.Action1;

final /* synthetic */ class TestActivity$$Lambda$3 implements Action1 {
    private final TestActivity arg$1;

    private TestActivity$$Lambda$3(TestActivity testActivity) {
        this.arg$1 = testActivity;
    }

    public static Action1 lambdaFactory$(TestActivity testActivity) {
        return new TestActivity$$Lambda$3(testActivity);
    }

    public void call(Object obj) {
        TestActivity.lambda$onCreate$1(this.arg$1, (List) obj);
    }
}
