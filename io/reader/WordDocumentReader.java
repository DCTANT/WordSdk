package com.chisalsoft.wordsdk.io.reader;

import cn.hutool.core.util.*;
import org.w3c.dom.*;
import com.chisalsoft.wordsdk.model.*;
import java.util.*;
import com.chisalsoft.wordsdk.model_parpro.*;
import com.chisalsoft.wordsdk.model_section.*;
import com.chisalsoft.wordsdk.model_main.*;

public class WordDocumentReader extends WordXmlBaseReader
{
    public WordDocumentReader(final String srcPath) {
        super(srcPath);
    }
    
    @Override
    public WordBody readXml() {
        final NodeList childNodes = XmlUtil.getRootElement(XmlUtil.readXML(this.srcFile)).getChildNodes();
        final WordBody wordBody = new WordBody();
        for (int i = 0; i < childNodes.getLength(); ++i) {
            final Node item;
            if ((item = childNodes.item(i)).getNodeName() == "w:body") {
                this.traverse(item, wordBody);
            }
        }
        return wordBody;
    }
    
    @Override
    protected <T extends BaseWord> void traverse(final Node fatherNode, final T fatherWord) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //     4: invokevirtual   java/lang/Class.getSimpleName:()Ljava/lang/String;
        //     7: dup            
        //     8: astore_3       
        //     9: astore_3       
        //    10: iconst_m1      
        //    11: istore          4
        //    13: aload_3        
        //    14: invokevirtual   java/lang/String.hashCode:()I
        //    17: lookupswitch {
        //          -1698225661: 230
        //          -1446216947: 294
        //          -1105379583: 200
        //          -1105378293: 278
        //          -924427754: 170
        //          -848818196: 185
        //          92488684: 140
        //          92488911: 310
        //          93011400: 262
        //          93015927: 215
        //          179805540: 155
        //          189349305: 246
        //          1414774866: 342
        //          1498520258: 326
        //          default: 355
        //        }
        //   140: aload_3        
        //   141: ldc             "WordBody"
        //   143: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   146: ifeq            355
        //   149: iconst_0       
        //   150: istore          4
        //   152: goto            355
        //   155: aload_3        
        //   156: ldc             "WordParagraph"
        //   158: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   161: ifeq            355
        //   164: iconst_1       
        //   165: istore          4
        //   167: goto            355
        //   170: aload_3        
        //   171: ldc             "WordParPro"
        //   173: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   176: ifeq            355
        //   179: iconst_2       
        //   180: istore          4
        //   182: goto            355
        //   185: aload_3        
        //   186: ldc             "WordRunPro"
        //   188: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   191: ifeq            355
        //   194: iconst_3       
        //   195: istore          4
        //   197: goto            355
        //   200: aload_3        
        //   201: ldc             "WordRun"
        //   203: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   206: ifeq            355
        //   209: iconst_4       
        //   210: istore          4
        //   212: goto            355
        //   215: aload_3        
        //   216: ldc             "WordText"
        //   218: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   221: ifeq            355
        //   224: iconst_5       
        //   225: istore          4
        //   227: goto            355
        //   230: aload_3        
        //   231: ldc             "WordJc"
        //   233: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   236: ifeq            355
        //   239: bipush          6
        //   241: istore          4
        //   243: goto            355
        //   246: aload_3        
        //   247: ldc             "WordSpacing"
        //   249: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   252: ifeq            355
        //   255: bipush          7
        //   257: istore          4
        //   259: goto            355
        //   262: aload_3        
        //   263: ldc             "WordTabs"
        //   265: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   268: ifeq            355
        //   271: bipush          8
        //   273: istore          4
        //   275: goto            355
        //   278: aload_3        
        //   279: ldc             "WordTab"
        //   281: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   284: ifeq            355
        //   287: bipush          9
        //   289: istore          4
        //   291: goto            355
        //   294: aload_3        
        //   295: ldc             "WordWidowControl"
        //   297: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   300: ifeq            355
        //   303: bipush          10
        //   305: istore          4
        //   307: goto            355
        //   310: aload_3        
        //   311: ldc             "WordBold"
        //   313: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   316: ifeq            355
        //   319: bipush          11
        //   321: istore          4
        //   323: goto            355
        //   326: aload_3        
        //   327: ldc             "WordUnderline"
        //   329: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   332: ifeq            355
        //   335: bipush          12
        //   337: istore          4
        //   339: goto            355
        //   342: aload_3        
        //   343: ldc             "WordSectionPro"
        //   345: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   348: ifeq            355
        //   351: bipush          13
        //   353: istore          4
        //   355: iload           4
        //   357: tableswitch {
        //                0: 428
        //                1: 482
        //                2: 489
        //                3: 496
        //                4: 503
        //                5: 510
        //                6: 517
        //                7: 518
        //                8: 519
        //                9: 546
        //               10: 547
        //               11: 548
        //               12: 549
        //               13: 550
        //          default: 575
        //        }
        //   428: aload_0         /* this */
        //   429: aload_1         /* fatherNode */
        //   430: aload_2         /* fatherWord */
        //   431: astore_3       
        //   432: astore_2        /* fatherWord */
        //   433: astore_1        /* fatherNode */
        //   434: aload_3        
        //   435: checkcast       Lcom/chisalsoft/wordsdk/model_main/WordBody;
        //   438: astore          4
        //   440: new             Ljava/util/ArrayList;
        //   443: dup            
        //   444: invokespecial   java/util/ArrayList.<init>:()V
        //   447: astore          5
        //   449: aload           4
        //   451: aload           5
        //   453: invokevirtual   com/chisalsoft/wordsdk/model_main/WordBody.setParagraphList:(Ljava/util/ArrayList;)V
        //   456: iconst_1       
        //   457: newarray        I
        //   459: dup            
        //   460: iconst_0       
        //   461: iconst_0       
        //   462: iastore        
        //   463: astore          5
        //   465: aload_1         /* fatherNode */
        //   466: aload_2         /* fatherWord */
        //   467: aload_3        
        //   468: aload_1         /* fatherNode */
        //   469: aload           5
        //   471: aload           4
        //   473: invokedynamic   BootstrapMethod #0, onGetChild:(Lcom/chisalsoft/wordsdk/io/reader/WordDocumentReader;[ILcom/chisalsoft/wordsdk/model_main/WordBody;)Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;
        //   478: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.nodeTraverse:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;)V
        //   481: return         
        //   482: aload_0         /* this */
        //   483: aload_1         /* fatherNode */
        //   484: aload_2         /* fatherWord */
        //   485: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.paragraphHandle:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;)V
        //   488: return         
        //   489: aload_0         /* this */
        //   490: aload_1         /* fatherNode */
        //   491: aload_2         /* fatherWord */
        //   492: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.parproHandle:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;)V
        //   495: return         
        //   496: aload_0         /* this */
        //   497: aload_1         /* fatherNode */
        //   498: aload_2         /* fatherWord */
        //   499: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.runproHandle:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;)V
        //   502: return         
        //   503: aload_0         /* this */
        //   504: aload_1         /* fatherNode */
        //   505: aload_2         /* fatherWord */
        //   506: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.runHandle:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;)V
        //   509: return         
        //   510: aload_0         /* this */
        //   511: aload_1         /* fatherNode */
        //   512: aload_2         /* fatherWord */
        //   513: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.textHandle:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;)V
        //   516: return         
        //   517: return         
        //   518: return         
        //   519: aload_0         /* this */
        //   520: aload_1         /* fatherNode */
        //   521: aload_2         /* fatherWord */
        //   522: astore_3       
        //   523: astore_2        /* fatherWord */
        //   524: astore_1        /* fatherNode */
        //   525: aload_3        
        //   526: checkcast       Lcom/chisalsoft/wordsdk/model_parpro/WordTabs;
        //   529: astore          4
        //   531: aload_1         /* fatherNode */
        //   532: aload_2         /* fatherWord */
        //   533: aload_3        
        //   534: aload_1         /* fatherNode */
        //   535: aload           4
        //   537: invokedynamic   BootstrapMethod #1, onGetChild:(Lcom/chisalsoft/wordsdk/io/reader/WordDocumentReader;Lcom/chisalsoft/wordsdk/model_parpro/WordTabs;)Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;
        //   542: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.nodeTraverse:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;)V
        //   545: return         
        //   546: return         
        //   547: return         
        //   548: return         
        //   549: return         
        //   550: aload_0         /* this */
        //   551: aload_1         /* fatherNode */
        //   552: aload_2         /* fatherWord */
        //   553: astore_3       
        //   554: astore_2       
        //   555: astore_1       
        //   556: aload_3        
        //   557: checkcast       Lcom/chisalsoft/wordsdk/model_section/WordSectionPro;
        //   560: astore          4
        //   562: aload_1        
        //   563: aload_2        
        //   564: aload_3        
        //   565: aload           4
        //   567: invokedynamic   BootstrapMethod #2, onGetChild:(Lcom/chisalsoft/wordsdk/model_section/WordSectionPro;)Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;
        //   572: invokevirtual   com/chisalsoft/wordsdk/io/reader/WordDocumentReader.nodeTraverse:(Lorg/w3c/dom/Node;Lcom/chisalsoft/wordsdk/model/BaseWord;Lcom/chisalsoft/wordsdk/io/reader/WordXmlBaseReader$ChildNodeAction;)V
        //   575: return         
        //    Signature:
        //  <T:Lcom/chisalsoft/wordsdk/model/BaseWord;>(Lorg/w3c/dom/Node;TT;)V
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
