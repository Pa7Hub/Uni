package Q4.TM.w1;

import java.io.IOException;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        DBConnectionEstablisher connector = new DBConnectionEstablisher();
        try {
            connector.connect();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
