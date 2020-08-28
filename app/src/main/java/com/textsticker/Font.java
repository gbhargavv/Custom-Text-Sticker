package com.textsticker;

import android.graphics.Shader.TileMode;

public class Font {
    private String category;
    private int color;
    private String[] gradient;
    private String gradientType;
    private String linearDirection;
    private TileMode patternMode = TileMode.MIRROR;
    private String patternPath;
    private int patternRepeats = 8;
    private float size;
    private TileMode tileMode;
    private String typeface;

    private interface Limits {
        public static final float MIN_FONT_SIZE = 0.01f;
    }

    public void increaseSize(float f) {
        this.size += f;
    }

    public void decreaseSize(float f) {
        float f2 = this.size;
        if (f2 - f >= 0.01f) {
            this.size = f2 - f;
        }
    }

    public String getTypeface() {
        return this.typeface;
    }

    public void setTypeface(String str) {
        this.typeface = str;
    }

    public float getSize() {
        return this.size;
    }

    public void setSize(float f) {
        this.size = f;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public String[] getGradient() {
        return this.gradient;
    }

    public void setGradient(String[] strArr) {
        this.gradient = strArr;
    }

    public TileMode getTileMode() {
        return this.tileMode;
    }

    public void setTileMode(TileMode tileMode2) {
        this.tileMode = tileMode2;
    }

    public String getGradientType() {
        return this.gradientType;
    }

    public void setGradientType(String str) {
        this.gradientType = str;
    }

    public String getLinearDirection() {
        return this.linearDirection;
    }

    public void setLinearDirection(String str) {
        this.linearDirection = str;
    }

    public String getPatternPath() {
        return this.patternPath;
    }

    public void setPatternPath(String str) {
        this.patternPath = str;
    }

    public TileMode getPatternMode() {
        return this.patternMode;
    }

    public void setPatternMode(TileMode tileMode2) {
        this.patternMode = tileMode2;
    }

    public int getPatternRepeats() {
        return this.patternRepeats;
    }

    public void setPatternRepeats(int i) {
        this.patternRepeats = i;
    }
}
