package Characters;

import Items.*;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import Misc.*;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import javafx.scene.image.Image;

public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String spritePath;
    private transient Image fxImage;
    private double attack;
    private double magic;
    private double defense;
    private int level;
    private LinkedList<Item> items;
    private LinkedList<Weapon> weapons;
    private Weapon actualWeapon;
    private GeneralTree<Classes> unlockedClasses;
    private Classes actualClass;
    private Queue<Task> tasks;
    private Deque<Task> completedTasks;

    public Hero(String name) {
        setName(name);
        setSpritePath("/Resources/sprites/hero.png");
        setAttack(5);
        setMagic(20);
        setDefense(4);
        setLevel(1);
        items = new LinkedList<>();
        weapons = new LinkedList<>();
        actualWeapon = null;
        unlockedClasses = new GeneralTree<>();
        this.actualClass = null;
        tasks = new ArrayDeque<>();
        completedTasks = new ArrayDeque<>();
        loadFxImage();
    }

    private void loadFxImage() {
        if (!(spritePath == null || spritePath.isEmpty())) {

            try {
                fxImage = new Image(getClass().getResourceAsStream(spritePath));
                if (fxImage.isError()) {
                    fxImage = null;
                }
            } catch (Throwable ignored) {
                fxImage = null;
            }
        }
    }

    public Image getImage() {
        if (fxImage != null) {
            return fxImage;
        }
        loadFxImage();
        return fxImage;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
        this.fxImage = null;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Debe ser mayor que 0");
        }
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        if (attack >= 1) {
            this.attack = attack;
        } else {
            throw new IllegalArgumentException("Debe ser mayor que 0");
        }
    }

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        if (magic >= 1) {
            this.magic = magic;
        } else {
            throw new IllegalArgumentException("Debe ser mayor que 0");
        }
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        if (defense >= 1) {
            this.defense = defense;
        } else {
            throw new IllegalArgumentException("Debe ser mayor que 0");
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level >= 1) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Debe ser mayor que 0");
        }
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }

    public LinkedList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(LinkedList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Weapon getActualWeapon() {
        return actualWeapon;
    }

    public void setActualWeapon(Weapon actualWeapon) {
        this.actualWeapon = actualWeapon;
    }

    public Deque<Task> getCompletedTasks() {
        return completedTasks;
    }

    public void addCompletedTasks(Task t) {
        completedTasks.push(t);
    }

    public Queue<Task> getTasks() {
        return tasks;
    }

    public void addTasks(Task t) {
        tasks.offer(t);
    }
}
