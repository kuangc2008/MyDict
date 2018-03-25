package dict.com.huiyuandict.adapter;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class DataListAdapter$$Lambda$1 implements OnClickListener {
    private final DataListAdapter arg$1;
    private final int arg$2;

    private DataListAdapter$$Lambda$1(DataListAdapter dataListAdapter, int i) {
        this.arg$1 = dataListAdapter;
        this.arg$2 = i;
    }

    public static OnClickListener lambdaFactory$(DataListAdapter dataListAdapter, int i) {
        return new DataListAdapter$$Lambda$1(dataListAdapter, i);
    }

    public void onClick(View view) {
        DataListAdapter.lambda$getView$0(this.arg$1, this.arg$2, view);
    }
}
