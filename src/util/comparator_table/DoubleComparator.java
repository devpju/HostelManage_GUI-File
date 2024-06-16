
package util.comparator_table;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Comparator;
import java.util.Locale;

public class DoubleComparator implements Comparator<String> {

    private DecimalFormat decimalFormat;

    public DoubleComparator() {
        decimalFormat = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(symbols);
    }

    @Override
    public int compare(String s1, String s2) {
        try {
            Double d1 = decimalFormat.parse(s1).doubleValue();
            Double d2 = decimalFormat.parse(s2).doubleValue();
            return Double.compare(d1, d2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        }
    }
}
