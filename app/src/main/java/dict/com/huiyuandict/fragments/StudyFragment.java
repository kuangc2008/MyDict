package dict.com.huiyuandict.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.sqlbrite.SqlBrite;
import com.squareup.sqlbrite.SqlBrite.Builder;

import net.nashlegend.anypref.AnyPref;

import dict.com.huiyuandict.R;
import dict.com.huiyuandict.activity.StudyUnitActivity;
import dict.com.huiyuandict.activity.TestUnitActivity;
import dict.com.huiyuandict.data.Book;
import dict.com.huiyuandict.data.Conf;
import dict.com.huiyuandict.db.Cet;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class StudyFragment extends BaseFragment implements OnClickListener {
    protected Button btnLearn;
    protected Button btnTest;
    protected LinearLayout buttonPanel;
    protected LinearLayout buttonPanelSub2;
    protected ImageView imageView;
    protected LinearLayout infoPanel;
    protected LinearLayout infoPanelLearnAndTestInfo;
    protected LinearLayout infoPanelWordsInfo;
    protected View rootView;
    protected RelativeLayout todayPanel;
    protected TextView tvLearn;
    protected TextView tvLearnText;
    protected TextView tvTest;
    protected TextView tvTestText;
    protected TextView tvTitle;
    protected TextView tvUnits;
    protected TextView tvWords;

    protected int setRootView() {
        return R.layout.main_sub_study;
    }

    protected void initView() {
        this.rootView = this.view;
        this.tvTitle = (TextView) this.rootView.findViewById(R.id.tvTitle);
        this.tvUnits = (TextView) this.rootView.findViewById(R.id.tvUnits);
        this.tvWords = (TextView) this.rootView.findViewById(R.id.tvWords);
        this.infoPanelWordsInfo = (LinearLayout) this.rootView.findViewById(R.id.infoPanelWordsInfo);
        this.tvLearnText = (TextView) this.rootView.findViewById(R.id.tvLearnText);
        this.tvLearn = (TextView) this.rootView.findViewById(R.id.tvLearn);
        this.tvTestText = (TextView) this.rootView.findViewById(R.id.tvTestText);
        this.tvTest = (TextView) this.rootView.findViewById(R.id.tvTest);
        this.infoPanelLearnAndTestInfo = (LinearLayout) this.rootView.findViewById(R.id.infoPanelLearnAndTestInfo);
        this.infoPanel = (LinearLayout) this.rootView.findViewById(R.id.infoPanel);
        this.btnTest = (Button) this.rootView.findViewById(R.id.btnTest);
        this.btnTest.setOnClickListener(this);
        this.btnLearn = (Button) this.rootView.findViewById(R.id.btnLearn);
        this.btnLearn.setOnClickListener(this);
        this.buttonPanelSub2 = (LinearLayout) this.rootView.findViewById(R.id.buttonPanelSub2);
        this.buttonPanelSub2.setOnClickListener(this);
        this.buttonPanel = (LinearLayout) this.rootView.findViewById(R.id.buttonPanel);
        this.buttonPanel.setOnClickListener(this);
        this.imageView = (ImageView) this.rootView.findViewById(R.id.imageView);
        this.todayPanel = (RelativeLayout) this.rootView.findViewById(R.id.todayPanel);
        this.todayPanel.setOnClickListener(this);
    }

    protected void initData() {
        new Builder().build().wrapDatabaseHelper
                (new Cet(this.mContext), Schedulers.io()).createQuery("words", "SELECT\n  (SELECT count(*) FROM words WHERE xuexi = 1) AS xuexi,\n  (SELECT count(*) FROM words WHERE error = 2) AS error",
                new String[]{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SqlBrite.Query>() {
                    @Override
                    public void call(SqlBrite.Query query) {
                        Cursor cursor = query.run();
                        if (cursor.moveToNext()) {
                            tvLearn.setText(cursor.getString(cursor.getColumnIndex("xuexi")));
                            tvTest.setText(cursor.getString(cursor.getColumnIndex("error")));
                        }
                    }
                });
        Book book = (Book) ((Conf) AnyPref.get(Conf.class)).getBooks().get(((Conf) AnyPref.get(Conf.class)).getSelectId());
        this.tvTitle.setText(book.getTitle());
        this.tvUnits.setText(book.getUnit() + "个单元");
        this.tvWords.setText(book.getWordCount() + "个单词");
    }

    static /* synthetic */ void lambda$initData$0(StudyFragment this_, Cursor cursor) {
        if (cursor.moveToNext()) {
            this_.tvLearn.setText(cursor.getString(cursor.getColumnIndex("xuexi")));
            this_.tvTest.setText(cursor.getString(cursor.getColumnIndex("error")));
        }
    }

    static /* synthetic */ void lambda$initData$1() {
    }

    public void onClick(View view) {
        Intent intent;
        if (view.getId() == R.id.btnTest) {
            intent = new Intent();
            intent.setClass(this.mContext, TestUnitActivity.class);
            intent.putExtra("type", "test");
            startActivity(intent);
        } else if (view.getId() == R.id.btnLearn) {
            intent = new Intent();
            intent.setClass(this.mContext, StudyUnitActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.todayPanel) {
            intent = new Intent();
            intent.setClass(this.mContext, TestUnitActivity.class);
            intent.putExtra("type", "history");
            startActivity(intent);
        }
    }
}
