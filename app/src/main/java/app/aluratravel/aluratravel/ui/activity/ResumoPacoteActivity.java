package app.aluratravel.aluratravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.math.BigDecimal;

import app.aluratravel.R;
import app.aluratravel.aluratravel.model.Pacote;
import app.aluratravel.aluratravel.util.DatasUtil;
import app.aluratravel.aluratravel.util.DiasUtil;
import app.aluratravel.aluratravel.util.MoedaUtil;
import app.aluratravel.aluratravel.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity{

    public static final String TITLE_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLE_APPBAR);

        Intent intent = getIntent();

        if(intent.hasExtra("pacote")){

            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostrarLocal(pacote);

            mostrarImagem(pacote);

            mostrarDias(pacote);

            mostrarPreco(pacote);

            mostraDataViagem(pacote);

            Button buttonPay = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
            buttonPay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openPagamentoActivity(pacote);

                }
            });

        }



    }

    private void openPagamentoActivity(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, Pagamento_Activity.class);
        intent.putExtra("pacote", pacote);
        startActivity(intent);

    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getCity());
    }

    private void mostrarImagem(Pacote pacote){
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostrarDias(Pacote pacoteSaoPaulo) {
        TextView dias = findViewById(R.id.resumo_pacote_dia);
        String diasEmtexto = DiasUtil.formatarDiasEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasEmtexto);
    }


    private void mostrarPreco(Pacote pacoteSaoPaulo) {

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaMoedaReal(pacoteSaoPaulo.getPrice());
        preco.setText(moedaBrasileira);
    }

    private void mostraDataViagem(Pacote pacote) {
        TextView dataViagem = findViewById(R.id.resumo_pacote_data);
        dataViagem.setText(DatasUtil.dataDaViagem(pacote.getDias()));
    }


}
