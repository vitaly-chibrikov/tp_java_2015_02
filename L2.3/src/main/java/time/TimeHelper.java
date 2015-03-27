package time;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("UnusedDeclaration")
public class TimeHelper {
    public static long getTimeInMs() {
        Date date = new Date();
        //return System.currentTimeMillis();
        return date.getTime();
    }

    public static int getPOSIX() {
        Date date = new Date();
        return (int) (date.getTime() / 1000);
    }

    public static String getUserDateFull(Locale locale) {
        Date date = new Date();
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
        return dateFormatter.format(date);
    }

    public static String getUserDateShort(Locale locale) {
        Date date = new Date();
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        return dateFormatter.format(date);
    }

    public static String getUserTimeFull(Locale locale) {
        Date date = new Date();
        DateFormat dateFormatter = DateFormat.getTimeInstance(DateFormat.FULL, locale);
        return dateFormatter.format(date);
    }

    public static void sleep(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

