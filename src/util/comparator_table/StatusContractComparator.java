package util.comparator_table;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatusContractComparator implements Comparator<String> {

    private final Pattern daysLeftPattern = Pattern.compile("Còn (\\d+) ngày");
    private final Pattern cancelPattern = Pattern.compile("Hủy HĐ: (\\d{2}/\\d{2}/\\d{4})");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public StatusContractComparator() {
    }

    @Override
    public int compare(String status1, String status2) {
        // Kiểm tra nếu status1 và status2 là null
        if (status1 == null && status2 == null) {
            return 0;
        }
        if (status1 == null) {
            return -1; // status1 null, status2 không null
        }
        if (status2 == null) {
            return 1; // status2 null, status1 không null
        }

        // Kiểm tra nếu status1 và status2 là "Còn X ngày"
        Matcher matcher1 = daysLeftPattern.matcher(status1);
        Matcher matcher2 = daysLeftPattern.matcher(status2);
        if (matcher1.matches() && matcher2.matches()) {
            int daysLeft1 = Integer.parseInt(matcher1.group(1));
            int daysLeft2 = Integer.parseInt(matcher2.group(1));
            return Integer.compare(daysLeft1, daysLeft2);
        } else if (matcher1.matches()) {
            return -1; // status1 là "Còn X ngày", status2 không phải
        } else if (matcher2.matches()) {
            return 1; // status2 là "Còn X ngày", status1 không phải
        }

        // Kiểm tra nếu status1 là "Đã hết hạn"
        if (status1.equals("Đã hết hạn")) {
            if (status2.equals("Đã hết hạn")) {
                return 0; // cả hai đều là "Đã hết hạn"
            }
            return 1; // status1 là "Đã hết hạn", status2 không phải
        } else if (status2.equals("Đã hết hạn")) {
            return -1; // status2 là "Đã hết hạn", status1 không phải
        }

        // Kiểm tra nếu status1 và status2 là "Hủy HĐ: dd/MM/yyyy"
        Matcher cancelMatcher1 = cancelPattern.matcher(status1);
        Matcher cancelMatcher2 = cancelPattern.matcher(status2);
        if (cancelMatcher1.matches() && cancelMatcher2.matches()) {
            LocalDate date1 = LocalDate.parse(cancelMatcher1.group(1), dateFormatter);
            LocalDate date2 = LocalDate.parse(cancelMatcher2.group(1), dateFormatter);
            return date1.compareTo(date2);
        } else if (cancelMatcher1.matches()) {
            return -1; // status1 là "Hủy HĐ: dd/MM/yyyy", status2 không phải
        } else if (cancelMatcher2.matches()) {
            return 1; // status2 là "Hủy HĐ: dd/MM/yyyy", status1 không phải
        }

        return status1.compareTo(status2);
    }
}
