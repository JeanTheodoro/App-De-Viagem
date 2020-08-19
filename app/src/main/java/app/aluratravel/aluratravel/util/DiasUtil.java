package app.aluratravel.aluratravel.util;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    public static String formatarDiasEmTexto(int quantidadesDias){

        return quantidadesDias > 1 ? quantidadesDias + PLURAL : quantidadesDias + SINGULAR;
    }
}
