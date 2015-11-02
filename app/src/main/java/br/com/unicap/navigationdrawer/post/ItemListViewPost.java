package br.com.unicap.navigationdrawer.post;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class ItemListViewPost implements Serializable {
    String tituloPost;
    int imagePost;
    String infoPost;
    String dadosPost;

    public ItemListViewPost(){
    }

    public ItemListViewPost(String tituloPost, int imagePost, String infoPost, String dadosPost){
        this.tituloPost = tituloPost;
        this.imagePost = imagePost;
        this.infoPost = infoPost;
        this.dadosPost = dadosPost;
    }

    public String getTituloPost() {
        return tituloPost;
    }

    public void setTituloPost(String tituloPost) {
        this.tituloPost = tituloPost;
    }

    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePost) {
        this.imagePost = imagePost;
    }

    public String getInfoPost(){
        return infoPost;
    }

    public void setInfoPost(String infoPost) {
        this.infoPost = infoPost;
    }

    public String getDadosPost() {
        return dadosPost;
    }

    public void setDadosPost(String dadosPost) {
        this.dadosPost = dadosPost;
    }
}