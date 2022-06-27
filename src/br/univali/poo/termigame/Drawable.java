package br.univali.poo.termigame;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Drawable {
    protected int x;
    protected int y;

    public abstract void draw(TextGraphics t);
}
