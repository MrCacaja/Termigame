package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Hazard extends Text implements Collidable {
    public Hazard() {
        super(" ", TextColor.ANSI.RED_BRIGHT, TextColor.ANSI.RED_BRIGHT);
    }

    @Override
    public boolean collide(Collidable collision) {
        GameDemo.getInstance().loadmap(false);
        return true;
    }
}
