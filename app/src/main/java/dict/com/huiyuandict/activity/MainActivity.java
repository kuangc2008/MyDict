package dict.com.huiyuandict.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.nashlegend.anypref.AnyPref;

import java.util.ArrayList;
import java.util.List;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.Book;
import dict.com.huiyuandict.data.Conf;
import dict.com.huiyuandict.fragments.AboutFragment;
import dict.com.huiyuandict.fragments.ProjectFragment;
import dict.com.huiyuandict.fragments.StudyFragment;
import jonathanfinerty.once.Once;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    protected LinearLayout contentLayout;
    protected DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private List<Fragment> fragments;
    protected ImageView ivBooks;
    protected ImageView ivMenu1;
    protected ImageView ivMenu2;
    protected ImageView ivMenu3;
    protected ImageView ivMenu4;
    protected LinearLayout llMenu1;
    protected LinearLayout llMenu2;
    protected LinearLayout llMenu3;
    protected LinearLayout llMenu4;
    protected FrameLayout middleContent;
    protected Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setSupportActionBar(this.toolbar);
        this.toolbar.setTitle((CharSequence) "背单词");

        String showWhatsNew = "initbook";
        if (!Once.beenDone(1, showWhatsNew)) {
            ArrayList<Book> books = new ArrayList();
            books.add(new Book("cet4-1.sqlite", "CET-4精选单词（一）", 40, 1600, true));
            books.add(new Book("cet4-2.sqlite", "CET-4精选单词（二）", 40, 1600));
            books.add(new Book("cet4-3.sqlite", "CET-4精选单词（三）", 30, 1200));
            books.add(new Book("cet6-1.sqlite", "CET-6精选单词（一）", 40, 1600));
            books.add(new Book("cet6-2.sqlite", "CET-6精选单词（二）", 40, 1600));
            books.add(new Book("cet6-3.sqlite", "CET-6精选单词（三）", 29, 1152));
            AnyPref.put(new Conf(books, 0));
            Once.markDone(showWhatsNew);
        }


        this.fragments = new ArrayList();
        this.fragments.add(new StudyFragment());
//        this.fragments.add(new YilanFragment());
        this.fragments.add(new ProjectFragment());
        this.fragments.add(new AboutFragment());
        this.fragmentManager = getFragmentManager();
        this.llMenu1.performClick();


    }


    private void initView() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.middleContent = (FrameLayout) findViewById(R.id.middle_content);
        this.ivMenu1 = (ImageView) findViewById(R.id.iv_menu_1);
        this.llMenu1 = (LinearLayout) findViewById(R.id.ll_menu_1);
        this.llMenu1.setOnClickListener(this);
        this.ivMenu2 = (ImageView) findViewById(R.id.iv_menu_2);
        this.llMenu2 = (LinearLayout) findViewById(R.id.ll_menu_2);
        this.llMenu2.setOnClickListener(this);
        this.ivMenu3 = (ImageView) findViewById(R.id.iv_menu_3);
        this.llMenu3 = (LinearLayout) findViewById(R.id.ll_menu_3);
        this.llMenu3.setOnClickListener(this);
        this.ivMenu4 = (ImageView) findViewById(R.id.iv_menu_4);
        this.llMenu4 = (LinearLayout) findViewById(R.id.ll_menu_4);
        this.llMenu4.setOnClickListener(this);
        this.contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.ivBooks = (ImageView) findViewById(R.id.iv_books);
        this.ivBooks.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, BooksActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setNormal() {
        this.ivMenu1.setImageResource(R.drawable.ic_menu_xuexi_normal);
        this.ivMenu2.setImageResource(R.drawable.ic_menu_yilan_normal);
        this.ivMenu3.setImageResource(R.drawable.ic_menu_fuxi_normal);
        this.ivMenu4.setImageResource(R.drawable.ic_menu_baogao_normal);
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        if (view.getId() == R.id.ll_menu_1) {
            setNormal();
            this.ivMenu1.setImageResource(R.drawable.ic_menu_xuexi_selected);
            fragmentTransaction.replace(R.id.middle_content, (Fragment) this.fragments.get(0));
        } else if (view.getId() == R.id.ll_menu_2) {
            setNormal();
            this.ivMenu2.setImageResource(R.drawable.ic_menu_yilan_selected);
            fragmentTransaction.replace(R.id.middle_content, (Fragment) this.fragments.get(1));
        } else if (view.getId() == R.id.ll_menu_3) {
            setNormal();
            this.ivMenu3.setImageResource(R.drawable.ic_menu_fuxi_selected);
            fragmentTransaction.replace(R.id.middle_content, (Fragment) this.fragments.get(2));
        } else if (view.getId() == R.id.ll_menu_4) {
            setNormal();
            this.ivMenu4.setImageResource(R.drawable.ic_menu_baogao_selected);
            fragmentTransaction.replace(R.id.middle_content, (Fragment) this.fragments.get(3));
        }
        fragmentTransaction.commit();
    }
}
