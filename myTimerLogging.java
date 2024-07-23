package org.example; // Replace with your package name

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLogging {
    // Create loggers for different levels
    private static final Logger debugLogger = LogManager.getLogger("myTimerLoggingDebug");
    private static final Logger infoLogger = LogManager.getLogger("myTimerLoggingInfo");
    private static final Logger errorLogger = LogManager.getLogger("myTimerLoggingError");

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Timer task for Debug logs every second
        TimerTask debugTask = new TimerTask() {
            @Override
            public void run() {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                debugLogger.debug("Debug log at: {}", timestamp);
            }
        };

        // Timer task for Info logs every minute
        TimerTask infoTask = new TimerTask() {
            @Override
            public void run() {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                infoLogger.info("Info log at: {}", timestamp);
            }
        };

        // Timer task for Error logs every hour
        TimerTask errorTask = new TimerTask() {
            @Override
            public void run() {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                errorLogger.error("Error log at: {}", timestamp);
            }
        };

        // Schedule tasks
        timer.scheduleAtFixedRate(debugTask, 0, 1000); // Run every second
        timer.scheduleAtFixedRate(infoTask, 0, 60000); // Run every minute
        timer.scheduleAtFixedRate(errorTask, 0, 3600000); // Run every hour
    }
}
