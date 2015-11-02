package br.com.unicap.navigationdrawer.post;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 18/10/2015.
 */
public class DetailsActivityPost extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        long idSelected = getIntent().getLongExtra("ID", 0);
        long positionSelected = getIntent().getIntExtra("POSITION", 0);
        ItemListViewPost item = (ItemListViewPost) getIntent().getSerializableExtra("OBJETO");

        TextView titulo = ((TextView) findViewById(R.id.tituloPost));
        titulo.setText(item.getTituloPost());
        ImageView image = ((ImageView) findViewById(R.id.imagePost));
        image.setImageResource(item.getImagePost());
        TextView info = ((TextView) findViewById(R.id.infoPost));
        info.setText(item.getInfoPost());
        TextView dados = ((TextView) findViewById(R.id.dadosPost));
        dados.setText(item.getDadosPost());
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
