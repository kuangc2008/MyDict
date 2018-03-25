package dict.com.huiyuandict.adapter;


import dict.com.huiyuandict.R;
import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class UnitItemContent extends DataBean {
    private int percentage;
    private int sum;
    private String unit;
    private int yixueNum;

    public UnitItemContent(String unit, int percentage, int sum, int yixueNum) {
        this.unit = unit;
        this.percentage = percentage;
        this.sum = sum;
        this.yixueNum = yixueNum;
    }

    public int getItemLayoutId(StickyHeaderViewAdapter stickyHeaderViewAdapter) {
        return R.layout.unit_list_item;
    }

    public boolean shouldSticky() {
        return false;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getYixueNum() {
        return this.yixueNum;
    }

    public void setYixueNum(int yixueNum) {
        this.yixueNum = yixueNum;
    }
}
