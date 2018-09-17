package com.chisalsoft.wordsdk.util;

import org.w3c.dom.*;

public class NodeToXml
{
    private StringBuffer xmlSb;
    
    public NodeToXml() {
        this.xmlSb = new StringBuffer();
    }
    
    public String getNodeXml(final Node goalNode) {
        (this.xmlSb = new StringBuffer()).append("<" + goalNode.getNodeName());
        final int length = goalNode.getChildNodes().getLength();
        this.a(goalNode);
        boolean b;
        if (length == 0) {
            this.xmlSb.append("/>");
            final boolean b2;
            b = (b2 = false);
        }
        else {
            this.xmlSb.append(">");
            final boolean b2;
            b = (b2 = true);
        }
        if (b) {
            this.traverse(goalNode);
        }
        final String result = this.xmlSb.toString();
        System.out.println(result);
        return result;
    }
    
    private void traverse(final Node fatherNode) {
        final NodeList childNodeList = fatherNode.getChildNodes();
        for (int i = 0; i < childNodeList.getLength(); ++i) {
            final Node childNode;
            final String nodeName = (childNode = childNodeList.item(i)).getNodeName();
            String nodeValue = null;
            if (childNode.getFirstChild() != null) {
                nodeValue = childNode.getFirstChild().getNodeValue();
            }
            if (!nodeName.substring(0, 1).equals("#")) {
                this.xmlSb.append("<" + nodeName);
                System.out.println("nodeName is " + nodeName + " nodeValue is " + nodeValue);
                this.a(childNode);
                if (childNode.getChildNodes().getLength() == 0) {
                    this.xmlSb.append("/>");
                }
                else {
                    this.xmlSb.append(">");
                }
                if (nodeValue != null && nodeValue.trim().length() > 0) {
                    this.xmlSb.append(nodeValue);
                }
                this.traverse(childNode);
            }
        }
        if (childNodeList.getLength() > 0) {
            this.xmlSb.append("</" + fatherNode.getNodeName() + ">");
        }
    }
    
    private void a(final Node node) {
        final NamedNodeMap attributes;
        if ((attributes = node.getAttributes()) != null) {
            final int length = attributes.getLength();
            System.out.println("attribute length is " + length);
            for (int j = 0; j < attributes.getLength(); ++j) {
                final Node attibuteNode = attributes.item(j);
                System.out.println("attibuteNode name is " + attibuteNode.getNodeName() + " value is " + attibuteNode.getNodeValue());
                final String attributeName = attibuteNode.getNodeName();
                final String attributeValue = attibuteNode.getNodeValue();
                this.xmlSb.append(" " + attributeName + "=\"" + attributeValue + "\"");
            }
        }
    }
}
