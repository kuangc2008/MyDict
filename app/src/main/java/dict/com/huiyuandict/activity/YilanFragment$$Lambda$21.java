package dict.com.huiyuandict.activity;

import java.util.ArrayList;

import rx.functions.Action1;

final /* synthetic */ class YilanFragment$$Lambda$21 implements Action1 {
    private final YilanFragment arg$1;

    private YilanFragment$$Lambda$21(YilanFragment yilanFragment) {
        this.arg$1 = yilanFragment;
    }

    public static Action1 lambdaFactory$(YilanFragment yilanFragment) {
        return new YilanFragment$$Lambda$21(yilanFragment);
    }

    public void call(Object obj) {
        YilanFragment.lambda$query1$14(this.arg$1, (ArrayList) obj);
    }
}
