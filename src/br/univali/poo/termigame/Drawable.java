package br.univali.poo.termigame;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Drawable {
    protected int x;
    protected int y;

    public abstract void draw(TextGraphics t, TextColor defaultColor, TextColor defaultBgColor);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
