package dict.com.huiyuandict.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;

import java.util.ArrayList;
import java.util.Locale;

import dict.com.huiyuandict.App;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.activity.DetailActivity;
import dict.com.huiyuandict.data.Data;
import dict.com.huiyuandict.db.Cet;
import rx.schedulers.Schedulers;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

public class UnitItemContentViewBinder extends ViewBinder<UnitItemContent, UnitItemContentViewBinder.ViewHolder> {
    public final BriteDatabase briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(App.getContext()), Schedulers.io());
    int position = 0;

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

    public ViewHolder provideViewHolder(View view) {
        return new ViewHolder(view);
    }

    public void bindView(StickyHeaderViewAdapter stickyHeaderViewAdapter, ViewHolder viewHolder, int i, UnitItemContent unitItemContent) {
        viewHolder.tvUnit.setText(unitItemContent.getUnit());
        viewHolder.progressView.setProgress(unitItemContent.getPercentage());
        viewHolder.tvCnt.setText(String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(unitItemContent.getYixueNum()), Integer.valueOf(unitItemContent.getSum())}));
        viewHolder.itemView.setOnClickListener(UnitItemContentViewBinder$$Lambda$1.lambdaFactory$(this, unitItemContent, viewHolder));
    }

    static /* synthetic */ ArrayList lambda$null$0(UnitItemContentViewBinder this_, Cursor cursor) {
        ArrayList list = new ArrayList();
        while (cursor.moveToNext()) {
            Data e = new Data();
            e.setId(cursor.getInt(cursor.getColumnIndex("item0")));
            list.add(e);
            this_.position = cursor.getInt(cursor.getColumnIndex("xuexinum"));
        }
        return list;
    }

    static /* synthetic */ void lambda$null$1(UnitItemContentViewBinder this_, ViewHolder viewHolder, ArrayList list) {
        Intent intent = new Intent();
        Context context = viewHolder.itemView.getContext();
        intent.setClass(context, DetailActivity.class);
        intent.putExtra("position", this_.position);
        intent.putExtra("datas", list);
        intent.putExtra("isStudy", true);
        context.startActivity(intent);
    }

    static /* synthetic */ void lambda$null$2() {
    }

    public int getItemLayoutId(StickyHeaderViewAdapter stickyHeaderViewAdapter) {
        return R.layout.unit_list_item;
    }
}
