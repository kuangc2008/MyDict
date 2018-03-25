package dict.com.huiyuandict.activity;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class DetailActivity$$Lambda$5 implements Func1 {
    private final DetailActivity arg$1;

    private DetailActivity$$Lambda$5(DetailActivity detailActivity) {
        this.arg$1 = detailActivity;
    }

    public static Func1 lambdaFactory$(DetailActivity detailActivity) {
        return new DetailActivity$$Lambda$5(detailActivity);
    }

    public Object call(Object obj) {
        return DetailActivity.lambda$refresh$1(this.arg$1, (Cursor) obj);
    }
}
