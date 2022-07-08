package Q4.TM.w1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBConnectorTest {

    @Test
    void urlBuilderBuildsSQLiteCorrectly() {
        DBConnectionManager connector = new DBConnectionManager();
        SQLiteParameters p = new SQLiteParameters("sqlite", "filename");
        String expected = "jdbc:sqlite:filename";
        String result = "";
        try {
            result = connector.urlBuilder(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected, result);
    }

    @Test
    void urlBuilderBuildsMariaDBCorrectly() {
        DBConnectionManager connector = new DBConnectionManager();
        MariaDBOrPostgreSQLParameters p = new MariaDBOrPostgreSQLParameters("mariadb", "dbname1", "user1", "password1");
        String expected = "jdbc:mariadb://localhost/dbname1?user=user1&password=password1";
        String result = "";
        try {
            result = connector.urlBuilder(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected, result);
    }

    @Test
    void urlBuilderBuildsPostgresqlCorrectly() {
        DBConnectionManager connector = new DBConnectionManager();
        MariaDBOrPostgreSQLParameters p = new MariaDBOrPostgreSQLParameters("postgresql", "dbname2", "user2", "password2");
        String expected = "jdbc:postgresql://localhost/dbname2?user=user2&password=password2";
        String result = "";
        try {
            result = connector.urlBuilder(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected, result);
    }
}
