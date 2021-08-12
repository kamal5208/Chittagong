package practice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LearnDate {

    public void formatDate(){
        LocalDateTime currentTime=LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dtf.format(currentTime));

        Date date = Calendar.getInstance().getTime();
        System.out.println(date);

}
}
