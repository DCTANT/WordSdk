package com.chisalsoft.wordsdk.model_parpro;

import com.chisalsoft.wordsdk.model.*;

public class WordJc extends BaseWord
{
    private String aV;
    
    public WordJc() {
        this.tagName = "w:jc";
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
    
    @Override
    public String toString() {
        return "WordJc{attrVal='" + this.aV + '\'' + '}';
    }
}
