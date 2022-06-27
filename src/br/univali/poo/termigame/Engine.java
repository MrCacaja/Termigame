package br.univali.poo.termigame;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Engine {
    private final Terminal terminal;
    private final Screen screen;
    private final TextGraphics textGraphics;
    protected TextColor defaultTextColor; //NÃO USEI AINDA
    protected TextColor defaultBgColor; //NÃO USEI AINDA
    protected List<Drawable> drawables;


    public Engine() throws IOException { //TEM QUE TRATAR ISSO
        terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        textGraphics = screen.newTextGraphics();
        defaultBgColor = TextColor.ANSI.BLACK;
        defaultTextColor = TextColor.ANSI.DEFAULT;
        drawables = new ArrayList<>();
    }

    protected abstract void init();
    protected abstract void update();
    protected abstract boolean readInput();
    protected abstract void drawGraphics();

    protected void draw() {
        for (Drawable drawable : this.drawables) {
            drawable.draw(textGraphics);
        }
    }

    public Collection<Drawable> getDrawables() {
        return drawables;
    }

    public void setDrawables(List<Drawable> drawables) {
        this.drawables = drawables;
    }

    public void pushDrawable(Drawable drawable, int i) {
        drawables.add(i, drawable);
    }

    public int pushDrawable(Drawable drawable) {
        drawables.add(drawable);
        return drawables.size();
    }

    public void removeDrawable(Drawable drawable) {
        drawables.remove(drawable);
    }

    public void start() throws IOException, InterruptedException {
        init();
        screen.startScreen();
        boolean running = true;
        while (running) {
            running = readInput();
            update();
            drawGraphics();
            screen.refresh();
            Thread.sleep(500);
        }
    }

}
