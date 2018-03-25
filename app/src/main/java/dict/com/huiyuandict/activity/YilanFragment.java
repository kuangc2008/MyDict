package dict.com.huiyuandict.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.jakewharton.rxbinding.widget.RxTextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dict.com.huiyuandict.R;
import dict.com.huiyuandict.adapter.DataListAdapter;
import dict.com.huiyuandict.adapter.DataParkListAdapter;
import dict.com.huiyuandict.data.Data;
import dict.com.huiyuandict.db.Cet;
import dict.com.huiyuandict.fragments.BaseFragment;
import dict.com.huiyuandict.view.SideLetterBar;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class YilanFragment extends BaseFragment {
    public ListView ListViewe;
    public DataListAdapter adapter;
    private DataParkListAdapter adapter2;
    private DataListAdapter adapter3;
    private BriteDatabase briteDatabase;
    private ArrayList<Data> datas;
    private ArrayList<Data> datas2;
    private ArrayList<Data> datas3;
    protected EditText etSearch;
    public ListView listView;
    private ListView listView2;
    private ListView listView3;
    protected View rootView;
    protected SideLetterBar sideLetterBar;
    private SideLetterBar sideLetterBar2;
    private SideLetterBar sideLetterBar3;
    protected SmartTabLayout stlTab;
    private String[] titles = new String[]{"ABC", "PARKS", "查询历史"};
    protected TextView tvLetterOverlay;
    private TextView tvLetterOverlay2;
    private TextView tvLetterOverlay3;
    protected ViewPager viewPager;
    private List<View> views;

    class ItemAdapter extends PagerAdapter {
        private final SparseArrayCompat<WeakReference<View>> holder;

        public CharSequence getPageTitle(int position) {
            return YilanFragment.this.titles[position];
        }

        public ItemAdapter() {
            this.holder = new SparseArrayCompat(YilanFragment.this.titles.length);
        }

        public int getCount() {
            return YilanFragment.this.titles.length;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            View view = (View) YilanFragment.this.views.get(position);
            container.addView(view);
            this.holder.put(position, new WeakReference(view));
            return view;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            this.holder.remove(position);
            container.removeView((View) object);
        }

        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }
    }

    protected int setRootView() {
        return R.layout.main_sub_list;
    }

    protected void initView() {
        this.rootView = this.view;
        this.etSearch = (EditText) this.rootView.findViewById(R.id.etSearch);
        this.stlTab = (SmartTabLayout) this.rootView.findViewById(R.id.stlTab);
        this.viewPager = (ViewPager) this.rootView.findViewById(R.id.viewPager);
        this.views = new ArrayList();
        View v1 = View.inflate(this.mContext, R.layout.main_sub_list_child, null);
        View v2 = View.inflate(this.mContext, R.layout.main_sub_list_child, null);
        View v3 = View.inflate(this.mContext, R.layout.main_sub_list_child, null);
        this.views.add(v1);
        this.views.add(v2);
        this.views.add(v3);
        this.viewPager.setAdapter(new ItemAdapter());
        this.stlTab.setViewPager(this.viewPager);
        this.listView = (ListView) v1.findViewById(R.id.listview_all_data);
        this.tvLetterOverlay = (TextView) v1.findViewById(R.id.tv_letter_overlay);
        this.sideLetterBar = (SideLetterBar) v1.findViewById(R.id.side_letter_bar);
        this.listView2 = (ListView) v2.findViewById(R.id.listview_all_data);
        this.tvLetterOverlay2 = (TextView) v2.findViewById(R.id.tv_letter_overlay);
        this.sideLetterBar2 = (SideLetterBar) v2.findViewById(R.id.side_letter_bar);
        this.listView3 = (ListView) v3.findViewById(R.id.listview_all_data);
        this.tvLetterOverlay3 = (TextView) v3.findViewById(R.id.tv_letter_overlay);
        this.sideLetterBar3 = (SideLetterBar) v3.findViewById(R.id.side_letter_bar);
        this.datas = new ArrayList();
        this.adapter = new DataListAdapter(this.mContext, this.datas);
        this.listView.setAdapter(this.adapter);
        this.sideLetterBar.setOverlay(this.tvLetterOverlay);
        this.sideLetterBar.setOnLetterChangedListener(YilanFragment$$Lambda$1.lambdaFactory$(this));
        this.listView.setOnItemClickListener(YilanFragment$$Lambda$2.lambdaFactory$(this));
        this.listView2.setOnItemClickListener(YilanFragment$$Lambda$3.lambdaFactory$(this));
        this.listView3.setOnItemClickListener(YilanFragment$$Lambda$4.lambdaFactory$(this));
        this.datas2 = new ArrayList();
        this.adapter2 = new DataParkListAdapter(this.mContext, this.datas2);
        this.listView2.setAdapter(this.adapter2);
        this.sideLetterBar2.setVisibility(8);
        this.datas3 = new ArrayList();
        this.adapter3 = new DataListAdapter(this.mContext, this.datas3);
        this.listView3.setAdapter(this.adapter3);
        this.sideLetterBar3.setOverlay(this.tvLetterOverlay);
        this.sideLetterBar3.setOnLetterChangedListener(YilanFragment$$Lambda$5.lambdaFactory$(this));
        RxTextView.textChanges(this.etSearch).debounce(600, TimeUnit.MILLISECONDS).subscribe(YilanFragment$$Lambda$6.lambdaFactory$(this), YilanFragment$$Lambda$7.lambdaFactory$(), YilanFragment$$Lambda$8.lambdaFactory$());
    }

    static /* synthetic */ void lambda$initView$1(YilanFragment this_, AdapterView parent, View view1, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this_.mContext, DetailActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("datas", this_.datas);
        this_.mContext.startActivity(intent);
    }

    static /* synthetic */ void lambda$initView$2(YilanFragment this_, AdapterView parent, View view1, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this_.mContext, DetailActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("datas", this_.datas2);
        this_.mContext.startActivity(intent);
    }

    static /* synthetic */ void lambda$initView$3(YilanFragment this_, AdapterView parent, View view1, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this_.mContext, DetailActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("datas", this_.datas3);
        this_.mContext.startActivity(intent);
    }

    static /* synthetic */ void lambda$initView$5(YilanFragment this_, CharSequence charSequence) {
        this_.query1(this_.briteDatabase, charSequence.toString());
        this_.query2(this_.briteDatabase, charSequence.toString());
        this_.query3(this_.briteDatabase, charSequence.toString());
    }

    static /* synthetic */ void lambda$initView$6() {
    }

    protected void initData() {
        this.briteDatabase = new SqlBrite.Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io());
        query1(this.briteDatabase, "");
        query2(this.briteDatabase, "");
        query3(this.briteDatabase, "");
    }

    private void query3(BriteDatabase briteDatabase, String str) {
        briteDatabase.createQuery("words", "SELECT item0,word,shuoming FROM words WHERE error = 1 AND word LIKE '" + str + "%' ORDER BY word COLLATE NOCASE", new String[0]).map(YilanFragment$$Lambda$9.lambdaFactory$()).map(YilanFragment$$Lambda$10.lambdaFactory$()).observeOn(AndroidSchedulers.mainThread()).subscribe(YilanFragment$$Lambda$11.lambdaFactory$(this), YilanFragment$$Lambda$12.lambdaFactory$(), YilanFragment$$Lambda$13.lambdaFactory$());
    }

    static /* synthetic */ List lambda$query3$7(Cursor cursor) {
        List datas = new ArrayList();
        while (cursor.moveToNext()) {
            Data data = new Data();
            data.setId(cursor.getInt(cursor.getColumnIndex("item0")));
            data.setTitle(cursor.getString(cursor.getColumnIndex("word")));
            data.setContent(cursor.getString(cursor.getColumnIndex("shuoming")));
            datas.add(data);
        }
        return datas;
    }

    static /* synthetic */ void lambda$query3$8(YilanFragment this_, List datas) {
        this_.datas3 = (ArrayList) datas;
        this_.adapter3 = new DataListAdapter(this_.mContext, datas);
        this_.listView3.setAdapter(this_.adapter3);
    }

    static /* synthetic */ void lambda$query3$9() {
    }

    private void query2(BriteDatabase briteDatabase, String str) {
        briteDatabase.createQuery("words", "SELECT item0, part, word, shuoming FROM words WHERE word LIKE '" + str + "%' ORDER BY part, word COLLATE NOCASE", new String[0]).map(YilanFragment$$Lambda$14.lambdaFactory$()).map(YilanFragment$$Lambda$15.lambdaFactory$()).observeOn(AndroidSchedulers.mainThread()).subscribe(YilanFragment$$Lambda$16.lambdaFactory$(this), YilanFragment$$Lambda$17.lambdaFactory$(), YilanFragment$$Lambda$18.lambdaFactory$());
    }

    static /* synthetic */ List lambda$query2$10(Cursor cursor) {
        List datas = new ArrayList();
        while (cursor.moveToNext()) {
            Data data = new Data();
            data.setId(cursor.getInt(cursor.getColumnIndex("item0")));
            data.setTitle(cursor.getString(cursor.getColumnIndex("word")));
            data.setPart(cursor.getString(cursor.getColumnIndex("part")));
            data.setContent(cursor.getString(cursor.getColumnIndex("shuoming")));
            datas.add(data);
        }
        return datas;
    }

    static /* synthetic */ void lambda$query2$11(YilanFragment this_, List datas) {
        this_.datas2 = (ArrayList) datas;
        this_.adapter2 = new DataParkListAdapter(this_.mContext, datas);
        this_.listView2.setAdapter(this_.adapter2);
    }

    static /* synthetic */ void lambda$query2$12() {
    }

    private void query1(BriteDatabase briteDatabase, String str) {
        briteDatabase.createQuery("words", "SELECT item0,word,shuoming FROM words WHERE word LIKE '" + str + "%' ORDER BY word COLLATE NOCASE", new String[0]).map(YilanFragment$$Lambda$19.lambdaFactory$()).map(YilanFragment$$Lambda$20.lambdaFactory$()).observeOn(AndroidSchedulers.mainThread()).subscribe(YilanFragment$$Lambda$21.lambdaFactory$(this), YilanFragment$$Lambda$22.lambdaFactory$(), YilanFragment$$Lambda$23.lambdaFactory$());
    }

    static /* synthetic */ ArrayList lambda$query1$13(Cursor cursor) {
        ArrayList datas = new ArrayList();
        while (cursor.moveToNext()) {
            Data data = new Data();
            data.setId(cursor.getInt(cursor.getColumnIndex("item0")));
            data.setTitle(cursor.getString(cursor.getColumnIndex("word")));
            data.setContent(cursor.getString(cursor.getColumnIndex("shuoming")));
            datas.add(data);
        }
        return datas;
    }

    static /* synthetic */ void lambda$query1$14(YilanFragment this_, ArrayList datas) {
        this_.datas = datas;
        this_.adapter = new DataListAdapter(this_.mContext, datas);
        this_.listView.setAdapter(this_.adapter);
    }

    static /* synthetic */ void lambda$query1$15() {
    }
}
