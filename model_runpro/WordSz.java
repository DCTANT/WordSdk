package com.chisalsoft.wordsdk.model_runpro;

import com.chisalsoft.wordsdk.model.*;

public class WordSz extends BaseWord
{
    private String aV;
    
    public WordSz() {
        this.tagName = "w:sz";
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
}
