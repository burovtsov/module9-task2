import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionLogger {

    public static void logIt(Exception e) {

        Logger LOG = LogManager.getLogger(Main.class);

        StringWriter stackTrace = new StringWriter();
        e.printStackTrace(new PrintWriter(stackTrace));
        LOG.error(e.toString() + "\nSTACK TRACE:\n" + stackTrace.toString());
        System.out.println("Произошла ошибка. Подробности в logs/exceptions.log");
    }
}
