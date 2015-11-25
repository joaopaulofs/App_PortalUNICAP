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
        disciplinas = new Disciplina[200];

        try {
            jsonObject = new JSONObject(json);
            JSONArray jsonresult = jsonObject.getJSONArray("result");
            int tamanho = jsonresult.length();

            for (int i=0;i<tamanho;i++){
                disciplinas[i]= new Disciplina();

            }
            for(int i=0;i<tamanho;i++) {
                JSONObject disciplina = jsonresult.getJSONObject(i);
                disciplinas[i].setDisciplinaId(disciplina.getString("disciplinaId"));
                disciplinas[i].setDisciplinaCodigo(disciplina.getString("disciplinaCodigo"));
                disciplinas[i].setDisciplinaNome(disciplina.getString("disciplinaNome"));
                disciplinas[i].setDisciplinaLinkPlanoAcademico(disciplina.getString("disciplinaLinkPlanoAcademico"));
                disciplinas[i].setDisciplinaCreditos(disciplina.getString("disciplinaCreditos"));
                disciplinas[i].setDisciplinaCargaHoraria(disciplina.getString("disciplinaCargaHoraria"));
                disciplinas[i].setDisciplinaArquivos(disciplina.getString("disciplinaArquivos"));
                disciplinas[i].setDisciplinaProfessorNome(disciplina.getString("disciplinaProfessorNome"));
                disciplinas[i].setDisciplinaProfessorMatricula(disciplina.getString("disciplinaProfessorMatricula"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }
}