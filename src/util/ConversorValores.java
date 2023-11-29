package util;

import java.text.DecimalFormat;

public class ConversorValores {

    private static final String PATTERN = "###,###,##0.00";

    public static String converte(Object valor) {
        DecimalFormat decimalFormat = new DecimalFormat(PATTERN);
        return decimalFormat.format(valor);
    }
}
