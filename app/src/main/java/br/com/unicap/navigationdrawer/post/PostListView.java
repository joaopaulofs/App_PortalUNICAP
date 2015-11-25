package br.com.unicap.navigationdrawer.post;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.unicap.navigationdrawer.MainActivity;
import br.com.unicap.navigationdrawer.evento.AdapterListViewEvento;
import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 02/11/2015.
 */
public class PostListView extends Fragment {

    ListView list;
    private AdapterListViewPost adapterListView;
    private ArrayList<Post> itens = new ArrayList<Post>();

    private Post[] postagem = new Post[20];
    private JSONArray posts = null;
    private String json;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view_maior_espacamento, container, false);

        list = (ListView) view.findViewById(R.id.list);
        sendRequestPosts(0);

        //createListView();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityPost.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                intent.putExtra("OBJETO", adapterListView.getItem(position));
                startActivity(intent);
            }
        });

        list.setOnScrollListener(new AdapterListViewPost() {
            @Override
            public void loadMore(int page, int totalItemsCount) {
//                list = loader.loadData();
//                dataList.addAll(newData);
//                adapter.notifyDataSetChanged();
                sendRequestPosts(totalItemsCount);
            }

        });

        return view;
    }

    private void createListView() {

        int tamanho = getSize(postagem);

        if (postagem!=null) {
            for (int i = 0; i < tamanho; i++) {
                Post item = new Post(postagem[i].getPostId() != null ? postagem[i].getPostId() : "",
                        postagem[i].getPostTitulo()!= null ? postagem[i].getPostTitulo() : ""
                        , postagem[i].getPostDescricao()!= null ? postagem[i].getPostDescricao() : ""
                        , postagem[i].getPostAutorNome()!= null ? postagem[i].getPostAutorNome() : ""
                        , postagem[i].getPostAutorMatricula()!= null ?  postagem[i].getPostAutorMatricula() :""
                        , postagem[i].getPostData()!= null ? postagem[i].getPostData() : ""
                        ,"");
                itens.add(item);
            }
        }

        //Cria o adapter
        adapterListView = new AdapterListViewPost(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }

    public void setJson(String json) {
        this.json = json;
    }
    private void sendRequestPosts(int startNum){
        String  url = String.format("http://sm.c3.unicap.br/portalC3/api/posts?startNum=" + startNum);

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

        JsonPosts pj = new JsonPosts(json);
        //pj.JsonPosts();
        postagem= pj.JsonPosts();
        createListView();
    }


    public int getSize(Post[] postagem){
        int tamanho=0;
        for (int i=0;i<postagem.length;i++){
            if (postagem[i]==null)
                return i;
        }
        return tamanho;
    }

}
