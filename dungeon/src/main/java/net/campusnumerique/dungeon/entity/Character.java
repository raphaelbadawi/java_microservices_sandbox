package net.campusnumerique.dungeon.entity;

import net.campusnumerique.dungeon.type.CharacterType;

import javax.persistence.*;

@Entity
@Table(name = "Personnages")
public class Character {
    private long id;
    private String name;
    private CharacterType type;

    public Character(int id, String name, CharacterType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", nullable = false)
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
