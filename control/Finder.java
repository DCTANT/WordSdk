package com.chisalsoft.wordsdk.control;

import java.util.*;
import com.chisalsoft.wordsdk.model_main.*;
import com.chisalsoft.wordsdk.model.*;
import java.io.*;

public class Finder extends a
{
    public Finder(final ArrayList<WordParagraph> totalParagraphList) {
        super(totalParagraphList);
    }
    
    public ArrayList<WordParagraph> findByText(final String text) {
        System.out.println("findByText text is " + text);
        final ArrayList<WordParagraph> wordParagraphResultList = new ArrayList<WordParagraph>();
        for (final WordParagraph wordParagraph : this.totalParagraphList) {
            final String totalString = this.getParagraphText(wordParagraph);
            System.out.println("totalString is " + totalString);
            if (totalString.contains(text)) {
                wordParagraphResultList.add(wordParagraph);
            }
        }
        return wordParagraphResultList;
    }
    
    public WordRun findInMainRun(final WordParagraph wordParagraph, final String key) {
        final ArrayList<WordRun> runList = wordParagraph.getRunList();
        final int keySize = key.length() - 3;
        final Iterator<WordRun> iterator = runList.iterator();
        while (iterator.hasNext()) {
            final WordRun wordRun;
            final String value = (wordRun = iterator.next()).getText().getValue();
            if (key.contains(value)) {
                if (value.length() > keySize / 2) {
                    return wordRun;
                }
                if (value.length() == keySize / 2) {
                    return wordRun;
                }
                continue;
            }
        }
        return null;
    }
    
    public String getParagraphText(final WordParagraph wordParagraph) {
        final StringBuffer totalStringSb = new StringBuffer();
        final Iterator<WordRun> iterator = wordParagraph.getRunList().iterator();
        while (iterator.hasNext()) {
            final WordRun wordRun;
            if ((wordRun = iterator.next()).getText() != null && wordRun.getText().getValue() != null) {
                final String value = wordRun.getText().getValue();
                totalStringSb.append(value);
            }
        }
        return totalStringSb.toString();
    }
    
    public ArrayList<WordRun> findInMainRunList(final WordParagraph wordParagraph, final String key) {
        final ArrayList<WordRun> resultRunList = new ArrayList<WordRun>();
        final ArrayList<WordRun> runList = wordParagraph.getRunList();
        final StringBuilder totalStringsplice = new StringBuilder();
        final int halfKeySize = (key.length() - 3) / 2;
        WordRun preWordRun = new WordRun();
        boolean isNeedAdd = true;
        System.out.println("findInMainRunList key is " + key);
        final Iterator<WordRun> iterator = runList.iterator();
        while (iterator.hasNext()) {
            final WordRun wordRun;
            final String runText = (wordRun = iterator.next()).getText().getValue();
            totalStringsplice.append(runText);
            if (key.contains(runText)) {
                if (runText.length() > halfKeySize) {
                    System.out.println("resultRunList.add " + runText);
                    a(resultRunList, totalStringsplice, wordRun);
                }
                else if (runText.length() == halfKeySize) {
                    if (isNeedAdd) {
                        System.out.println("resultRunList.add " + runText);
                        a(resultRunList, totalStringsplice, wordRun);
                        isNeedAdd = false;
                    }
                    else {
                        isNeedAdd = true;
                    }
                }
            }
            else {
                System.out.println("not contain and splice is " + totalStringsplice.toString() + " key is " + key);
                if (totalStringsplice.toString().contains(key)) {
                    if (runText.length() > halfKeySize) {
                        System.out.println("resultRunList.add " + runText);
                        a(resultRunList, totalStringsplice, wordRun);
                    }
                    else if (runText.length() == halfKeySize) {
                        if (isNeedAdd) {
                            System.out.println("resultRunList.add " + runText);
                            a(resultRunList, totalStringsplice, wordRun);
                            isNeedAdd = false;
                        }
                        else {
                            isNeedAdd = true;
                        }
                    }
                    else {
                        System.out.println("resultRunList.add " + preWordRun.getText().getValue());
                        a(resultRunList, totalStringsplice, preWordRun);
                    }
                }
            }
            preWordRun = wordRun;
        }
        return resultRunList;
    }
    
