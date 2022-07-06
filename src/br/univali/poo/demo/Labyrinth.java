package br.univali.poo.demo;

import br.univali.poo.termigame.Drawable;
import br.univali.poo.termigame.Text;
import br.univali.poo.termigame.TileMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Labyrinth extends TileMap {
    public Labyrinth(File csvFile, int startPosX, int startPosY) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super(csvFile, startPosX, startPosY);
    }

    public Labyrinth(List<List<Drawable>> content, int startPosX, int startPosY) {
        super(content, startPosX, startPosY);
    }

    public Labyrinth(List<List<Drawable>> content, int startPosX, int startPosY, int x, int y) {
        super(content, startPosX, startPosY, x, y);
    }

    // https://www.geeksforgeeks.org/how-to-iterate-over-a-2d-list-or-list-of-lists-in-java/
    public void RemoveObject(Drawable d){ // É uma função genérica de remoção de tile, faz sentido pra mim estar aqui.
        for (List list : getContent()){
            int cont = 0;
            for (Object obj : list) {
                if (d == obj) {
                    list.set(cont, new Text());
                    break;
                }
                cont++;
            }
        }
    }

    @Override
    protected HashMap<String, String> organizeTileset() {
        HashMap<String, String> tileSet = new HashMap<>();
        tileSet.put("", Text.class.getName());
        tileSet.put(" ", Text.class.getName());
        tileSet.put("wall", Wall.class.getName());
        tileSet.put("w", Wall.class.getName()); // Eu não quero chegar na insanidade digitando wall
        tileSet.put("f", Flag.class.getName());
        tileSet.put("b", Button.class.getName());
        tileSet.put("d", Door.class.getName());
        tileSet.put("h", Hazard.class.getName());
        tileSet.put("c", Coin.class.getName());
        return tileSet;
    }
}
