package br.com.unicap.navigationdrawer.disciplina;

/**
 * Created by Derick on 07/11/2015.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.unicap.navigationdrawer.model.Disciplina;
import br.com.unicap.navigationdrawer.model.Post;


import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.unicap.navigationdrawer.model.Post;

/**
 * Created by Derick on 07/11/2015.
 */
public class JsonDisciplinas {



    private String json;

    public JsonDisciplinas(String json){
        this.json = json;
    }

    public Disciplina[] JsonDisciplinas(){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        Disciplina[] disciplinas;
        disciplinas = new Disciplina[20];

        try {
            jsonArray = new JSONArray(json);
            int tamanho = jsonArray.length();

            for (int i=0;i<tamanho;i++){
                disciplinas[i]= new Disciplina();

            }
            for(int i=0;i<tamanho;i++) {
                jsonObject = jsonArray.getJSONObject(i);
                disciplinas[i].setDisciplinaId(jsonObject.getString("disciplinaId"));
                disciplinas[i].setDisciplinaCodigo(jsonObject.getString("disciplinaCodigo"));
                disciplinas[i].setDisciplinaNome(jsonObject.getString("disciplinaNome"));
                disciplinas[i].setDisciplinaLinkPlanoAcademico(jsonObject.getString("disciplinaLinkPlanoAcademico"));
                disciplinas[i].setDisciplinaCreditos(jsonObject.getString("disciplinaCreditos"));
                disciplinas[i].setDisciplinaCargaHoraria(jsonObject.getString("disciplinaCargaHoraria"));
                disciplinas[i].setDisciplinaData(jsonObject.getString("disciplinaData"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }
}