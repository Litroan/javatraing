class Cashcard {
    String number;
    int balance;
    int bonus;
    Cashcard(String number, int balance, int bonus) {
        this.number = number;
        this.balance = balance;
        this.bonus = bonus;
    }
}

public class helloworld {
    public static void main(String[] args) {
        Cashcard[] cards = {
            new Cashcard("A01", 300, 0),
            new Cashcard("A02", 500, 0),
            new Cashcard("A03", 1000, 1),
            new Cashcard("A04", 3000, 3)
        };

        for (Cashcard card : cards) {
            System.out.printf(": %s, 點數 : %d, 紅利點數 : %d/n", 
                    card.number, card.balance, card.bonus);
        }
    }
}
