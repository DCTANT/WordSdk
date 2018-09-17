package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;
import com.chisalsoft.wordsdk.model_parpro.*;
import com.chisalsoft.wordsdk.model_runpro.*;

public class WordRunPro extends BaseWord
{
    private WordRunFonts aN;
    private WordBold aO;
    private WordSpacing az;
    private WordSz aP;
    private WordSzCs aQ;
    private WordUnderline aR;
    
    public WordRunPro() {
        this.tagName = "w:rPr";
    }
    
    public WordRunFonts getWordRunFonts() {
        return this.aN;
    }
    
    public void setWordRunFonts(final WordRunFonts wordRunFonts) {
        this.aN = wordRunFonts;
    }
    
    public WordBold getWordBold() {
        return this.aO;
    }
    
    public void setWordBold(final WordBold wordBold) {
        this.aO = wordBold;
    }
    
    public WordSpacing getWordSpacing() {
        return this.az;
    }
    
    public void setWordSpacing(final WordSpacing wordSpacing) {
        this.az = wordSpacing;
    }
    
    public WordSz getWordSz() {
        return this.aP;
    }
    
    public void setWordSz(final WordSz wordSz) {
        this.aP = wordSz;
    }
    
    public WordSzCs getWordSzCs() {
        return this.aQ;
    }
    
    public void setWordSzCs(final WordSzCs wordSzCs) {
        this.aQ = wordSzCs;
    }
    
    public WordUnderline getWordUnderline() {
        return this.aR;
    }
    
    public void setWordUnderline(final WordUnderline wordUnderline) {
        this.aR = wordUnderline;
    }
    
    @Override
    public String toString() {
        return "WordRunPro{wordRunFonts=" + this.aN + ", wordBold=" + this.aO + ", wordSpacing=" + this.az + ", wordSz=" + this.aP + ", wordSzCs=" + this.aQ + ", wordUnderline=" + this.aR + '}';
    }
}
