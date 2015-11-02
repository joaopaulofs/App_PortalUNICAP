package br.com.unicap.navigationdrawer.professor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 18/10/2015.
 */
public class AdapterListViewProfessor extends BaseAdapter  implements Serializable
{
    private LayoutInflater mInflater;
    private ArrayList<ItemListViewProfessor> itens;

    public AdapterListViewProfessor(Context context, ArrayList<ItemListViewProfessor> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    public AdapterListViewProfessor() {

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
    public ItemListViewProfessor getItem(int position)
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
        ItemListViewProfessor item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview_professor, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.nome)).setText(item.getNome());
        ImageView imagem = (ImageView) view.findViewById(R.id.imagem);
        ((ImageView) view.findViewById(imagem.getId())).setImageResource(item.getImagem());
        ((TextView) view.findViewById(R.id.cargo)).setText(item.getCargo());
        ((TextView) view.findViewById(R.id.email)).setText(item.getEmail());

        return view;
    }
}
