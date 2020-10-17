package web.model;

import javax.persistence.*;

@Entity
@Table(name = "crud_users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "characteristic")
    private String character;

    @Column(name = "iq")
    private int iq;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getIQ() {
        return iq;
    }

    public void setIQ(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", character='" + character + '\'' +
                ", iq=" + iq +
                '}';
    }
}
