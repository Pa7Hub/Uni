package Q4.TM.w3;

import Q4.TM.w1.DBConnectionManager;

import java.io.IOException;
import java.sql.SQLException;

public class BookingThreadImpl {
    public static void main(String[] args) {
        DBConnectionManager manager = new DBConnectionManager();
        try {
            manager.establishConnectionFromUserInput();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        BookingThread thread = new BookingThread(manager);
        BankTransferExample example = new BankTransferExample();
        thread.runTransaction(example);
    }
}
