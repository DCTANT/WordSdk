package com.chisalsoft.wordsdk.control;

import java.io.*;
import cn.hutool.core.io.*;
import java.util.*;

public class WordPicOverWritter
{
    private String A;
    
    public WordPicOverWritter(final String docxRootDirectory) {
        this.A = docxRootDirectory;
    }
    
    public void overWritePic(final HashMap<Integer, String> imgMap) {
        final String picFold = this.A;
        for (final Map.Entry<Integer, String> entry : imgMap.entrySet()) {
            if (new File(picFold + entry.getKey() + ".jpeg").exists()) {
                FileUtil.copy((String)entry.getValue(), picFold + entry.getKey() + ".jpeg", true);
                return;
            }
            if (new File(picFold + entry.getKey() + ".png").exists()) {
                FileUtil.copy((String)entry.getValue(), picFold + entry.getKey() + ".png", true);
            }
        }
    }
}
