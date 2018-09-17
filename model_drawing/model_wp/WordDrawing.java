package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WordDrawing extends BaseWord
{
    private WpAnchor N;
    private String O;
    
    public WordDrawing() {
        this.tagName = "w:drawing";
    }
    
    public WpAnchor getWpAnchor() {
        return this.N;
    }
    
    public void setWpAnchor(final WpAnchor wpAnchor) {
        this.N = wpAnchor;
    }
    
    public String getXmlDrawingString() {
        return this.O;
    }
    
    public void setXmlDrawingString(final String xmlDrawingString) {
        this.O = xmlDrawingString;
    }
    
    @Override
    public String toString() {
        return "WordDrawing{wpAnchor=" + this.N + ", xmlDrawingString='" + this.O + '\'' + '}';
    }
}
