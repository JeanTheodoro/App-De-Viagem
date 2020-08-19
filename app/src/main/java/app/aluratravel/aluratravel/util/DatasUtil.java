package app.aluratravel.aluratravel.util;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import app.aluratravel.aluratravel.model.Pacote;

public class DatasUtil {

    public static final String DATA = "dd/MM";

    public static String dataDaViagem(int dias){

        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatDataBrasil = new SimpleDateFormat(DATA);
        String dataFormatIda = formatDataBrasil.format(dataIda.getTime());
        String dataFormatVolta = formatDataBrasil.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatIda + " - "
                + dataFormatVolta + " de "
                + dataVolta.get(Calendar.YEAR);

        return dataFormatadaDaViagem;



    }
}
