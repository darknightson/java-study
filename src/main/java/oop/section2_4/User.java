package oop.section2_4;

public class User {
    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isSame(String id) {
        return this.id.equals(id);
    }
}
