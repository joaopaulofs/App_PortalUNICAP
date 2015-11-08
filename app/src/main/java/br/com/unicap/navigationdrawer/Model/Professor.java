package br.com.unicap.navigationdrawer.model;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class Professor implements Serializable {
    private String usuarioNome;
    private String usuarioCargo;
    private String usuarioEmail;
    private String usuarioLattesURL;
    private String usuarioTelefone;
    private String usuarioAreaInteresse;
    private String usuarioPaginaPessoalURL;
    private String usuarioFoto;
    private String usuarioTitulacao;
    private String usuarioMatricula;

    public Professor(){
    }

    public Professor(String usuarioMatricula,String usuarioEmail,String usuarioCargo,String usuarioNome ){
        this.usuarioNome = usuarioNome;
        this.usuarioCargo = usuarioCargo;
        this.usuarioEmail = usuarioEmail;
        this.usuarioMatricula = usuarioMatricula;
    }
    public Professor(String usuarioNome, String usuarioCargo, String usuarioEmail, String usuarioLattesURL, String usuarioTelefone, String usuarioAreaInteresse, String usuarioPaginaPessoalURL, String usuarioFoto, String usuarioTitulacao, String usuarioMatricula) {
        this.usuarioNome = usuarioNome;
        this.usuarioCargo = usuarioCargo;
        this.usuarioEmail = usuarioEmail;
        this.usuarioLattesURL = usuarioLattesURL;
        this.usuarioTelefone = usuarioTelefone;
        this.usuarioAreaInteresse = usuarioAreaInteresse;
        this.usuarioPaginaPessoalURL = usuarioPaginaPessoalURL;
        this.usuarioFoto = usuarioFoto;
        this.usuarioTitulacao = usuarioTitulacao;
        this.usuarioMatricula = usuarioMatricula;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioCargo() {
        return usuarioCargo;
    }

    public void setUsuarioCargo(String usuarioCargo) {
        this.usuarioCargo = usuarioCargo;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioLattesURL() {
        return usuarioLattesURL;
    }

    public void setUsuarioLattesURL(String usuarioLattesURL) {
        this.usuarioLattesURL = usuarioLattesURL;
    }

    public String getUsuarioTelefone() {
        return usuarioTelefone;
    }

    public void setUsuarioTelefone(String usuarioTelefone) {
        this.usuarioTelefone = usuarioTelefone;
    }

    public String getUsuarioAreaInteresse() {
        return usuarioAreaInteresse;
    }

    public void setUsuarioAreaInteresse(String usuarioAreaInteresse) {
        this.usuarioAreaInteresse = usuarioAreaInteresse;
    }

    public String getUsuarioPaginaPessoalURL() {
        return usuarioPaginaPessoalURL;
    }

    public void setUsuarioPaginaPessoalURL(String usuarioPaginaPessoalURL) {
        this.usuarioPaginaPessoalURL = usuarioPaginaPessoalURL;
    }

    public String getUsuarioFoto() {
        return usuarioFoto;
    }

    public void setUsuarioFoto(String usuarioFoto) {
        this.usuarioFoto = usuarioFoto;
    }

    public String getUsuarioTitulacao() {
        return usuarioTitulacao;
    }

    public void setUsuarioTitulacao(String usuarioTitulacao) {
        this.usuarioTitulacao = usuarioTitulacao;
    }

    public String getUsuarioMatricula() {
        return usuarioMatricula;
    }

    public void setUsuarioMatricula(String usuarioMatricula) {
        this.usuarioMatricula = usuarioMatricula;
    }
}