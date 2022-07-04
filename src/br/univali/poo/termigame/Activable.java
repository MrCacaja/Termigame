package br.univali.poo.termigame;

import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;
import java.util.List;

public abstract class Activable extends Text {
    protected String id;
    private static List<Activable> activables;

    public Activable() {
        super();
        this.id = activables.size() + "";
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public Activable(String id) {
        super();
        this.id = id;
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public Activable(String value, String id) {
        super(value);
        this.id = id;
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public Activable(String value, int x, int y, String id) {
        super(value, x, y);
        this.id = id;
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public Activable(String value, TextColor color, TextColor bgColor, String id) {
        super(value, color, bgColor);
        this.id = id;
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public Activable(String value, int x, int y, TextColor color, TextColor bgColor, String id) {
        super(value, x, y, color, bgColor);
        this.id = id;
        if (activables == null) {
            activables = new ArrayList<>();
        }
        activables.add(this);
    }

    public static Activable getActivable(String id) {
        for (Activable activable: activables) {
            if (activable.id.equals(id)) return activable;
        }
        return null;
    }

    public abstract void active(boolean status);
}
