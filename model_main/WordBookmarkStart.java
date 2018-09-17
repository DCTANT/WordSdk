package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;

public class WordBookmarkStart extends BaseWord
{
    private String id;
    private String name;
    
    public WordBookmarkStart() {
        this.tagName = "w:bookmarkStart";
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
    
    @Override
    public String toString() {
        return "WordBookmarkStart{id='" + this.id + '\'' + ", name='" + this.name + '\'' + '}';
    }
}
