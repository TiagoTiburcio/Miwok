package com.example.android.miwok.entities;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private Color backColor;

    public Color getBackColor() {
        return backColor;
    }

    public void setBackColor(Color backColor) {
        this.backColor = backColor;
    }



    public Drawable getmSymbolWord() {
        return mSymbolWord;
    }

    public void setmSymbolWord(Drawable mSymbolWord) {
        this.mSymbolWord = mSymbolWord;
    }

    private Drawable mSymbolWord;

    public Word(String defaultTranslation, String miwokTranslation, Drawable symbolWord, Color back) {
        this.setmDefaultTranslation(defaultTranslation);
        this.setMiwokTranslation(miwokTranslation);
        this.setmSymbolWord(symbolWord);
        this.setBackColor(back);
    }

    public Word(String defaultTranslation, String miwokTranslation, Color back) {
        this.setmDefaultTranslation(defaultTranslation);
        this.setMiwokTranslation(miwokTranslation);
        this.setBackColor(back);
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public void setMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }


}
