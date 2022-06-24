package Q4.TM.w1;

public class SQLiteParameters extends IDatabaseConnectionParameters {
    public String filename;

    public SQLiteParameters(String type, String file) {
        super(type);
        this.filename = file;
    }
}
