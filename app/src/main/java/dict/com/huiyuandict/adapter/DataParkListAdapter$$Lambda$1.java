package dict.com.huiyuandict.adapter;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class DataParkListAdapter$$Lambda$1 implements OnClickListener {
    private final DataParkListAdapter arg$1;
    private final int arg$2;

    private DataParkListAdapter$$Lambda$1(DataParkListAdapter dataParkListAdapter, int i) {
        this.arg$1 = dataParkListAdapter;
        this.arg$2 = i;
    }

    public static OnClickListener lambdaFactory$(DataParkListAdapter dataParkListAdapter, int i) {
        return new DataParkListAdapter$$Lambda$1(dataParkListAdapter, i);
    }

    public void onClick(View view) {
        DataParkListAdapter.lambda$getView$0(this.arg$1, this.arg$2, view);
    }
}
