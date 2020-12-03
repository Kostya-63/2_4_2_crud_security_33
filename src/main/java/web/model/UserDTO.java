package web.model;

import java.util.Set;

public class UserDTO {

    private int id;

    private String name;

    private String password;

    private String character;

    private int iq;

    private Set<Role> roles;

    public UserDTO(String name, String character, int iq, String password, String admin, String user, Set<Role> roles) {
        this.name = name;
        this.character = character;
        this.iq = iq;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCharacter() {
        return character;
    }

    public int getIq() {
        return iq;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
