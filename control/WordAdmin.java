package com.chisalsoft.wordsdk.control;

import com.chisalsoft.wordsdk.io.reader.*;
import com.chisalsoft.wordsdk.io.writer.*;
import java.io.*;
import com.google.gson.*;
import com.chisalsoft.wordsdk.model.*;
import java.util.*;
import com.chisalsoft.wordsdk.model_main.*;

public class WordAdmin
{
    private WordExtracter b;
    private WordCompresser c;
    private Replacer d;
    private WordPicOverWritter e;
    private WordDocumentReader f;
    private WordDocumentWriter g;
    private WordHeadFootReader h;
    private WordHeadFootWriter i;
    private WordHeadFootReader j;
    private WordHeadFootWriter k;
    private WordToPdf l;
    private WordTempDeleter m;
    private String n;
    private String o;
    private File p;
    private final String q;
    private String r;
    private String s;
    private String u;
    private String v;
    private String w;
    private final String x;
    private Gson gson;
    
    public WordAdmin(String templateDocxPath, final String openOfficePath) {
        this.w = openOfficePath;
        templateDocxPath = templateDocxPath.replace("\\", "/");
        this.n = templateDocxPath;
        this.p = new File(templateDocxPath);
        this.o = this.p.getName();
        final int lastSlash = templateDocxPath.lastIndexOf("/");
        this.q = templateDocxPath.substring(0, lastSlash + 1);
        this.r = this.q + "$" + this.o;
        this.b = new WordExtracter(templateDocxPath);
        this.x = this.b.getDesExtractPath();
        System.out.println("desExtractPath is " + this.x + " tempDocxFilePath is " + this.r);
        this.c = new WordCompresser(this.r, this.x);
        this.s = this.x + "/word/document.xml";
        this.u = this.x + "/word/header1.xml";
        this.v = this.x + "/word/footer1.xml";
        this.f = new WordDocumentReader(this.s);
        this.g = new WordDocumentWriter(this.s);
        this.h = new WordHeadFootReader(this.u);
        this.i = new WordHeadFootWriter(this.u, true);
        this.j = new WordHeadFootReader(this.v);
        this.k = new WordHeadFootWriter(this.v, false);
        this.l = new WordToPdf(this.r, this.q + this.o.substring(0, this.o.lastIndexOf(".")) + ".pdf", openOfficePath);
        this.m = new WordTempDeleter(this.x, this.r);
        this.gson = new Gson();
    }
    
    public void admin(final HashMap<String, String> documentParamsMap, final WordListReplacerModel documentWordListReplacerModel, final ArrayList<WordListReplacerModel> wordListReplacerModelList, final HashMap<Integer, String> imgMap, final HashMap<String, String> headerParamsMap, final HashMap<String, String> footerParamsMap) {
        this.b.extract();
        final WordBody wordBody = this.f.readXml();
        this.d = new Replacer(wordBody.getParagraphList());
        if (documentParamsMap != null) {
            this.d.replaceParas(documentParamsMap);
        }
        if (documentWordListReplacerModel != null) {
            this.d.replaceList(documentWordListReplacerModel.getListName(), documentWordListReplacerModel.getReplaceMapList());
        }
        if (wordListReplacerModelList != null) {
            this.d.replaceLists(wordListReplacerModelList);
        }
        this.g.writeXml(wordBody);
        if (imgMap != null) {
            (this.e = new WordPicOverWritter(this.x + "word/media/image")).overWritePic(imgMap);
        }
        if (headerParamsMap != null) {
            final ArrayList<WordParagraph> wordHeadParagraphList = this.h.readXml();
            System.out.println(this.gson.toJson((Object)wordHeadParagraphList));
            final ArrayList<WordParagraph> wordParagraphArrayList = new Replacer(wordHeadParagraphList).replaceParas(headerParamsMap);
            this.i.writeXml(wordParagraphArrayList);
        }
        if (footerParamsMap != null) {
            final ArrayList<WordParagraph> wordHeadParagraphList = this.j.readXml();
            System.out.println(this.gson.toJson((Object)wordHeadParagraphList));
            final ArrayList<WordParagraph> wordParagraphArrayList = new Replacer(wordHeadParagraphList).replaceParas(headerParamsMap);
            this.k.writeXml(wordParagraphArrayList);
        }
        this.c.compress();
        this.l.convert();
        this.m.deleteTemp();
    }
}
