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

import java.util.ArrayList;

import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 13/09/2015.
 */
public class Post extends Fragment {

    ListView list;
    private AdapterListViewPost adapterListView;
    private ArrayList<ItemListViewPost> itens;

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

    private void createListView()
    {   String texto1 = new String("");
        String texto2 = new String("");
        itens = new ArrayList<ItemListViewPost>();
        ItemListViewPost item1 = new ItemListViewPost("O que é Inteligência Artifical?", R.drawable.ia, "Especialistas acreditam que a inteligência das máquinas se equiparará à de humanos até 2050, graças a uma nova era na sua capacidade de aprendizado.\n" +
                "Computadores já estão começando a assimilar informações a partir de dados coletados, da mesma forma que crianças aprendem com o mundo ao seu redor.\n" +
                "Isso significa que estamos criando máquinas que podem ensinar a si mesmas a participar de jogos de computador – e ser muito boas neles – e também a se comunicar simulando a fala humana, como acontece com os smartphones e seus sistemas de assistentes virtuais.\n" +
                "Fei-Fei Li, professora da Universidade de Stanford e diretora do laboratório de visão computacional da instituição, passou os últimos 15 anos ensinando computadores a enxergar.\n" +
                "Seu objetivo é criar olhos eletrônicos para robôs e máquinas e torná-los capazes de entender o ambiente em que estão.", "Posted by: Admin | 19 de Setembro de 2015");
        ItemListViewPost item2 = new ItemListViewPost("Alunos de ciência da computação desenvolvem aplicativo ”Ônibus para Todos”", R.drawable.aa, "Supervisionados pelo professor Sérgio Murilo,  alunos do 5º período de Ciência da Computação desenvolveram um aplicativo para facilitar a vida das pessoas que utilizam  o transporte público e sofrem com algum tipo de deficiência visual. “Essa é uma atividade prática, que propomos como trabalho para o segundo GQ.  É uma forma de estimular os alunos, e também uma forma importante de instigar a criatividade deles”, afirmou.\n" +
                "\n" +
                "Derick, um dos idealizadores do protótipo, falou sobre a experiência: “ Nesse período, o professor nos deu carta branca para que pudéssemos ir mais adiante, e irmos além dos padrões da Universidade”, disse.   A escolha por um aplicativo relacionado à mobilidade urbana foi influenciada pelo ex-professor da Unicap Eduardo Oliveira. A plataforma serve tanto para pessoas que têm deficiência visual total como para aqueles indivíduos que apresentam problemas de vista parcial. O projeto custou entre $500,00 e $600,00 e durou um mês  para ser concluído.\n" +
                "\n" +
                "Os alunos simularam, numa maquete, o funcionamento da plataforma. O protótipo interage com o indivíduo, informando o número ou nome do ônibus desejado. Além disso, ele está sempre informando onde o veículo encontra-se e quando está se aproximando. Segundo o estudante Dimas, o diferencial desse software é que tudo pode ser feito através de um único toque. “Nos outros existentes, é necessário verificar uma lista. No nosso, o indivíduo pode tocar em qualquer lugar da tela e toda interação é feita por voz”, enfatizou.", "Posted by: Robson | 06 de Junho de 2014");
        itens.add(item1);
        itens.add(item2);

        //Cria o adapter
        adapterListView = new AdapterListViewPost(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }

}
