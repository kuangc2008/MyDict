package dict.com.huiyuandict.activity;

import android.view.View;
import android.view.View.OnClickListener;

import me.drakeet.materialdialog.MaterialDialog;

final /* synthetic */ class DetailActivity$$Lambda$12 implements OnClickListener {
    private final DetailActivity arg$1;
    private final MaterialDialog arg$2;

    private DetailActivity$$Lambda$12(DetailActivity detailActivity, MaterialDialog materialDialog) {
        this.arg$1 = detailActivity;
        this.arg$2 = materialDialog;
    }

    public static OnClickListener lambdaFactory$(DetailActivity detailActivity, MaterialDialog materialDialog) {
        return new DetailActivity$$Lambda$12(detailActivity, materialDialog);
    }

    public void onClick(View view) {
        DetailActivity.lambda$showDialog1$7(this.arg$1, this.arg$2, view);
    }
}
