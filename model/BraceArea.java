package com.chisalsoft.wordsdk.model;

public class BraceArea
{
    private int F;
    private int G;
    private int H;
    private int I;
    
    public int getStartParagraphIndex() {
        return this.F;
    }
    
    public void setStartParagraphIndex(final int startParagraphIndex) {
        this.F = startParagraphIndex;
    }
    
    public int getStartRunIndex() {
        return this.G;
    }
    
    public void setStartRunIndex(final int startRunIndex) {
        this.G = startRunIndex;
    }
    
    public int getEndParagraphIndex() {
        return this.H;
    }
    
    public void setEndParagraphIndex(final int endParagraphIndex) {
        this.H = endParagraphIndex;
    }
    
    public int getEndRunIndex() {
        return this.I;
    }
    
    public void setEndRunIndex(final int endRunIndex) {
        this.I = endRunIndex;
    }
    
    @Override
    public String toString() {
        return "BraceArea{startParagraphIndex=" + this.F + ", startRunIndex=" + this.G + ", endParagraphIndex=" + this.H + ", endRunIndex=" + this.I + '}';
    }
}
