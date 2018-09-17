package com.chisalsoft.wordsdk.model_runpro;

import com.chisalsoft.wordsdk.model.*;

public class WordSzCs extends BaseWord
{
    private String aV;
    
    public WordSzCs() {
        this.tagName = "w:szCs";
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
}
