package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordPageMargin extends BaseWord
{
    private String bj;
    private String bk;
    private String bl;
    private String bm;
    private String bn;
    private String bo;
    private String bp;
    
    public WordPageMargin() {
        this.tagName = "w:pgMar";
    }
    
    public String getTop() {
        return this.bj;
    }
    
    public void setTop(final String top) {
        this.bj = top;
    }
    
    public String getRight() {
        return this.bk;
    }
    
    public void setRight(final String right) {
        this.bk = right;
    }
    
    public String getBottom() {
        return this.bl;
    }
    
    public void setBottom(final String bottom) {
        this.bl = bottom;
    }
    
    public String getLeft() {
        return this.bm;
    }
    
    public void setLeft(final String left) {
        this.bm = left;
    }
    
    public String getHeader() {
        return this.bn;
    }
    
    public void setHeader(final String header) {
        this.bn = header;
    }
    
    public String getFooter() {
        return this.bo;
    }
    
    public void setFooter(final String footer) {
        this.bo = footer;
    }
    
    public String getGutter() {
        return this.bp;
    }
    
    public void setGutter(final String gutter) {
        this.bp = gutter;
    }
    
    @Override
    public String toString() {
        return "WordPageMargin{top='" + this.bj + '\'' + ", right='" + this.bk + '\'' + ", bottom='" + this.bl + '\'' + ", left='" + this.bm + '\'' + ", header='" + this.bn + '\'' + ", footer='" + this.bo + '\'' + ", gutter='" + this.bp + '\'' + '}';
    }
}
