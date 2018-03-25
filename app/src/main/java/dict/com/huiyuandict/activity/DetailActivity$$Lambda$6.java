package dict.com.huiyuandict.activity;



import dict.com.huiyuandict.data.WordDetail;
import rx.functions.Action1;

final /* synthetic */ class DetailActivity$$Lambda$6 implements Action1 {
    private final DetailActivity arg$1;
    private final DetailActivity.ViewHolder arg$2;
    private final int arg$3;

    private DetailActivity$$Lambda$6(DetailActivity detailActivity, DetailActivity.ViewHolder viewHolder, int i) {
        this.arg$1 = detailActivity;
        this.arg$2 = viewHolder;
        this.arg$3 = i;
    }

    public static Action1 lambdaFactory$(DetailActivity detailActivity, DetailActivity.ViewHolder viewHolder, int i) {
        return new DetailActivity$$Lambda$6(detailActivity, viewHolder, i);
    }

    public void call(Object obj) {
        DetailActivity.lambda$refresh$2(this.arg$1, this.arg$2, this.arg$3, (WordDetail) obj);
    }
}
