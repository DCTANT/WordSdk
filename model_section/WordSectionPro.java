package com.chisalsoft.wordsdk.model_section;

import com.chisalsoft.wordsdk.model.*;

public class WordSectionPro extends BaseWord
{
    private String aE;
    private WordHeaderReference bs;
    private WordFooterReference bt;
    private WordPageSize bu;
    private WordPageMargin bv;
    private WordCols bw;
    private WordDocGrid bx;
    
    public WordSectionPro() {
        this.tagName = "w:sectPr";
    }
    
    public String getRsidR() {
        return this.aE;
    }
    
    public void setRsidR(final String rsidR) {
        this.aE = rsidR;
    }
    
    public WordHeaderReference getWordHeaderReference() {
        return this.bs;
    }
    
    public void setWordHeaderReference(final WordHeaderReference wordHeaderReference) {
        this.bs = wordHeaderReference;
    }
    
    public WordFooterReference getWordFooterReference() {
        return this.bt;
    }
    
    public void setWordFooterReference(final WordFooterReference wordFooterReference) {
        this.bt = wordFooterReference;
    }
    
    public WordPageSize getWordPageSize() {
        return this.bu;
    }
    
    public void setWordPageSize(final WordPageSize wordPageSize) {
        this.bu = wordPageSize;
    }
    
    public WordPageMargin getWordPageMargin() {
        return this.bv;
    }
    
    public void setWordPageMargin(final WordPageMargin wordPageMargin) {
        this.bv = wordPageMargin;
    }
    
    public WordCols getWordCols() {
        return this.bw;
    }
    
    public void setWordCols(final WordCols wordCols) {
        this.bw = wordCols;
    }
    
    public WordDocGrid getWordDocGrid() {
        return this.bx;
    }
    
    public void setWordDocGrid(final WordDocGrid wordDocGrid) {
        this.bx = wordDocGrid;
    }
    
    @Override
    public String toString() {
        return "WordSectionPro{rsidR='" + this.aE + '\'' + ", wordHeaderReference=" + this.bs + ", wordFooterReference=" + this.bt + ", wordPageSize=" + this.bu + ", wordPageMargin=" + this.bv + ", wordCols=" + this.bw + ", wordDocGrid=" + this.bx + '}';
    }
}
