package app.aluratravel.aluratravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import app.aluratravel.R;
import app.aluratravel.aluratravel.model.Pacote;
import app.aluratravel.aluratravel.util.DatasUtil;
import app.aluratravel.aluratravel.util.MoedaUtil;
import app.aluratravel.aluratravel.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String RESUMO_DA_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(RESUMO_DA_COMPRA);

        Intent intent = getIntent();

        if (intent.hasExtra("pacote")) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostrarImagem(pacote);

            mostrasCidade(pacote);

            mostrarDataViagem(pacote);

            mostraPreco(pacote);
        }


    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagemLocal = findViewById(R.id.resumo_pagamento_pacote_imagem_local);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagemLocal.setImageDrawable(drawable);
    }

    private void mostrasCidade(Pacote pacote) {
        TextView textCidade = findViewById(R.id.resumo_pagamento_pacote_cidade);
        textCidade.setText(pacote.getCity());
    }

    private void mostrarDataViagem(Pacote pacote) {
        TextView textDatViagem = findViewById(R.id.resumo_pagamento_pacote_data_viagem);
        textDatViagem.setText(DatasUtil.dataDaViagem(pacote.getDias()));

    }

    private void mostraPreco(Pacote pacote) {
        TextView textValorPassagem = findViewById(R.id.resumo_pagamento_pacote_valor_da_passagem);
        textValorPassagem.setText(MoedaUtil.formataParaMoedaReal(pacote.getPrice()));
    }
}
