package lt.warehousesystem.services;

import java.text.ParseException;
import java.util.Date;

public interface DateService {

    Date addToDate(int amountOfDays, Date date);

    Date getFormatedDate(String date) throws ParseException;
}
