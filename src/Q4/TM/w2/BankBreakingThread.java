package Q4.TM.w2;

import java.sql.*;

/**
 * Will establish a connection to the database and finish one transaction
 */
public class BankBreakingThread extends Thread {
    Connection _connection;
    String _account;

    public BankBreakingThread(String account, String connectionURL) throws SQLException {
        System.out.println("Thread has been created");
        this._account = "'" + account + "'";
        this._connection = DriverManager.getConnection(connectionURL);
    }

    public void run() {
        System.out.println("Thread has been started");
        String readAccount = "SELECT kontostand FROM Konten WHERE id == " + this._account;
        Integer ks = 0;
        try (Statement stmt = this._connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(readAccount)) {
                while (rs.next()) {
                    ks = rs.getInt("kontostand");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ks += 1000;
        String updateAccountBalance = "UPDATE konten SET kontostand = " + ks + " WHERE id = " + this._account;

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            System.out.println("Whoops");
//        }

        try (Statement stmt = this._connection.createStatement()) {
            stmt.executeUpdate(updateAccountBalance);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}