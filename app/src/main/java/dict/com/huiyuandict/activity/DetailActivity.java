package dict.com.huiyuandict.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;



import java.util.HashMap;
import java.util.List;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.Data;
import dict.com.huiyuandict.data.WordDetail;
import dict.com.huiyuandict.db.Cet;
import me.drakeet.materialdialog.MaterialDialog;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailActivity extends BaseActivity implements OnClickListener {
    private static final String TAG = "DetailActivity";
    private ItemAdapter adapter;
    private BriteDatabase briteDatabase;
    private List<Data> datas;
    private boolean isStudy;
    protected ImageView ivEdit;
    private HashMap<Integer, ViewHolder> map;
    public int position;
    protected Toolbar toolbar;
    protected TextView tvBiaoji;
    private View view;
    protected ViewPager vpDetail;
    private WordDetail wordDetail;

    class ViewHolder {
        protected ImageView imgLine;
        protected LinearLayout llLiju1;
        protected LinearLayout llLiju2;
        protected LinearLayout llLiju3;
        protected LinearLayout textPanel;
        protected LinearLayout topLayout;
        protected TextView tvDetail;
        protected TextView tvLijucn1;
        protected TextView tvLijucn2;
        protected TextView tvLijucn3;
        protected TextView tvLijuen1;
        protected TextView tvLijuen2;
        protected TextView tvLijuen3;
        protected TextView tvSubTitle;
        protected TextView tvText;
        protected TextView tvTitle;

        ViewHolder() {
        }
    }

    class ItemAdapter extends PagerAdapter {
        ItemAdapter() {
        }

        public int getCount() {
            return DetailActivity.this.datas.size();
        }

        public Object instantiateItem(ViewGroup container, int position) {
            Log.i(DetailActivity.TAG, "instantiateItem: " + position);
            ViewHolder holder = new ViewHolder();
            DetailActivity.this.initContent(holder);
            DetailActivity.this.map.put(Integer.valueOf(position), holder);
            container.addView(DetailActivity.this.view);
            return DetailActivity.this.view;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.activity_detail);
        initView();
    }

    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initView() {
        initContent(new ViewHolder());
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.tvBiaoji = (TextView) findViewById(R.id.tv_biaoji);
        this.tvBiaoji.setOnClickListener(this);
        this.vpDetail = (ViewPager) findViewById(R.id.vp_detail);
        this.ivEdit = (ImageView) findViewById(R.id.iv_edit);
        this.ivEdit.setOnClickListener(this);
    }

    private void initContent(ViewHolder holder) {
        this.view = getLayoutInflater().inflate(R.layout.layout_word_detail, null);
        holder.tvTitle = (TextView) this.view.findViewById(R.id.tvTitle);
        holder.tvSubTitle = (TextView) this.view.findViewById(R.id.tvSubTitle);
        holder.tvDetail = (TextView) this.view.findViewById(R.id.tvDetail);
        holder.textPanel = (LinearLayout) this.view.findViewById(R.id.textPanel);
        holder.imgLine = (ImageView) this.view.findViewById(R.id.imgLine);
        holder.topLayout = (LinearLayout) this.view.findViewById(R.id.topLayout);
        holder.tvText = (TextView) this.view.findViewById(R.id.tvText);
        holder.tvLijuen1 = (TextView) this.view.findViewById(R.id.tvLijuen1);
        holder.tvLijucn1 = (TextView) this.view.findViewById(R.id.tvLijucn1);
        holder.llLiju1 = (LinearLayout) this.view.findViewById(R.id.ll_liju1);
        holder.tvLijuen2 = (TextView) this.view.findViewById(R.id.tvLijuen2);
        holder.tvLijucn2 = (TextView) this.view.findViewById(R.id.tvLijucn2);
        holder.llLiju2 = (LinearLayout) this.view.findViewById(R.id.ll_liju2);
        holder.tvLijuen3 = (TextView) this.view.findViewById(R.id.tvLijuen3);
        holder.tvLijucn3 = (TextView) this.view.findViewById(R.id.tvLijucn3);
        holder.llLiju3 = (LinearLayout) this.view.findViewById(R.id.ll_liju3);
    }

    private void initData() {
        this.map = new HashMap();
        this.datas = (List) getIntent().getSerializableExtra("datas");
        this.position = getIntent().getIntExtra("position", 1);
        this.isStudy = getIntent().getBooleanExtra("isStudy", false);
        this.adapter = new ItemAdapter();
        this.vpDetail.setAdapter(this.adapter);
        this.briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io());
        this.vpDetail.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                DetailActivity.this.refresh(position, (ViewHolder) DetailActivity.this.map.get(Integer.valueOf(position)));
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
        this.vpDetail.postDelayed(DetailActivity$$Lambda$1.lambdaFactory$(this), 500);
    }

    private void refresh(int p, ViewHolder holder) {
        int id = ((Data) this.datas.get(p)).getId();
        Subscription subscribe = this.briteDatabase.createQuery("words", "SELECT item0,unit,word,error,yinbiao,shuoming,shuoming2,shuoming3,liju1cn,liju1en,liju2en,liju2cn,liju3en,liju3cn FROM words WHERE item0 = " + id, new String[0]).map(DetailActivity$$Lambda$4.lambdaFactory$()).map(DetailActivity$$Lambda$5.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(DetailActivity$$Lambda$6.lambdaFactory$(this, holder, id), DetailActivity$$Lambda$7.lambdaFactory$(), DetailActivity$$Lambda$8.lambdaFactory$());
    }

    static /* synthetic */ WordDetail lambda$refresh$1(DetailActivity this_, Cursor cursor) {
        this_.wordDetail = new WordDetail();
        if (cursor.moveToNext()) {
            this_.wordDetail.setItem0(cursor.getInt(cursor.getColumnIndex("item0")));
            this_.wordDetail.setUnit(cursor.getString(cursor.getColumnIndex("unit")));
            this_.wordDetail.setWord(cursor.getString(cursor.getColumnIndex("word")));
            this_.wordDetail.setError(cursor.getInt(cursor.getColumnIndex("error")));
            this_.wordDetail.setYinbiao(cursor.getString(cursor.getColumnIndex("yinbiao")));
            this_.wordDetail.setShuoming(cursor.getString(cursor.getColumnIndex("shuoming")));
            this_.wordDetail.setShuoming2(cursor.getString(cursor.getColumnIndex("shuoming2")));
            this_.wordDetail.setShuoming3(cursor.getString(cursor.getColumnIndex("shuoming3")));
            this_.wordDetail.setLiju1en(cursor.getString(cursor.getColumnIndex("liju1en")));
            this_.wordDetail.setLiju2en(cursor.getString(cursor.getColumnIndex("liju2en")));
            this_.wordDetail.setLiju3en(cursor.getString(cursor.getColumnIndex("liju3en")));
            this_.wordDetail.setLiju1zh(cursor.getString(cursor.getColumnIndex("liju1cn")));
            this_.wordDetail.setLiju2zh(cursor.getString(cursor.getColumnIndex("liju2cn")));
            this_.wordDetail.setLiju3zh(cursor.getString(cursor.getColumnIndex("liju3cn")));
        }
        return this_.wordDetail;
    }

    static /* synthetic */ void lambda$refresh$2(DetailActivity this_, ViewHolder holder, int id, WordDetail data) {
        Log.i(TAG, "initData: " + data.toString());
        holder.tvTitle.setText(data.getWord());
        holder.tvSubTitle.setText(data.getYinbiao());
        this_.toolbar.setTitle("Unit" + data.getUnit());
        holder.tvDetail.setText(data.getShuoming() + "\n" + (data.getShuoming2() == null ? "" : data.getShuoming2()) + "\n" + (data.getShuoming3() == null ? "" : data.getShuoming3()));
        holder.tvLijucn1.setText(data.getLiju1zh() == null ? "" : data.getLiju1zh());
        holder.tvLijucn2.setText(data.getLiju2zh() == null ? "" : data.getLiju2zh());
        holder.tvLijucn3.setText(data.getLiju3zh() == null ? "" : data.getLiju3zh());
        holder.tvLijuen1.setText(data.getLiju1en() == null ? "" : data.getLiju1en());
        holder.tvLijuen2.setText(data.getLiju2en() == null ? "" : data.getLiju2en());
        holder.tvLijuen3.setText(data.getLiju3en() == null ? "" : data.getLiju3en());
        if (this_.isStudy) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("xuexi", Integer.valueOf(1));
            this_.briteDatabase.update("words", contentValues, "item0 = ?", String.valueOf(id));
        }
        this_.edit();
        throw new RuntimeException();
    }

    static /* synthetic */ void lambda$refresh$3() {
    }

    private void getUnsubscribe(Subscription subscribe) {
        subscribe.unsubscribe();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.tv_biaoji && view.getId() == R.id.iv_edit) {
            Intent intent = new Intent();
            intent.setClass(this.mContext, EditActivity.class);
            intent.putExtra("data", this.wordDetail);
            intent.putExtra("id", String.valueOf(((Data) this.datas.get(this.vpDetail.getCurrentItem())).getId()));
            startActivity(intent);
        }
    }

    private void edit() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("error", Integer.valueOf(1));
        this.briteDatabase.update("words", contentValues, "item0 = ?", String.valueOf(((Data) this.datas.get(this.vpDetail.getCurrentItem())).getId()));
    }

    private void showDialog() {
        MaterialDialog materialDialog = new MaterialDialog(this);
        materialDialog.setTitle((CharSequence) "提示").setMessage((CharSequence) "是否标记措词").setNegativeButton("否", DetailActivity$$Lambda$9.lambdaFactory$(materialDialog)).setPositiveButton("是", DetailActivity$$Lambda$10.lambdaFactory$(this, materialDialog));
        materialDialog.show();
    }

    static /* synthetic */ void lambda$showDialog$5(DetailActivity this_, MaterialDialog materialDialog, View v) {
        this_.edit();
        materialDialog.dismiss();
    }

    private void showDialog1() {
        MaterialDialog materialDialog = new MaterialDialog(this);
        materialDialog.setTitle((CharSequence) "提示").setMessage((CharSequence) "是否取消标记措词").setNegativeButton("否", DetailActivity$$Lambda$11.lambdaFactory$(materialDialog)).setPositiveButton("是", DetailActivity$$Lambda$12.lambdaFactory$(this, materialDialog));
        materialDialog.show();
    }

    static /* synthetic */ void lambda$showDialog1$7(DetailActivity this_, MaterialDialog materialDialog, View v) {
        this_.edit();
        materialDialog.dismiss();
    }
}
