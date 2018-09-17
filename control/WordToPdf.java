package com.chisalsoft.wordsdk.control;

import java.io.*;
import com.artofsolving.jodconverter.openoffice.converter.*;
import com.artofsolving.jodconverter.openoffice.connection.*;
import com.artofsolving.jodconverter.*;

public class WordToPdf
{
    private String y;
    private String D;
    private String w;
    
    public WordToPdf(final String docxPath, final String pdfPath, final String openOfficePath) {
        this.y = docxPath;
        this.D = pdfPath;
        this.w = openOfficePath;
    }
    
    public void convert() {
        try {
            final File inputFile;
            if (!(inputFile = new File(this.y)).exists()) {
                System.out.println("\u6e90\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
                return;
            }
            final File outputFile;
            if (!(outputFile = new File(this.D)).getParentFile().exists()) {
                outputFile.getParentFile().exists();
            }
            final String command = this.w + " -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";
            final Process p = Runtime.getRuntime().exec(command);
            final OpenOfficeConnection connection;
            (connection = (OpenOfficeConnection)new SocketOpenOfficeConnection("127.0.0.1", 8100)).connect();
            ((DocumentConverter)new OpenOfficeDocumentConverter(connection)).convert(inputFile, outputFile);
            connection.disconnect();
            p.destroy();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
