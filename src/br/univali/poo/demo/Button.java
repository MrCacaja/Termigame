package br.univali.poo.demo;

import br.univali.poo.termigame.Activable;
import br.univali.poo.termigame.Collidable;
import br.univali.poo.termigame.Text;
import com.googlecode.lanterna.TextColor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Button extends Text implements Collidable {
    private boolean activated;
    private String id;
    private static Map<String, Boolean> activatedButtons;

    public Button() {
        super("◉", TextColor.ANSI.RED, TextColor.ANSI.BLACK);
        this.id = new Random().nextInt() + "";
        this.setActivated(false);
    }

    public Button(boolean activated, String id) {
        super("◉", TextColor.ANSI.RED, TextColor.ANSI.BLUE);
        this.id = id;
        this.setActivated(activated);
    }

    public Button(String id) {
        super("◉", TextColor.ANSI.RED, TextColor.ANSI.BLUE);
        this.id = id;
        this.setActivated(false);
    }

    public void setActivated(boolean status) {
        this.activated = status;
        if (this.activated) {
            this.setColor(TextColor.ANSI.BLACK);
            this.setBgColor(TextColor.ANSI.RED);
        } else {
            this.setBgColor(TextColor.ANSI.BLACK);
            this.setColor(TextColor.ANSI.RED);
        }
        updateStaticStatus();
    }

    private void updateStaticStatus() {
        checkAndInitStatuses();
        activatedButtons.put(this.id, this.activated);
    }

    private static void checkAndInitStatuses() {
        if (activatedButtons == null) {
            activatedButtons = new HashMap<>();
        }
    }

    public static boolean getStateOf(String buttonId) {
        checkAndInitStatuses();
        return getCurrentStates().get(buttonId);
    }

    public static Map<String, Boolean> getCurrentStates() {
        checkAndInitStatuses();
        return activatedButtons;
    }

    @Override
    public boolean collide(Collidable collision) {
        this.setActivated(!this.activated);
        if (Activable.getActivable(this.id) != null) {
            Activable.getActivable(this.id).activate(this.activated);
        }
        return false;
    }
}
