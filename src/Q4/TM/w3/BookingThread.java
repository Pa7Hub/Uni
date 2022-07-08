package Q4.TM.w3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookingThread extends Thread {
    Connection _connection;
    String _account;
    String _url;

    public BookingThread(String url, String account, String connectionURL) throws SQLException {
        this._url = url;
        this._connection = DriverManager.getConnection(connectionURL);
    }

    public void runTransaction(ITransaction transaction) {
        try {
            transaction.run(this._connection); // Currently doesn't throw an exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
