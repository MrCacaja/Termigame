package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Wall extends Text implements Collidable {

    public Wall() {
        super("#", TextColor.ANSI.BLUE, TextColor.ANSI.CYAN);
    }

    @Override
    public boolean collide(Collidable collision) {
        return true;
    }
}
