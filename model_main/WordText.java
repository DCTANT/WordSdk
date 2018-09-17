package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;

public class WordText extends BaseWord
{
    private String aS;
    
    public WordText() {
        this.tagName = "w:t";
    }
    
    public String getSpace() {
        return this.aS;
    }
    
    public void setSpace(final String space) {
        this.aS = space;
    }
}
