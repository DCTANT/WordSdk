package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpSimplePos extends BaseWord
{
    private String as;
    private String at;
    
    public WpSimplePos() {
        this.tagName = "wp:simplePos";
    }
    
    public String getX() {
        return this.as;
    }
    
    public void setX(final String x) {
        this.as = x;
    }
    
    public String getY() {
        return this.at;
    }
    
    public void setY(final String y) {
        this.at = y;
    }
    
    @Override
    public String toString() {
        return "WpSimplePos{x='" + this.as + '\'' + ", y='" + this.at + '\'' + '}';
    }
}
