package dict.com.huiyuandict.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.nashlegend.anypref.AnyPref;

import java.util.List;

import dict.com.huiyuandict.BaseActivity;
import dict.com.huiyuandict.R;
import dict.com.huiyuandict.adapter.BookItem;
import dict.com.huiyuandict.data.Book;
import dict.com.huiyuandict.data.Conf;
import kale.adapter.CommonAdapter;
import kale.adapter.item.AdapterItem;


public class BooksActivity extends BaseActivity {
    private List<Book> books;
    private Conf conf;
    protected ListView listView;
    protected Toolbar toolbar;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView((int) R.layout.books_local);
        this.conf = (Conf) AnyPref.get(Conf.class);
        this.books = this.conf.getBooks();
        initView();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.toolbar.setTitle((CharSequence) "词汇管理");
    }

    private void initView() {
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.listView = (ListView) findViewById(R.id.listView);
        final CommonAdapter<Book> adapter = new CommonAdapter<Book>(this.books, 1) {
            @NonNull
            public AdapterItem createItem(Object o) {
                return new BookItem();
            }
        };
        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lambda$initView$0(BooksActivity.this, adapter, parent, view, position, id);
            }
        });
    }

    static /* synthetic */ void lambda$initView$0(BooksActivity this_, CommonAdapter adapter, AdapterView parent, View view, int position, long id) {
        this_.conf.setSelectId((int) id);
        AnyPref.put(this_.conf);
        adapter.notifyDataSetChanged();
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
