package dict.com.huiyuandict.activity;

import java.util.List;

import rx.functions.Action1;

final /* synthetic */ class TestUnitActivity$$Lambda$3 implements Action1 {
    private final TestUnitActivity arg$1;
    private final List arg$2;

    private TestUnitActivity$$Lambda$3(TestUnitActivity testUnitActivity, List list) {
        this.arg$1 = testUnitActivity;
        this.arg$2 = list;
    }

    public static Action1 lambdaFactory$(TestUnitActivity testUnitActivity, List list) {
        return new TestUnitActivity$$Lambda$3(testUnitActivity, list);
    }

    public void call(Object obj) {
        TestUnitActivity.lambda$initData$1(this.arg$1, this.arg$2, (List) obj);
    }
}
