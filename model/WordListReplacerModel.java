package com.chisalsoft.wordsdk.model;

import java.util.*;

public class WordListReplacerModel
{
    private String J;
    private ArrayList<HashMap<String, String>> K;
    
    public WordListReplacerModel(final String listName, final ArrayList<HashMap<String, String>> replaceMapList) {
        this.J = listName;
        this.K = replaceMapList;
    }
    
    public String getListName() {
        return this.J;
    }
    
    public void setListName(final String listName) {
        this.J = listName;
    }
    
    public ArrayList<HashMap<String, String>> getReplaceMapList() {
        return this.K;
    }
    
    public void setReplaceMapList(final ArrayList<HashMap<String, String>> replaceMapList) {
        this.K = replaceMapList;
    }
}
