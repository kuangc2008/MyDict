package dict.com.huiyuandict.data;

import java.io.Serializable;

public class Book implements Serializable {
    public String id;
    @Deprecated
    public boolean ischeck;
    public String title;
    public int unit;
    public int wordCount;

    public Book() {

    }

    public Book(String id, String title, int unit, int wordCount) {
        this.id = id;
        this.title = title;
        this.unit = unit;
        this.wordCount = wordCount;
    }

    public Book(String id, String title, int unit, int wordCount, boolean ischeck) {
        this.id = id;
        this.title = title;
        this.unit = unit;
        this.wordCount = wordCount;
        this.ischeck = ischeck;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUnit() {
        return this.unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public boolean ischeck() {
        return this.ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }
}
