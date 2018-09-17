package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;
import java.util.*;

public class WordParagraph extends BaseWord
{
    private WordParPro aC;
    private ArrayList<WordRun> aD;
    private String aE;
    private String aF;
    private String aG;
    private WordBookmarkStart aH;
    private WordBookmarkEnd aI;
    private int index;
    
    public WordParagraph() {
        this.tagName = "w:p";
    }
    
    public WordParPro getWordParPro() {
        return this.aC;
    }
    
    public void setWordParPro(final WordParPro wordParPro) {
        this.aC = wordParPro;
    }
    
    public ArrayList<WordRun> getRunList() {
        return this.aD;
    }
    
    public void setRunList(final ArrayList<WordRun> runList) {
        this.aD = runList;
    }
    
    public String getRsidR() {
        return this.aE;
    }
    
    public void setRsidR(final String rsidR) {
        this.aE = rsidR;
    }
    
    public String getRsidRDefault() {
        return this.aF;
    }
    
    public void setRsidRDefault(final String rsidRDefault) {
        this.aF = rsidRDefault;
    }
    
    public String getRsidP() {
        return this.aG;
    }
    
    public void setRsidP(final String rsidP) {
        this.aG = rsidP;
    }
    
    public WordBookmarkStart getWordBookmarkStart() {
        return this.aH;
    }
    
    public void setWordBookmarkStart(final WordBookmarkStart wordBookmarkStart) {
        this.aH = wordBookmarkStart;
    }
    
    public WordBookmarkEnd getWordBookmarkEnd() {
        return this.aI;
    }
    
    public void setWordBookmarkEnd(final WordBookmarkEnd wordBookmarkEnd) {
        this.aI = wordBookmarkEnd;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(final int index) {
        this.index = index;
    }
    
    @Override
    public String toString() {
        return "WordParagraph{wordParPro=" + this.aC + ", runList=" + this.aD + ", rsidR='" + this.aE + '\'' + ", rsidRDefault='" + this.aF + '\'' + ", rsidP='" + this.aG + '\'' + ", wordBookmarkStart=" + this.aH + ", wordBookmarkEnd=" + this.aI + ", index=" + this.index + '}';
    }
}
