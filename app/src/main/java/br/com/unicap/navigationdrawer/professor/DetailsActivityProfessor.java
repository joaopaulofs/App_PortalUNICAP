package br.com.unicap.navigationdrawer.professor;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Professor;

/**
 * Created by Joao on 02/11/2015.
 */
public class DetailsActivityProfessor extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity_professor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        long idSelected = getIntent().getLongExtra("ID", 0);
        long positionSelected = getIntent().getIntExtra("POSITION", 0);
        Professor item = (Professor) getIntent().getSerializableExtra("OBJETO");

        TextView nome = ((TextView) findViewById(R.id.nome));
        nome.setText(item.getUsuarioNome());
//        ImageView imagem = ((ImageView) findViewById(R.id.imagem));
//        imagem.setImageResource(item.getUsuarioFoto());
        TextView cargo = ((TextView) findViewById(R.id.cargo));
        cargo.setText(item.getUsuarioCargo());
        TextView email = ((TextView) findViewById(R.id.email));
        email.setText(item.getUsuarioEmail());
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
