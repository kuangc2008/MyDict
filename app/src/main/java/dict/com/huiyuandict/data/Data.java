package dict.com.huiyuandict.data;

import java.io.Serializable;

public class Data implements Serializable {
    private String content;
    private int id;
    private String part;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String toString() {
        return "Data{title='" + this.title + '\'' + ", content='" + this.content + '\'' + ", id=" + this.id + ", part='" + this.part + '\'' + '}';
    }
}
