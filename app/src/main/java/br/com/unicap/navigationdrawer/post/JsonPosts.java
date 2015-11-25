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

        Post[] postagem;
        postagem = new Post[20];

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonresult = jsonObject.getJSONArray("result");
                int tamanho = jsonresult.length();

            for (int i=0;i<tamanho;i++){
                postagem[i]= new Post();

            }
                for(int i=0;i<tamanho;i++) {
                    JSONObject post = jsonresult.getJSONObject(i);
                    postagem[i].setPostId(post.getString("postId"));
                    postagem[i].setPostTitulo(post.getString("postTitulo"));
                    postagem[i].setPostDescricao(post.getString("postDescricao"));
                    postagem[i].setPostData(post.getString("postData"));
                    postagem[i].setPostAutorNome(post.getString("postAutorNome"));
                    postagem[i].setPostAutorMatricula(post.getString("postAutorMatricula"));
                    //postagem[i].setPostImage(jsonObject.getString("postImage"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        return postagem;
        }
}