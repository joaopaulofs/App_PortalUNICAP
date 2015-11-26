package br.com.unicap.navigationdrawer.professor;

import android.accounts.NetworkErrorException;

import com.android.volley.NetworkError;

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

        Professor[] professores;
        professores = new Professor[2000];
        JSONObject jsonobjectresult = null;

        try {

           JSONObject jsonObject = new JSONObject(json);
            String tamanho =  jsonObject.getString("totalCount");
            JSONArray jsonresult = jsonObject.getJSONArray("result");
            for (int i=0;i<Integer.parseInt(tamanho);i++){
                professores[i]= new Professor();
            }
            for(int i=0;i<Integer.parseInt(tamanho);i++) {
                JSONObject professor = jsonresult.getJSONObject(i);
                professores[i].setUsuarioMatricula(professor.getString("usuarioMatricula"));
                professores[i].setUsuarioEmail(professor.getString("usuarioEmail"));

                    professores[i].setUsuarioCargo(professor.getString("usuarioCargo"));
                if(professor.names().toString().contains("usuarioNome")) {
                    professores[i].setUsuarioNome(professor.getString("usuarioNome"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }{

        }
        return professores;
    }
}