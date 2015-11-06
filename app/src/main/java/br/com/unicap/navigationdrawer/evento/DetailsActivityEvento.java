package br.com.unicap.navigationdrawer.evento;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.unicap.navigationdrawer.model.Evento;
import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 18/10/2015.
 */
public class DetailsActivityEvento extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity_evento);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        long idSelected = getIntent().getLongExtra("ID", 0);
        long positionSelected = getIntent().getIntExtra("POSITION", 0);
        Evento item = (Evento) getIntent().getSerializableExtra("OBJETO");

        TextView titulo = ((TextView) findViewById(R.id.tituloEvento));
        titulo.setText(item.getEventoTitulo());
//        ImageView image = ((ImageView) findViewById(R.id.imageEvento));
//        image.setImageResource(item.getEventoImagens());
        TextView info = ((TextView) findViewById(R.id.infoEvento));
        info.setText(item.getEventoDescricao());
        TextView dados = ((TextView) findViewById(R.id.dadosEvento));
        dados.setText(item.getEventoCriador() + " / " + item.getEventoData());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Responsável pela seta voltar do Toolbar
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
