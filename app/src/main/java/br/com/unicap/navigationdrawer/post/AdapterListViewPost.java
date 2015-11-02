package br.com.unicap.navigationdrawer.post;

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
public class AdapterListViewPost extends BaseAdapter  implements Serializable
{
    private LayoutInflater mInflater;
    private ArrayList<ItemListViewPost> itens;

    public AdapterListViewPost(Context context, ArrayList<ItemListViewPost> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    public AdapterListViewPost() {

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
    public ItemListViewPost getItem(int position)
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
        ItemListViewPost item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.tituloPost)).setText(item.getTituloPost());
        ImageView image = (ImageView) view.findViewById(R.id.imagePost);
        ((ImageView) view.findViewById(image.getId())).setImageResource(item.getImagePost());
        if(item.getInfoPost().length() > 235) {
            ((TextView) view.findViewById(R.id.infoPost)).setText(item.getInfoPost().substring(0, 235) + "...");
        } else {
            ((TextView) view.findViewById(R.id.infoPost)).setText(item.getInfoPost());
        }
        ((TextView) view.findViewById(R.id.dadosPost)).setText(item.getDadosPost());

        return view;
    }
}
