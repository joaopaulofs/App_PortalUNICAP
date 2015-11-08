package br.com.unicap.navigationdrawer.evento;

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

import br.com.unicap.navigationdrawer.model.Evento;
import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.post.JsonPosts;

/**
 * Created by Joao on 13/09/2015.
 */
public class EventListView extends Fragment {

    ListView list;
    private AdapterListViewEvento adapterListView;
    private ArrayList<Evento> itens;
    private Evento[] eventos = new Evento[20];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view_maior_espacamento, container, false);

        list = (ListView) view.findViewById(R.id.list);

        sendRequestEventos();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityEvento.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                intent.putExtra("OBJETO", adapterListView.getItem(position));
                startActivity(intent);
            }
        });

        return view;
    }

    private void createListView() {
        itens = new ArrayList<Evento>();
        int tamanho = getSize(eventos);

        if (eventos!=null) {
            for (int i = 0; i < tamanho; i++) {
                Evento item = new Evento(eventos[i].getEventoId() != null ? eventos[i].getEventoId() : ""
                        , eventos[i].getEventoTitulo()!= null ? eventos[i].getEventoTitulo() : ""
                        , eventos[i].getEventoDescricao()!= null ? eventos[i].getEventoDescricao() : ""
                        , eventos[i].getEventoLocal()!= null ? eventos[i].getEventoLocal() : ""
                        , eventos[i].getEventoData()!= null ? eventos[i].getEventoData() : ""
                        , eventos[i].getEventoCriador()!= null ? eventos[i].getEventoCriador() : ""
                        , eventos[i].getEventoCriadorMatricula()!= null ?  eventos[i].getEventoCriadorMatricula() :""
                        , eventos[i].getEventoImagens()!= null ? eventos[i].getEventoImagens() : "");
                itens.add(item);
            }
        }

        //Cria o adapter
        adapterListView = new AdapterListViewEvento(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }
    private void sendRequestEventos(){
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/eventos?startNum=0");

        StringRequest teste = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSONEventos(response);

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
    private void showJSONEventos(String json) {

        JsonEventos pj = new JsonEventos(json);

        eventos= pj.JsonEventos();
        createListView();
    }


    public int getSize(Evento[] eventos){
        int tamanho=0;
        for (int i=0;i<eventos.length;i++){
            if (eventos[i]==null)
                return i;
        }
        return tamanho;
    }
}
