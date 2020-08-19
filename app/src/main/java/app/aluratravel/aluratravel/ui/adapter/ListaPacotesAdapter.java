package app.aluratravel.aluratravel.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.aluratravel.R;
import app.aluratravel.aluratravel.util.DiasUtil;
import app.aluratravel.aluratravel.util.MoedaUtil;
import app.aluratravel.aluratravel.model.Pacote;
import app.aluratravel.aluratravel.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {


    private final List<Pacote> pacotes;

    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent,false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);

        mostraImagem(viewCriada, pacote);

        mostraDias(viewCriada, pacote);

        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {

        TextView price = viewCriada.findViewById(R.id.item_pacote_price);
        price.setText(MoedaUtil.formataParaMoedaReal(pacote.getPrice()));

    }

    private void mostraDias(View viewCriada, Pacote pacote) {

        TextView textDias = viewCriada.findViewById(R.id.item_pacote_day);
        String diasEmTexto = DiasUtil.formatarDiasEmTexto(pacote.getDias());
        textDias.setText(diasEmTexto);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {

        ImageView image = viewCriada.findViewById(R.id.item_pacote_imagem_city);
        Drawable drawableImagemPacote = devolveDrawable(pacote);
        image.setImageDrawable(drawableImagemPacote);
    }

    private Drawable devolveDrawable(Pacote pacote) {

        return ResourceUtil.devolveDrawable(context, pacote.getImagem());
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getCity());
    }
}
