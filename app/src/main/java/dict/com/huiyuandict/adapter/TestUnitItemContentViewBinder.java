package dict.com.huiyuandict.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;



import java.util.Locale;

import dict.com.huiyuandict.App;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.activity.ResultActivity;
import dict.com.huiyuandict.activity.TestActivity;
import dict.com.huiyuandict.db.Cet;
import rx.schedulers.Schedulers;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

public class TestUnitItemContentViewBinder extends ViewBinder<UnitItemContent, TestUnitItemContentViewBinder.ViewHolder> {
    public final BriteDatabase briteDatabase;
    int position = 0;
    private String type;

    static class ViewHolder extends tellh.com.stickyheaderview_rv.adapter.ViewBinder.ViewHolder {
        protected Button btnWords;
        protected LinearLayout panelMiddle;
        protected RelativeLayout panelMiddleSub;
        protected LinearLayout panelRight;
        protected ProgressBar progressView;
        protected RelativeLayout topLayout;
        protected TextView tvCnt;
        protected TextView tvUnit;

        public ViewHolder(View rootView) {
            super(rootView);
            initView(rootView);
        }

        private void initView(View rootView) {
            this.btnWords = (Button) rootView.findViewById(R.id.btnWords);
            this.panelRight = (LinearLayout) rootView.findViewById(R.id.panelRight);
            this.tvUnit = (TextView) rootView.findViewById(R.id.tvUnit);
            this.progressView = (ProgressBar) rootView.findViewById(R.id.progressView);
            this.tvCnt = (TextView) rootView.findViewById(R.id.tvCnt);
            this.panelMiddleSub = (RelativeLayout) rootView.findViewById(R.id.panelMiddleSub);
            this.panelMiddle = (LinearLayout) rootView.findViewById(R.id.panelMiddle);
            this.topLayout = (RelativeLayout) rootView.findViewById(R.id.topLayout);
        }
    }

    public TestUnitItemContentViewBinder(String type) {
        this.type = type;
        this.briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(App.getContext()), Schedulers.io());
    }

    public ViewHolder provideViewHolder(View view) {
        return new ViewHolder(view);
    }

    public void bindView(StickyHeaderViewAdapter stickyHeaderViewAdapter, ViewHolder viewHolder, int i, UnitItemContent unitItemContent) {
        viewHolder.tvUnit.setText(unitItemContent.getUnit());
        viewHolder.progressView.setProgress(unitItemContent.getPercentage());
        viewHolder.tvCnt.setText(String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(unitItemContent.getYixueNum()), Integer.valueOf(unitItemContent.getSum())}));
        viewHolder.itemView.setOnClickListener(TestUnitItemContentViewBinder$$Lambda$1.lambdaFactory$(this, i));
    }

    static /* synthetic */ void lambda$bindView$0(TestUnitItemContentViewBinder this_, int i, View v) {
        Intent intent = new Intent();
        if ("test".equals(this_.type)) {
            intent.setClass(v.getContext(), TestActivity.class);
            intent.putExtra("unit", i + "");
            v.getContext().startActivity(intent);
            return;
        }
        intent = new Intent();
        intent.setClass(v.getContext(), ResultActivity.class);
        intent.putExtra("unit", i + "");
        v.getContext().startActivity(intent);
    }

    public int getItemLayoutId(StickyHeaderViewAdapter stickyHeaderViewAdapter) {
        return R.layout.unit_list_item;
    }
}
