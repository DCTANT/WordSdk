package com.chisalsoft.wordsdk.io.reader;

import java.util.*;
import com.chisalsoft.wordsdk.model_main.*;
import cn.hutool.core.util.*;
import org.w3c.dom.*;
import com.chisalsoft.wordsdk.model.*;

public class WordHeadFootReader extends WordXmlBaseReader
{
    public WordHeadFootReader(final String srcPath) {
        super(srcPath);
    }
    
    @Override
    public ArrayList<WordParagraph> readXml() {
        final NodeList childNodes = XmlUtil.getRootElement(XmlUtil.readXML(this.srcFile)).getChildNodes();
        final ArrayList<WordParagraph> wordParagraphList = new ArrayList<WordParagraph>();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item;
            if ((item = childNodes.item(i)).getNodeName() == "w:p") {
                final WordParagraph wordParagraph = new WordParagraph();
                wordParagraphList.add(wordParagraph);
                this.traverse(item, wordParagraph);
            }
        }
        return wordParagraphList;
    }
    
    @Override
    protected <T extends BaseWord> void traverse(final Node fatherNode, final T fatherWord) {
        final String simpleName = fatherWord.getClass().getSimpleName();
        switch (simpleName) {
            case "WordParagraph": {
                this.paragraphHandle(fatherNode, fatherWord);
            }
            case "WordParPro": {
                this.parproHandle(fatherNode, fatherWord);
            }
            case "WordRunPro": {
                this.runproHandle(fatherNode, fatherWord);
            }
            case "WordRun": {
                this.runHandle(fatherNode, fatherWord);
            }
            case "WordText": {
                this.textHandle(fatherNode, fatherWord);
                break;
            }
        }
    }
}
