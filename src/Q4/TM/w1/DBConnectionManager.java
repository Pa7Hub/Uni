package Q4.TM.w1;

import Q4.TM.w1.Exceptions.TableAlreadyExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DBConnectionManager {

    /**
     * @param connection  connection to the database
     * @param tableString should specify the name of the table and exact parameters as follows:
     *                    tableName(name type, name type, ...)
     */
    public void createTable(Connection connection, String tableString) throws TableAlreadyExistsException {
        String command = "CREATE TABLE " + tableString;
        try (Statement stmt = connection.createStatement()) {
            try {
                stmt.executeUpdate(command);
            } catch (SQLException e) {
                throw new TableAlreadyExistsException("The table you are trying to create already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param connection    connection to the database
     * @param tableName     specifies the name of the table
     * @param insertCommand should specify exact insert command as follows:
     *                      VALUES(valueOfType1, valueOfType2, ...)
     */
    public void insertIntoTable(Connection connection, String tableName, String insertCommand) {
        String command = "INSERT INTO " + tableName + " " + insertCommand;
        try (Statement stmt = connection.createStatement()) {
            try {
                stmt.executeUpdate(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO currently assumes you want to select a string, should be type based
     *
     * @param connection connection to the database
     * @param tableName  specifies the name of the table
     * @param value      should specify exact select command as follows:
     *                   type || *
     */
    public String selectFromTable(Connection connection, String tableName, String value) throws SQLException {
        String command = "SELECT " + value + " FROM " + tableName;
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(command)) {
                while (rs.next()) {
                    final String r = rs.getString(value);
                    return r;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return "This shouldn't be returned";
    }

    /**
     * Will prompt the user with a few inputs to generate a DB Connection URL
     */
    public String generateURLFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String url = "";
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
        return url;
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
