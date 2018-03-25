package dict.com.huiyuandict.adapter;

import dict.com.huiyuandict.R;
import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class UnitItemHead extends DataBean {
    private String part;

    public UnitItemHead(String part) {
        this.part = part;
    }

    public int getItemLayoutId(StickyHeaderViewAdapter stickyHeaderViewAdapter) {
        return R.layout.unit_list_sep;
    }

    public boolean shouldSticky() {
        return true;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
