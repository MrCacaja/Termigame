package br.univali.poo.termigame;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Text extends Drawable {
    private String value;
    private TextColor color;
    private TextColor bgColor;

    public Text() {
        this.x = 0;
        this.y = 0;
        this.value = "";
        this.color = TextColor.ANSI.DEFAULT;
        this.bgColor = TextColor.ANSI.BLACK;
    }

    public Text(String value) {
        this.x = 0;
        this.y = 0;
        this.value = value;
        this.color = TextColor.ANSI.DEFAULT;
        this.bgColor = TextColor.ANSI.BLACK;
    }

    public Text(String value, int x, int y) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.color = TextColor.ANSI.DEFAULT;
        this.bgColor = TextColor.ANSI.BLACK;
    }

    public Text(String value, TextColor color, TextColor bgColor) {
        this.x = 0;
        this.y = 0;
        this.value = value;
        this.color = color;
        this.bgColor = bgColor;
    }

    public Text(String value, int x, int y, TextColor color, TextColor bgColor) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.color = color;
        this.bgColor = bgColor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TextColor getColor() {
        return color;
    }

    public void setColor(TextColor color) {
        this.color = color;
    }

    public TextColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(TextColor bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public void draw(TextGraphics t, TextColor defaultColor, TextColor defaultBgColor) {
        t.setBackgroundColor(bgColor);
        t.setForegroundColor(color);
        t.putString(x, y, value);
        t.setForegroundColor(defaultColor);
        t.setBackgroundColor(defaultBgColor);
    }
}
