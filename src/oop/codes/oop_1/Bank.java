package src.codes.oop.codes;

public class Bank {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.insert(8169, 10000, "Elon");
        a1.display();
        a1.checkBalance();
        a1.deposit(50000);
        a1.checkBalance();
        a1.withdraw(1000);
        a1.checkBalance();
    }
}

class Account {
    int acc_no;
    float amount;
    String name;

    // method to initialize object
    void insert(int accNo, float amt, String n) {
        acc_no = accNo;
        amount = amt;
        name = n;
    }

    void deposit(float amt) {
        amount = amount + amt;
        System.out.println("amount deposited: " + amt);
        System.out.println();
    }

    void withdraw(float amt) {
        if (amt > amount) {
            System.out.println("insufficient balance");
            System.out.println();
        } else {
            amount = amount - amt;
        }
        System.out.println("amount withdrawn: " + amt);
        System.out.println();
    }

    void checkBalance() {
        System.out.println("balance: " + amount);
        System.out.println();
    }

    void display() {
        System.out.println("account no: " + acc_no + "\namount: " + amount + "\nname: " + name);
        System.out.println();
    }
}
