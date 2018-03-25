package dict.com.huiyuandict.adapter;

import com.squareup.sqlbrite.SqlBrite.Query;

import rx.functions.Func1;

final /* synthetic */ class UnitItemContentViewBinder$$Lambda$2 implements Func1 {
    private static final UnitItemContentViewBinder$$Lambda$2 instance = new UnitItemContentViewBinder$$Lambda$2();

    private UnitItemContentViewBinder$$Lambda$2() {
    }

    public static Func1 lambdaFactory$() {
        return instance;
    }

    public Object call(Object obj) {
        return ((Query) obj).run();
    }
}
