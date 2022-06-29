package br.univali.poo.demo;

import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Text;
import br.univali.poo.termigame.TileMap;
import com.googlecode.lanterna.TextColor;

import java.util.List;

public class Player extends Text implements Collidable {
    public Player(TileMap map) {
        super("☻", map.getStartPosX(), map.getStartPosY(), TextColor.ANSI.RED, TextColor.ANSI.BLACK);
    }

    public boolean move(TileMap map, int dirX, int dirY) {
        if (checkCollision(map, dirX, dirY)) return false;
        x += dirX;
        y += dirY;
        return true;
    }

    private boolean checkCollision(TileMap map, int dirX, int dirY) {
        if (this.x + dirX < 0 || this.y + dirY < 0) return true;
        if (map.getContent().size() <= this.x + dirX) return false;
        List<Drawable> x = map.getContent().get(this.x + dirX);
        if (x == null || x.size() <= this.y + dirY) return false;
        return x.get(this.y + dirY) instanceof Collidable && ((Collidable) x.get(this.y + dirY)).collide(this);
    }

    @Override
    public boolean collide(Collidable collision) {
        return collision.collide(this);
    }
}
