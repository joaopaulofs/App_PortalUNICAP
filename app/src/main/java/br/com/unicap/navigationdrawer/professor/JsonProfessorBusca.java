package br.com.unicap.navigationdrawer.professor;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.unicap.navigationdrawer.model.Professor;

public class JsonProfessorBusca {


    private String json;

    public JsonProfessorBusca(String json) {
        this.json = json;
    }

    public Professor JsonProfessorBusca() {
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        Professor professores= new Professor();


        try {
            jsonObject = new JSONObject(json);


                professores.setUsuarioMatricula(jsonObject.getString("usuarioMatricula"));
                professores.setUsuarioTitulacao(jsonObject.getString("usuarioTitulacao"));
                professores.setUsuarioFotoUrl(jsonObject.getString("usuarioFotoUrl"));
                professores.setUsuarioPaginaPessoalUrl(jsonObject.getString("usuarioPaginaPessoalUrl"));
                professores.setUsuarioAreaInteresse(jsonObject.getString("usuarioAreaInteresse"));
                professores.setUsuarioTelefone(jsonObject.getString("usuarioTelefone"));
                professores.setUsuarioLattesUrl(jsonObject.getString("usuarioLattesUrl"));
                professores.setUsuarioEmail(jsonObject.getString("usuarioEmail"));
                professores.setUsuarioCargo(jsonObject.getString("usuarioCargo"));
                professores.setUsuarioNome(jsonObject.getString("usuarioNome"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return professores;
    }
}