package dict.com.huiyuandict.adapter;

import android.database.Cursor;

import rx.functions.Func1;

final /* synthetic */ class UnitItemContentViewBinder$$Lambda$3 implements Func1 {
    private final UnitItemContentViewBinder arg$1;

    private UnitItemContentViewBinder$$Lambda$3(UnitItemContentViewBinder unitItemContentViewBinder) {
        this.arg$1 = unitItemContentViewBinder;
    }

    public static Func1 lambdaFactory$(UnitItemContentViewBinder unitItemContentViewBinder) {
        return new UnitItemContentViewBinder$$Lambda$3(unitItemContentViewBinder);
    }

    public Object call(Object obj) {
        return UnitItemContentViewBinder.lambda$null$0(this.arg$1, (Cursor) obj);
    }
}
