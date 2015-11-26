package br.com.unicap.navigationdrawer.evento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.unicap.navigationdrawer.model.Evento;
import br.com.unicap.navigationdrawer.model.Post;

/**
 * Created by Derick on 07/11/2015.
 */
public class JsonEventos {



    private String json;

    public JsonEventos(String json){
        this.json = json;
    }

    public Evento[] JsonEventos(){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        Evento[] eventos;
        eventos = new Evento[20];

        try {
            jsonObject = new JSONObject(json);

            JSONArray jsonresult = jsonObject.getJSONArray("result");
            int tamanho = jsonresult.length();


            for (int i=0;i<tamanho;i++){
                eventos[i]= new Evento();

            }
            for(int i=0;i<tamanho;i++) {
                JSONObject evento = jsonresult.getJSONObject(i);
                eventos[i].setEventoId(evento.getString("eventoId"));
                eventos[i].setEventoTitulo(evento.getString("eventoTitulo"));
                eventos[i].setEventoDescricao(evento.getString("eventoDescricao"));
                eventos[i].setEventoLocal(evento.getString("eventoLocal"));
                eventos[i].setEventoData(evento.getString("eventoData"));
                eventos[i].setEventoCriador(evento.getString("eventoCriador"));
                eventos[i].setEventoCriadorMatricula(evento.getString("eventoCriadorMatricula"));
                eventos[i].setEventoImagens(evento.getString("eventoImagens"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventos;
    }
}
