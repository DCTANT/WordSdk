package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpDocPr extends BaseWord
{
    private String id;
    private String name;
    
    public WpDocPr() {
        this.tagName = "wp:docPr";
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
}
