package br.com.unicap.navigationdrawer.disciplina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.unicap.navigationdrawer.R;
import br.com.unicap.navigationdrawer.model.Disciplina;

/**
 * Created by Joao on 18/10/2015.
 */
public class AdapterListViewDisciplina extends BaseAdapter  implements Serializable
{
    private LayoutInflater mInflater;
    private ArrayList<Disciplina> itens;

    public AdapterListViewDisciplina(Context context, ArrayList<Disciplina> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    public AdapterListViewDisciplina() {

    }

    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return itens.size();
    }

    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public Disciplina getItem(int position)
    {
        return itens.get(position);
    }

    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posição.
        Disciplina item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview_disciplina, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.nome)).setText(item.getDisciplinaNome());
//        ImageView imagem = (ImageView) view.findViewById(R.id.imagem);
//        ((ImageView) view.findViewById(imagem.getId())).setImageResource(item.getUsuarioFoto());
        ((TextView) view.findViewById(R.id.codigo)).setText(item.getDisciplinaCodigo());
        //((TextView) view.findViewById(R.id.link)).setText(item.getDisciplinaLinkPlanoAcademico());

        return view;
    }
}
