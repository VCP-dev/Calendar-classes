import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class weekdetails {

    public static ArrayList<String> GetWeekdates(String input) {
        Calendar c = returncalendar(2020,Calendar.APRIL);
        ArrayList<String> Weekdays = new ArrayList<>();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.WEEK_OF_MONTH,c.get(Calendar.WEEK_OF_MONTH));
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i <7; i++) {
            Weekdays.add(df.format(c.getTime()));
            c.add(Calendar.DATE, 1);
        }
        return Weekdays;
    }

    public static Calendar returncalendar(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        return cal;
    }

}
