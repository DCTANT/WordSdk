package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordHeaderReference extends BaseWord
{
    private String type;
    private String bi;
    
    public WordHeaderReference() {
        this.tagName = "w:headerReference";
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
