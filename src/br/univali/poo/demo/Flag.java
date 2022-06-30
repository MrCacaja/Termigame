package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Flag extends Text implements Collidable {
    public Flag() {
        super("!", TextColor.ANSI.GREEN, TextColor.ANSI.GREEN_BRIGHT);
    }

    @Override
    public boolean collide(Collidable collision) {
        GameDemo.getInstance().loadmap();
        return true;
    }
}
