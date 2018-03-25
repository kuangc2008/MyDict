package dict.com.huiyuandict.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite.Builder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.WordDetail;
import dict.com.huiyuandict.db.Cet;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TestActivity extends BaseActivity implements OnClickListener {
    protected LinearLayout answerPanel;
    protected LinearLayout answerSubPanel1;
    protected LinearLayout answerSubPanel2;
    protected LinearLayout answerSubPanel3;
    protected LinearLayout answerSubPanel4;
    private BriteDatabase briteDatabase;
    protected Button btnAnswer1;
    protected Button btnAnswer2;
    protected Button btnAnswer3;
    protected Button btnAnswer4;
    protected ImageButton btnPause;
    protected Button btnVoice;
    private List<Button> btns;
    protected LinearLayout contentBar;
    protected LinearLayout contentLayout;
    protected ImageView imgLine;
    protected ImageView imgLine2;
    protected ImageView imgMove;
    protected RelativeLayout navBar1;
    protected RelativeLayout navItemRight;
    protected RelativeLayout noPanel;
    private int position = 0;
    protected RelativeLayout pronouncePanel;
    protected RelativeLayout questionPanel;
    protected RelativeLayout questionTextPanel;
    private List<String> shuomings;
    protected Toolbar toolbar;
    protected TextView tvNo;
    protected TextView tvQuestion;
    protected TextView tvTitle;
    private String unit;
    private List<WordDetail> wordDetails;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.test_running);
        initView();
        this.briteDatabase = new Builder().build().wrapDatabaseHelper(new Cet(this.mContext), Schedulers.io());
        this.briteDatabase.createQuery("words", "SELECT item0, word, shuoming, shuoming2, shuoming3 FROM words WHERE unit = " + this.unit, new String[0]).map(TestActivity$$Lambda$1.lambdaFactory$()).map(TestActivity$$Lambda$2.lambdaFactory$(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(TestActivity$$Lambda$3.lambdaFactory$(this), TestActivity$$Lambda$4.lambdaFactory$(), TestActivity$$Lambda$5.lambdaFactory$());
    }

    static /* synthetic */ List lambda$onCreate$0(TestActivity this_, Cursor cursor) {
        List<WordDetail> datas = new ArrayList();
        this_.shuomings = new ArrayList();
        while (cursor.moveToNext()) {
            WordDetail wordDetail = new WordDetail();
            wordDetail.setItem0(cursor.getInt(cursor.getColumnIndex("item0")));
            wordDetail.setWord(cursor.getString(cursor.getColumnIndex("word")));
            wordDetail.setShuoming(cursor.getString(cursor.getColumnIndex("shuoming")));
            wordDetail.setShuoming2(cursor.getString(cursor.getColumnIndex("shuoming2")));
            wordDetail.setShuoming3(cursor.getString(cursor.getColumnIndex("shuoming3")));
            if (wordDetail.getShuoming() != null) {
                this_.shuomings.add(wordDetail.getShuoming());
            }
            if (wordDetail.getShuoming2() != null) {
                this_.shuomings.add(wordDetail.getShuoming2());
            }
            if (wordDetail.getShuoming3() != null) {
                this_.shuomings.add(wordDetail.getShuoming3());
            }
            datas.add(wordDetail);
        }
        Collections.shuffle(this_.shuomings);
        return datas;
    }

    static /* synthetic */ void lambda$onCreate$1(TestActivity this_, List datas) {
        this_.wordDetails = datas;
        this_.setAllWord(0);
        throw new RuntimeException();
    }

    static /* synthetic */ void lambda$onCreate$2() {
    }

    private String getRightWord(int p) {
        List<String> shuomingstmp = getRightWords(p);
        Random random = new Random();
        if (shuomingstmp.size() > 1) {
            return (String) shuomingstmp.get(random.nextInt(shuomingstmp.size() - 1));
        }
        return (String) shuomingstmp.get(0);
    }

    private List<String> getRightWords(int p) {
        WordDetail wordDetail = (WordDetail) this.wordDetails.get(p);
        List<String> shuomingstmp = new ArrayList();
        if (wordDetail.getShuoming() != null) {
            shuomingstmp.add(wordDetail.getShuoming());
        }
        if (wordDetail.getShuoming2() != null) {
            shuomingstmp.add(wordDetail.getShuoming2());
        }
        if (wordDetail.getShuoming3() != null) {
            shuomingstmp.add(wordDetail.getShuoming3());
        }
        return shuomingstmp;
    }

    private void setAllWord(int p) {
        this.tvQuestion.setText(((WordDetail) this.wordDetails.get(p)).getWord());
        Collections.shuffle(this.btns);
        ((Button) this.btns.get(0)).setText(getRightWord(p));
        String[] otherWord = getOtherWord(p, this.shuomings);
        ((Button) this.btns.get(1)).setText(otherWord[0]);
        ((Button) this.btns.get(2)).setText(otherWord[1]);
        ((Button) this.btns.get(3)).setText(otherWord[2]);
        this.tvNo.setText(String.format("%d/40", new Object[]{Integer.valueOf(p + 1)}));
    }

    private String[] getOtherWord(int p, List<String> list) {
        List<String> list1 = new ArrayList();
        list1.addAll(list);
        for (String s : getRightWords(p)) {
            list1.remove(s);
        }
        Collections.shuffle(list1);
        return new String[]{(String) list1.get(0), (String) list1.get(2), (String) list1.get(1)};
    }

    private void initView() {
        this.btnPause = (ImageButton) findViewById(R.id.btnPause);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.navItemRight = (RelativeLayout) findViewById(R.id.navItemRight);
        this.navBar1 = (RelativeLayout) findViewById(R.id.navBar1);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.imgLine = (ImageView) findViewById(R.id.imgLine);
        this.tvNo = (TextView) findViewById(R.id.tvNo);
        this.noPanel = (RelativeLayout) findViewById(R.id.noPanel);
        this.tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        this.questionTextPanel = (RelativeLayout) findViewById(R.id.questionTextPanel);
        this.btnVoice = (Button) findViewById(R.id.btnVoice);
        this.pronouncePanel = (RelativeLayout) findViewById(R.id.pronouncePanel);
        this.imgLine2 = (ImageView) findViewById(R.id.imgLine2);
        this.imgMove = (ImageView) findViewById(R.id.imgMove);
        this.questionPanel = (RelativeLayout) findViewById(R.id.questionPanel);
        this.btnAnswer1 = (Button) findViewById(R.id.btnAnswer1);
        this.btnAnswer1.setOnClickListener(this);
        this.answerSubPanel1 = (LinearLayout) findViewById(R.id.answerSubPanel1);
        this.btnAnswer2 = (Button) findViewById(R.id.btnAnswer2);
        this.btnAnswer2.setOnClickListener(this);
        this.answerSubPanel2 = (LinearLayout) findViewById(R.id.answerSubPanel2);
        this.btnAnswer3 = (Button) findViewById(R.id.btnAnswer3);
        this.btnAnswer3.setOnClickListener(this);
        this.answerSubPanel3 = (LinearLayout) findViewById(R.id.answerSubPanel3);
        this.btnAnswer4 = (Button) findViewById(R.id.btnAnswer4);
        this.btnAnswer4.setOnClickListener(this);
        this.answerSubPanel4 = (LinearLayout) findViewById(R.id.answerSubPanel4);
        this.answerPanel = (LinearLayout) findViewById(R.id.answerPanel);
        this.contentBar = (LinearLayout) findViewById(R.id.contentBar);
        this.contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
        this.btns = Arrays.asList(new Button[]{this.btnAnswer1, this.btnAnswer2, this.btnAnswer3, this.btnAnswer4});
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.unit = getIntent().getStringExtra("unit");
        this.toolbar.setTitle("Unit" + this.unit);
        setTitle("Unit" + this.unit);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnAnswer1) {
            btnClick((Button) view);
        } else if (view.getId() == R.id.btnAnswer2) {
            btnClick((Button) view);
        } else if (view.getId() == R.id.btnAnswer3) {
            btnClick((Button) view);
        } else if (view.getId() == R.id.btnAnswer4) {
            btnClick((Button) view);
        }
    }

    private void btnClick(Button view) {
        boolean equals = view.getText().equals(((WordDetail) this.wordDetails.get(this.position)).getShuoming());
        boolean equals2 = view.getText().equals(((WordDetail) this.wordDetails.get(this.position)).getShuoming2());
        boolean equals3 = view.getText().equals(((WordDetail) this.wordDetails.get(this.position)).getShuoming3());
        ContentValues contentValues = new ContentValues();
        if (equals || equals2 || equals3) {
            contentValues.put("error", Integer.valueOf(2));
            Toast.makeText(this.mContext, "正确", 0).show();
        } else {
            contentValues.put("error", Integer.valueOf(1));
            Toast.makeText(this.mContext, "错误", 0).show();
        }
        this.briteDatabase.update("words", contentValues, "item0 = ?", String.valueOf(((WordDetail) this.wordDetails.get(this.position)).getItem0()));
        this.position++;
        if (this.position > 39) {
            Intent intent = new Intent();
            intent.putExtra("unit", this.unit);
            intent.setClass(this.mContext, ResultActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        setAllWord(this.position);
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
