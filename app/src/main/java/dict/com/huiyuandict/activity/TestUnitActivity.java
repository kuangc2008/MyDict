package dict.com.huiyuandict.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.squareup.sqlbrite.SqlBrite.Builder;



import java.util.ArrayList;
import java.util.List;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.adapter.TestUnitItemContentViewBinder;
import dict.com.huiyuandict.adapter.UnitItemContent;
import dict.com.huiyuandict.adapter.UnitItemHead;
import dict.com.huiyuandict.adapter.UnitItemHeadViewBinder;
import dict.com.huiyuandict.data.Unit;
import dict.com.huiyuandict.db.Cet;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import tellh.com.stickyheaderview_rv.adapter.DataBean;
import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;

public class TestUnitActivity extends BaseActivity {
    private StickyHeaderViewAdapter adapter;
    protected RecyclerView rcvUnit;
    protected Toolbar toolbar;
    private List<DataBean> userList;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.activity_unit);
        initView();
    }

    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initView() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.rcvUnit = (RecyclerView) findViewById(R.id.rcv_unit);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("单元列表");
        this.rcvUnit.setLayoutManager(new LinearLayoutManager(this));
        this.userList = new ArrayList();
        this.adapter = new StickyHeaderViewAdapter(this.userList).RegisterItemType(new TestUnitItemContentViewBinder(getIntent().getStringExtra("type"))).RegisterItemType(new UnitItemHeadViewBinder());
        this.rcvUnit.setAdapter(this.adapter);
        this.adapter.setDataSetChangeListener(new StickyHeaderViewAdapter.DataSetChangeListener() {
            @Override
            public void onClearAll() {

            }

            @Override
            public void remove(int i) {

            }
        });
    }

    private void initData() {
        String str = "words";
        new Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io()).createQuery(str, "SELECT *\nFROM (SELECT\n        unit     AS unit,\n        0        AS xuexinum,\n        part,\n        count(*) AS sum\n      FROM words\n      WHERE unit NOT IN (SELECT unit\n                         FROM words\n                         WHERE error = 2\n                         GROUP BY unit)\n      GROUP BY unit\n      UNION ALL\n      SELECT\n        unit,\n        count(error),\n        part,\n        40\n      FROM words\n      WHERE error = 2\n      GROUP BY unit)\nORDER BY unit", new String[0]).map(TestUnitActivity$$Lambda$1.lambdaFactory$()).map(TestUnitActivity$$Lambda$2.lambdaFactory$()).observeOn(AndroidSchedulers.mainThread()).subscribe(TestUnitActivity$$Lambda$3.lambdaFactory$(this, new ArrayList()), TestUnitActivity$$Lambda$4.lambdaFactory$(), TestUnitActivity$$Lambda$5.lambdaFactory$());
    }

    static /* synthetic */ List lambda$initData$0(Cursor cursor) {
        List<Unit> list = new ArrayList();
        while (cursor.moveToNext()) {
            Unit unit = new Unit();
            unit.setPart(cursor.getString(cursor.getColumnIndex("part")));
            unit.setUnit(cursor.getString(cursor.getColumnIndex("unit")));
            unit.setSum(cursor.getInt(cursor.getColumnIndex("sum")));
            unit.setYixueNum(cursor.getInt(cursor.getColumnIndex("xuexinum")));
            list.add(unit);
        }
        return list;
    }

    static /* synthetic */ void lambda$initData$1(TestUnitActivity this_, List datas, List units) {
        int i = 0;
        while (i < units.size()) {
            if (i <= 0 || !((Unit) units.get(i - 1)).getPart().equals(((Unit) units.get(i)).getPart())) {
                datas.add(new UnitItemHead(((Unit) units.get(i)).getPart()));
                datas.add(new UnitItemContent(((Unit) units.get(i)).getUnit(), (((Unit) units.get(i)).getYixueNum() * 100) / ((Unit) units.get(i)).getSum(), ((Unit) units.get(i)).getSum(), ((Unit) units.get(i)).getYixueNum()));
            } else {
                datas.add(new UnitItemContent(((Unit) units.get(i)).getUnit(), (((Unit) units.get(i)).getYixueNum() * 100) / ((Unit) units.get(i)).getSum(), ((Unit) units.get(i)).getSum(), ((Unit) units.get(i)).getYixueNum()));
            }
            i++;
        }
        this_.adapter.refresh(datas);
        this_.adapter.notifyDataSetChanged();
    }

    static /* synthetic */ void lambda$initData$2() {
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
