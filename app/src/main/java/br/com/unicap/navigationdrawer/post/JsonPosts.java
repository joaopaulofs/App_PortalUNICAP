package br.com.unicap.navigationdrawer.post;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.unicap.navigationdrawer.model.Post;

/**
 * Created by Derick on 07/11/2015.
 */
public class JsonPosts {



    private String json;

    public JsonPosts(String json){
        this.json = json;
    }

    public Post[] JsonPosts(){
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;
        Post[] postagem;
        postagem = new Post[20];

        try {
                jsonArray = new JSONArray(json);
                int tamanho = jsonArray.length();

            for (int i=0;i<tamanho;i++){
                postagem[i]= new Post();

            }
                for(int i=0;i<tamanho;i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    postagem[i].setPostId(jsonObject.getString("postId"));
                    postagem[i].setPostTitulo(jsonObject.getString("postTitulo"));
                    postagem[i].setPostDescricao(jsonObject.getString("postDescricao"));
                    postagem[i].setPostData(jsonObject.getString("postData"));
                    postagem[i].setPostAutorNome(jsonObject.getString("postAutorNome"));
                    postagem[i].setPostAutorMatricula(jsonObject.getString("postAutorMatricula"));
                    //postagem[i].setPostImage(jsonObject.getString("postImage"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return postagem;
        }
}