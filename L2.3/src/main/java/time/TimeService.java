package time;

import java.util.Timer;
import java.util.TimerTask;

public class TimeService {
    private static TimeService timeService;
    private Timer timer = null;

    public static TimeService instance() {
        if (timeService == null) {
            timeService = new TimeService();
        }
        return timeService;
    }

    public void start() {
        timer = new Timer();
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public boolean scheduleTask(TimerTask task, long timeMs) {
        if (timer != null) {
            timer.schedule(task, timeMs);
            return true;
        }
        return false;
    }

    private TimeService() {
    }

}
