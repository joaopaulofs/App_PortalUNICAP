package br.com.unicap.navigationdrawer.disciplina;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Disciplina;

/**
 * Created by Joao on 02/11/2015.
 */
public class DetailsActivityDisciplina extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity_disciplina);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        long idSelected = getIntent().getLongExtra("ID", 0);
        long positionSelected = getIntent().getIntExtra("POSITION", 0);
        Disciplina item = (Disciplina) getIntent().getSerializableExtra("OBJETO");

        TextView nome = ((TextView) findViewById(R.id.nome));
        nome.setText(item.getDisciplinaNome());
//        ImageView imagem = ((ImageView) findViewById(R.id.imagem));
//        imagem.setImageResource(item.getUsuarioFoto());
        TextView codigo = ((TextView) findViewById(R.id.codigo));
        codigo.setText(item.getDisciplinaCodigo());
        TextView link = ((TextView) findViewById(R.id.link));
        link.setText(item.getDisciplinaLinkPlanoAcademico());
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
