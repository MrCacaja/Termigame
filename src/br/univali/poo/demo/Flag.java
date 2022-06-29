package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Flag extends Text implements Collidable {
    private GameDemo Game = null;
    public Flag() {
        super("!", TextColor.ANSI.GREEN, TextColor.ANSI.GREEN_BRIGHT);
    }

    public void setGame(GameDemo game) {
        if (Game == null) Game = game;
    }

    @Override
    public boolean collide(Collidable collision) {
        Game.loadmap();
        return true;
    }
}
