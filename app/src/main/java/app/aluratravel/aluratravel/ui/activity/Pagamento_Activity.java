package app.aluratravel.aluratravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import app.aluratravel.R;
import app.aluratravel.aluratravel.model.Pacote;
import app.aluratravel.aluratravel.util.MoedaUtil;

public class Pagamento_Activity extends AppCompatActivity{

    public static final String PAGAMENTO = "Pagamento";
    public static final String CHAVE_PACOTE = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_);

        setTitle(PAGAMENTO);

        final Intent intent = getIntent();

        if (intent.hasExtra("pacote")) {

            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostrarPreco(pacote);

            Button bntFinalizarCompra = findViewById(R.id.pagamento_button_finalizar_compra);
            bntFinalizarCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openResumoCompraActivity(pacote);

                }
            });
        }


    }

    private void openResumoCompraActivity(Pacote pacote) {

        
        Intent intent = new Intent(Pagamento_Activity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostrarPreco(Pacote pacote) {

        TextView preco = findViewById(R.id.pagamento_do_pacote);
        preco.setText(MoedaUtil.formataParaMoedaReal(pacote.getPrice()));
    }

}
