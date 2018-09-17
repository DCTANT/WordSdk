package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;
import com.chisalsoft.wordsdk.model_drawing.model_wp.*;

public class WordRun extends BaseWord
{
    private WordRunPro aw;
    private WordText aJ;
    private String aE;
    private String aK;
    private int index;
    private WordDrawing aL;
    private int aM;
    
    public WordRun() {
        this.tagName = "w:r";
    }
    
    public WordRunPro getRunPro() {
        return this.aw;
    }
    
    public void setRunPro(final WordRunPro runPro) {
        this.aw = runPro;
    }
    
    public WordText getText() {
        return this.aJ;
    }
    
    public void setText(final WordText text) {
        this.aJ = text;
    }
    
    public String getRsidR() {
        return this.aE;
    }
    
    public void setRsidR(final String rsidR) {
        this.aE = rsidR;
    }
    
    public String getRsidRPr() {
        return this.aK;
    }
    
    public void setRsidRPr(final String rsidRPr) {
        this.aK = rsidRPr;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    public WordDrawing getWordDrawing() {
        return this.aL;
    }
    
    public void setWordDrawing(final WordDrawing wordDrawing) {
        this.aL = wordDrawing;
    }
    
    public int getParagraphIndex() {
        return this.aM;
    }
    
    public void setParagraphIndex(final int paragraphIndex) {
        this.aM = paragraphIndex;
    }
    
    @Override
    public String toString() {
        return "WordRun{runPro=" + this.aw + ", text=" + this.aJ + ", rsidR='" + this.aE + '\'' + ", rsidRPr='" + this.aK + '\'' + ", index=" + this.index + ", wordDrawing=" + this.aL + ", paragraphIndex=" + this.aM + '}';
    }
}
