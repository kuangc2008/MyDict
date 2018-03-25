package dict.com.huiyuandict.activity;

import rx.functions.Action1;

final /* synthetic */ class TestActivity$$Lambda$4 implements Action1 {
    private static final TestActivity$$Lambda$4 instance = new TestActivity$$Lambda$4();

    private TestActivity$$Lambda$4() {
    }

    public static Action1 lambdaFactory$() {
        return instance;
    }

    public void call(Object obj) {
        ((Throwable) obj).printStackTrace();
    }
}
