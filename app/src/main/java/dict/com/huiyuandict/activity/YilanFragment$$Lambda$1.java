package dict.com.huiyuandict.activity;


import dict.com.huiyuandict.view.SideLetterBar;

final /* synthetic */ class YilanFragment$$Lambda$1 implements SideLetterBar.OnLetterChangedListener {
    private final YilanFragment arg$1;

    private YilanFragment$$Lambda$1(YilanFragment yilanFragment) {
        this.arg$1 = yilanFragment;
    }

    public static SideLetterBar.OnLetterChangedListener lambdaFactory$(YilanFragment yilanFragment) {
        return new YilanFragment$$Lambda$1(yilanFragment);
    }

    public void onLetterChanged(String str) {
        this.arg$1.listView.setSelection(this.arg$1.adapter.getLetterPosition(str));
    }
}
