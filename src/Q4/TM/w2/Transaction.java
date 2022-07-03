package Q4.TM.w2;

import java.util.List;

public class Transaction {
    List<String> sqlCommands;

    public void addCommand(String command) {
        sqlCommands.add(command);
    }

    public void removeLastCommand() {
        sqlCommands.remove(sqlCommands.size()-1);
    }
}
