package com.competitive;

import java.util.ArrayList;

public class Photo{

    private char orientation;
    private int Ntag;
    private ArrayList<String> tags;

    private int posicionOriginal;

    public Photo(char orientation, int ntag, ArrayList<String> tags,int posicionOriginal) {
        this.orientation = orientation;
        Ntag = ntag;
        this.tags = tags;
        this.posicionOriginal = posicionOriginal;
    }
    public int getPosicionOriginal(){
        return this.posicionOriginal;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public void setNtag(int ntag) {
        Ntag = ntag;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getNtag() {
        return Ntag;
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}