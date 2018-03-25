package dict.com.huiyuandict.adapter;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class TestUnitItemContentViewBinder$$Lambda$1 implements OnClickListener {
    private final TestUnitItemContentViewBinder arg$1;
    private final int arg$2;

    private TestUnitItemContentViewBinder$$Lambda$1(TestUnitItemContentViewBinder testUnitItemContentViewBinder, int i) {
        this.arg$1 = testUnitItemContentViewBinder;
        this.arg$2 = i;
    }

    public static OnClickListener lambdaFactory$(TestUnitItemContentViewBinder testUnitItemContentViewBinder, int i) {
        return new TestUnitItemContentViewBinder$$Lambda$1(testUnitItemContentViewBinder, i);
    }

    public void onClick(View view) {
        TestUnitItemContentViewBinder.lambda$bindView$0(this.arg$1, this.arg$2, view);
    }
}
