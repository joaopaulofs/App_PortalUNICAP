package br.com.unicap.navigationdrawer.post;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import br.com.unicap.navigationdrawer.evento.AdapterListViewEvento;
import br.com.unicap.navigationdrawer.model.Post;
import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 02/11/2015.
 */
public class PostListView extends Fragment {

    ListView list;
    private AdapterListViewPost adapterListView;
    private ArrayList<Post> itens;
    private String[] postId;
    private String[] postTitulo;
    private String[] postDescricao;
    private String[] postData;
    private String[] postAutorNome;
    private String[] postAutorMatricula;
    private String[] postImage;

    private JSONArray posts = null;
    private String json;

//    public PostListView (String json) {this.json = json;}

    protected void parseJSONPosts() {
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(json);

            postId = new String[jsonArray.length()];
            postTitulo = new String[jsonArray.length()];
            postDescricao = new String[jsonArray.length()];
            postData = new String[jsonArray.length()];
            postAutorNome = new String[jsonArray.length()];
            postAutorMatricula = new String[jsonArray.length()];
            postImage = new String[jsonArray.length()];

            for(int i=0;i<jsonArray.length();i++) {
                jsonObject = jsonArray.getJSONObject(i);
                postId[i] = jsonObject.getString("postId");
                postTitulo[i] = jsonObject.getString("postTitulo");
                postDescricao[i] = jsonObject.getString("postDescricao");
                postData[i] = jsonObject.getString("postData");
                postAutorNome[i] = jsonObject.getString("postAutorNome");
                postAutorMatricula[i] = jsonObject.getString("postAutorMatricula");
                postImage[i] = jsonObject.getString("postImage");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.post, container, false);

        list = (ListView) view.findViewById(R.id.list);

        createListView();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityPost.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                intent.putExtra("OBJETO", adapterListView.getItem(position));
                startActivity(intent);
            }
        });

        return view;
    }

    private void createListView() {
        itens = new ArrayList<Post>();
        if(postId != null) {
            for (int i = 0; i < postId.length; i++) {
                Post item = new Post(postId[i], postTitulo[i], postDescricao[i], postAutorNome[i], postAutorMatricula[i], postData[i], postImage[i]);
                itens.add(item);
            }
        }

        Post item1 = new Post("", "O que é Inteligência Artifical?", "Especialistas acreditam que a inteligência das máquinas se equiparará à de humanos até 2050, graças a uma nova era na sua capacidade de aprendizado.\n" +
                "\" +\n" +
                "                \"Computadores já estão começando a assimilar informações a partir de dados coletados, da mesma forma que crianças aprendem com o mundo ao seu redor.\\n\" +\n" +
                "                \"Isso significa que estamos criando máquinas que podem ensinar a si mesmas a participar de jogos de computador – e ser muito boas neles – e também a se comunicar simulando a fala humana, como acontece com os smartphones e seus sistemas de assistentes virtuais.\\n\" +\n" +
                "                \"Fei-Fei Li, professora da Universidade de Stanford e diretora do laboratório de visão computacional da instituição, passou os últimos 15 anos ensinando computadores a enxergar.\\n\" +\n" +
                "                \"Seu objetivo é criar olhos eletrônicos para robôs e máquinas e torná-los capazes de entender o ambiente em que estão.", "Admin", "", "19 de Setembro de 2015", "");

        Post item2 = new Post("", "Alunos de ciência da computação desenvolvem aplicativo ”Ônibus para Todos”", "Supervisionados pelo professor Sérgio Murilo,  alunos do 5º período de Ciência da Computação desenvolveram um aplicativo para facilitar a vida das pessoas que utilizam  o transporte público e sofrem com algum tipo de deficiência visual. “Essa é uma atividade prática, que propomos como trabalho para o segundo GQ.  É uma forma de estimular os alunos, e também uma forma importante de instigar a criatividade deles”, afirmou.\n" +
                "\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Derick, um dos idealizadores do protótipo, falou sobre a experiência: “ Nesse período, o professor nos deu carta branca para que pudéssemos ir mais adiante, e irmos além dos padrões da Universidade”, disse.   A escolha por um aplicativo relacionado à mobilidade urbana foi influenciada pelo ex-professor da Unicap Eduardo Oliveira. A plataforma serve tanto para pessoas que têm deficiência visual total como para aqueles indivíduos que apresentam problemas de vista parcial. O projeto custou entre $500,00 e $600,00 e durou um mês  para ser concluído.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Os alunos simularam, numa maquete, o funcionamento da plataforma. O protótipo interage com o indivíduo, informando o número ou nome do ônibus desejado. Além disso, ele está sempre informando onde o veículo encontra-se e quando está se aproximando. Segundo o estudante Dimas, o diferencial desse software é que tudo pode ser feito através de um único toque. “Nos outros existentes, é necessário verificar uma lista. No nosso, o indivíduo pode tocar em qualquer lugar da tela e toda interação é feita por voz”, enfatizou.", "Admin", "", "20 de Outubro de 2015", "");
        itens.add(item1);
        itens.add(item2);

        //Cria o adapter
        adapterListView = new AdapterListViewPost(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }

    public void setJson(String json) {
        this.json = json;
    }
}
