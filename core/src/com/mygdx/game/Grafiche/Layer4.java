package com.mygdx.game.Grafiche;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Layer4 {
    private static Texture image;
    private int x = 0;
    private int y = 0;

    //TODO DA RANDOMIZZARE CON TUTTE LE IMMAGINI DI STRADA
    public Layer4(int x, int y) {
        image = new Texture(Gdx.files.internal("data/nuvole.png"));
        this.x = x;
        this.y = y;
    }

    public static Texture getImage() {
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
        x-=amount;
    }

    public void setX(int x) {
        this.x = x;
    }
}