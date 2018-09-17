package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;

public class WordBookmarkEnd extends BaseWord
{
    private String id;
    
    public WordBookmarkEnd() {
        this.tagName = "w:bookmarkEnd";
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "WordBookmarkEnd{id='" + this.id + '\'' + '}';
    }
}
