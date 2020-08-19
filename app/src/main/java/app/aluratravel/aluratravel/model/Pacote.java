package app.aluratravel.aluratravel.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pacote implements Serializable {

    private final String city;
    private final String imagem;
    private final int dias;
    private final BigDecimal price;

    public Pacote(String city, String imagem, int dias, BigDecimal price) {
        this.city = city;
        this.imagem = imagem;
        this.dias = dias;
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
