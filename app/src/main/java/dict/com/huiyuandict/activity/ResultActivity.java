package dict.com.huiyuandict.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;


import java.util.ArrayList;
import java.util.List;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.adapter.ResultItem;
import dict.com.huiyuandict.data.WordDetail;
import dict.com.huiyuandict.db.Cet;
import kale.adapter.CommonAdapter;
import kale.adapter.item.AdapterItem;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ResultActivity extends BaseActivity {
    private BriteDatabase briteDatabase;
    protected Button btnMistake;
    protected Button btnNext;
    protected Button btnRetry;
    protected RelativeLayout contentBar;
    protected LinearLayout contentLayout;
    protected LinearLayout footerBar;
    protected ImageView imgAllRight;
    protected ImageView imgResult;
    protected ImageView imgSeperator;
    protected ImageView imgSeperator2;
    protected LinearLayout listLayout;
    protected ListView listView;
    protected LinearLayout resultPanel;
    protected LinearLayout resultPanelsub;
    private int rightNum;
    protected RelativeLayout subHeaderLayout;
    protected Toolbar toolbar;
    protected TextView tvComment;
    protected TextView tvCount;
    protected TextView tvScore;
    protected TextView tvScoreTxt;
    private String unit;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.test_result);
        this.unit = getIntent().getStringExtra("unit");
        initView();
        setSupportActionBar(this.toolbar);
        this.toolbar.setTitle((CharSequence) "测试结果");
        this.briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io());
        this.briteDatabase.createQuery("words", "SELECT\n  item0,\n  word,\n  unit,\n  error,\n  shuoming,\n  shuoming2,\n  shuoming3,\n  (SELECT COUNT(error)\n   FROM words WHERE error = 2 AND unit = " + this.unit + ") AS rightnum\nFROM words\nWHERE unit =  " + this.unit, new String[0]).map(ResultActivity$$Lambda$1.lambdaFactory$()).map(ResultActivity$$Lambda$2.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(ResultActivity$$Lambda$3.lambdaFactory$(this), ResultActivity$$Lambda$4.lambdaFactory$(), ResultActivity$$Lambda$5.lambdaFactory$());
    }

    static /* synthetic */ List lambda$onCreate$0(ResultActivity this_, Cursor cursor) {
        List<WordDetail> datas = new ArrayList();
        while (cursor.moveToNext()) {
            WordDetail wordDetail = new WordDetail();
            wordDetail.setItem0(cursor.getInt(cursor.getColumnIndex("item0")));
            wordDetail.setWord(cursor.getString(cursor.getColumnIndex("word")));
            wordDetail.setShuoming(cursor.getString(cursor.getColumnIndex("shuoming")));
            wordDetail.setShuoming2(cursor.getString(cursor.getColumnIndex("shuoming2")));
            wordDetail.setShuoming3(cursor.getString(cursor.getColumnIndex("shuoming3")));
            wordDetail.setError(cursor.getInt(cursor.getColumnIndex("error")));
            this_.rightNum = cursor.getInt(cursor.getColumnIndex("rightnum"));
            datas.add(wordDetail);
        }
        return datas;
    }

    static /* synthetic */ void lambda$onCreate$1(ResultActivity this_, List datas) {
        this_.tvScore.setText(((this_.rightNum * 100) / 40) + "%");
        this_.listView.setAdapter(new CommonAdapter<WordDetail>(datas, 1) {
            @NonNull
            public AdapterItem createItem(Object o) {
                return new ResultItem();
            }
        });
        this_.tvCount.setText(String.format(this_.getResources().getString(R.string.test_result_info), new Object[]{Integer.valueOf(40), Integer.valueOf(this_.rightNum)}));
        throw new RuntimeException();
    }

    static /* synthetic */ void lambda$onCreate$2() {
    }

    private void initView() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.tvScoreTxt = (TextView) findViewById(R.id.tvScoreTxt);
        this.subHeaderLayout = (RelativeLayout) findViewById(R.id.subHeaderLayout);
        this.imgResult = (ImageView) findViewById(R.id.imgResult);
        this.tvScore = (TextView) findViewById(R.id.tvScore);
        this.resultPanelsub = (LinearLayout) findViewById(R.id.resultPanelsub);
        this.tvComment = (TextView) findViewById(R.id.tvComment);
        this.tvCount = (TextView) findViewById(R.id.tvCount);
        this.resultPanel = (LinearLayout) findViewById(R.id.resultPanel);
        this.contentBar = (RelativeLayout) findViewById(R.id.contentBar);
        this.imgSeperator2 = (ImageView) findViewById(R.id.imgSeperator2);
        this.listView = (ListView) findViewById(R.id.listView);
        this.listLayout = (LinearLayout) findViewById(R.id.listLayout);
        this.imgSeperator = (ImageView) findViewById(R.id.imgSeperator);
        this.btnRetry = (Button) findViewById(R.id.btnRetry);
        this.btnNext = (Button) findViewById(R.id.btnNext);
        this.btnMistake = (Button) findViewById(R.id.btnMistake);
        this.imgAllRight = (ImageView) findViewById(R.id.imgAllRight);
        this.footerBar = (LinearLayout) findViewById(R.id.footerBar);
        this.contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.toolbar.setTitle((CharSequence) "测试结果");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
