package br.com.unicap.navigationdrawer.evento;

import java.io.Serializable;

/**
 * Created by Joao on 18/10/2015.
 */
public class ItemListViewEvento implements Serializable {
    String tituloEvento;
    int imageEvento;
    String infoEvento;
    String dadosEvento;

    public ItemListViewEvento(){
    }

    public ItemListViewEvento(String tituloEvento, int imageEvento, String infoEvento, String dadosEvento){
        this.tituloEvento = tituloEvento;
        this.imageEvento = imageEvento;
        this.infoEvento = infoEvento;
        this.dadosEvento = dadosEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public int getImageEvento() {
        return imageEvento;
    }

    public void setImageEvento(int imageEvento) { this.imageEvento = imageEvento; }

    public String getInfoEvento(){
        return infoEvento;
    }

    public void setInfoEvento(String infoEvento) { this.infoEvento = infoEvento; }

    public String getDadosEvento() {
        return dadosEvento;
    }

    public void setDadosEvento(String dadosEvento) {
        this.dadosEvento = dadosEvento;
    }
}