package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class HUD extends Text {
    public HUD(int fase) {
        super("Fase " + fase, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }

}
