package clientside;

public class User {
    
    private String name;
    //maybe hand made of a card class
    
    public User(String name) {
        this.name = name;
    }
    
    public boolean equals(String name) {
        return this.name.equals(name);
    }
    
    public String getName() {
        return name;
    }
    
}
