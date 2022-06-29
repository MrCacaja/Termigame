package br.univali.poo.demo;

import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Engine;
import br.univali.poo.termigame.Text;
import br.univali.poo.termigame.TileMap;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameDemo extends Engine {
    private TileMap tileMap;
    private Player player;

    public GameDemo() throws IOException {
        super();
    }

    protected void init() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        tileMap = new TileMap(new File("./resources/map.csv"), 5, 5);
        player = new Player(tileMap);
        this.drawables.add(tileMap);
        this.drawables.add(player);
    }

    protected void update() {
    }

    protected boolean readInput() throws IOException {
        KeyStroke key = pollInput();
        if (key == null) return true;
        if (key.getKeyType() == KeyType.Character) {
            int dirX = 0;
            int dirY = 0;
            char keyChar = key.getCharacter().toString().toLowerCase().toCharArray()[0];
            if (keyChar == 'w')
                dirY -= 1;
            if (keyChar == 'a')
                dirX -= 1;
            if (keyChar == 's')
                dirY += 1;
            if (keyChar == 'd')
                dirX += 1;
            player.move(tileMap, dirX, dirY);
        }
        else if (key.getKeyType() == KeyType.EOF) {
            return false;
        }
        System.out.println(key);
        return true;
    }

    protected void drawGraphics() {
        draw();
    }
}
