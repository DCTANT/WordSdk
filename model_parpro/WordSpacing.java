package com.chisalsoft.wordsdk.model_parpro;

import com.chisalsoft.wordsdk.model.*;

public class WordSpacing extends BaseWord
{
    private String aW;
    private String aX;
    private String aY;
    private String aZ;
    private String ba;
    private String line;
    private String bb;
    private String aV;
    
    public WordSpacing() {
        this.tagName = "w:spacing";
    }
    
    public String getBefore() {
        return this.aW;
    }
    
    public void setBefore(final String before) {
        this.aW = before;
    }
    
    public String getBeforeAutospacing() {
        return this.aX;
    }
    
    public void setBeforeAutospacing(final String beforeAutospacing) {
        this.aX = beforeAutospacing;
    }
    
    public String getAfterLines() {
        return this.aY;
    }
    
    public void setAfterLines(final String afterLines) {
        this.aY = afterLines;
    }
    
    public String getAfterAutospacing() {
        return this.ba;
    }
    
    public void setAfterAutospacing(final String afterAutospacing) {
        this.ba = afterAutospacing;
    }
    
    public String getLine() {
        return this.line;
    }
    
    public void setLine(final String line) {
        this.line = line;
    }
    
    public String getLineRule() {
        return this.bb;
    }
    
    public void setLineRule(final String lineRule) {
        this.bb = lineRule;
    }
    
    public String getAfter() {
        return this.aZ;
    }
    
    public void setAfter(final String after) {
        this.aZ = after;
    }
    
    public String getAttrVal() {
        return this.aV;
    }
    
    public void setAttrVal(final String attrVal) {
        this.aV = attrVal;
    }
    
    @Override
    public String toString() {
        return "WordSpacing{before='" + this.aW + '\'' + ", beforeAutospacing='" + this.aX + '\'' + ", afterLines='" + this.aY + '\'' + ", after='" + this.aZ + '\'' + ", afterAutospacing='" + this.ba + '\'' + ", line='" + this.line + '\'' + ", lineRule='" + this.bb + '\'' + ", attrVal='" + this.aV + '\'' + '}';
    }
}
