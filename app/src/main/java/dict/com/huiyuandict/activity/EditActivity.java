package dict.com.huiyuandict.activity;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;


import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.WordDetail;
import dict.com.huiyuandict.db.Cet;
import rx.schedulers.Schedulers;

public class EditActivity extends BaseActivity implements OnClickListener {
    private BriteDatabase briteDatabase;
    protected ImageView imgLine;
    protected LinearLayout llLiju1;
    protected LinearLayout llLiju2;
    protected LinearLayout llLiju3;
    protected LinearLayout textPanel;
    protected Toolbar toolbar;
    protected LinearLayout topLayout;
    protected EditText tvDetail;
    protected EditText tvLijucn1;
    protected EditText tvLijucn2;
    protected EditText tvLijucn3;
    protected EditText tvLijuen1;
    protected EditText tvLijuen2;
    protected EditText tvLijuen3;
    protected TextView tvSave;
    protected EditText tvSubTitle;
    protected TextView tvText;
    protected EditText tvTitle;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.activity_edit);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        WordDetail wordDetail = (WordDetail) getIntent().getSerializableExtra("data");
        if (wordDetail != null) {
            this.tvTitle.setText(wordDetail.getWord());
            this.tvSubTitle.setText(wordDetail.getYinbiao());
            this.tvDetail.setText(wordDetail.getShuoming() + "\n" + (wordDetail.getShuoming2() == null ? "" : wordDetail.getShuoming2()) + "\n" + (wordDetail.getShuoming3() == null ? "" : wordDetail.getShuoming3()));
            this.tvLijucn1.setText(wordDetail.getLiju1zh() == null ? "" : wordDetail.getLiju1zh());
            this.tvLijucn2.setText(wordDetail.getLiju2zh() == null ? "" : wordDetail.getLiju2zh());
            this.tvLijucn3.setText(wordDetail.getLiju3zh() == null ? "" : wordDetail.getLiju3zh());
            this.tvLijuen1.setText(wordDetail.getLiju1en() == null ? "" : wordDetail.getLiju1en());
            this.tvLijuen2.setText(wordDetail.getLiju2en() == null ? "" : wordDetail.getLiju2en());
            this.tvLijuen3.setText(wordDetail.getLiju3en() == null ? "" : wordDetail.getLiju3en());
        }
        this.briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_save) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("word", this.tvTitle.getText().toString());
            contentValues.put("yinbiao", this.tvSubTitle.getText().toString());
            String[] split = this.tvDetail.getText().toString().split("\n");
            contentValues.put("shuoming", split[0]);
            contentValues.put("shuoming2", split[1]);
            contentValues.put("shuoming3", split[2]);
            contentValues.put("liju1cn", this.tvLijucn1.getText().toString());
            contentValues.put("liju2cn", this.tvLijucn2.getText().toString());
            contentValues.put("liju3cn", this.tvLijucn3.getText().toString());
            contentValues.put("liju1en", this.tvLijuen1.getText().toString());
            contentValues.put("liju2en", this.tvLijuen2.getText().toString());
            contentValues.put("liju3en", this.tvLijuen3.getText().toString());
            int update = this.briteDatabase.update("words", contentValues, "item0 = ?", getIntent().getStringExtra("id"));
            Toast.makeText(this.mContext, "保存成功", 1).show();
            finish();
        }
    }

    private void initView() {
        this.tvSave = (TextView) findViewById(R.id.tv_save);
        this.tvSave.setOnClickListener(this);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.tvTitle = (EditText) findViewById(R.id.tvTitle);
        this.tvSubTitle = (EditText) findViewById(R.id.tvSubTitle);
        this.tvDetail = (EditText) findViewById(R.id.tvDetail);
        this.textPanel = (LinearLayout) findViewById(R.id.textPanel);
        this.imgLine = (ImageView) findViewById(R.id.imgLine);
        this.topLayout = (LinearLayout) findViewById(R.id.topLayout);
        this.tvText = (TextView) findViewById(R.id.tvText);
        this.tvLijuen1 = (EditText) findViewById(R.id.tvLijuen1);
        this.tvLijucn1 = (EditText) findViewById(R.id.tvLijucn1);
        this.llLiju1 = (LinearLayout) findViewById(R.id.ll_liju1);
        this.tvLijuen2 = (EditText) findViewById(R.id.tvLijuen2);
        this.tvLijucn2 = (EditText) findViewById(R.id.tvLijucn2);
        this.llLiju2 = (LinearLayout) findViewById(R.id.ll_liju2);
        this.tvLijuen3 = (EditText) findViewById(R.id.tvLijuen3);
        this.tvLijucn3 = (EditText) findViewById(R.id.tvLijucn3);
        this.llLiju3 = (LinearLayout) findViewById(R.id.ll_liju3);
    }
}
