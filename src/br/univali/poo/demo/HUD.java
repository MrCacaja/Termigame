package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class HUD extends Text {
    private GameDemo Game = null;

    public HUD(int fase) {
        super("Fase " + fase, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }

    public void setGame(GameDemo game) {
        if (Game == null) Game = game;
    }

}
