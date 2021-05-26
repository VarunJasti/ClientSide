package clientside;

public class User {
    
    private String name;
    private boolean mainPlayer;
    //maybe hand made of a card class
    
    public User(String name) {
        this.name = name;
    }
    
    public User(String name, boolean mainPlayer) {
        this.name = name;
        this.mainPlayer = mainPlayer;
    }
    
    public boolean equals(String name) {
        return this.name.equals(name);
    }
    
    public String getName() {
        return name;
    }
    
}
