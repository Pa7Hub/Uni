package Q4.TM.w2;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;


public class SimpleBankTransferTest {

    @Test
    void creatingAccountsWorks() throws SQLException {
        SimpleBankTransfer sbt = new SimpleBankTransfer();
//        sbt.createTable(); // commented out to not always create the table
        sbt.createAccounts();
    }

    @Test
    void transactionWorks() throws SQLException {
        SimpleBankTransfer sbt = new SimpleBankTransfer();
        sbt.createTable(); // commented out to not always create the table
        sbt.createAccounts();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        sbt.doTransaction();
    }

    @Test
    void lostUpdateHappens() throws SQLException {
        SimpleBankTransfer sbt = new SimpleBankTransfer();
//        sbt.createTable(); // commented out to not always create the table
//        sbt.createAccounts();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sbt.lostUpdateExample();
    }
}
