package dict.com.huiyuandict.data;


import net.nashlegend.anypref.annotations.PrefArrayList;

import java.io.Serializable;
import java.util.List;



public class Conf implements Serializable {
    @PrefArrayList
    public List<Book> books;
    public int selectId;

    public Conf() {

    }

    public Conf(List<Book> books, int selectId) {
        this.books = books;
        this.selectId = selectId;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getSelectId() {
        return this.selectId;
    }

    public void setSelectId(int selectId) {
        this.selectId = selectId;
    }
}
