package dict.com.huiyuandict.data;

import java.io.Serializable;

public class WordDetail implements Serializable {
    private int error;
    private int item0;
    private String liju1en;
    private String liju1zh;
    private String liju2en;
    private String liju2zh;
    private String liju3en;
    private String liju3zh;
    private String shuoming;
    private String shuoming2;
    private String shuoming3;
    private String unit;
    private String word;
    private String yinbiao;

    public int getItem0() {
        return this.item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getYinbiao() {
        return this.yinbiao;
    }

    public void setYinbiao(String yinbiao) {
        this.yinbiao = yinbiao;
    }

    public String getShuoming() {
        return this.shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    public String getShuoming2() {
        return this.shuoming2;
    }

    public void setShuoming2(String shuoming2) {
        this.shuoming2 = shuoming2;
    }

    public String getShuoming3() {
        return this.shuoming3;
    }

    public void setShuoming3(String shuoming3) {
        this.shuoming3 = shuoming3;
    }

    public String getLiju1zh() {
        return this.liju1zh;
    }

    public void setLiju1zh(String liju1zh) {
        this.liju1zh = liju1zh;
    }

    public String getLiju2zh() {
        return this.liju2zh;
    }

    public void setLiju2zh(String liju2zh) {
        this.liju2zh = liju2zh;
    }

    public String getLiju3zh() {
        return this.liju3zh;
    }

    public void setLiju3zh(String liju3zh) {
        this.liju3zh = liju3zh;
    }

    public String getLiju1en() {
        return this.liju1en;
    }

    public void setLiju1en(String liju1en) {
        this.liju1en = liju1en;
    }

    public String getLiju2en() {
        return this.liju2en;
    }

    public void setLiju2en(String liju2en) {
        this.liju2en = liju2en;
    }

    public String getLiju3en() {
        return this.liju3en;
    }

    public void setLiju3en(String liju3en) {
        this.liju3en = liju3en;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getError() {
        return this.error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String toString() {
        return "WordDetail{item0=" + this.item0 + ", word='" + this.word + '\'' + ", yinbiao='" + this.yinbiao + '\'' + ", shuoming='" + this.shuoming + '\'' + ", shuoming2='" + this.shuoming2 + '\'' + ", shuoming3='" + this.shuoming3 + '\'' + ", liju1zh='" + this.liju1zh + '\'' + ", liju2zh='" + this.liju2zh + '\'' + ", liju3zh='" + this.liju3zh + '\'' + ", liju1en='" + this.liju1en + '\'' + ", liju2en='" + this.liju2en + '\'' + ", liju3en='" + this.liju3en + '\'' + '}';
    }
}
