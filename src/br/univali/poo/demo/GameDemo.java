package br.univali.poo.demo;

import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Engine;
import br.univali.poo.termigame.Text;

import java.io.IOException;

public class GameDemo extends Engine {
    public GameDemo() throws IOException {
        super();
    }

    protected void init() {
        this.drawables.add(new Text("teste"));
    }

    protected void update() {
        System.out.println("rodando");
    }

    protected boolean readInput() {
        return true;
    }

    protected void drawGraphics() {
        draw();
    }
}
