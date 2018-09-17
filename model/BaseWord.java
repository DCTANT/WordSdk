package com.chisalsoft.wordsdk.model;

import java.util.*;
import java.io.*;

public class BaseWord implements Serializable
{
    protected String tagName;
    protected String value;
    protected ArrayList<String> unknowTag;
    
    public String getTagName() {
        return this.tagName;
    }
    
    public void setTagName(final String tagName) {
        this.tagName = tagName;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public void setValue(final String value) {
        this.value = value;
    }
    
    public ArrayList<String> getUnknowTag() {
        return this.unknowTag;
    }
    
    public void setUnknowTag(final ArrayList<String> unknowTag) {
        this.unknowTag = unknowTag;
    }
    
    public BaseWord clone() {
        try {
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(this);
            final ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            return (BaseWord)new ObjectInputStream(bis).readObject();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
