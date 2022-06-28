package br.univali.poo.demo;

import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Engine;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class GameDemo extends Engine {
    public GameDemo() throws IOException {
        super();
    }

    protected void init() {
        this.drawables.add(new Text("teste", 10, 10));
    }

    protected void update() {
        System.out.println("rodando");
    }

    protected boolean readInput() throws IOException {
        KeyStroke key = pollInput();
        if (key == null) return true;
        if (key.getKeyType() == KeyType.EOF) {
            return false;
        }
        System.out.println(key);
        return true;
    }

    protected void drawGraphics() {
        draw();
    }
}
