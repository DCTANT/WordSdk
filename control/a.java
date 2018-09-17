package com.chisalsoft.wordsdk.control;

import java.util.*;
import com.chisalsoft.wordsdk.model_main.*;
import com.google.gson.*;

class a
{
    protected Gson gson;
    protected ArrayList<WordParagraph> totalParagraphList;
    
    public a(final ArrayList<WordParagraph> totalParagraphList) {
        this.totalParagraphList = totalParagraphList;
        this.gson = new GsonBuilder().create();
    }
}
