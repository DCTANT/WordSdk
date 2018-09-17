package com.chisalsoft.wordsdk.model_main;

import com.chisalsoft.wordsdk.model.*;
import java.util.*;
import com.chisalsoft.wordsdk.model_section.*;

public class WordBody extends BaseWord
{
    private ArrayList<WordParagraph> au;
    private WordSectionPro av;
    
    public WordBody() {
        this.tagName = "w:body";
    }
    
    public ArrayList<WordParagraph> getParagraphList() {
        return this.au;
    }
    
    public void setParagraphList(final ArrayList<WordParagraph> paragraphList) {
        this.au = paragraphList;
    }
    
    public WordSectionPro getWordSectionPro() {
        return this.av;
    }
    
    public void setWordSectionPro(final WordSectionPro wordSectionPro) {
        this.av = wordSectionPro;
    }
    
    @Override
    public String toString() {
        return "WordBody{paragraphList=" + this.au + ", wordSectionPro=" + this.av + '}';
    }
}
