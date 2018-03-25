package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class ResultActivity$$Lambda$2 implements Func1 {
    private final ResultActivity arg$1;

    private ResultActivity$$Lambda$2(ResultActivity resultActivity) {
        this.arg$1 = resultActivity;
    }

    public static Func1 lambdaFactory$(ResultActivity resultActivity) {
        return new ResultActivity$$Lambda$2(resultActivity);
    }

    public Object call(Object obj) {
        return ResultActivity.lambda$onCreate$0(this.arg$1, (Cursor) obj);
    }
}
