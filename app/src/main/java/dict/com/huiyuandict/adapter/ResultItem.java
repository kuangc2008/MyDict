package dict.com.huiyuandict.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.WordDetail;
import kale.adapter.item.AdapterItem;

public class ResultItem implements AdapterItem<WordDetail> {
    protected LinearLayout Layout1;
    protected LinearLayout Layout21;
    protected ImageView imgResult;
    protected View rootView;
    protected LinearLayout topLayout;
    protected LinearLayout topSubLayout;
    protected TextView tvNo;
    protected TextView tvWordEn;
    protected TextView tvWordJp;

    public int getLayoutResId() {
        return R.layout.test_result_item;
    }

    public void bindViews(View view) {
        initView(view);
    }

    public void setViews() {
    }

    public void handleData(WordDetail wordDetail, int i) {
        this.tvNo.setText((i + 1) + "");
        this.tvWordEn.setText(wordDetail.getWord());
        this.tvWordJp.setText(wordDetail.getShuoming());
        if (wordDetail.getError() == 2) {
            this.imgResult.setImageResource(R.drawable.list_right2);
        } else {
            this.imgResult.setImageResource(R.drawable.list_wrong);
        }
    }

    private void initView(View rootView) {
        this.tvNo = (TextView) rootView.findViewById(R.id.tvNo);
        this.tvWordEn = (TextView) rootView.findViewById(R.id.tvWordEn);
        this.tvWordJp = (TextView) rootView.findViewById(R.id.tvWordJp);
        this.Layout1 = (LinearLayout) rootView.findViewById(R.id.Layout1);
        this.imgResult = (ImageView) rootView.findViewById(R.id.imgResult);
        this.Layout21 = (LinearLayout) rootView.findViewById(R.id.Layout21);
        this.topSubLayout = (LinearLayout) rootView.findViewById(R.id.topSubLayout);
        this.topLayout = (LinearLayout) rootView.findViewById(R.id.topLayout);
    }
}
