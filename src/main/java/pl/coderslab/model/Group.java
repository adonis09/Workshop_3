package pl.coderslab.model;

public class Group {
    private int id;
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Group(){}

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

    @Override
    public String toString() {
        return "id: " + this.id + " | name: " + this.name;
    }
}
