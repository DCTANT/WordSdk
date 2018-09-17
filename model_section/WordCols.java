package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordCols extends BaseWord
{
    private String aS;
    
    public WordCols() {
        this.tagName = "w:cols";
    }
    
    public String getSpace() {
        return this.aS;
    }
    
    public void setSpace(final String space) {
        this.aS = space;
    }
    
    @Override
    public String toString() {
        return "WordCols{space='" + this.aS + '\'' + '}';
    }
}
