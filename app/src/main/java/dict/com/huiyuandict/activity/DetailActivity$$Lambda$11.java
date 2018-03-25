package dict.com.huiyuandict.activity;

import android.view.View;
import android.view.View.OnClickListener;

import me.drakeet.materialdialog.MaterialDialog;

final /* synthetic */ class DetailActivity$$Lambda$11 implements OnClickListener {
    private final MaterialDialog arg$1;

    private DetailActivity$$Lambda$11(MaterialDialog materialDialog) {
        this.arg$1 = materialDialog;
    }

    public static OnClickListener lambdaFactory$(MaterialDialog materialDialog) {
        return new DetailActivity$$Lambda$11(materialDialog);
    }

    public void onClick(View view) {
        this.arg$1.dismiss();
    }
}
