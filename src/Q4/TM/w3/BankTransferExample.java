package Q4.TM.w3;

import Q4.TM.w1.DBConnectionManager;
import Q4.TM.w1.Exceptions.TableAlreadyExistsException;

import java.sql.SQLException;

public class BankTransferExample implements ITransaction {
    @Override
    public void run(DBConnectionManager manager) {
        try {
            manager.createTable("konten(id text, kontostand numeric)");
            manager.insertIntoTable( "konten", "VALUES('A', 1000)");
            manager.insertIntoTable( "konten", "VALUES('Z', 2000)");
        } catch (TableAlreadyExistsException e) {
            e.printStackTrace();
        }

        Integer kontoStandA = 0;
        Integer kontoStandZ = 0;

        try {
            kontoStandA = manager.selectIntegerFromTable("konten", "kontostand", "WHERE id == 'A'");
            kontoStandZ = manager.selectIntegerFromTable("konten", "kontostand", "WHERE id == 'Z'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        kontoStandA -= 100;
        kontoStandZ += 100;

        try {
            manager.updateValueInTable("konten", "kontostand", kontoStandA, "WHERE id = 'A'");
            manager.updateValueInTable("konten", "kontostand", kontoStandZ, "WHERE id = 'Z'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
