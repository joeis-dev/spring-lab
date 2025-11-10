package dev.joeis.spring.lab.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    // This example uses fixedRate(), which specifies the interval between method invocations,
    // measured from the start time of each invocation. Other options are cron() and fixedDelay(). 
    // For periodic tasks, exactly one of these three options must be specified, and optionally, 
    // initialDelay(). For a one-time task, it is sufficient to just specify an initialDelay()
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The current time is {}", dateFormat.format(new Date()));
    }
}