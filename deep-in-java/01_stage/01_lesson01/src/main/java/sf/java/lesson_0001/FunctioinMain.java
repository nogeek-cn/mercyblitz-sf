package sf.java.lesson_0001;

import java.util.logging.Logger;

public class FunctioinMain {
    private static final Logger LOGGER = Logger.getLogger("aaa");
    public static void main(String[] args) {
        try {
            execute();
        } catch (Throwable e) {
            LOGGER.warning(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void execute() throws Throwable{
    }
}
