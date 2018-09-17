package com.chisalsoft.wordsdk.model_runpro;

import com.chisalsoft.wordsdk.model.*;

public class WordRunFonts extends BaseWord
{
    private String be;
    private String bf;
    private String bg;
    
    public WordRunFonts() {
        this.tagName = "w:rFonts";
    }
    
    public String getAscii() {
        return this.be;
    }
    
    public void setAscii(final String ascii) {
        this.be = ascii;
    }
    
    public String gethAnsi() {
        return this.bf;
    }
    
    public void sethAnsi(final String hAnsi) {
        this.bf = hAnsi;
    }
    
    public String getHint() {
        return this.bg;
    }
    
    public void setHint(final String hint) {
        this.bg = hint;
    }
    
    @Override
    public String toString() {
        return "WordRunFonts{ascii='" + this.be + '\'' + ", hAnsi='" + this.bf + '\'' + ", hint='" + this.bg + '\'' + '}';
    }
}
