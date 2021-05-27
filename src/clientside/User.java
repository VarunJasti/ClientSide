package clientside;

public class User {
    
    private String name;
    private boolean mainPlayer;
    private double bet;
    private double money;
    //maybe hand made of a card class
    
    public User(String name) {
        this.name = name;
        this.bet = 0;
        this.money = 5;
    }
    
    public User(String name, boolean mainPlayer) {
        this.name = name;
        this.mainPlayer = mainPlayer;
        this.bet = 0;
        this.money = 5;
    }

    public boolean isMainPlayer() {
        return mainPlayer;
    }
    
    public boolean equals(String name) {
        return this.name.equals(name);
    }
    
    public String getName() {
        return name;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getBet() {
        return bet;
    }

    public double getMoney() {
        return money;
    }
    
}
