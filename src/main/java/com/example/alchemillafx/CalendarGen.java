package com.example.alchemillafx;


import java.util.Calendar;
import java.util.GregorianCalendar;

/*This class should be designed as a pseudo-functional class that takes a list of plants and a start date
* calendar object and outputs a formatted string that can be uploaded into the microsoft graph api
* This class is a proof of concept and not currently ready to work*/
public class CalendarGen {
    /**
     * Currently only a proof of concept
     * @param startDate root of calendar entries
     * @param timeDelta time between calendar entries
     * @param numEntries how many calendar entries we ultimately want
     * @return
     */
    public GregorianCalendar[] genCalendarEntries(
            GregorianCalendar startDate, Integer timeDelta, Integer numEntries){

        if (numEntries == 0){ //default number of entries is 30
            numEntries = 30;
        }

        GregorianCalendar temp, next;
        temp = (GregorianCalendar) startDate.clone();

        GregorianCalendar[] entries = new GregorianCalendar[numEntries];

        for (int i = 0; i<numEntries;i++){
            entries[0]=temp;
            next = (GregorianCalendar) temp.clone();
            next.add(Calendar.DAY_OF_MONTH, timeDelta);
            temp = (GregorianCalendar) next.clone();
        }

        return entries;
    }
}


