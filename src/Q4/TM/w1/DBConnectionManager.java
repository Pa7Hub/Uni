package Q4.TM.w1;

import Q4.TM.w1.Exceptions.TableAlreadyExistsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

/**
 * A DBConnectionManager helps with executing a handful of tasks on a database via a established Connection.
 * The Connection has to be established by hand via the establishConnectionFromUserInput method.
 * If not called upon creating the object, it will throw errors.
 * TODO make it so that instantiating a DBCManager Object will prompt you instantly, or expect an already existing Connection
 */
public class DBConnectionManager {
    private Connection _connection;

    /**
     * @param tableString should specify the name of the table and exact parameters as follows:
     *                    tableName(name type, name type, ...)
     */
    public void createTable(String tableString) throws TableAlreadyExistsException {
        String command = "CREATE TABLE " + tableString;
        try (Statement stmt = this.getConnection().createStatement()) {
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
     * @param tableName     specifies the name of the table
     * @param insertCommand should specify exact insert command as follows:
     *                      VALUES('valueOfType1', 'valueOfType2', ...)
     */
    public void insertIntoTable(String tableName, String insertCommand) {
        String command = "INSERT INTO " + tableName + " " + insertCommand;
        try (Statement stmt = this.getConnection().createStatement()) {
            try {
                stmt.executeUpdate(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO Yes yes, I know, this could all be one function. But as for now I couldn't be bothered.

    /**
     * @param tableName  specifies the name of the table
     * @param value      should specify exact select command as follows:
     *                   type || *
     * @param condition specifies SELECT condition as follows:
     *                  WHERE valueType == condition
     *                  example: WHERE id == 'A'
     *                  Empty string for no condition !!! will return everything from Table
     */
    public String selectStringFromTable(String tableName, String value, String condition) throws SQLException {
        String command = "SELECT " + value + " FROM " + tableName + " " + condition;
        try (Statement stmt = this.getConnection().createStatement()) {
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
     * @param tableName  specifies the name of the table
     * @param value      should specify exact select command as follows:
     *                   type || *
     * @param condition specifies SELECT condition as follows:
     *                  WHERE valueType == condition
     *                  example: WHERE id == 'A'
     *                  Empty string for no condition !!! will return everything from Table
     */
    public Integer selectIntegerFromTable(String tableName, String value, String condition) throws SQLException {
        String command = "SELECT " + value + " FROM " + tableName + " " + condition;
        try (Statement stmt = this.getConnection().createStatement()) {
            try (ResultSet rs = stmt.executeQuery(command)) {
                while (rs.next()) {
                    final Integer r = rs.getInt(value);
                    return r;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return 0;
    }

    /**
     * @param tableName  specifies the name of the table
     * @param value      should specify exact select command as follows:
     *                   type || *
     * @param condition specifies SELECT condition as follows:
     *                  WHERE valueType == condition
     *                  example: WHERE id == 'A'
     *                  Empty string for no condition !!! will return everything from Table
     */
    public Boolean selectBooleanFromTable(String tableName, String value, String condition) throws SQLException {
        String command = "SELECT " + value + " FROM " + tableName + " " + condition;
        try (Statement stmt = this.getConnection().createStatement()) {
            try (ResultSet rs = stmt.executeQuery(command)) {
                while (rs.next()) {
                    final Boolean r = rs.getBoolean(value);
                    return r;
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }

    /**
     *
     * @param tableName name of table in database
     * @param type column of the value that should be read
     * @param value should be of the type that is specified for the column you're trying to update
     * @param condition condition formulated as follows:
     *                  Empty String iff no condition
     *                  else: "WHERE valueType = value"
     *                  example: "WHERE id = 'A'"
     */
    public void updateValueInTable(String tableName, String type, Object value, String condition) throws SQLException {
        // TODO this will most likely break if value is anything other than String, Integer or Boolean
        String command = "UPDATE " + tableName + " SET " + type + " = " + value + " " + condition;
        try (Statement stmt = this.getConnection().createStatement()) {
            stmt.executeUpdate(command);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Will prompt the user for input to gather a URL and establish a connection with it.
     * Be careful with using this as of right now, it does not account for a lot of input mistakes
     * Will automatically save the Connection within the DBCManager!
     */
    public Connection establishConnectionFromUserInput() throws IOException, SQLException {
        String url = this.generateURLFromUserInput();
        Connection connection = this.establishConnectionFromURL(url);
        try {
            this.setConnection(connection);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            this._connection.close();
            System.out.println("Connection has been closed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    private Connection establishConnectionFromURL(String url) throws SQLException {
        Properties properties = new Properties();
        properties.put("connectionTimeout", "2000");
        return DriverManager.getConnection(url, properties);
    }

    public void setConnection(Connection connection) {
        this._connection = connection;
    }

    public Connection getConnection() {
        return this._connection;
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
