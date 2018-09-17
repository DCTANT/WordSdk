package com.chisalsoft.wordsdk.util;

import net.lingala.zip4j.exception.*;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.model.*;
import java.util.*;
import java.io.*;

public class WordZipUtil
{
    private static WordZipUtil by;
    
    public static WordZipUtil getInstance() {
        if (WordZipUtil.by == null) {
            WordZipUtil.by = new WordZipUtil();
        }
        return WordZipUtil.by;
    }
    
    public static File[] unzip(final String zip, final String dest, final String passwd) throws ZipException {
        return unzip(new File(zip), dest, passwd);
    }
    
    public static File[] unzip(final String zip, final String passwd) throws ZipException {
        final File zipFile;
        final File parentDir = (zipFile = new File(zip)).getParentFile();
        return unzip(zipFile, parentDir.getAbsolutePath(), passwd);
    }
    
    public static File[] unzip(final File zipFile, final String dest, final String passwd) throws ZipException {
        final ZipFile zFile;
        (zFile = new ZipFile(zipFile)).setFileNameCharset("GBK");
        if (!zFile.isValidZipFile()) {
            throw new ZipException("\u538b\u7f29\u6587\u4ef6\u4e0d\u5408\u6cd5,\u53ef\u80fd\u88ab\u635f\u574f.");
        }
        final File destDir;
        if ((destDir = new File(dest)).isDirectory() && !destDir.exists()) {
            destDir.mkdir();
        }
        if (zFile.isEncrypted()) {
            zFile.setPassword(passwd.toCharArray());
        }
        zFile.extractAll(dest);
        final List<FileHeader> headerList = (List<FileHeader>)zFile.getFileHeaders();
        final List<File> extractedFileList = new ArrayList<File>();
        final Iterator<FileHeader> iterator = headerList.iterator();
        while (iterator.hasNext()) {
            final FileHeader fileHeader;
            if (!(fileHeader = iterator.next()).isDirectory()) {
                extractedFileList.add(new File(destDir, fileHeader.getFileName()));
            }
        }
        final File[] extractedFiles = new File[extractedFileList.size()];
        extractedFileList.toArray(extractedFiles);
        return extractedFiles;
    }
    
    public static String zip(final String src) {
        return zip(src, null);
    }
    
    public static String zip(final String src, final String passwd) {
        return zip(src, null, passwd);
    }
    
    public static String zip(final String src, final String dest, final String passwd) {
        return zip(src, dest, true, passwd);
    }
    
    public static String zip(final String src, String dest, final boolean isCreateDir, final String passwd) {
        final File file;
        final Serializable s = file = new File(src);
        String str = dest;
        dest = (String)s;
        if (StringUtil.isEmpty(str)) {
            if (((File)dest).isDirectory()) {
                str = ((File)dest).getParent() + "/" + ((File)dest).getName() + ".zip";
            }
            else {
                str = ((File)dest).getParent() + "/" + ((File)dest).getName().substring(0, ((File)dest).getName().lastIndexOf(".")) + ".zip";
            }
        }
        else {
            final String s2;
            File file2;
            if ((s2 = str).endsWith("/")) {
                file2 = new File(s2);
            }
            else {
                file2 = new File(s2.substring(0, s2.lastIndexOf("/")));
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (str.endsWith("/")) {
                String s3;
                if (((File)dest).isDirectory()) {
                    s3 = ((File)dest).getName();
                }
                else {
                    s3 = ((File)dest).getName().substring(0, ((File)dest).getName().lastIndexOf("."));
                }
                str = str + s3 + ".zip";
            }
        }
        dest = str;
        final ZipParameters parameters;
        (parameters = new ZipParameters()).setCompressionMethod(8);
        parameters.setCompressionLevel(5);
        if (!StringUtil.isEmpty(passwd)) {
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(0);
            parameters.setPassword(passwd.toCharArray());
        }
        try {
            final ZipFile zipFile = new ZipFile(dest);
            if (file.isDirectory()) {
                if (!isCreateDir) {
                    final File[] subFiles = file.listFiles();
                    final ArrayList<File> temp;
                    Collections.addAll(temp = new ArrayList<File>(), subFiles);
                    zipFile.addFiles((ArrayList)temp, parameters);
                    return dest;
                }
                zipFile.addFolder(file, parameters);
            }
            else {
                zipFile.addFile(file, parameters);
            }
            return dest;
        }
        catch (ZipException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
