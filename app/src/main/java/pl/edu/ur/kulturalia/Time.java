package pl.edu.ur.kulturalia;

import java.util.Calendar;
import java.util.Date;

public class Time {

    public static int SECONDS_IN_A_DAY = 24 * 60 * 60;
    public static String wyrazenie;

    public Time(){
        Calendar thatDay = Calendar.getInstance();
        thatDay.setTime(new Date(0));
        thatDay.set(Calendar.DAY_OF_MONTH, 19);
        thatDay.set(Calendar.MONTH, 4);
        thatDay.set(Calendar.YEAR, 2016);

        Calendar today = Calendar.getInstance();
        long diff = thatDay.getTimeInMillis() - today.getTimeInMillis();
        long diffSec = diff / 1000;

        long days = diffSec / SECONDS_IN_A_DAY;
        long secondsDay = diffSec % SECONDS_IN_A_DAY;
        long minutes = (secondsDay / 60) % 60;
        long hours = (secondsDay / 3600)-1;

        if (days <= 0 && minutes <= 0 && hours <= 0) {
            wyrazenie = "Dobrej zabawy!";
        } else {
            wyrazenie = "Do KultURaliów pozostało: " + days + " dni " + hours + " godz. " + minutes + " min.";
        }

    }
}