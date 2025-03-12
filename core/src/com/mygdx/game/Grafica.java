package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class Grafica {
    private static Texture image;
    private int x = 0;
    private int y = 0;

    public Grafica(int x, int y,String path) {
        image = new Texture(Gdx.files.internal("data/sfondo_palazzi.png"));
        this.x = x;
        this.y = y;
    }
}
