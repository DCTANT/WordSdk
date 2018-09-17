package com.chisalsoft.wordsdk.control;

import cn.hutool.core.io.*;

public class WordTempDeleter
{
    private String B;
    private String C;
    
    public WordTempDeleter(final String extractPath, final String tempDocxPath) {
        this.B = extractPath;
        this.C = tempDocxPath;
    }
    
    public void deleteTemp() {
        FileUtil.del(this.B);
        FileUtil.del(this.C);
    }
}
