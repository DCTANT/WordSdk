package com.chisalsoft.wordsdk.model_drawing.model_wp;

import com.chisalsoft.wordsdk.model.*;

public class WpAnchor extends BaseWord
{
    private WpSimplePos S;
    private WpPositionH T;
    private WpPositionV U;
    private WpExtent V;
    private WpEffectExtent W;
    private WpWrapNone X;
    private WpDocPr Y;
    private WpCNvGraphicFramePr Z;
    private Wp14SizeRelH aa;
    private Wp14SizeRelV ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;
    private String al;
    
    public WpAnchor() {
        this.tagName = "wp:anchor";
    }
    
    public WpSimplePos getWpSimplePos() {
        return this.S;
    }
    
    public void setWpSimplePos(final WpSimplePos wpSimplePos) {
        this.S = wpSimplePos;
    }
    
    public WpPositionH getWpPositionH() {
        return this.T;
    }
    
    public void setWpPositionH(final WpPositionH wpPositionH) {
        this.T = wpPositionH;
    }
    
    public WpPositionV getWpPositionV() {
        return this.U;
    }
    
    public void setWpPositionV(final WpPositionV wpPositionV) {
        this.U = wpPositionV;
    }
    
    public WpExtent getWpExtent() {
        return this.V;
    }
    
    public void setWpExtent(final WpExtent wpExtent) {
        this.V = wpExtent;
    }
    
    public WpEffectExtent getWpEffectExtent() {
        return this.W;
    }
    
    public void setWpEffectExtent(final WpEffectExtent wpEffectExtent) {
        this.W = wpEffectExtent;
    }
    
    public WpWrapNone getWpWrapNone() {
        return this.X;
    }
    
    public void setWpWrapNone(final WpWrapNone wpWrapNone) {
        this.X = wpWrapNone;
    }
    
    public WpDocPr getWpDocPr() {
        return this.Y;
    }
    
    public void setWpDocPr(final WpDocPr wpDocPr) {
        this.Y = wpDocPr;
    }
    
    public WpCNvGraphicFramePr getWpCNvGraphicFramePr() {
        return this.Z;
    }
    
    public void setWpCNvGraphicFramePr(final WpCNvGraphicFramePr wpCNvGraphicFramePr) {
        this.Z = wpCNvGraphicFramePr;
    }
    
    public Wp14SizeRelH getWp14SizeRelH() {
        return this.aa;
    }
    
    public void setWp14SizeRelH(final Wp14SizeRelH wp14SizeRelH) {
        this.aa = wp14SizeRelH;
    }
    
    public Wp14SizeRelV getWp14SizeRelV() {
        return this.ab;
    }
    
    public void setWp14SizeRelV(final Wp14SizeRelV wp14SizeRelV) {
        this.ab = wp14SizeRelV;
    }
    
    public String getDistT() {
        return this.ac;
    }
    
    public void setDistT(final String distT) {
        this.ac = distT;
    }
    
    public String getDistB() {
        return this.ad;
    }
    
    public void setDistB(final String distB) {
        this.ad = distB;
    }
    
    public String getDistL() {
        return this.ae;
    }
    
    public void setDistL(final String distL) {
        this.ae = distL;
    }
    
    public String getDistR() {
        return this.af;
    }
    
    public void setDistR(final String distR) {
        this.af = distR;
    }
    
    public String getSimplePos() {
        return this.ag;
    }
    
    public void setSimplePos(final String simplePos) {
        this.ag = simplePos;
    }
    
    public String getRelativeHeight() {
        return this.ah;
    }
    
    public void setRelativeHeight(final String relativeHeight) {
        this.ah = relativeHeight;
    }
    
    public String getBehindDoc() {
        return this.ai;
    }
    
    public void setBehindDoc(final String behindDoc) {
        this.ai = behindDoc;
    }
    
    public String getLocked() {
        return this.aj;
    }
    
    public void setLocked(final String locked) {
        this.aj = locked;
    }
    
    public String getLayoutInCell() {
        return this.ak;
    }
    
    public void setLayoutInCell(final String layoutInCell) {
        this.ak = layoutInCell;
    }
    
    public String getAllowOverlap() {
        return this.al;
    }
    
    public void setAllowOverlap(final String allowOverlap) {
        this.al = allowOverlap;
    }
}
