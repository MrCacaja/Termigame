package br.univali.poo.termigame;

import br.univali.poo.demo.Wall;
import br.univali.poo.demo.Flag;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileMap extends Drawable {
    private List<List<Drawable>> content;
    private int startPosX;
    private int startPosY;
    private Map<String, String> tileSet;

    public TileMap(File csvFile, int startPosX, int startPosY) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.content = new ArrayList<>();
        this.organizeTileset();
        List<List<String>> stringsMap = new CSVReader().readFile(csvFile);
        for (List<String> stringList : stringsMap) {
            List<Drawable> textList = new ArrayList<>();
            for (String string : stringList) {
                try {
                    if (!this.tileSet.containsKey(string)) {
                        throw new ClassNotFoundException();
                    }
                    Object newObject = Class.forName(this.tileSet.get(string)).newInstance();
                    if (!(newObject instanceof Drawable)) {
                        throw new InstantiationException();
                    }
                    textList.add((Drawable) newObject);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException classNotFoundException) {
                    System.out.println("A classe de nome " + string + " não pôde ser instanciada");
                }
            }
            this.content.add(textList);
        }
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.x = 0;
        this.y = 0;
    }

    public TileMap(List<List<Drawable>> content, int startPosX, int startPosY) {
        this.content = content;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.x = 0;
        this.y = 0;
    }

    public TileMap(List<List<Drawable>> content, int startPosX, int startPosY, int x, int y) {
        this.content = content;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.x = x;
        this.y = y;
    }

    private void organizeTileset() {
        this.tileSet = new HashMap<>();
        this.tileSet.put("", Text.class.getName());
        this.tileSet.put(" ", Text.class.getName());
        this.tileSet.put("", Text.class.getName());
        this.tileSet.put("wall", Wall.class.getName());
        this.tileSet.put("w", Wall.class.getName()); // Eu não quero chegar na insanidade digitando wall
        this.tileSet.put("f", Flag.class.getName());
    }

    public List<List<Drawable>> getContent() {
        return content;
    }

    public void setContent(List<List<Drawable>> content) {
        this.content = content;
    }

    public int getStartPosX() {
        return startPosX;
    }

    public void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public void setStartPosY(int startPosY) {
        this.startPosY = startPosY;
    }

    @Override
    public void draw(TextGraphics t, TextColor defaultColor, TextColor defaultBgColor) {
        for (int x = 0; x < this.content.size(); x++) {
            List<Drawable> textList = this.content.get(x);
            if (textList == null) continue;
            for (int y = 0; y < this.content.get(x).size(); y++) {
                Drawable text = textList.get(y);
                if (text == null) continue;
                text.setX(x);
                text.setY(y);
                text.draw(t, defaultColor, defaultBgColor);
            }
        }
    }
}
