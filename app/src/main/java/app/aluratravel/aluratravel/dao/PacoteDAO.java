package app.aluratravel.aluratravel.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.aluratravel.aluratravel.model.Pacote;

public class PacoteDAO {

    public List<Pacote> list(){

        List<Pacote> pAcotes = new ArrayList<>(Arrays.asList(

                new Pacote("São Paulo", "sao_paulo_sp", 1, new BigDecimal(243.99)),
                new Pacote("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal(421.50)),
                new Pacote("Recife", "recife_pe", 4, new BigDecimal(724.20)),
                new Pacote("Rio de Janeiro", "rio_de_janeiro_rj", 6, new BigDecimal(532.55)),
                new Pacote("Salvador", "salvador_ba", 5, new BigDecimal(899.99)),
                new Pacote("Foz do Iguaçu", "foz_do_iguacu_pr", 5, new BigDecimal(289.90))));

        return pAcotes;
    }


}
