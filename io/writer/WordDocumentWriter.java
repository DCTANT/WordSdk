package com.chisalsoft.wordsdk.io.writer;

import com.chisalsoft.wordsdk.model.*;
import com.chisalsoft.wordsdk.model_main.*;
import cn.hutool.core.io.*;
import java.util.*;
import com.chisalsoft.wordsdk.model_section.*;

public class WordDocumentWriter extends WordXmlBaseWriter
{
    public WordDocumentWriter(final String desPath) {
        super(desPath);
        this.xmlSb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<w:document xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\" xmlns:cx=\"http://schemas.microsoft.com/office/drawing/2014/chartex\" xmlns:cx1=\"http://schemas.microsoft.com/office/drawing/2015/9/8/chartex\" xmlns:cx2=\"http://schemas.microsoft.com/office/drawing/2015/10/21/chartex\" xmlns:cx3=\"http://schemas.microsoft.com/office/drawing/2016/5/9/chartex\" xmlns:cx4=\"http://schemas.microsoft.com/office/drawing/2016/5/10/chartex\" xmlns:cx5=\"http://schemas.microsoft.com/office/drawing/2016/5/11/chartex\" xmlns:cx6=\"http://schemas.microsoft.com/office/drawing/2016/5/12/chartex\" xmlns:cx7=\"http://schemas.microsoft.com/office/drawing/2016/5/13/chartex\" xmlns:cx8=\"http://schemas.microsoft.com/office/drawing/2016/5/14/chartex\" xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\" xmlns:aink=\"http://schemas.microsoft.com/office/drawing/2016/ink\" xmlns:am3d=\"http://schemas.microsoft.com/office/drawing/2017/model3d\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\" xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" xmlns:w10=\"urn:schemas-microsoft-com:office:word\" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\" xmlns:w15=\"http://schemas.microsoft.com/office/word/2012/wordml\" xmlns:w16cid=\"http://schemas.microsoft.com/office/word/2016/wordml/cid\" xmlns:w16se=\"http://schemas.microsoft.com/office/word/2015/wordml/symex\" xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\" xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\" xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\" xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 w15 w16se w16cid wp14\">");
    }
    
    public String writeXml(final WordBody wordBody) {
        final ArrayList<WordParagraph> list;
        final Iterator<WordParagraph> iterator;
        WordParagraph wordParagraph;
        final WordSectionPro wordNode;
        final WordSectionPro baseWord;
        final WordHeaderReference wordHeaderReference;
        final WordHeaderReference baseWord2;
        final WordFooterReference wordFooterReference;
        final WordFooterReference baseWord3;
        final WordPageSize wordPageSize;
        final WordPageSize baseWord4;
        final WordPageMargin wordPageMargin;
        final WordPageMargin baseWord5;
        final WordCols wordCols;
        final WordCols baseWord6;
        final WordDocGrid wordDocGrid;
        final WordDocGrid baseWord7;
        this.appendNodeString(wordBody, () -> {
            this.appendRightAngleBracket(wordBody);
            wordBody.getParagraphList();
            list.iterator();
            while (iterator.hasNext()) {
                wordParagraph = iterator.next();
                this.writeParagraph(wordParagraph);
            }
            wordBody.getWordSectionPro();
            this.appendNodeString(wordNode, () -> {
                this.appendAttribute(baseWord.getRsidR(), "w:rsidR");
                this.appendRightAngleBracket(baseWord);
                wordHeaderReference = baseWord.getWordHeaderReference();
                this.appendNodeString(wordHeaderReference, () -> {
                    this.appendAttribute(baseWord2.getType(), "w:type");
                    this.appendAttribute(baseWord2.getrId(), "r:id");
                    this.appendRightAngleBracket(baseWord2);
                    return;
                });
                wordFooterReference = baseWord.getWordFooterReference();
                this.appendNodeString(wordFooterReference, () -> {
                    this.appendAttribute(baseWord3.getType(), "w:type");
                    this.appendAttribute(baseWord3.getrId(), "r:id");
                    this.appendRightAngleBracket(baseWord3);
                    return;
                });
                wordPageSize = baseWord.getWordPageSize();
                this.appendNodeString(wordPageSize, () -> {
                    this.appendAttribute(baseWord4.getWidth(), "w:w");
                    this.appendAttribute(baseWord4.getHeight(), "w:h");
                    this.appendRightAngleBracket(baseWord4);
                    return;
                });
                wordPageMargin = baseWord.getWordPageMargin();
                this.appendNodeString(wordPageMargin, () -> {
                    this.appendAttribute(baseWord5.getTop(), "w:top");
                    this.appendAttribute(baseWord5.getRight(), "w:right");
                    this.appendAttribute(baseWord5.getBottom(), "w:bottom");
                    this.appendAttribute(baseWord5.getLeft(), "w:left");
                    this.appendAttribute(baseWord5.getHeader(), "w:header");
                    this.appendAttribute(baseWord5.getFooter(), "w:footer");
                    this.appendAttribute(baseWord5.getGutter(), "w:gutter");
                    this.appendRightAngleBracket(baseWord5);
                    return;
                });
                wordCols = baseWord.getWordCols();
                this.appendNodeString(wordCols, () -> {
                    this.appendAttribute(baseWord6.getSpace(), "w:space");
                    this.appendRightAngleBracket(baseWord6);
                    return;
                });
                wordDocGrid = baseWord.getWordDocGrid();
                this.appendNodeString(wordDocGrid, () -> {
                    this.appendAttribute(baseWord7.getType(), "w:type");
                    this.appendAttribute(baseWord7.getLinePitch(), "w:linePitch");
                    this.appendRightAngleBracket(baseWord7);
                });
            });
            return;
        });
        this.xmlSb.append("</w:document>");
        final String result;
        FileUtil.writeString(result = this.xmlSb.toString(), this.desFile, "UTF-8");
        return result;
    }
}
