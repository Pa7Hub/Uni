package Q4.TM.w1;

public class MariaDBOrPostgreSQLParameters extends IDatabaseConnectionParameters {
    public String dbName;
    public String user;
    public String password;

    public MariaDBOrPostgreSQLParameters(String type, String dbName, String user, String password) {
        super(type);
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }
}
