package br.com.unicap.navigationdrawer.evento;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Evento extends Fragment {

    ListView list;
    private AdapterListViewEvento adapterListView;
    private ArrayList<ItemListViewEvento> itens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.evento, container, false);

        list = (ListView) view.findViewById(R.id.list);

        createListView();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityEvento.class);
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
        itens = new ArrayList<ItemListViewEvento>();
        ItemListViewEvento item1 = new ItemListViewEvento("Palestra Mensal de Computação (Setembro/2015)", -1, "Prezados Alunos e Professores,\n" +
                "\n" +
                "Segue abaixo informações sobre a palestra do mês de Setembro/2015:\n" +
                "\n" +
                "Tema: Clean Code e boas práticas em Orientação a Objetos. Você sabe mesmo programar Orientado a Objetos? Eu duvido!\n" +
                "Palestrante: Prof. Antonio Luiz Cavalcanti\n" +
                "Local: Sala Multiuso (1º Andar - Bloco D)\n" +
                "Data: 23/09/2015 (quarta-feira)\n" +
                "Horário: 19h\n" +
                "Realização: Curso de Ciência da Computação da Universidade Católica de Pernambuco\n" +
                "OBS: Não é necessária inscrição prévia, todos são bem-vindos e o acesso à sala se dará por ordem de chegada até a sua capacidade máxima estar esgotada.", "Posted by: marcio Bueno | 19 de Setembro de 2015");
        ItemListViewEvento item2 = new ItemListViewEvento("Palestra Mensal de Ciência da Computação", -1, "Prezados alunos e professores,\n" +
                "\n" +
                "Retomando as nossas palestras mensais, segue informação sobre a palestra de Agosto:\n" +
                "\n" +
                "Tema: Visão Geral sobre Realidade Aumentada\n" +
                "Palestrante: Prof. Márcio Bueno\n" +
                "Local: Sala Multiuso (1º Andar - Bloco D)\n" +
                "Data: 25/08/2015 (terça-feira)\n" +
                "Horário: 19h\n" +
                "Realização: Curso de Ciência da Computação da Universidade Católica de Pernambuco\n" +
                "OBS: Não é necessária inscrição prévia, todos são bem-vindos e o acesso à sala se dará por ordem de chegada até a sua capacidade máxima estar esgotada", "Posted by: marcio Bueno | 20 de Agosto de 2015");
        itens.add(item1);
        itens.add(item2);

        //Cria o adapter
        adapterListView = new AdapterListViewEvento(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }
}
