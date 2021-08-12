package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth(){
        //Create date object
        Date dateOfNow = new Date();

    //Create calendar object for GregorianCalendar
        Calendar calendar = new GregorianCalendar();

        //Set calendar date to current date
        calendar.setTime(dateOfNow);

        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(calendar.MONTH,1); //adding one month ahead with current month
         return sdf.format(calendar.getTime());
    }

}
