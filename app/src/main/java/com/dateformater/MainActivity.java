package com.dateformater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dateformatter.FormatConversation;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();

    String strDate = "26-2-2019";
    String strCreatedDate = "24-2-2018";
    String strCurrentDate = "26-2-2019";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     /*   *//**Convert String to String Date Format : strDateFormateConversion *//*
        Log.e(TAG, "onCreate: strDateFormateConversion : " + strDate + " ::-> " + FormatConversation.strDateFormateConversion(strDate, FormatConversation.dd_MM_yyyy, FormatConversation.yyyy_MM_dd_HH_mm_ss));

        *//**Convert Date to String with desired format : dateToStringConversion *//*
        Log.e(TAG, "onCreate: Convert Date to String with desired format : " + strDate + " ::-> "
                + FormatConversation.dateToStringConversion(FormatConversation.strDateToDateConversion(strDate, FormatConversation.dd_MM_yyyy),
                FormatConversation.dd_MM_yyyy));

        *//** Get Time Ago From Two Dates : getTimeAgo *//*
        Log.e(TAG, "onCreate: getTimeAgo : " + strCreatedDate + " ::-> "
                + FormatConversation.getTimeAgo(FormatConversation.strDateToDateConversion(strCreatedDate, FormatConversation.dd_MM_yyyy), FormatConversation.strDateToDateConversion(strCurrentDate, FormatConversation.dd_MM_yyyy)));

        *//** Get difference between two date in days, hours, minutes and seconds : getDateDifferenceInX *//*
        Log.e(TAG, "onCreate: getDateDifferenceInX : " + strCreatedDate + " ::-> "
                + FormatConversation.getDateDifferenceInX(FormatConversation.strDateToDateConversion(strCurrentDate, FormatConversation.dd_MM_yyyy), FormatConversation.strDateToDateConversion(strCreatedDate, FormatConversation.dd_MM_yyyy), FormatConversation.RemainingType.DAYS));

        *//** Get Duration from given seconds in HH:mm:ss format: getDurationFromSeconds *//*
        Log.e(TAG, "onCreate: getDurationFromSeconds : 12500 ::-> "
                + FormatConversation.getDurationFromSeconds(12500));*/


        //  Log.e(TAG, "onCreate: " + FormatConversation.getDateBeforeAfterXDays(2));
    }
}
