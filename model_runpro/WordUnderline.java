package com.chisalsoft.wordsdk.model_runpro;

import com.chisalsoft.wordsdk.model.*;

public class WordUnderline extends BaseWord
{
    private String aV;
    
    public WordUnderline() {
        this.tagName = "w:u";
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
}
