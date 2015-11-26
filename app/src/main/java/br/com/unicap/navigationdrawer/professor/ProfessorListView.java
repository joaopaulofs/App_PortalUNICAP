package br.com.unicap.navigationdrawer.professor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.model.Professor;
import br.com.unicap.navigationdrawer.post.JsonPosts;

/**
 * Created by Joao on 13/09/2015.
 */
public class ProfessorListView extends Fragment {

    ListView list;
    private AdapterListViewProfessor adapterListView;
    private ArrayList<Professor> itens;
    private Professor[] professores;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);

        list = (ListView) view.findViewById(R.id.list);

        sendRequestProfessores();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityProfessor.class);
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
        itens = new ArrayList<Professor>();
        int tamanho = getSize(professores);

        if (professores!=null) {
            for (int i = 0; i < tamanho; i++) {
                Professor item = new Professor(professores[i].getUsuarioMatricula() != null ? professores[i].getUsuarioMatricula() : ""
                        , professores[i].getUsuarioEmail()!= null ? professores[i].getUsuarioEmail() : ""
                        , professores[i].getUsuarioCargo()!= null ? professores[i].getUsuarioCargo() : ""
                        , professores[i].getUsuarioNome()!= null ? professores[i].getUsuarioNome() : "");
                itens.add(item);
            }
        }

        //Cria o adapter
        adapterListView = new AdapterListViewProfessor(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.GRAY);
    }
    private void sendRequestProfessores(){
<<<<<<< HEAD
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/usuarios?startNum=0&usuarioTipo=2");
=======
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/usuarios?startNum=0");
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
    professores= new Professor[2000];
        StringRequest teste = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSONProfessores(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

<<<<<<< HEAD
                        Toast.makeText(getActivity(),"Erro de Conexão./nServiço Não Disponível" , Toast.LENGTH_LONG).show();
=======
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());
        requestQueue.add(teste);
    }
    private void showJSONProfessores(String json) {

        JsonProfessores pj = new JsonProfessores(json);

        professores= pj.JsonProfessores();
        createListView();
    }


    public int getSize(Professor[] professores){
        int tamanho=0;
        for (int i=0;i<professores.length;i++){
            if (professores[i]==null)
                return i;
        }
        return tamanho;
    }

}


