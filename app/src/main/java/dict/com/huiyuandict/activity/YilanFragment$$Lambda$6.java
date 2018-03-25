package dict.com.huiyuandict.activity;

import rx.functions.Action1;

final /* synthetic */ class YilanFragment$$Lambda$6 implements Action1 {
    private final YilanFragment arg$1;

    private YilanFragment$$Lambda$6(YilanFragment yilanFragment) {
        this.arg$1 = yilanFragment;
    }

    public static Action1 lambdaFactory$(YilanFragment yilanFragment) {
        return new YilanFragment$$Lambda$6(yilanFragment);
    }

    public void call(Object obj) {
        YilanFragment.lambda$initView$5(this.arg$1, (CharSequence) obj);
    }
}
