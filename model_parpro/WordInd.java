package com.chisalsoft.wordsdk.model_parpro;

import com.chisalsoft.wordsdk.model.*;

public class WordInd extends BaseWord
{
    private String aT;
    private String aU;
    
    public WordInd() {
        this.tagName = "w:ind";
    }
    
    public String getFirstLineChars() {
        return this.aT;
    }
    
    public void setFirstLineChars(final String firstLineChars) {
        this.aT = firstLineChars;
    }
    
    public String getFirstLine() {
        return this.aU;
    }
    
    public void setFirstLine(final String firstLine) {
        this.aU = firstLine;
    }
    
    @Override
    public String toString() {
        return "WordInd{firstLineChars='" + this.aT + '\'' + ", firstLine='" + this.aU + '\'' + '}';
    }
}
