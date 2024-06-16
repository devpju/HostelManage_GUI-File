package util.comparator_table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class LocalDateComparator implements Comparator<String> {

    private DateTimeFormatter formatter;

    public LocalDateComparator() {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public int compare(String dateStr1, String dateStr2) {
        LocalDate date1 = LocalDate.parse(dateStr1, formatter);
        LocalDate date2 = LocalDate.parse(dateStr2, formatter);
        return date1.compareTo(date2);
    }
}
