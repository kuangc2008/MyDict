package dict.com.huiyuandict.activity;

final /* synthetic */ class DetailActivity$$Lambda$1 implements Runnable {
    private final DetailActivity arg$1;

    private DetailActivity$$Lambda$1(DetailActivity detailActivity) {
        this.arg$1 = detailActivity;
    }

    public static Runnable lambdaFactory$(DetailActivity detailActivity) {
        return new DetailActivity$$Lambda$1(detailActivity);
    }

    public void run() {
        this.arg$1.vpDetail.setCurrentItem(this.arg$1.position, false);
    }
}
