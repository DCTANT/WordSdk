package com.chisalsoft.wordsdk.io.writer;

import java.io.*;
import com.chisalsoft.wordsdk.model.*;
import java.util.*;
import com.chisalsoft.wordsdk.model_drawing.model_wp.*;
import com.chisalsoft.wordsdk.model_main.*;
import com.chisalsoft.wordsdk.model_parpro.*;
import com.chisalsoft.wordsdk.model_runpro.*;
import com.chisalsoft.wordsdk.util.*;

public abstract class WordXmlBaseWriter
{
    protected String desPath;
    protected File desFile;
    protected StringBuffer xmlSb;
    
    public WordXmlBaseWriter(final String desPath) {
        this.desPath = desPath;
        this.desFile = new File(desPath);
    }
    
    protected void writeParagraph(final WordParagraph wordParagraph) {
        final WordBookmarkStart wordBookmarkStart;
        final WordBookmarkStart baseWord;
        final WordBookmarkEnd wordBookmarkEnd;
        final WordBookmarkEnd baseWord2;
        final ArrayList<WordRun> list;
        final Iterator<WordRun> iterator;
        WordRun wordRun;
        this.appendNodeString(wordParagraph, () -> {
            this.appendAttribute(wordParagraph.getRsidR(), "w:rsidR");
            this.appendAttribute(wordParagraph.getRsidRDefault(), "w:rsidRDefault");
            this.appendAttribute(wordParagraph.getRsidP(), "w:rsidP");
            this.appendRightAngleBracket(wordParagraph);
            this.writeParPro(wordParagraph.getWordParPro());
            wordBookmarkStart = wordParagraph.getWordBookmarkStart();
            this.appendNodeString(wordBookmarkStart, () -> {
                this.appendAttribute(baseWord.getId(), "w:id");
                this.appendAttribute(baseWord.getName(), "w:name");
                this.appendRightAngleBracket(baseWord);
                return;
            });
            wordBookmarkEnd = wordParagraph.getWordBookmarkEnd();
            this.appendNodeString(wordBookmarkEnd, () -> {
                this.appendAttribute(baseWord2.getId(), "w:id");
                this.appendRightAngleBracket(baseWord2);
                return;
            });
            wordParagraph.getRunList();
            list.iterator();
            while (iterator.hasNext()) {
                wordRun = iterator.next();
                this.writeRun(wordRun);
            }
        });
    }
    
    protected void writeRun(final WordRun wordRun) {
        final WordRunPro wordRunPro;
        final WordDrawing wordDrawing;
        final Object o;
        this.appendNodeString(wordRun, () -> {
            this.appendAttribute(wordRun.getRsidR(), "w:rsidR");
            this.appendAttribute(wordRun.getRsidRPr(), "w:rsidRPr");
            this.appendRightAngleBracket(wordRun);
            wordRunPro = wordRun.getRunPro();
            this.writeRunPro(wordRunPro);
            this.writeText(wordRun);
            wordDrawing = wordRun.getWordDrawing();
            if (o != null) {
                this.xmlSb.append(wordDrawing.getXmlDrawingString());
            }
        });
    }
    
    protected void writeParPro(final WordParPro wordParPro) {
        final WordWidowControl wordWidowControl;
        final WordInd wordInd;
        final WordInd baseWord;
        this.appendNodeString(wordParPro, () -> {
            this.appendRightAngleBracket(wordParPro);
            wordWidowControl = wordParPro.getWordWidowControl();
            this.appendNodeString(wordWidowControl, () -> this.appendRightAngleBracket(wordWidowControl));
            this.writeTabs(wordParPro.getWordTabs());
            this.writeSpacing(wordParPro.getWordSpacing());
            this.writeJc(wordParPro);
            wordInd = wordParPro.getWordInd();
            this.appendNodeString(wordInd, () -> {
                this.appendAttribute(baseWord.getFirstLineChars(), "w:firstLineChars");
                this.appendAttribute(baseWord.getFirstLine(), "w:firstLine");
                this.appendRightAngleBracket(baseWord);
                return;
            });
            this.writeRunPro(wordParPro.getRunPro());
        });
    }
    
    protected void writeRunPro(final WordRunPro wordRunPro) {
        final WordUnderline wordUnderline;
        final WordUnderline baseWord;
        this.appendNodeString(wordRunPro, () -> {
            this.appendRightAngleBracket(wordRunPro);
            this.writeRunFonts(wordRunPro.getWordRunFonts());
            this.writeBold(wordRunPro.getWordBold());
            this.writeSpacing(wordRunPro.getWordSpacing());
            this.writeSz(wordRunPro.getWordSz());
            this.writeSzCs(wordRunPro.getWordSzCs());
            wordUnderline = wordRunPro.getWordUnderline();
            this.appendNodeString(wordUnderline, () -> {
                this.appendAttribute(baseWord.getAttrVal(), "w:val");
                this.appendRightAngleBracket(baseWord);
            });
        });
    }
    
