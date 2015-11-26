package br.com.unicap.navigationdrawer.model;

import java.io.Serializable;

/**
 * Created by Joao on 05/11/2015.
 */
public class Disciplina implements Serializable {
    private String disciplinaId;
    private String disciplinaCodigo;
    private String disciplinaNome;
    private String disciplinaLinkPlanoAcademico;
    private String disciplinaCreditos;
    private String disciplinaCargaHoraria;
    private String disciplinaArquivos;
    private String disciplinaProfessorNome;
    private String disciplinaProfessorMatricula;

    public Disciplina() {

    }

    public Disciplina(String disciplinaId, String disciplinaCodigo, String disciplinaNome, String disciplinaLinkPlanoAcademico, String disciplinaCreditos, String disciplinaCargaHoraria, String disciplinaArquivos,String disciplinaProfessorNome,String disciplinaProfessorMatricula) {
        this.disciplinaId = disciplinaId;
        this.disciplinaCodigo = disciplinaCodigo;
        this.disciplinaNome = disciplinaNome;
        this.disciplinaLinkPlanoAcademico = disciplinaLinkPlanoAcademico;
        this.disciplinaCreditos = disciplinaCreditos;
        this.disciplinaCargaHoraria = disciplinaCargaHoraria;
        this.disciplinaArquivos = disciplinaArquivos;
        this.disciplinaProfessorNome=disciplinaProfessorNome;
        this.disciplinaProfessorMatricula=disciplinaProfessorMatricula;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public String getDisciplinaCodigo() {
        return disciplinaCodigo;
    }

    public void setDisciplinaCodigo(String disciplinaCodigo) {
        this.disciplinaCodigo = disciplinaCodigo;
    }

    public String getDisciplinaNome() {
        return disciplinaNome;
    }

    public void setDisciplinaNome(String disciplinaNome) {
        this.disciplinaNome = disciplinaNome;
    }

    public String getDisciplinaLinkPlanoAcademico() {
        return disciplinaLinkPlanoAcademico;
    }

    public void setDisciplinaLinkPlanoAcademico(String disciplinaLinkPlanoAcademico) {
        this.disciplinaLinkPlanoAcademico = disciplinaLinkPlanoAcademico;
    }

    public String getDisciplinaCreditos() {
        return disciplinaCreditos;
    }

    public void setDisciplinaCreditos(String disciplinaCreditos) {
        this.disciplinaCreditos = disciplinaCreditos;
    }

    public String getDisciplinaCargaHoraria() {
        return disciplinaCargaHoraria;
    }

    public void setDisciplinaCargaHoraria(String disciplinaCargaHoraria) {
        this.disciplinaCargaHoraria = disciplinaCargaHoraria;
    }

    public String getDisciplinaArquivos() {
        return disciplinaArquivos;
    }

    public void setDisciplinaArquivos(String disciplinaArquivos) {
        this.disciplinaArquivos = disciplinaArquivos;
    }
    public String getDisciplinaProfessorNome(){
        return disciplinaProfessorNome;
    }
    public void setDisciplinaProfessorNome(String disciplinaProfessorNome){
        this.disciplinaProfessorNome= disciplinaProfessorNome;
    }
    public String getDisciplinaProfessorMatricula(){
        return this.disciplinaProfessorMatricula;
    }
    public void setDisciplinaProfessorMatricula(String disciplinaProfessorMatricula){
        this.disciplinaProfessorMatricula=disciplinaProfessorMatricula;
    }
}
