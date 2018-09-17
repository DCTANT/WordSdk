package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpEffectExtent extends BaseWord
{
    private String am;
    private String t;
    private String an;
    private String ao;
    
    public WpEffectExtent() {
        this.tagName = "wp:effectExtent";
    }
    
    public String getL() {
        return this.am;
    }
    
    public void setL(final String l) {
        this.am = l;
    }
    
    public String getT() {
        return this.t;
    }
    
    public void setT(final String t) {
        this.t = t;
    }
    
    public String getR() {
        return this.an;
    }
    
    public void setR(final String r) {
        this.an = r;
    }
    
    public String getB() {
        return this.ao;
    }
    
    public void setB(final String b) {
        this.ao = b;
    }
}
