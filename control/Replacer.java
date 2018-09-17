package com.chisalsoft.wordsdk.control;

import com.chisalsoft.wordsdk.model_main.*;
import java.util.*;
import com.chisalsoft.wordsdk.model.*;

public class Replacer extends a
{
    private Finder a;
    
    public Replacer(final ArrayList<WordParagraph> totalParagraphList) {
        super(totalParagraphList);
        this.a = new Finder(totalParagraphList);
    }
    
    public ArrayList<WordParagraph> replaceParas(final HashMap<String, String> paramMap) {
        final Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry;
            String key = (entry = iterator.next()).getKey();
            final String originKey = entry.getKey();
            final String value = entry.getValue();
            if (!key.contains("${")) {
                key = "${" + key + "}";
            }
            for (final WordParagraph paragraph : this.a.findByText(key)) {
                final ArrayList<WordRun> inMainRunList;
                final Iterator<WordRun> iterator3 = (inMainRunList = this.a.findInMainRunList(paragraph, key)).iterator();
                while (iterator3.hasNext()) {
                    final WordRun wordRun;
                    final String originRunText;
                    String runText = originRunText = (wordRun = iterator3.next()).getText().getValue();
                    if (runText.contains(originKey)) {
                        System.out.println("replaceParas runText is " + runText);
                        runText = (runText = (runText = runText.replace("}", "")).replace("${", "")).replace("{", "");
                        wordRun.getText().setValue(runText);
                        if (!originRunText.contains("$")) {
                            this.a("$", wordRun, paragraph);
                        }
                        if (!originRunText.contains("}")) {
                            this.b("}", wordRun, paragraph);
                        }
                    }
                    else {
                        this.a(key, inMainRunList, paragraph);
                    }
                    a(value, wordRun);
                }
            }
        }
        return this.totalParagraphList;
    }
    
    public ArrayList<WordParagraph> replaceLists(final ArrayList<WordListReplacerModel> listReplacerModelList) {
        for (final WordListReplacerModel wordListReplacerModel : listReplacerModelList) {
            this.replaceList(wordListReplacerModel.getListName(), wordListReplacerModel.getReplaceMapList());
        }
        return this.totalParagraphList;
    }
    
    public ArrayList<WordParagraph> replaceList(final String listName, final ArrayList<HashMap<String, String>> paramMapList) {
        final ArrayList<BraceArea> listBraceMatch = this.a.findListBraceMatch(listName);
        final Iterator<ArrayList<WordParagraph>> iterator = this.a.matchParagraphBlock(listBraceMatch).iterator();
        while (iterator.hasNext()) {
            for (final WordParagraph wordParagraph2 : iterator.next()) {
                final WordParagraph wordParagraph = wordParagraph2;
                wordParagraph2.getRunList();
                final String string = "name=" + listName;
                this.a(string, "{", "}", this.a.findTextInRun(wordParagraph2, string), wordParagraph2);
                final String s = "{/list}";
                this.a(s, "{", "}", this.a.findTextInRun(wordParagraph2, s), wordParagraph2);
                this.a(paramMapList, wordParagraph);
                this.totalParagraphList.remove(wordParagraph);
            }
        }
        for (int i = 0; i < this.totalParagraphList.size(); ++i) {
            this.totalParagraphList.get(i).setIndex(i);
        }
        return this.totalParagraphList;
    }
    
    private void a(final String wholeKey, final ArrayList<WordRun> findedRunList, final WordParagraph paragraph) {
        final Iterator<WordRun> iterator = findedRunList.iterator();
        while (iterator.hasNext()) {
            final WordRun wordRun;
            final String runText = (wordRun = iterator.next()).getText().getValue();
            System.out.println("runText is " + runText + " whole key is " + wholeKey);
            if (!runText.contains(wholeKey)) {
                System.out.println("replaceSingleParamRedundantEmpty wholeKey is " + wholeKey + " runText is " + runText);
                final String keyChar = "$";
                final String s = "}";
                final WordRun wordRun2 = wordRun;
                final String keyChar2 = s;
                this.a(keyChar, wordRun2, paragraph);
                this.b(keyChar2, wordRun2, paragraph);
            }
        }
    }
    
    private void a(String wholeKey, String index, String rightKeyWord, final WordRun run, final WordParagraph paragraph) {
        final String runText;
        if (!(runText = run.getText().getValue()).contains(wholeKey)) {
            this.setEmpty(run);
            this.a(leftKeyWord, run, paragraph);
            this.b(rightKeyWord, run, paragraph);
            return;
        }
        if (runText.length() == wholeKey.length()) {
            this.setEmpty(run);
            return;
        }
        index = runText.indexOf(wholeKey);
        rightKeyWord = runText.substring(0, index);
        wholeKey = runText.substring(index + wholeKey.length(), runText.length());
        wholeKey = rightKeyWord + wholeKey;
        run.getText().setValue(wholeKey);
    }
    
    private void a(String dollarIndex, final WordRun midRun, final WordParagraph paragraph) {
        int i = midRun.getIndex() - 1;
        while (i >= 0) {
            final WordRun preRun;
            String preTextValue = (preRun = paragraph.getRunList().get(i)).getText().getValue();
            System.out.println("preTextValue is " + preTextValue);
            if (preTextValue.contains(keyChar)) {
                if (preTextValue.length() == 1) {
                    this.setEmpty(preRun);
                    return;
                }
                dollarIndex = preTextValue.indexOf(keyChar);
                preTextValue = preTextValue.substring(0, dollarIndex);
                preRun.getText().setValue(preTextValue);
            }
            else {
                this.setEmpty(preRun);
                --i;
            }
        }
    }
    
    private void b(String rightBrace, final WordRun midRun, final WordParagraph paragraph) {
        int i = midRun.getIndex() + 1;
        while (i < paragraph.getRunList().size()) {
            final WordRun nextRun;
            String nextTextValue;
            if ((nextTextValue = (nextRun = paragraph.getRunList().get(i)).getText().getValue()).contains(keyChar)) {
                if (nextTextValue.length() == 1) {
                    this.setEmpty(nextRun);
                    return;
                }
                rightBrace = nextTextValue.lastIndexOf(keyChar);
                nextTextValue = nextTextValue.substring(rightBrace + 1, nextTextValue.length());
                nextRun.getText().setValue(nextTextValue);
            }
            else {
                this.setEmpty(nextRun);
                ++i;
            }
        }
    }
    
    private void a(final ArrayList<HashMap<String, String>> paramMapList, final WordParagraph wordParagraph) {
        for (final HashMap<String, String> paramMap : paramMapList) {
            final WordParagraph clone = (WordParagraph)wordParagraph.clone();
            final HashMap<String, String> hashMap = paramMap;
            final WordParagraph wordParagraph2 = clone;
            final Iterator<Map.Entry<String, String>> iterator2 = hashMap.entrySet().iterator();
            while (iterator2.hasNext()) {
                final Map.Entry<String, String> entry;
                String string = (entry = iterator2.next()).getKey();
                final String value = entry.getValue();
                if (!string.contains("%{")) {
                    string = "${" + string + "}";
                }
                final ArrayList<WordRun> inMainRunList;
                final Iterator<WordRun> iterator3 = (inMainRunList = this.a.findInMainRunList(wordParagraph2, string)).iterator();
                while (iterator3.hasNext()) {
                    a(value, iterator3.next());
                }
                this.a(string, inMainRunList, wordParagraph2);
            }
            final ArrayList<WordParagraph> totalParagraphList = this.totalParagraphList;
            for (int i = this.totalParagraphList.size() - 1; i >= 0; --i) {
                if (this.totalParagraphList.get(i).getIndex() == wordParagraph.getIndex()) {
                    this.totalParagraphList.add(i + 1, clone);
                    break;
                }
            }
        }
    }
    
    private void setEmpty(final WordRun wordRun) {
        wordRun.getText().setSpace("preserve");
        wordRun.getText().setValue("");
    }
    
    private static void a(final String value, final WordRun wordRun) {
        wordRun.getText().setValue(value);
    }
}
