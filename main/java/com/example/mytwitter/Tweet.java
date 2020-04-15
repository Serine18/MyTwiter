package com.example.mytwitter;

public class Tweet {
    private int image;
    private String pseudo;
    private String text;

    public int getimage() {
        return image;
    }

    public void setimage(int color) {
        this.image = color;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tweet(int image, String pseudo, String text) {
        this.image = image;
        this.pseudo = pseudo;
        this.text = text;
    }

}