package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpPositionV extends BaseWord
{
    private String P;
    private WpPosOffset ar;
    
    public WpPositionV() {
        this.tagName = "wp:positionV";
    }
    
    public String getRelativeFrom() {
        return this.P;
    }
    
    public void setRelativeFrom(final String relativeFrom) {
        this.P = relativeFrom;
    }
    
    public WpPosOffset getWpPosOffset() {
        return this.ar;
    }
    
    public void setWpPosOffset(final WpPosOffset wpPosOffset) {
        this.ar = wpPosOffset;
    }
}
