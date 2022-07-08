package Q4.TM.w2;

import java.sql.*;

public class SimpleBankTransfer {
    private final String _url = "jdbc:sqlite:bank.db";
    Connection _connection;


    public SimpleBankTransfer() throws SQLException {
        // will initialize the connection, but not the accounts and their values
        this._connection = DriverManager.getConnection(this._url);
    }

    // public for testing. Do not call again after already called once
    public void createTable() throws SQLException {
        String createTable = "CREATE TABLE Konten (id text, kontostand numeric)";

        try (Statement stmt = this._connection.createStatement()) {
            stmt.executeUpdate(createTable);

        }
    }

    public void createAccounts() throws SQLException {
        String sqlInsertAccount1 = "INSERT INTO Konten VALUES('A', 1000)";
        String sqlInsertAccount2 = "INSERT INTO Konten VALUES('Z', 2000)";
        try (Statement stmt = this._connection.createStatement()) {
            stmt.executeUpdate(sqlInsertAccount1);
            stmt.executeUpdate(sqlInsertAccount2);

        }
    }

    public void doTransaction() throws SQLException {
        String readAccount1 = "SELECT kontostand FROM Konten WHERE id == 'A'";
        String readAccount2 = "SELECT kontostand FROM Konten WHERE id == 'Z'";

        Integer ksA = 0;
        Integer ksZ = 0;
        try (Statement stmt = this._connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(readAccount1)) {
                while (rs.next()) {
                    ksA = rs.getInt("kontostand");
                }
            }
            try (ResultSet rs = stmt.executeQuery(readAccount2)) {
                while (rs.next()) {
                    ksZ = rs.getInt("kontostand");
                }
            }
        }
        ksA -= 100;
        String sqlUpdateAccount1 = "UPDATE konten SET kontostand = " + ksA + " WHERE id = 'A'";
        ksZ += 100;
        String sqlUpdateAccount2 = "UPDATE konten SET kontostand = " + ksZ + " WHERE id = 'Z'";

        try (Statement stmt = this._connection.createStatement()) {
            stmt.executeUpdate(sqlUpdateAccount1);
            stmt.executeUpdate(sqlUpdateAccount2);
        }

    }

    /**
     * This will produce a lost update, as it reads the account balance on both threads and then updates it by 1000 individually
     * When run, you will see that it only adds 1000 instead of 2000
     */
    public void lostUpdateExample() throws SQLException {
        BankBreakingThread thread1 = new BankBreakingThread("A", this._url);
        BankBreakingThread thread2 = new BankBreakingThread("A", this._url);

        thread1.start();
        thread2.start();
    }


}
