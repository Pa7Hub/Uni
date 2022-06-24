package Q3.exams.programming.cheatsheets.threads;

public class SyncAccountManagerThread extends Thread {
    private SyncAccount _account;
    private String _type;

    public SyncAccountManagerThread(SyncAccount account, String type) {
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

    public SyncAccount getAccount() {
        return this._account;
    }
}
