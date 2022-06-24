package Q4.TM.w1;


import java.sql.*;

public class Test {
    public static void main(String[] args) {
        try {
            demoSqlite();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void demoSqlite() throws SQLException {
        // create connection url
        final String filename = "tmExample.db";
        final String jdbc = "jdbc:sqlite";
        final String url = jdbc + ":" + filename;
//        final String url = jdbc + ":" + "//localhost/Practice?user=User&password=supersecure";

        // the SQL commands
        final String sqlCreate;
        sqlCreate = "CREATE TABLE tmX (id numeric, greetings text)";
        final String sqlInsert;
        sqlInsert = "INSERT INTO tmX VALUES(1,'Hello FHDW')";
        final String sqlSelect;
        sqlSelect = "SELECT greetings from tmX";

        // create a database connection
        // ( alternatives : properties and user / passwort )
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
}