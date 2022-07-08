package Q4.TM.w3;

import java.sql.Connection;

public interface ITransaction {
    public void run(Connection connection);
}
