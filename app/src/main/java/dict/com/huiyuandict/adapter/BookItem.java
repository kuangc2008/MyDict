package dict.com.huiyuandict.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.nashlegend.anypref.AnyPref;


import dict.com.huiyuandict.R;
import dict.com.huiyuandict.data.Book;
import dict.com.huiyuandict.data.Conf;
import kale.adapter.item.AdapterItem;

public class BookItem implements AdapterItem<Book> {
    private View rootView;
    protected LinearLayout selectPanel;
    protected LinearLayout textPanel;
    protected LinearLayout topLayout;
    protected TextView tvCurBook;
    protected TextView tvSize;
    protected TextView tvSubTitle;
    protected TextView tvTitle;

    public int getLayoutResId() {
        return R.layout.books_local_item;
    }

    public void bindViews(View view) {
        initView(view);
    }

    public void setViews() {
    }

    public void handleData(Book book, int i) {
        this.tvTitle.setText(book.getTitle());
        this.tvSubTitle.setText(book.getUnit() + "个单元，共" + book.getWordCount() + "个单词");
        if (((Conf) AnyPref.get(Conf.class)).getSelectId() == i) {
            this.tvCurBook.setVisibility(0);
        } else {
            this.tvCurBook.setVisibility(8);
        }
    }

    private void initView(View rootView) {
        this.rootView = rootView;
        this.tvCurBook = (TextView) rootView.findViewById(R.id.tvCurBook);
        this.selectPanel = (LinearLayout) rootView.findViewById(R.id.selectPanel);
        this.tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        this.tvSubTitle = (TextView) rootView.findViewById(R.id.tvSubTitle);
        this.tvSize = (TextView) rootView.findViewById(R.id.tvSize);
        this.textPanel = (LinearLayout) rootView.findViewById(R.id.textPanel);
        this.topLayout = (LinearLayout) rootView.findViewById(R.id.topLayout);
    }
}
