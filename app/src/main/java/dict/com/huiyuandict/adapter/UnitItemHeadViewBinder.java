package dict.com.huiyuandict.adapter;

import android.view.View;
import android.widget.TextView;


import dict.com.huiyuandict.R;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

public class UnitItemHeadViewBinder extends ViewBinder<UnitItemHead, UnitItemHeadViewBinder.ViewHolder> {

    static class ViewHolder extends tellh.com.stickyheaderview_rv.adapter.ViewBinder.ViewHolder {
        protected TextView tvText;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvText = (TextView) rootView.findViewById(R.id.tvText);
        }
    }

    public ViewHolder provideViewHolder(View view) {
        return new ViewHolder(view);
    }

    public void bindView(StickyHeaderViewAdapter stickyHeaderViewAdapter, ViewHolder viewHolder, int i, UnitItemHead unitItemHead) {
        viewHolder.tvText.setText(unitItemHead.getPart());
    }

    public int getItemLayoutId(StickyHeaderViewAdapter stickyHeaderViewAdapter) {
        return R.layout.unit_list_sep;
    }
}
