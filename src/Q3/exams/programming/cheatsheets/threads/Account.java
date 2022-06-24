package Q3.exams.programming.cheatsheets.threads;

/**
 * Die Form mit current ist hier nötig, um die Nebeneffekte von Nebenläufigkeit besser zu sehen.
 */
public class Account {
    private Integer _balance;
    public Account(Integer startingBalance) {
        this._balance = startingBalance;
    }

    public void deposit(Integer amount) {
        Integer current = this._balance;
        current += amount;
        this._balance = current;
    }

    public void withdraw(Integer amount) {
        // Rather use an Exception here, but it would just make implementation annoying
//        if (amount > this._balance) {
//            System.out.println("Cannot withdraw more money than available on Account!");
//        } else {
           Integer current = this._balance;
           current -= amount;
           this._balance = current;
//        };
    }

    public Integer getBalance() {
        return this._balance;
    }
}
