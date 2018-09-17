package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordDocGrid extends BaseWord
{
    private String type;
    private String bh;
    
    public WordDocGrid() {
        this.tagName = "w:docGrid";
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public String getLinePitch() {
        return this.bh;
    }
    
    public void setLinePitch(final String linePitch) {
        this.bh = linePitch;
    }
    
    @Override
    public String toString() {
        return "WordDocGrid{type='" + this.type + '\'' + ", linePitch='" + this.bh + '\'' + '}';
    }
}
