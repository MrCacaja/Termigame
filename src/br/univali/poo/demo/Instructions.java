package br.univali.poo.demo;

import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class Instructions extends Text {
    public Instructions() {
        super("Mova-se com WASD e chegue ao fim da fase!", 5, 15, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }
}
