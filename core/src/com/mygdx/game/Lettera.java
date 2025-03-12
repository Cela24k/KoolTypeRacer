package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Lettera {

    private Texture image;
    private int x;
    private int y=300;
    private char carattere;

    public Lettera(char carattere) {
        this.carattere = carattere;
        x = 250;
    }

    public void loadImage()
    {
        carattere = formatta(carattere);
        image = new Texture("lettersImages/"+ carattere +".png");
    }
    public static char formatta(char x)
    {
        if(x == 'è' || x == 'é') x = 'e';
        if(x == 'à' || x == 'á') x = 'a';
        if(x == 'ò' || x == 'ó') x = 'o';
        if(x == 'ì' || x == 'í') x = 'i';
        if(x == 'ù') x = 'u';
        return x;
    }
    public void setChar(char x)
    {
        carattere = x;
    }
    public Texture getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void incX(int amount)
    {
        x+=amount;
    }

    public void setY(int x){ y+=x;}
}