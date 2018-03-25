package dict.com.huiyuandict.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final /* synthetic */ class YilanFragment$$Lambda$4 implements OnItemClickListener {
    private final YilanFragment arg$1;

    private YilanFragment$$Lambda$4(YilanFragment yilanFragment) {
        this.arg$1 = yilanFragment;
    }

    public static OnItemClickListener lambdaFactory$(YilanFragment yilanFragment) {
        return new YilanFragment$$Lambda$4(yilanFragment);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        YilanFragment.lambda$initView$3(this.arg$1, adapterView, view, i, j);
    }
}