    protected void writeText(final WordRun wordRun) {
        final WordText wordText = wordRun.getText();
        final WordText baseWord;
        this.appendNodeString(wordText, () -> {
            this.appendAttribute(baseWord.getSpace(), "xml:space");
            this.appendRightAngleBracket(baseWord);
            this.xmlSb.append(baseWord.getValue());
        });
    }
    
    protected void writeJc(final WordParPro wordParPro) {
        final WordJc wordJc = wordParPro.getWordJc();
        final WordJc baseWord;
        this.appendNodeString(wordJc, () -> {
            this.appendAttribute(baseWord.getAttrVal(), "w:val");
            this.appendRightAngleBracket(baseWord);
        });
    }
    
    protected void writeTabs(final WordTabs wordTabs) {
        final WordTab wordTab;
        final WordTab baseWord;
        this.appendNodeString(wordTabs, () -> {
            this.appendRightAngleBracket(wordTabs);
            wordTab = wordTabs.getWordTab();
            this.appendNodeString(wordTab, () -> {
                this.appendAttribute(baseWord.getAttrVal(), "w:val");
                this.appendAttribute(baseWord.getPos(), "w:pos");
                this.appendRightAngleBracket(baseWord);
            });
        });
    }
    
    protected void writeSpacing(final WordSpacing wordSpacing) {
        this.appendNodeString(wordSpacing, () -> {
            this.appendAttribute(wordSpacing.getBefore(), "w:before");
            this.appendAttribute(wordSpacing.getBeforeAutospacing(), "w:beforeAutospacing");
            this.appendAttribute(wordSpacing.getAfterLines(), "w:afterLines");
            this.appendAttribute(wordSpacing.getAfter(), "w:after");
            this.appendAttribute(wordSpacing.getAfterAutospacing(), "w:afterAutospacing");
            this.appendAttribute(wordSpacing.getLine(), "w:line");
            this.appendAttribute(wordSpacing.getLineRule(), "w:lineRule");
            this.appendAttribute(wordSpacing.getAttrVal(), "w:val");
            this.appendRightAngleBracket(wordSpacing);
        });
    }
    
    protected void writeSzCs(final WordSzCs wordSzCs) {
        this.appendNodeString(wordSzCs, () -> {
            this.appendAttribute(wordSzCs.getAttrVal(), "w:val");
            this.appendRightAngleBracket(wordSzCs);
        });
    }
    
    protected void writeSz(final WordSz wordSz) {
        this.appendNodeString(wordSz, () -> {
            this.appendAttribute(wordSz.getAttrVal(), "w:val");
            this.appendRightAngleBracket(wordSz);
        });
    }
    
    protected void writeBold(final WordBold wordBold) {
        this.appendNodeString(wordBold, () -> this.appendRightAngleBracket(wordBold));
    }
    
    protected void writeRunFonts(final WordRunFonts wordRunFonts) {
        this.appendNodeString(wordRunFonts, () -> {
            this.appendAttribute(wordRunFonts.getAscii(), "w:ascii");
            this.appendAttribute(wordRunFonts.gethAnsi(), "w:hAnsi");
            this.appendAttribute(wordRunFonts.getHint(), "w:hint");
            this.appendRightAngleBracket(wordRunFonts);
        });
    }
    
    protected void appendAttribute(final String attribute, final String attributeTagName) {
        if (StringUtil.isNotEmpty(attribute)) {
            this.xmlSb.append(" " + attributeTagName + "=\"" + attribute + "\"");
        }
    }
    
    protected <T extends BaseWord> void appendNodeString(final T wordNode, final ChildWriteAction action) {
        if (wordNode != null) {
            this.xmlSb.append("<" + wordNode.getTagName());
            action.onChild();
            this.xmlSb.append("</" + wordNode.getTagName() + ">");
        }
    }
    
    protected void appendRightAngleBracket(final BaseWord baseWord) {
        this.xmlSb.append(">");
        if (baseWord.getUnknowTag() != null) {
            for (final String stringXml : baseWord.getUnknowTag()) {
                this.xmlSb.append(stringXml);
            }
        }
    }
    
    public interface ChildWriteAction
    {
        void onChild();
    }
}
