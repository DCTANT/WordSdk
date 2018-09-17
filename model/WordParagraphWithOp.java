package com.chisalsoft.wordsdk.model;

import com.chisalsoft.wordsdk.model_main.*;
import java.util.*;

public class WordParagraphWithOp
{
    private WordParagraph L;
    private HashMap<String, String> M;
    
    public WordParagraph getWordParagraph() {
        return this.L;
    }
    
    public void setWordParagraph(final WordParagraph wordParagraph) {
        this.L = wordParagraph;
    }
    
    public HashMap<String, String> getParamMap() {
        return this.M;
    }
    
    public void setParamMap(final HashMap<String, String> paramMap) {
        this.M = paramMap;
    }
}
