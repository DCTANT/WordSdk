package com.chisalsoft.wordsdk.model_parpro;

import com.chisalsoft.wordsdk.model.*;

public class WordTabs extends BaseWord
{
    private WordTab bd;
    
    public WordTabs() {
        this.tagName = "w:tabs";
    }
    
    public WordTab getWordTab() {
        return this.bd;
    }
    
    public void setWordTab(final WordTab wordTab) {
        this.bd = wordTab;
    }
}
