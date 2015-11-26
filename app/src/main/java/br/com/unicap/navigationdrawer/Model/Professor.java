package br.com.unicap.navigationdrawer.model;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class Professor implements Serializable {
    private String usuarioMatricula;
    private String usuarioTitulacao;
    private String usuarioFotoUrl;
    private String usuarioPaginaPessoalUrl;
    private String usuarioAreaInteresse;
    private String usuarioTelefone;
    private String usuarioLattesUrl;
    private String usuarioEmail;
    private String usuarioCargo;
    private String usuarioNome;



    public Professor(){
    }

    public Professor(String usuarioMatricula,String usuarioEmail,String usuarioCargo,String usuarioNome ){
        this.usuarioNome = usuarioNome;
        this.usuarioCargo = usuarioCargo;
        this.usuarioEmail = usuarioEmail;
        this.usuarioMatricula = usuarioMatricula;
    }
<<<<<<< HEAD
    public Professor(String usuarioNome, String usuarioCargo, String usuarioEmail, String usuarioLattesURL, String usuarioTelefone, String usuarioAreaInteresse, String usuarioPaginaPessoalURL, String usuarioFotoUrl, String usuarioTitulacao, String usuarioMatricula) {
=======
    public Professor(String usuarioNome, String usuarioCargo, String usuarioEmail, String usuarioLattesURL, String usuarioTelefone, String usuarioAreaInteresse, String usuarioPaginaPessoalURL, String usuarioFoto, String usuarioTitulacao, String usuarioMatricula) {
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
        this.usuarioNome = usuarioNome;
        this.usuarioCargo = usuarioCargo;
        this.usuarioEmail = usuarioEmail;
        this.usuarioLattesUrl = usuarioLattesUrl;
        this.usuarioTelefone = usuarioTelefone;
        this.usuarioAreaInteresse = usuarioAreaInteresse;
        this.usuarioPaginaPessoalUrl = usuarioPaginaPessoalUrl;
        this.usuarioFotoUrl = usuarioFotoUrl;
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

    public String getUsuarioLattesUrl() {
        return usuarioLattesUrl;
    }

    public void setUsuarioLattesUrl(String usuarioLattesUrl) {
        this.usuarioLattesUrl = usuarioLattesUrl;
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

    public String getUsuarioPaginaPessoalUrl() {
        return usuarioPaginaPessoalUrl;
    }

    public void setUsuarioPaginaPessoalUrl(String usuarioPaginaPessoalUrl) {
        this.usuarioPaginaPessoalUrl = usuarioPaginaPessoalUrl;
    }

    public String getUsuarioFotoUrl() {
        return usuarioFotoUrl;
    }

    public void setUsuarioFotoUrl(String usuarioFotoUrl) {
        this.usuarioFotoUrl = usuarioFotoUrl;
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