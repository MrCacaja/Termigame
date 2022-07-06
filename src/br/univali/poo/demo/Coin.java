package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Coin extends Text implements Collidable {
    public Coin() {
        super("o", TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.BLACK);
    }

    @Override
    public boolean collide(Collidable collision) {
        GameDemo.getInstance().collectable(this);
        return false;
    }
}
