package br.univali.poo.demo;

import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

public class HUD extends Text {
    public HUD(int fase, int pontos) {
        super( "| Fase " + fase + " | Pontos: " + pontos + " |", TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }
    public void updateHUD(int fase, int pontos){
        this.setValue("| Fase " + fase + " | Pontos: " + pontos + " |");
    }
}
