package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordFooterReference extends BaseWord
{
    private String type;
    private String bi;
    
    public WordFooterReference() {
        this.tagName = "w:footerReference";
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getrId() {
        return this.bi;
    }
    
    public void setrId(final String rId) {
        this.bi = rId;
    }
    
    @Override
    public String toString() {
        return "WordHeaderReference{type='" + this.type + '\'' + ", rId='" + this.bi + '\'' + '}';
    }
}
