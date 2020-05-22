import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class monthlydetails {

    public static ArrayList<String> GetMonthDates(String input)
    {
        Calendar c = returncalendar(2020,Calendar.APRIL);
        ArrayList<String> daysOfMonth = new ArrayList<>();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        c.setTime(date);
        c.set(Calendar.MONTH,c.get(Calendar.MONTH));
        c.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < maxDay; i++)
        {
            c.set(Calendar.DAY_OF_MONTH, i + 1);
            daysOfMonth.add(df.format(c.getTime()));
        }

        return daysOfMonth;
    }

    public static Calendar returncalendar(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        return cal;
    }

}
