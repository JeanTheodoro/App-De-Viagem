package app.aluratravel.aluratravel.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.List;

import app.aluratravel.R;
import app.aluratravel.aluratravel.dao.PacoteDAO;
import app.aluratravel.aluratravel.model.Pacote;
import app.aluratravel.aluratravel.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        ListView listaDePacote;
        configuraLista();


    }

    private void configuraLista() {
        ListView listaDePacote = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().list();
        listaDePacote.setAdapter(new ListaPacotesAdapter(pacotes, this));

        listaDePacote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                Pacote pacoteClicado = pacotes.get(position);
                intent.putExtra("pacote", pacoteClicado);
                startActivity(intent);

            }
        });
    }
}
