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
            jsonArray = new JSONArray(json);
            int tamanho = jsonArray.length();

            for (int i=0;i<tamanho;i++){
                eventos[i]= new Evento();

            }
            for(int i=0;i<tamanho;i++) {
                jsonObject = jsonArray.getJSONObject(i);
                eventos[i].setEventoId(jsonObject.getString("eventoId"));
                eventos[i].setEventoTitulo(jsonObject.getString("eventoTitulo"));
                eventos[i].setEventoDescricao(jsonObject.getString("eventoDescricao"));
                eventos[i].setEventoLocal(jsonObject.getString("eventoLocal"));
                eventos[i].setEventoData(jsonObject.getString("eventoData"));
                eventos[i].setEventoCriador(jsonObject.getString("eventoCriador"));
                eventos[i].setEventoCriadorMatricula(jsonObject.getString("eventoCriadorMatricula"));
                eventos[i].setEventoImagens(jsonObject.getString("eventoImagens"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventos;
    }
}
