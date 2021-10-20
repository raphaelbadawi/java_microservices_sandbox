package net.campusnumerique.dungeonfront.entity;

import net.campusnumerique.dungeonfront.type.CharacterType;

import java.beans.ConstructorProperties;

public class Character {
    private long id;
    private String name;
    private CharacterType type;

    @ConstructorProperties({"name", "data"})
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }


}
