package web.model;

public class UserDTO {

    private int id;

    private String name;

    private String password;

    private String character;

    private int iq;

    private String admin;

    private String user;


    public UserDTO(String name, String character, int iq, String password, String admin, String user) {
        this.name = name;
        this.character = character;
        this.iq = iq;
        this.password = password;
        this.admin = admin;
        this.user = user;
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

    public String getAdmin() {
        return admin;
    }

    public String getUser() {
        return user;
    }
}
