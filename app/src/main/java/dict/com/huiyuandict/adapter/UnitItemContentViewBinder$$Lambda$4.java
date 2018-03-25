package dict.com.huiyuandict.adapter;

import java.util.ArrayList;

import rx.functions.Action1;

final /* synthetic */ class UnitItemContentViewBinder$$Lambda$4 implements Action1 {
    private final UnitItemContentViewBinder arg$1;
    private final UnitItemContentViewBinder.ViewHolder arg$2;

    private UnitItemContentViewBinder$$Lambda$4(UnitItemContentViewBinder unitItemContentViewBinder, UnitItemContentViewBinder.ViewHolder viewHolder) {
        this.arg$1 = unitItemContentViewBinder;
        this.arg$2 = viewHolder;
    }

    public static Action1 lambdaFactory$(UnitItemContentViewBinder unitItemContentViewBinder, UnitItemContentViewBinder.ViewHolder viewHolder) {
        return new UnitItemContentViewBinder$$Lambda$4(unitItemContentViewBinder, viewHolder);
    }

    public void call(Object obj) {
        UnitItemContentViewBinder.lambda$null$1(this.arg$1, this.arg$2, (ArrayList) obj);
    }
}
