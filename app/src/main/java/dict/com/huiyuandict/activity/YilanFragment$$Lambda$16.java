package dict.com.huiyuandict.activity;

import java.util.List;

import rx.functions.Action1;

final /* synthetic */ class YilanFragment$$Lambda$16 implements Action1 {
    private final YilanFragment arg$1;

    private YilanFragment$$Lambda$16(YilanFragment yilanFragment) {
        this.arg$1 = yilanFragment;
    }

    public static Action1 lambdaFactory$(YilanFragment yilanFragment) {
        return new YilanFragment$$Lambda$16(yilanFragment);
    }

    public void call(Object obj) {
        YilanFragment.lambda$query2$11(this.arg$1, (List) obj);
    }
}
