package br.com.rosana.testebrq.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static String formatDate(String dateStringISO) {

        SimpleDateFormat formatISO = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        try {
            Date date = formatISO.parse(dateStringISO);
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
