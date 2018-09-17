package com.chisalsoft.wordsdk.io.reader;

import com.chisalsoft.wordsdk.util.*;
import java.io.*;
import com.chisalsoft.wordsdk.model.*;
import java.util.*;
import org.w3c.dom.*;
import com.chisalsoft.wordsdk.model_runpro.*;
import com.chisalsoft.wordsdk.model_parpro.*;
import com.chisalsoft.wordsdk.model_section.*;
import com.chisalsoft.wordsdk.model_main.*;
import com.chisalsoft.wordsdk.model_drawing.model_wp.*;

public abstract class WordXmlBaseReader
{
    protected NodeToXml nodeToXml;
    protected String srcPath;
    protected File srcFile;
    
    public WordXmlBaseReader(final String srcPath) {
        this.srcPath = srcPath;
        this.srcFile = new File(srcPath);
        this.nodeToXml = new NodeToXml();
    }
    
    protected void nodeTraverse(final Node fatherNode, final BaseWord fatherWord, final ChildNodeAction action) {
        final NodeList childNodes = fatherNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node childNode;
            final NamedNodeMap attributes = (childNode = childNodes.item(i)).getAttributes();
            final HashMap<String, String> attributeMap = new HashMap<String, String>();
            if (attributes != null) {
                attributes.getLength();
                for (int j = 0; j < attributes.getLength(); ++j) {
                    final Node attibuteNode = attributes.item(j);
                    attributeMap.put(attibuteNode.getNodeName(), attibuteNode.getNodeValue());
                }
            }
            final String nodeName = childNode.getNodeName();
            final String nodeValue = childNode.getNodeValue();
            final BaseWord childWord;
            if ((childWord = this.getNodeByName(nodeName)).getClass().getSimpleName().equals(BaseWord.class.getSimpleName()) && !nodeName.substring(0, 1).equals("#")) {
                ArrayList<String> unknowTag;
                if ((unknowTag = fatherWord.getUnknowTag()) == null) {
                    unknowTag = new ArrayList<String>();
                    fatherWord.setUnknowTag(unknowTag);
                }
                unknowTag.add(this.nodeToXml.getNodeXml(childNode));
            }
            action.onGetChild(childNode, childWord, nodeName, nodeValue, attributeMap);
        }
    }
    
    protected BaseWord getNodeByName(String nodeName) {
        new BaseWord();
        nodeName = nodeName;
        BaseWord baseWord = null;
        switch (nodeName) {
            case "w:p": {
                baseWord = new WordParagraph();
                break;
            }
            case "w:pPr": {
                baseWord = new WordParPro();
                break;
            }
            case "w:r": {
                baseWord = new WordRun();
                break;
            }
            case "w:rPr": {
                baseWord = new WordRunPro();
                break;
            }
            case "w:t": {
                baseWord = new WordText();
                break;
            }
            case "w:jc": {
                baseWord = new WordJc();
                break;
            }
            case "w:spacing": {
                baseWord = new WordSpacing();
                break;
            }
            case "w:tabs": {
                baseWord = new WordTabs();
                break;
            }
            case "w:tab": {
                baseWord = new WordTab();
                break;
            }
            case "w:widowControl": {
                baseWord = new WordWidowControl();
                break;
            }
            case "w:b": {
                baseWord = new WordBold();
                break;
            }
            case "w:rFonts": {
                baseWord = new WordRunFonts();
                break;
            }
            case "w:sz": {
                baseWord = new WordSz();
                break;
            }
            case "w:szCs": {
                baseWord = new WordSzCs();
                break;
            }
            case "w:u": {
                baseWord = new WordUnderline();
                break;
            }
            case "w:ind": {
                baseWord = new WordInd();
                break;
            }
            case "w:sectPr": {
                baseWord = new WordSectionPro();
                break;
            }
            case "w:headerReference": {
                baseWord = new WordHeaderReference();
                break;
            }
            case "w:footerReference": {
                baseWord = new WordFooterReference();
                break;
            }
            case "w:pgSz": {
                baseWord = new WordPageSize();
                break;
            }
            case "w:pgMar": {
                baseWord = new WordPageMargin();
                break;
            }
            case "w:cols": {
                baseWord = new WordCols();
                break;
            }
            case "w:docGrid": {
                baseWord = new WordDocGrid();
                break;
            }
            case "w:bookmarkStart": {
                baseWord = new WordBookmarkStart();
                break;
            }
            case "w:bookmarkEnd": {
                baseWord = new WordBookmarkEnd();
                break;
            }
            case "w:drawing": {
                baseWord = new WordDrawing();
                break;
            }
            case "wp:anchor": {
                baseWord = new WpAnchor();
                break;
            }
            case "wp:simplePos": {
                baseWord = new WpSimplePos();
                break;
            }
            case "wp:positionH": {
                baseWord = new WpPositionH();
                break;
            }
            case "wp:posOffset": {
                baseWord = new WpPosOffset();
                break;
            }
            case "wp:positionV": {
                baseWord = new WpPositionV();
                break;
            }
            case "wp:extent": {
                baseWord = new WpExtent();
                break;
            }
            case "wp:effectExtent": {
                baseWord = new WpEffectExtent();
                break;
            }
            case "wp:wrapNone": {
                baseWord = new WpWrapNone();
                break;
            }
            case "wp:docPr": {
                baseWord = new WpDocPr();
                break;
            }
            case "wp:cNvGraphicFramePr": {
                baseWord = new WpCNvGraphicFramePr();
                break;
            }
            case "wp14:sizeRelH": {
                baseWord = new Wp14SizeRelH();
                break;
            }
            case "wp14:pctWidth": {
                baseWord = new Wp14PctWidth();
                break;
            }
            case "wp14:sizeRelV": {
                baseWord = new Wp14SizeRelV();
                break;
            }
            case "wp14:pctHeight": {
                baseWord = new Wp14PctHeight();
                break;
            }
            default: {
                baseWord = new BaseWord();
                break;
            }
        }
        return baseWord;
    }
    
    protected <T extends BaseWord> void paragraphHandle(final Node fatherNode, final T fatherWord) {
        final WordParagraph wordParagraph = (WordParagraph)fatherWord;
        final ArrayList<WordRun> runList = new ArrayList<WordRun>();
        final int[] runIndex = { 0 };
        wordParagraph.setRunList(runList);
        final WordParagraph wordParagraph2;
        final WordRun wordRun;
        final WordRun wordRun2;
        final Object o;
        final int n;
        final WordBookmarkStart wordBookmarkStart;
        final WordBookmarkStart wordBookmarkStart2;
        final WordBookmarkEnd wordBookmarkEnd;
        final WordBookmarkEnd wordBookmarkEnd2;
        this.nodeTraverse(fatherNode, fatherWord, (childNode, childWord, nodeName, nodeValue, attributeMap) -> {
            if (childWord instanceof WordParPro) {
                childWord = childWord;
                wordParagraph2.setWordParPro(childWord);
                this.traverse(childNode, childWord);
            }
            else if (childWord instanceof WordRun) {
                wordRun = (WordRun)childWord;
                wordRun2.setRsidR(attributeMap.get("w:rsidR"));
                wordRun.setRsidRPr(attributeMap.get("w:rsidRPr"));
                wordRun.setIndex(o[0]);
                wordRun.setParagraphIndex(wordParagraph2.getIndex());
                ++o[n];
                wordParagraph2.getRunList().add(wordRun);
                this.traverse(childNode, wordRun);
            }
            else if (childWord instanceof WordBookmarkStart) {
                wordBookmarkStart = (WordBookmarkStart)childWord;
                wordBookmarkStart2.setId(attributeMap.get("w:id"));
                wordBookmarkStart.setName(attributeMap.get("w:name"));
                wordParagraph2.setWordBookmarkStart(wordBookmarkStart);
            }
            else if (childWord instanceof WordBookmarkEnd) {
                wordBookmarkEnd = (WordBookmarkEnd)childWord;
                wordBookmarkEnd2.setId(attributeMap.get("w:id"));
                wordParagraph2.setWordBookmarkEnd(wordBookmarkEnd);
            }
        });
    }
    
    protected <T extends BaseWord> void parproHandle(final Node fatherNode, final T fatherWord) {
        final WordParPro wordParPro = (WordParPro)fatherWord;
        final WordParPro wordParPro2;
        final WordTabs wordTabs;
        final WordRunPro wordRunPro;
        final WordSpacing wordSpacing;
        final WordSpacing wordSpacing2;
        final WordJc wordJc;
        final WordJc wordJc2;
        final WordInd wordInd;
        final WordInd wordInd2;
        this.nodeTraverse(fatherNode, fatherWord, (childNode, childWord, nodeName, nodeValue, attributeMap) -> {
            if (childWord instanceof WordWidowControl) {
                childWord = childWord;
                wordParPro2.setWordWidowControl((WordWidowControl)childWord);
            }
            else if (childWord instanceof WordTabs) {
                wordTabs = (WordTabs)childWord;
                wordParPro2.setWordTabs(wordTabs);
                this.traverse(childNode, wordTabs);
            }
            else if (childWord instanceof WordRunPro) {
                wordRunPro = (WordRunPro)childWord;
                wordParPro2.setRunPro(wordRunPro);
                this.traverse(childNode, wordRunPro);
            }
            else if (childWord instanceof WordSpacing) {
                wordSpacing = (WordSpacing)childWord;
                wordSpacing2.setBefore(attributeMap.get("w:before"));
                wordSpacing.setBeforeAutospacing(attributeMap.get("w:beforeAutospacing"));
                wordSpacing.setAfterLines(attributeMap.get("w:afterLines"));
                wordSpacing.setAfter(attributeMap.get("w:after"));
                wordSpacing.setAfterAutospacing(attributeMap.get("w:afterAutospacing"));
                wordSpacing.setLine(attributeMap.get("w:line"));
                wordSpacing.setLineRule(attributeMap.get("w:lineRule"));
                wordParPro2.setWordSpacing(wordSpacing);
            }
            else if (childWord instanceof WordJc) {
                wordJc = (WordJc)childWord;
                wordJc2.setAttrVal(attributeMap.get("w:val"));
                wordParPro2.setWordJc(wordJc);
            }
            else if (childWord instanceof WordInd) {
                wordInd = childWord;
                wordInd2.setFirstLineChars(attributeMap.get("w:firstLineChars"));
                wordInd.setFirstLine(attributeMap.get("w:firstLine"));
                wordParPro2.setWordInd(wordInd);
            }
        });
    }
    
    protected <T extends BaseWord> void runproHandle(final Node fatherNode, final T fatherWord) {
        final WordRunPro wordRunPro = (WordRunPro)fatherWord;
        final WordRunFonts wordRunFonts;
        final WordRunFonts wordRunFonts2;
        final WordRunPro wordRunPro2;
        final WordBold wordBold;
        final WordSpacing wordSpacing;
        final WordSpacing wordSpacing2;
        final WordSz wordSz;
        final WordSz wordSz2;
        final WordSzCs wordSzCs;
        final WordSzCs wordSzCs2;
        final WordUnderline wordUnderline;
        final WordUnderline wordUnderline2;
        this.nodeTraverse(fatherNode, fatherWord, (childNode, childWord, nodeName, nodeValue, attributeMap) -> {
            if (childWord instanceof WordRunFonts) {
                wordRunFonts = (WordRunFonts)childWord;
                wordRunFonts2.setAscii(attributeMap.get("w:ascii"));
                wordRunFonts.sethAnsi(attributeMap.get("w:hAnsi"));
                wordRunFonts.setHint(attributeMap.get("w:hint"));
                wordRunPro2.setWordRunFonts(wordRunFonts);
            }
            else if (childWord instanceof WordBold) {
                wordBold = (WordBold)childWord;
                wordRunPro2.setWordBold(wordBold);
            }
            else if (childWord instanceof WordSpacing) {
                wordSpacing = (WordSpacing)childWord;
                wordSpacing2.setAttrVal(attributeMap.get("w:val"));
                wordRunPro2.setWordSpacing(wordSpacing);
            }
            else if (childWord instanceof WordSz) {
                wordSz = (WordSz)childWord;
                wordSz2.setAttrVal(attributeMap.get("w:val"));
                wordRunPro2.setWordSz(wordSz);
            }
            else if (childWord instanceof WordSzCs) {
                wordSzCs = (WordSzCs)childWord;
                wordSzCs2.setAttrVal(attributeMap.get("w:val"));
                wordRunPro2.setWordSzCs(wordSzCs);
            }
            else if (childWord instanceof WordUnderline) {
                wordUnderline = childWord;
                wordUnderline2.setAttrVal(attributeMap.get("w:val"));
                wordRunPro2.setWordUnderline(wordUnderline);
            }
        });
    }
    
    protected <T extends BaseWord> void runHandle(final Node fatherNode, final T fatherWord) {
        final WordRun wordRun = (WordRun)fatherWord;
        final WordText wordText;
        final WordRun wordRun2;
        final WordRunPro wordRunPro1;
        final WordDrawing wordDrawing;
        final WordDrawing wordDrawing2;
        this.nodeTraverse(fatherNode, fatherWord, (childNode, childWord, nodeName, nodeValue, attributeMap) -> {
            if (childWord instanceof WordText) {
                childWord = childWord;
                wordText.setSpace(attributeMap.get("xml:space"));
                wordRun2.setText((WordText)childWord);
                this.traverse(childNode, (WordText)childWord);
            }
            else if (childWord instanceof WordRunPro) {
                wordRunPro1 = (WordRunPro)childWord;
                wordRun2.setRunPro(wordRunPro1);
                this.traverse(childNode, wordRunPro1);
            }
            else if (childWord instanceof WordDrawing) {
                wordDrawing = childWord;
                wordDrawing2.setXmlDrawingString(this.nodeToXml.getNodeXml(childNode));
                wordRun2.setWordDrawing(wordDrawing);
            }
        });
    }
    
    protected <T extends BaseWord> void textHandle(final Node fatherNode, final T fatherWord) {
        final WordText wordText = (WordText)fatherWord;
        this.nodeTraverse(fatherNode, fatherWord, (childNode, childWord, nodeName, nodeValue, attributeMap) -> wordText.setValue(nodeValue));
    }
    
    protected abstract <T extends BaseWord> void traverse(final Node p0, final T p1);
    
    public abstract Object readXml();
    
    public interface ChildNodeAction
    {
        void onGetChild(final Node p0, final BaseWord p1, final String p2, final String p3, final HashMap<String, String> p4);
    }
}
