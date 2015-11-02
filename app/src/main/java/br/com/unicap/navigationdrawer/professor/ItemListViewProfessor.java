package br.com.unicap.navigationdrawer.professor;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class ItemListViewProfessor implements Serializable {
    String nome;
    int imagem;
    String cargo;
    String email;

    public ItemListViewProfessor(){
    }

    public ItemListViewProfessor(String nome, int imagem, String cargo, String email){
        this.nome = nome;
        this.imagem = imagem;
        this.cargo = cargo;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}