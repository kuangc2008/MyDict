package dict.com.huiyuandict.activity;

import com.squareup.sqlbrite.SqlBrite.Query;

import rx.functions.Func1;

final /* synthetic */ class DetailActivity$$Lambda$4 implements Func1 {
    private static final DetailActivity$$Lambda$4 instance = new DetailActivity$$Lambda$4();

    private DetailActivity$$Lambda$4() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return ((Query) obj).run();
    }
}
