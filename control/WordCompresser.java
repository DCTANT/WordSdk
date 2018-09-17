package com.chisalsoft.wordsdk.control;

import net.lingala.zip4j.core.*;
import java.io.*;
import net.lingala.zip4j.model.*;
import java.util.*;

public class WordCompresser
{
    private String y;
    private String z;
    
    public WordCompresser(final String docxPath, final String upzipDirectoryPath) {
        this.y = docxPath.replace("\\", "/");
        this.z = upzipDirectoryPath.replace("\\", "/");
    }
    
    public void compress() {
        try {
            final ZipFile zipFile = new ZipFile(this.y);
            final File file = new File(this.z);
            System.out.println("upzipDirectoryPath is " + this.z);
            final ArrayList<File> fileList = new ArrayList<File>();
            File[] listFiles;
            for (int length = (listFiles = file.listFiles()).length, i = 0; i < length; ++i) {
                final File file2 = listFiles[i];
                fileList.add(file2);
            }
            final ZipParameters parameters;
            (parameters = new ZipParameters()).setCompressionMethod(8);
            parameters.setCompressionLevel(5);
            zipFile.addFiles((ArrayList)fileList, parameters);
            final Iterator<File> iterator = fileList.iterator();
            while (iterator.hasNext()) {
                final File srcFile;
                if ((srcFile = iterator.next()).isDirectory()) {
                    final File[] subFiles = srcFile.listFiles();
                    final ArrayList<File> temp;
                    Collections.addAll(temp = new ArrayList<File>(), subFiles);
                    zipFile.addFiles((ArrayList)temp, parameters);
                    zipFile.addFolder(srcFile, parameters);
                }
                else {
                    final String name = srcFile.getName();
                    System.out.println("srcFile name " + name);
                    final String[] split = name.split("\\.");
                    System.out.println("split length is " + split.length);
                    final String[] array = split;
                    if (array[array.length - 1].equals("docx")) {
                        continue;
                    }
                    zipFile.addFile(srcFile, parameters);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
