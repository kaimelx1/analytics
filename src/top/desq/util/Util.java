package top.desq.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Util class.
 *
 * @author Aleksandr Vashchenko
 * @version 1.0
 */
public class Util {

    /**
     * Primary validation of input line.
     *
     * @param line
     * @return boolean
     */
    public static boolean validateLine(String line) {
        int length = line.split(" ").length;
        // add other validations here if need
        return !line.isEmpty() && ((line.startsWith("D ") && length == 5) || (line.startsWith("C ") && length == 6));
    }

    /**
     * Parse string to get {@link Date} object.
     *
     * @param str
     * @return {@link Date}
     */
    public static Date parseDate(String str) {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ROOT);
            return formatter.parse(str);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }

    }
}
