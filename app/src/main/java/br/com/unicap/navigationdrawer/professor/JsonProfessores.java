package br.com.unicap.navigationdrawer.professor;

<<<<<<< HEAD
import android.accounts.NetworkErrorException;

import com.android.volley.NetworkError;

=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
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
<<<<<<< HEAD

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

=======
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
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
        }
        return professores;
    }
}