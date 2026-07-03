import java.time.LocalDateTime;
import java.util.ArrayList;

public class AuditLogger {

    private static ArrayList<String> logs = new ArrayList<>();

    public static void log(String message, String level) {

        String logEntry = LocalDateTime.now()
                + " [" + level + "] "
                + message;

        logs.add(logEntry);
    }

    public static void displayLogs() {

        System.out.println("\n===== AUDIT LOGS =====");
        System.out.println();

        if (logs.isEmpty()) {
            System.out.println("No logs available.");
            return;
        }

        for (String log : logs) {
            System.out.println(log);
        }
    }
}
