package lt.warehousesystem.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateServiceImpl implements DateService{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date addToDate(int amountOfDays, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,amountOfDays);
        return calendar.getTime();
    }

    public Date getFormatedDate(String date) throws ParseException {
            return simpleDateFormat.parse(date);
        }
    }