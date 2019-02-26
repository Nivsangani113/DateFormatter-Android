package com.dateformatter;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FormatConversation {


    /**
     * Convert String to String Date Format
     *
     * @param dateString
     * @param currentFormat  (gives the format of String in which format you pass the string
     *                       ex. strDateFormateConversion("02/12/2015","dd/MM/yyyy")
     * @param requiredFormat (In witch format you want string)
     * @return String
     * In Return retrive your require date format in string
     */
    public static String strDateFormateConversion(String dateString, String currentFormat, String requiredFormat) {
        String convertedDateStr = "";

        if (dateString != null && !dateString.isEmpty() && currentFormat != null && !currentFormat.isEmpty() && requiredFormat != null && !requiredFormat.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(currentFormat);
                Date convertedDate = dateFormat.parse(dateString);
                convertedDateStr = dateToStringConversion(convertedDate, requiredFormat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return convertedDateStr;
    }


    /**
     * Convert Date to String with desired format
     *
     * @param date
     * @param DateFormatString (In witch format you want string)
     * @return
     */
    public static String dateToStringConversion(Date date, String DateFormatString) {
        String dateString = "";
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatString);
            dateString = dateFormat.format(date);

            dateString = getDateInEnglish(dateString, DateFormatString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateString;
    }

    /**
     * Convert String to Date Object
     *
     * @param dateString
     * @param DateFormatString (gives the format of String in which format you pass the string
     *                         ex. strDateToDateConversion("02/12/2015","dd/MM/yyyy")
     * @return Date object
     * <p/>
     * Date object always gives standard Data Format
     */
    public static Date strDateToDateConversion(String dateString, String DateFormatString) {
        Date convertedDate = new Date();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatString);
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return convertedDate;
    }

    /**
     * Get Time Ago From Two Dates
     *
     * @param createdDte (gives the Created Date in Date format
     * @param currentDte (gives the Current Date in Date format
     * @return String
     * <p/>
     * String object always gives Year,Month,Day,Hours,Minutes,Seconds
     * ex. 1 year
     * ex. 2 years
     */
    public static String getTimeAgo(Date createdDte, Date currentDte) {

        if (createdDte != null) {
            long diff = currentDte.getTime() - createdDte.getTime();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            long months = days / 30;
            long years = months / 12;
            if (createdDte.before(currentDte)) {

                if (years > 0) {
                    return "" + years + ((years > 1) ? " years" : " year");

                } else if (months > 0) {
                    return "" + months + ((months > 1) ? " months" : " month");

                } else if (days > 0) {
                    return "" + days + ((days > 1) ? " days" : " day");

                } else if (hours > 0) {
                    return "" + hours + ((hours > 1) ? " hours" : " hour");

                } else if (minutes > 0) {
                    return "" + minutes + ((minutes > 1) ? " minutes" : " minute");

                } else if (seconds > 0) {
                    return "" + seconds + ((seconds > 1) ? " seconds" : " second");
                } else {
                    return "";
                }
            }
        }
        return "";
    }

    public enum RemainingType {
        DAYS,
        HOURS,
        MINUTES,
        SECONDS,
    }

    /**
     * Get difference between two date in days, hours, minutes and seconds
     *
     * @param startDate     - give start date
     * @param endDate       - give end date
     * @param remainingType - specify type(days,hours, minutes and seconds)to find difference between two dates.
     * @return
     */
    public static long getDateDifferenceInX(Date startDate, Date endDate, RemainingType remainingType) {

        long remaining = 0;
        long diffInMilliSec = startDate.getTime() - endDate.getTime();

        if (remainingType == RemainingType.SECONDS) {
            remaining = diffInMilliSec / DateUtils.SECOND_IN_MILLIS;
        } else if (remainingType == RemainingType.MINUTES) {
            remaining = diffInMilliSec / DateUtils.MINUTE_IN_MILLIS;
        } else if (remainingType == RemainingType.HOURS) {
            remaining = diffInMilliSec / DateUtils.HOUR_IN_MILLIS;
        } else if (remainingType == RemainingType.DAYS) {
            remaining = diffInMilliSec / DateUtils.DAY_IN_MILLIS;
        }

        return remaining;
    }

    /**
     * Get the Date before and After X Days
     *
     * @param days
     * @return
     */
    public static Date getDateBeforeAfterXDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -days);

        return calendar.getTime();
    }

    /**
     * Get String Date from given Timestamp
     *
     * @param timestamp        - provide timestamp for gettimg string date of given timestamp
     * @param DateFormatString - provide string date format for gettimg string date of given timestamp
     * @return
     */
    public static String timestampToStrDateConversion(long timestamp, String DateFormatString) {
        Date convertedDate = getDateFromTimestamp(timestamp);
        return dateToStringConversion(convertedDate, DateFormatString);
    }

    /**
     * Get Date from given Timestamp
     *
     * @param timestamp - provide timestamp for gettimg date of given timestamp
     * @return
     */

    public static Date getDateFromTimestamp(long timestamp) {
        if (timestamp > 0) {
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getDefault();
            calendar.setTimeZone(tz);
            calendar.setTimeInMillis(timestamp);

            return calendar.getTime();
        }
        return null;
    }

    /**
     * Get Timestamp from given Date
     *
     * @param date - provide date for getting timestamp of given date
     * @return
     */
    public static long getTimestampFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.getTimeInMillis();
    }

    /**
     * Get Duration from given seconds in HH:mm:ss format
     *
     * @param seconds - provide seconds for getting duration of given seconds
     * @return
     */
    public static String getDurationFromSeconds(int seconds) {

        if (seconds > 0) {
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            seconds = seconds % 60;

            return "" + twoDigitString(hours) + ":" + twoDigitString(minutes) + ":" + twoDigitString(seconds);
        }
        return "";
    }


    public static String getDateInEnglish(String inputDate, String dateFormat) {

        String finalDate = "";
        try {

            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date = sdf.parse(inputDate);
            SimpleDateFormat finalDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
            finalDate = finalDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finalDate;
    }

    public static String twoDigitString(int number) {

        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);
    }
}
