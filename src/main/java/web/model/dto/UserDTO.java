package web.model.dto;

import web.model.Role;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
