package br.com.unicap.navigationdrawer.disciplina;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Disciplina;
import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.post.JsonPosts;

/**
 * Created by Joao on 07/11/2015.
 */
public class DisciplinaListView extends Fragment {

    ListView list;
    private AdapterListViewDisciplina adapterListView;
    private ArrayList<Disciplina> itens;
    private Disciplina[] disciplinas = new Disciplina[20];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        list = (ListView) view.findViewById(R.id.list);

        sendRequestDisciplinas();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityDisciplina.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                intent.putExtra("OBJETO", adapterListView.getItem(position));
                startActivity(intent);
            }
        });

        return view;
    }

    private void createListView()
    {
        itens = new ArrayList<Disciplina>();
        int tamanho = getSize(disciplinas);

        if (disciplinas!=null) {
            for (int i = 0; i < tamanho; i++) {
                Disciplina item = new Disciplina(disciplinas[i].getDisciplinaId() != null ? disciplinas[i].getDisciplinaId() : "",
                        disciplinas[i].getDisciplinaCodigo() != null ? disciplinas[i].getDisciplinaCodigo() : ""
                        , disciplinas[i].getDisciplinaNome() != null ? disciplinas[i].getDisciplinaNome() : ""
                        , disciplinas[i].getDisciplinaLinkPlanoAcademico() != null ? disciplinas[i].getDisciplinaLinkPlanoAcademico() : ""
                        , disciplinas[i].getDisciplinaCreditos() != null ? disciplinas[i].getDisciplinaCreditos() : ""
                        , disciplinas[i].getDisciplinaCargaHoraria() != null ? disciplinas[i].getDisciplinaCargaHoraria() : ""
                        , disciplinas[i].getDisciplinaArquivos() != null ? disciplinas[i].getDisciplinaArquivos() : ""
                        , disciplinas[i].getDisciplinaProfessorNome()!= null ? disciplinas[i].getDisciplinaProfessorNome() : ""
                        ,disciplinas[i].getDisciplinaProfessorMatricula()!= null ? disciplinas[i].getDisciplinaProfessorMatricula() : ""                );
                itens.add(item);
            }
        }
        //Cria o adapter
        adapterListView = new AdapterListViewDisciplina(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }
    private void sendRequestDisciplinas(){
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/disciplinas?startNum=0");

        StringRequest teste = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSONPosts(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(teste);
    }
    private void showJSONPosts(String json) {

        JsonDisciplinas pj = new JsonDisciplinas(json);

        disciplinas= pj.JsonDisciplinas();
        createListView();
    }


    public int getSize(Disciplina[] disciplinas){
        int tamanho=0;
        for (int i=0;i<disciplinas.length;i++){
            if (disciplinas[i]==null)
                return i;
        }
        return tamanho;
    }

}


