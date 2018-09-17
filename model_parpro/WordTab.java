package com.chisalsoft.wordsdk.model_parpro;

import com.chisalsoft.wordsdk.model.*;

public class WordTab extends BaseWord
{
    private String aV;
    private String bc;
    
    public WordTab() {
        this.tagName = "w:tab";
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
    
    public String getPos() {
        return this.bc;
    }
    
    public void setPos(final String pos) {
        this.bc = pos;
    }
    
    @Override
    public String toString() {
        return "WordTab{attrVal='" + this.aV + '\'' + ", pos='" + this.bc + '\'' + '}';
    }
}
