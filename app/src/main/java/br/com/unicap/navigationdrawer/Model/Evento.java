package br.com.unicap.navigationdrawer.model;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class Evento implements Serializable {
    private String eventoId;
    private String eventoTitulo;
    private String eventoDescricao;
    private String eventoData;
    private String eventoLocal;
    private String eventoCriador;
    private String eventoCriadorMatricula;
    private String eventoImagens;

    public Evento(){
    }

    public Evento(String eventoId, String eventoTitulo, String eventoDescricao, String eventoData, String eventoLocal, String eventoCriador, String eventoCriadorMatricula, String eventoImagens) {
        this.eventoId = eventoId;
        this.eventoTitulo = eventoTitulo;
        this.eventoDescricao = eventoDescricao;
        this.eventoData = eventoData;
        this.eventoLocal = eventoLocal;
        this.eventoCriador = eventoCriador;
        this.eventoCriadorMatricula = eventoCriadorMatricula;
        this.eventoImagens = eventoImagens;
    }

    public String getEventoId() {
        return eventoId;
    }

    public void setEventoId(String eventoId) {
        this.eventoId = eventoId;
    }

    public String getEventoTitulo() {
        return eventoTitulo;
    }

    public void setEventoTitulo(String eventoTitulo) {
        this.eventoTitulo = eventoTitulo;
    }

    public String getEventoDescricao() {
        return eventoDescricao;
    }

    public void setEventoDescricao(String eventoDescricao) {
        this.eventoDescricao = eventoDescricao;
    }

    public String getEventoData() {
        return eventoData;
    }

    public void setEventoData(String eventoData) {
        this.eventoData = eventoData;
    }

    public String getEventoLocal() {
        return eventoLocal;
    }

    public void setEventoLocal(String eventoLocal) {
        this.eventoLocal = eventoLocal;
    }

    public String getEventoCriador() {
        return eventoCriador;
    }

    public void setEventoCriador(String eventoCriador) {
        this.eventoCriador = eventoCriador;
    }

    public String getEventoCriadorMatricula() {
        return eventoCriadorMatricula;
    }

    public void setEventoCriadorMatricula(String eventoCriadorMatricula) {
        this.eventoCriadorMatricula = eventoCriadorMatricula;
    }

    public String getEventoImagens() {
        return eventoImagens;
    }

    public void setEventoImagens(String eventoImagens) {
        this.eventoImagens = eventoImagens;
    }
}