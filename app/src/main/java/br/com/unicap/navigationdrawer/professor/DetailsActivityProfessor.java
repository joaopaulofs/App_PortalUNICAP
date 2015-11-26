package br.com.unicap.navigationdrawer.professor;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
<<<<<<< HEAD
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
=======
import android.widget.LinearLayout;
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
<<<<<<< HEAD
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;
=======
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b

import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Professor;

/**
 * Created by Joao on 02/11/2015.
 */
public class DetailsActivityProfessor extends ActionBarActivity {
    Professor professores = new Professor();
<<<<<<< HEAD
    private ProgressBar spinner;
=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity_professor);
        spinner = ((ProgressBar) findViewById(R.id.progressBar));


<<<<<<< HEAD
spinner.setVisibility(View.VISIBLE);
=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Aqui você utiliza o ID do item(caso tenha) para pesquisar no banco de dados ou a position para pesquisar na list de origem
        // E então setar a View com os detalhes do item.

        long idSelected = getIntent().getLongExtra("ID", 0);
        long positionSelected = getIntent().getIntExtra("POSITION", 0);
        Professor item = (Professor) getIntent().getSerializableExtra("OBJETO");
        sendRequestBuscaProfessores(item.getUsuarioMatricula());


<<<<<<< HEAD
=======

>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b

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

    private void MostrarProfessor(){
<<<<<<< HEAD
        spinner.setVisibility(View.GONE);

        sendRequestImagemProfessores(professores.getUsuarioFotoUrl());
=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
        TextView nome = ((TextView) findViewById(R.id.professorBuscaNome));
        nome.setText(professores.getUsuarioNome());
        TextView cargo = ((TextView) findViewById(R.id.professorBuscaCargo));
        cargo.setText(professores.getUsuarioCargo());
        TextView email = ((TextView) findViewById(R.id.professorBuscaEmail));
        email.setText(professores.getUsuarioEmail());
        TextView lattesurl = ((TextView) findViewById(R.id.professorBuscaLattesUrl));
<<<<<<< HEAD
        lattesurl.setText(professores.getUsuarioLattesUrl());
        TextView areaInteresse = ((TextView) findViewById(R.id.professorAreaInteresse));
        areaInteresse.setText(professores.getUsuarioAreaInteresse());
        TextView paginaPessoalUrl = ((TextView) findViewById(R.id.professorPaginaPessoal));
        paginaPessoalUrl.setText(professores.getUsuarioPaginaPessoalUrl());
        TextView titulacao = ((TextView)findViewById(R.id.professorTitulacao));
        titulacao.setText(professores.getUsuarioTitulacao());
        ImageView imagemProfessor = (ImageView) findViewById(R.id.imagemProfessor);
        imagemProfessor.setImageResource(R.drawable.perfil_sem_foto);






    }
    private void mostrarImagem(Bitmap response){
        ImageView imagemProfessor = (ImageView) findViewById(R.id.imagemProfessor);
        imagemProfessor.setImageBitmap(response);
    }

=======
        lattesurl.setText(professores.getUsuarioLattesURL());
        TextView matricula = ((TextView) findViewById(R.id.professorBuscaMatricula));
        matricula.setText(professores.getUsuarioMatricula());


    }
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b

    private void sendRequestBuscaProfessores(String matricula){
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/usuarios/");
        url=url+matricula;

        StringRequest teste = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSONProfessorBusca(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(DetailsActivityProfessor.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(teste);
    }
    private void showJSONProfessorBusca(String json) {

        JsonProfessorBusca pj = new JsonProfessorBusca(json);

        professores= pj.JsonProfessorBusca();
        MostrarProfessor();

    }
<<<<<<< HEAD
private void  sendRequestImagemProfessores(String url){

    ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {

        @Override
        public void onResponse(Bitmap response) {
           mostrarImagem(response);

        }
    }, 0, 0, null, null);
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    requestQueue.add(ir);

}
=======

>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b

}
