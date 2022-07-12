package Q4.TM.w3;

import Q4.TM.w1.DBConnectionManager;

import java.sql.Connection;

public interface ITransaction {
    public void run(DBConnectionManager manager);
}
