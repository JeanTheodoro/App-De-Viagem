package app.aluratravel.aluratravel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LANGUAGE = "pt";
    public static final String COUNTRY = "br";

    public static String formataParaMoedaReal (BigDecimal valor){

        NumberFormat real = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE, COUNTRY));
        return real.format(valor);

    }

}
