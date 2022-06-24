package Q3.exams.programming.cheatsheets.threads;

/**
 * Einfacher Thread, der auf ein Konto zugreifen kann.
 */
public class AccountManagerThread extends Thread {
    private Account _account;
    private String _type;

    public AccountManagerThread(Account account, String type) {
        this._account = account;
        this._type = type;
    }

    @Override
    public void run() {
        if (this._type.equals("deposit")) {
            for (int i = 0; i <= 50; i++) {
                this._account.deposit(15);
            }
        } else {
            for (int i = 0; i <= 50; i++) {
                this._account.withdraw(15);
            }
        }
    }

    public Account getAccount() {
        return this._account;
    }
}
