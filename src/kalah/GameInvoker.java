package kalah;

import java.util.HashMap;
import java.util.Map;
import com.qualitascorpus.testsupport.IO;
import kalah.command.Command;

public class GameInvoker {

    private Game game;
    private IO io;
    private Map<String, Command> commandMap;

    public GameInvoker() {
        this.commandMap = new HashMap<>();
    }

    public void setCommand(String instruct, Command command) {
        commandMap.put(instruct, command);
    }

    public void executeCommand(String instruct) {
        commandMap.get(instruct).execute();
    }
}
