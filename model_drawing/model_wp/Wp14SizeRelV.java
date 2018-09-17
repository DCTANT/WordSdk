package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class Wp14SizeRelV extends BaseWord
{
    private String P;
    private Wp14PctHeight R;
    
    public Wp14SizeRelV() {
        this.tagName = "wp14:sizeRelV";
    }
    
    public String getRelativeFrom() {
        return this.P;
    }
    
    public void setRelativeFrom(final String relativeFrom) {
        this.P = relativeFrom;
    }
    
    public Wp14PctHeight getWp14PctHeight() {
        return this.R;
    }
    
    public void setWp14PctHeight(final Wp14PctHeight wp14PctHeight) {
        this.R = wp14PctHeight;
    }
}
