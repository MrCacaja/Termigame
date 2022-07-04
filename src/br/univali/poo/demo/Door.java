package br.univali.poo.demo;

import br.univali.poo.termigame.Activable;
import br.univali.poo.termigame.Collidable;
import com.googlecode.lanterna.TextColor;

public class Door extends Activable implements Collidable {
    private boolean open;

    public Door(String id) {
        super("ʭ", TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.YELLOW, id);
        active(false);
    }

    public Door(String id, boolean openStatus) {
        super("ʭ", TextColor.ANSI.YELLOW_BRIGHT, TextColor.ANSI.YELLOW, id);
        active(openStatus);
    }

    public void active(boolean status) {
        this.open = status;
        if (this.open) {
            this.setColor(TextColor.ANSI.BLACK);
            this.setBgColor(TextColor.ANSI.BLACK);
        } else {
            this.setBgColor(TextColor.ANSI.YELLOW_BRIGHT);
            this.setColor(TextColor.ANSI.YELLOW);
        }
        System.out.println(this.open);
    }

    @Override
    public boolean collide(Collidable collision) {
        return !this.open;
    }
}
