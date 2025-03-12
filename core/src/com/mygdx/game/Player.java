package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    private double speed;
    private int y;
    private int x;
    private int weight;
    private int height;
    private Texture image;

    public Player()
    {
        this.y = 30;
        this.x = 20;
        this.speed = 0;
        loadImage();
    }

    private void loadImage() {
        Texture ii = new Texture("badlogic.png");
        image = ii;
    }

    public void accelerate (int amount) throws IllegalArgumentException
    {
        if(amount>=0)
        {
            this.speed +=amount;
            if(x <= 270)
            {
                x+=amount;

            }
        }
        else throw new IllegalArgumentException("Insert a positive amount");
    }

    public void slowDown(int amount) throws IllegalArgumentException
    {
        if(speed > 0)
        {
            if(amount>=0)
            {
                this.speed -=amount;
                this.x -=amount;
            }
            else throw new IllegalArgumentException("Insert a positive amount");
        }
    }

    public double getSpeed() {
        return speed;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
    public Texture getImage() {
        return image;
    }
}