    private static void a(final ArrayList<WordRun> resultRunList, final StringBuilder totalStringsplice, final WordRun wordRun) {
        resultRunList.add(wordRun);
        totalStringsplice.delete(0, totalStringsplice.length());
    }
    
    public WordRun findTextInRun(final WordParagraph wordParagraph, final String key) {
        System.out.println("key is " + key);
        final ArrayList<WordRun> runList = wordParagraph.getRunList();
        final StringBuilder splice = new StringBuilder();
        final int halfKeySize = key.length() / 2;
        WordRun preWordRun = new WordRun();
        final Iterator<WordRun> iterator = runList.iterator();
        while (iterator.hasNext()) {
            final WordRun wordRun;
            final String value = (wordRun = iterator.next()).getText().getValue();
            System.out.println("findTextInRun value is " + value);
            splice.append(wordRun.getText().getValue());
            if (key.contains(value)) {
                if (value.length() > halfKeySize) {
                    System.out.println("value length is " + value.length() + " keySize/2 is " + halfKeySize + "findTextInRun return wordRun");
                    return wordRun;
                }
                System.out.println("splice is " + splice.toString() + " key is " + key);
                if (splice.toString().contains(key)) {
                    if (value.length() > halfKeySize) {
                        return wordRun;
                    }
                    return preWordRun;
                }
            }
            else {
                System.out.println("splice is " + splice.toString() + " key is " + key);
                if (splice.toString().contains(key)) {
                    if (value.length() > halfKeySize) {
                        return wordRun;
                    }
                    return preWordRun;
                }
            }
            preWordRun = wordRun;
        }
        return null;
    }
    
    public ArrayList<BraceArea> findListBraceMatch(String listName) {
        final ArrayList<BraceArea> braceAreaList = new ArrayList<BraceArea>();
        listName = "{list name=" + listName + "}";
        System.out.println("headKey is " + listName);
        final String endKey = "{/list}";
        for (final WordParagraph wordParagraph : this.findByText(listName)) {
            System.out.println("findByText is " + wordParagraph.toString());
            final BraceArea braceArea;
            (braceArea = new BraceArea()).setStartParagraphIndex(wordParagraph.getIndex());
            if (this.getParagraphText(wordParagraph).contains(endKey)) {
                braceArea.setEndParagraphIndex(wordParagraph.getIndex());
            }
            else {
                for (int i = wordParagraph.getIndex() + 1; i < this.totalParagraphList.size(); ++i) {
                    final WordParagraph nextParagraph = this.totalParagraphList.get(i);
                    if (this.getParagraphText(nextParagraph).contains(endKey)) {
                        braceArea.setEndParagraphIndex(nextParagraph.getIndex());
                    }
                }
            }
            braceAreaList.add(braceArea);
        }
        return braceAreaList;
    }
    
    public ArrayList<ArrayList<WordParagraph>> matchParagraphBlock(final ArrayList<BraceArea> braceAreaList) {
        final ArrayList<ArrayList<WordParagraph>> paragraphBlockList = new ArrayList<ArrayList<WordParagraph>>();
        for (final BraceArea braceArea : braceAreaList) {
            final ArrayList<WordParagraph> paragraphBlock = new ArrayList<WordParagraph>();
            for (int i = braceArea.getStartParagraphIndex(); i <= braceArea.getEndParagraphIndex(); ++i) {
                paragraphBlock.add(this.totalParagraphList.get(i));
            }
            paragraphBlockList.add(paragraphBlock);
        }
        return paragraphBlockList;
    }
}
