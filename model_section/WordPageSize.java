package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordPageSize extends BaseWord
{
    private String bq;
    private String br;
    
    public WordPageSize() {
        this.tagName = "w:pgSz";
    }
    
    public String getWidth() {
        return this.bq;
    }
    
    public void setWidth(final String width) {
        this.bq = width;
    }
    
    public String getHeight() {
        return this.br;
    }
    
    public void setHeight(final String height) {
        this.br = height;
    }
}
