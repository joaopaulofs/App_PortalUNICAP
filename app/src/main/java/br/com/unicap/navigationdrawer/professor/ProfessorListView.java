package br.com.unicap.navigationdrawer.professor;

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
import br.com.unicap.navigationdrawer.model.Professor;

/**
 * Created by Joao on 13/09/2015.
 */
public class ProfessorListView extends Fragment {

    ListView list;
    private AdapterListViewProfessor adapterListView;
    private ArrayList<Professor> itens;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.professor, container, false);

        list = (ListView) view.findViewById(R.id.list);

        createListView();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailsActivityProfessor.class);
                intent.putExtra("ID", id);
                intent.putExtra("POSITION", position);
                intent.putExtra("OBJETO", adapterListView.getItem(position));
                startActivity(intent);
            }
        });

        return view;
    }

    private void createListView()
    {
        itens = new ArrayList<Professor>();
        Professor item1 = new Professor("Almir Pires", "ProfessorListView", "almir@c3.unicap.br", "", "", "", "", "", "", "");
        Professor item2 = new Professor("Robson Lins", "ProfessorListView", "robson@c3.unicap.br", "", "", "", "", "", "", "");
        Professor item3 = new Professor("Marcio Bueno", "Coordenador", "marcio@c3.unicap.br", "", "", "", "", "", "", "");
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);

        //Cria o adapter
        adapterListView = new AdapterListViewProfessor(this.getActivity(), itens);

        //Define o Adapter
        list.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para rolagem.
        list.setCacheColorHint(Color.TRANSPARENT);
    }
}
