package br.univali.poo.demo;

import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Engine;
import br.univali.poo.termigame.TileMap;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameDemo extends Engine {
    private TileMap tileMap;
    private Player player;
    private HUD hud;
    private int score = 0;
    private int level = 1;
    private static GameDemo instance;

    private GameDemo() {
        super();
    }

    public static GameDemo getInstance() {
        if (instance == null) instance = new GameDemo();
        return instance;
    }

    protected void init() throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        tileMap = new Labyrinth(new File("./resources/map1.csv"), 1, 1);
        player = new Player(tileMap);
        hud = new HUD(level, score);
        this.drawables.add(tileMap);
        this.drawables.add(player);
        this.drawables.add(new Instructions());
        this.drawables.add(hud);
    }

    protected void loadmap(boolean skip) { // Loadmap com skip false pode ser usado para caso o player morra
        try {
            if (skip) {this.level += 1;}
            tileMap = new Labyrinth(new File("./resources/map" + this.level + ".csv"), 1, 1);
            player = new Player(tileMap);
            hud = new HUD(level, score);
            this.drawables = new ArrayList<>();
            this.drawables.add(tileMap);
            this.drawables.add(player);
            this.drawables.add(hud);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void collectable(Drawable collectable){
        tileMap.removeObject(collectable);
        score++;
        hud.updateHUD(level, score);
    }

    protected void update() {
    }

    public TileMap getTileMap() {
        return tileMap;
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
            if (keyChar == 'h') System.out.println(Button.getCurrentStates());
            player.move(dirX, dirY);
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
