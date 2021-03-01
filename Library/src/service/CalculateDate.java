package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDate {
	
	
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
    public static String calculate(String deadline, int delayDays) {
    	Calendar calendar = Calendar.getInstance();
    	Date date;
		try {
			date = format.parse(deadline);
	    	calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        calendar.add(calendar.DATE, delayDays); 
        deadline = format.format(calendar.getTime());
        return deadline;
	}
}