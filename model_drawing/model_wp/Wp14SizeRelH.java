package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class Wp14SizeRelH extends BaseWord
{
    private String P;
    private Wp14PctWidth Q;
    
    public Wp14SizeRelH() {
        this.tagName = "wp14:sizeRelH";
    }
    
    public String getRelativeFrom() {
        return this.P;
    }
    
    public void setRelativeFrom(final String relativeFrom) {
        this.P = relativeFrom;
    }
    
    public Wp14PctWidth getWp14PctWidth() {
        return this.Q;
    }
    
    public void setWp14PctWidth(final Wp14PctWidth wp14PctWidth) {
        this.Q = wp14PctWidth;
    }
}
