package Q4.TM.w3;

import Q4.TM.w1.DBConnectionManager;

import java.sql.SQLException;

public class BookingThread extends Thread {
    DBConnectionManager _manager;

    public BookingThread(DBConnectionManager manager) {
        this._manager = manager;
    }

    public void runTransaction(ITransaction transaction) {
        try {
//            this._manager.getConnection().setAutoCommit(false);
            transaction.run(this._manager); // Currently doesn't throw an exception
            this._manager.getConnection().commit();
        } catch (Exception e) {
            System.out.println("Something went wrong while processing the transaction. Reverting...");
            try {
                this._manager.getConnection().rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
