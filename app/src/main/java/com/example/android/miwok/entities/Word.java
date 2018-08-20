package com.example.android.miwok.entities;


public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int backColor;
    private int mSymbolWord;
    private int mSoundWord;

    public int getBackColor() {
        return backColor;
    }

    private void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public int getmSymbolWord() {
        return mSymbolWord;
    }

    private void setmSymbolWord(int mSymbolWord) {
        this.mSymbolWord = mSymbolWord;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    private void setMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    private void setmDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public int getmSoundWord() {
        return mSoundWord;
    }

    private void setmSoundWord(int mSoundWord) {
        this.mSoundWord = mSoundWord;
    }
    public Word(String defaultTranslation, String miwokTranslation, int symbolWord, int back, int sound) {
        this.setmDefaultTranslation(defaultTranslation);
        this.setMiwokTranslation(miwokTranslation);
        this.setmSymbolWord(symbolWord);
        this.setBackColor(back);
        this.setmSoundWord(sound);
    }

    public Word(String defaultTranslation, String miwokTranslation, int back,int sound) {
        this.setmDefaultTranslation(defaultTranslation);
        this.setMiwokTranslation(miwokTranslation);
        this.setBackColor(back);
        this.setmSymbolWord(0);
        this.setmSoundWord(sound);
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", backColor=" + backColor +
                ", mSymbolWord=" + mSymbolWord +
                ", mSoundWord=" + mSoundWord +
                '}';
    }
}
