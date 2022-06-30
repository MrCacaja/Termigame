package br.univali.poo.termigame;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Engine {
    private Terminal terminal;
    private Screen screen;
    private TextGraphics textGraphics;
    protected TextColor defaultTextColor; //NÃO USEI AINDA
    protected TextColor defaultBgColor; //NÃO USEI AINDA
    protected List<Drawable> drawables;


    public Engine() {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            textGraphics = screen.newTextGraphics();
            defaultBgColor = TextColor.ANSI.BLACK;
            defaultTextColor = TextColor.ANSI.DEFAULT;
            drawables = new ArrayList<>();
        } catch (Exception exception) {
            System.out.println("Ocorreu um erro ao instanciar o jogo");
        }
    }

    protected abstract void init() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException;
    protected abstract void update();
    protected abstract boolean readInput() throws IOException;
    protected abstract void drawGraphics();

    protected void draw() {
        for (Drawable drawable : this.drawables) {
            drawable.draw(textGraphics, defaultTextColor, defaultBgColor);
        }
    }

    public Collection<Drawable> getDrawables() {
        return drawables;
    }

    public KeyStroke pollInput() throws IOException {
        return terminal.pollInput();
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

    public void start() throws IOException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        init();
        screen.startScreen();
        screen.setCursorPosition(null);
        boolean running = true;
        while (running) {
            screen.clear();
            running = readInput();
            update();
            drawGraphics();
            screen.refresh();
            Thread.sleep(5);
        }
        screen.stopScreen();
    }

}
