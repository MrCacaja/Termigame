package br.univali.poo.demo;

import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Instrucoes extends Text {
    private GameDemo Game = null;

    public Instrucoes() {
        super("Mova-se com WASD e chegue ao fim da fase!", 5, 15, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }

    public void setGame(GameDemo game) {
        if (Game == null) Game = game;
    }

}
