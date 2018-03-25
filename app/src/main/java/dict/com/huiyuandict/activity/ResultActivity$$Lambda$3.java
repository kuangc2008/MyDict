package dict.com.huiyuandict.activity;

import java.util.List;

import rx.functions.Action1;

final /* synthetic */ class ResultActivity$$Lambda$3 implements Action1 {
    private final ResultActivity arg$1;

    private ResultActivity$$Lambda$3(ResultActivity resultActivity) {
        this.arg$1 = resultActivity;
    }

    public static Action1 lambdaFactory$(ResultActivity resultActivity) {
        return new ResultActivity$$Lambda$3(resultActivity);
    }

    public void call(Object obj) {
        ResultActivity.lambda$onCreate$1(this.arg$1, (List) obj);
    }
}
