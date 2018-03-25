package dict.com.huiyuandict.adapter;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class UnitItemContentViewBinder$$Lambda$1 implements OnClickListener {
    private final UnitItemContentViewBinder arg$1;
    private final UnitItemContent arg$2;
    private final UnitItemContentViewBinder.ViewHolder arg$3;

    private UnitItemContentViewBinder$$Lambda$1(UnitItemContentViewBinder unitItemContentViewBinder, UnitItemContent unitItemContent, UnitItemContentViewBinder.ViewHolder viewHolder) {
        this.arg$1 = unitItemContentViewBinder;
        this.arg$2 = unitItemContent;
        this.arg$3 = viewHolder;
    }

    public static OnClickListener lambdaFactory$(UnitItemContentViewBinder unitItemContentViewBinder, UnitItemContent unitItemContent, UnitItemContentViewBinder.ViewHolder viewHolder) {
        return new UnitItemContentViewBinder$$Lambda$1(unitItemContentViewBinder, unitItemContent, viewHolder);
    }

    public void onClick(View view) {
        this.arg$1.briteDatabase.createQuery("words", "SELECT item0, ( SELECT COUNT(xuexi = 0) FROM words) AS xuexinum FROM words WHERE unit = " + this.arg$2.getUnit(), new String[0]).map(UnitItemContentViewBinder$$Lambda$2.lambdaFactory$()).map(UnitItemContentViewBinder$$Lambda$3.lambdaFactory$(this.arg$1)).subscribe(UnitItemContentViewBinder$$Lambda$4.lambdaFactory$(this.arg$1, this.arg$3), UnitItemContentViewBinder$$Lambda$5.lambdaFactory$(), UnitItemContentViewBinder$$Lambda$6.lambdaFactory$());
    }
}
