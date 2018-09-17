package com.chisalsoft.wordsdk.control;

import com.chisalsoft.wordsdk.util.*;

public class WordExtracter
{
    private String n;
    private String x;
    
    public WordExtracter(String templateDocxPath) {
        this.n = templateDocxPath.replace("\\", "/");
        final int slash = (templateDocxPath = this.n).lastIndexOf("/");
        final String rootPath = templateDocxPath.substring(0, slash + 1);
        final int indexOfDot = (templateDocxPath = templateDocxPath.substring(slash + 1, templateDocxPath.length())).lastIndexOf(".");
        templateDocxPath = templateDocxPath.substring(0, indexOfDot);
        this.x = rootPath + templateDocxPath + "/";
    }
    
    public void extract() {
        try {
            WordZipUtil.unzip(this.n, this.x, "");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String getDesExtractPath() {
        return this.x;
    }
    
    public void setDesExtractPath(final String desExtractPath) {
        this.x = desExtractPath;
    }
}
