package Q4.TM.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DBConnectionEstablisher {

    public void connect() throws SQLException, IOException {
        String url = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter database type: ");
        String s = br.readLine(); // doesn't care about wrong inputs as of right now
        if (s.equals("sqlite")) {
            System.out.println("Enter file name: ");
            try {
                url = this.urlBuilder(new SQLiteParameters(s, br.readLine() + ".db"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Enter database name: ");
            String dbname = br.readLine();
            System.out.println("Enter user: ");
            String user = br.readLine();
            System.out.println("Enter password: ");
            String password = br.readLine();
            try {
                url = this.urlBuilder(new MariaDBOrPostgreSQLParameters(s, dbname, user, password));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // the SQL commands
        final String sqlCreate;
        sqlCreate = "CREATE TABLE works (id numeric, greetings text)";
        final String sqlInsert;
        sqlInsert = "INSERT INTO works VALUES(1,'Hello FHDW')";
        final String sqlSelect;
        sqlSelect = "SELECT greetings from works";

        // create a database connection
        // ( alternatives : properties and user / password )
        try (Connection conn = DriverManager.getConnection(url)) {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sqlCreate);
                stmt.executeUpdate(sqlInsert);
                try (ResultSet rs = stmt.executeQuery(sqlSelect)) {
                    while (rs.next()) {
                        final String g = rs.getString("greetings");
                        System.out.println(g);
                    }
                }
            }
        }
    }

    /**
     * @param parameters specifies: {
     *                   type: String
     *                   filename: String
     *                   dbName: String
     *                   user: String
     *                   password: String
     *                   }
     * @return URL String specifying which DB the request will be sent to
     * Public for testing
     */
    public String urlBuilder(IDatabaseConnectionParameters parameters) throws Exception {
        String url = "jdbc:" + parameters.type + ":";
        if (parameters instanceof SQLiteParameters) {
            SQLiteParameters params = (SQLiteParameters) parameters;
            return url + params.filename;
        } else if (parameters instanceof MariaDBOrPostgreSQLParameters) {
            MariaDBOrPostgreSQLParameters params = (MariaDBOrPostgreSQLParameters) parameters;
            return url + "//localhost/" + params.dbName + "?user=" + params.user + "&password=" + params.password;
        } else {
            throw new Exception("Wrong Parameter Object may not be passed");
        }
    }
}
