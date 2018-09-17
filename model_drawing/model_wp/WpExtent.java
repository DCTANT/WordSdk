package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpExtent extends BaseWord
{
    private String ap;
    private String aq;
    
    public WpExtent() {
        this.tagName = "wp:extent";
    }
    
    public String getCx() {
        return this.ap;
    }
    
    public void setCx(final String cx) {
        this.ap = cx;
    }
    
    public String getCy() {
        return this.aq;
    }
    
    public void setCy(final String cy) {
        this.aq = cy;
    }
}
