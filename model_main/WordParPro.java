package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;
import com.chisalsoft.wordsdk.model_parpro.*;

public class WordParPro extends BaseWord
{
    private WordRunPro aw;
    private WordWidowControl ax;
    private WordTabs ay;
    private WordSpacing az;
    private WordJc aA;
    private WordInd aB;
    
    public WordParPro() {
        this.tagName = "w:pPr";
    }
    
    public WordRunPro getRunPro() {
        return this.aw;
    }
    
    public void setRunPro(final WordRunPro runPro) {
        this.aw = runPro;
    }
    
    public WordWidowControl getWordWidowControl() {
        return this.ax;
    }
    
    public void setWordWidowControl(final WordWidowControl wordWidowControl) {
        this.ax = wordWidowControl;
    }
    
    public WordTabs getWordTabs() {
        return this.ay;
    }
    
    public void setWordTabs(final WordTabs wordTabs) {
        this.ay = wordTabs;
    }
    
    public WordSpacing getWordSpacing() {
        return this.az;
    }
    
    public void setWordSpacing(final WordSpacing wordSpacing) {
        this.az = wordSpacing;
    }
    
    public WordJc getWordJc() {
        return this.aA;
    }
    
    public void setWordJc(final WordJc wordJc) {
        this.aA = wordJc;
    }
    
    public WordInd getWordInd() {
        return this.aB;
    }
    
    public void setWordInd(final WordInd wordInd) {
        this.aB = wordInd;
    }
    
    @Override
    public String toString() {
        return "WordParPro{runPro=" + this.aw + ", wordWidowControl=" + this.ax + ", wordTabs=" + this.ay + ", wordSpacing=" + this.az + ", wordJc=" + this.aA + ", wordInd=" + this.aB + '}';
    }
}
