package br.com.unicap.navigationdrawer.model;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class Post implements Serializable {
    private String postId;
    private String postTitulo;
    private String postDescricao;
    private String postAutorNome;
    private String postAutorMatricula;
    private String postData;
    private String postImage;

    public Post(){
    }

    public Post(String postId, String postTitulo, String postDescricao, String postAutorNome, String postAutorMatricula,
                String postData, String postImage){
        this.postId = postId;
        this.postTitulo = postTitulo;
        this.postDescricao = postDescricao;
        this.postAutorNome = postAutorNome;
        this.postAutorMatricula = postAutorMatricula;
        this.postData = postData;
        this.postImage = postImage;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitulo() {
        return postTitulo;
    }

    public void setPostTitulo(String postTitulo) {
        this.postTitulo = postTitulo;
    }

    public String getPostDescricao() {
        return postDescricao;
    }

    public void setPostDescricao(String postDescricao) {
        this.postDescricao = postDescricao;
    }

    public String getPostAutorNome() {
        return postAutorNome;
    }

    public void setPostAutorNome(String postAutorNome) {
        this.postAutorNome = postAutorNome;
    }

    public String getPostAutorMatricula() {
        return postAutorMatricula;
    }

    public void setPostAutorMatricula(String postAutorMatricula) {
        this.postAutorMatricula = postAutorMatricula;
    }

    public String getPostData() {
        return postData;
    }

    public void setPostData(String postData) {
        this.postData = postData;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}