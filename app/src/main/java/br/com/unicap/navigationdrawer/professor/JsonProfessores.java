package br.com.unicap.navigationdrawer.professor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.model.Professor;

/**
 * Created by Derick on 07/11/2015.
 */
public class JsonProfessores {



    private String json;

    public JsonProfessores(String json){
        this.json = json;
    }

    public Professor[] JsonProfessores(){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        Professor[] professores;
        professores = new Professor[2000];

        try {
            jsonArray = new JSONArray(json);
            int tamanho = jsonArray.length();

            for (int i=0;i<tamanho;i++){
                professores[i]= new Professor();

            }
            for(int i=0;i<tamanho;i++) {
                jsonObject = jsonArray.getJSONObject(i);
                professores[i].setUsuarioMatricula(jsonObject.getString("usuarioMatricula"));
                professores[i].setUsuarioEmail(jsonObject.getString("usuarioEmail"));
                if(jsonObject.names().toString().contains("usuarioCargo")) {
                    professores[i].setUsuarioCargo(jsonObject.getString("usuarioCargo"));
                }
                professores[i].setUsuarioNome(jsonObject.getString("usuarioNome"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return professores;
    }
}