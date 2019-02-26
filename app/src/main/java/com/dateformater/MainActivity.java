package com.dateformater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dateformatter.FormatConversation;

import java.sql.Timestamp;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();

    String strDate = "26-2-2019";
    String strCreatedDate = "24-2-2018";
    String strCurrentDate = "26-2-2019";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**Convert String to String Date Format : strDateFormateConversion */
        Log.e(TAG, "onCreate: strDateFormateConversion : " + strDate + " ::-> " +
                FormatConversation.strDateFormateConversion(strDate, "dd-MM-yyyy", "yyyy-MMM-dd HH:mm:ss"));



        /**Convert Date to String with desired format : dateToStringConversion*/
        Log.e(TAG, "onCreate: Convert Date to String with desired format : " + strDate + " ::-> "
                + FormatConversation.dateToStringConversion(FormatConversation.strDateToDateConversion(strDate, "dd-MM-yyyy"),
                "dd-MM-yyyy"));



        /** Get Time Ago From Two Dates : getTimeAgo */
        Log.e(TAG, "onCreate: getTimeAgo : " + strCreatedDate + " ::-> "
                + FormatConversation.getTimeAgo(FormatConversation.strDateToDateConversion(strCreatedDate, "dd-MM-yyyy"),
                FormatConversation.strDateToDateConversion(strCurrentDate,"dd-MM-yyyy")));



        /** Get the Date before and After X Days : getDateBeforeAfterXDays */
        Log.e(TAG, "onCreate: getDateBeforeAfterXDays : " + strDate + " ::-> "
                + FormatConversation.dateToStringConversion(FormatConversation.getDateBeforeAfterXDays(3),"dd-MM-yyyy"));

        /** Get difference between two date in days, hours, minutes and seconds : getDateDifferenceInX */
        Log.e(TAG, "onCreate: getDateDifferenceInX : " + strCreatedDate + " ::-> "
                + FormatConversation.getDateDifferenceInX(FormatConversation.strDateToDateConversion(strCurrentDate, "dd-MM-yyyy")
                , FormatConversation.strDateToDateConversion(strCreatedDate, "DD-MM-yyyy"), FormatConversation.RemainingType.DAYS));

        /** Get Date from given Timestamp : getDateFromTimestamp */
        Log.e(TAG, "onCreate: getDateFromTimestamp : " + strDate + " ::-> "
                + FormatConversation.dateToStringConversion(FormatConversation.getDateFromTimestamp(new Date().getTime()),"dd-MM-yyyy HH:mm:ss"));

        /** Get String Date from given Timestamp : timestampToStrDateConversion */
        Log.e(TAG, "onCreate: timestampToStrDateConversion : " + strDate + " ::-> "
                + FormatConversation.timestampToStrDateConversion(FormatConversation.getTimestampFromDate(new Date()), "dd MM yyyy HH:mm:ss"));


        /** Get Duration from given seconds in HH:mm:ss format: getDurationFromSeconds */
        String[] duration = new String[]{"0", "0", "0"};
        duration = FormatConversation.getDurationFromSeconds(12500);
        Log.e(TAG, "onCreate: getDurationFromSeconds : 12500 ::-> "
                + "Hours : " + duration[0]
                + " Minutes : " + duration[1]
                + " Seconds : " + duration[2]);

    }
}
