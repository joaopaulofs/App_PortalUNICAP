package br.com.unicap.navigationdrawer.evento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.unicap.navigationdrawer.model.Evento;
import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 18/10/2015.
 */
public class AdapterListViewEvento extends BaseAdapter  implements Serializable
{
    private LayoutInflater mInflater;
    private ArrayList<Evento> itens;

    public AdapterListViewEvento(Context context, ArrayList<Evento> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    public AdapterListViewEvento() {

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
    public Evento getItem(int position)
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
        Evento item = itens.get(position);
        //infla o layout para podermos preencher os dados
        view = mInflater.inflate(R.layout.item_listview_evento, null);

        //atravez do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(R.id.tituloEvento)).setText(item.getEventoTitulo());
//        ImageView image = (ImageView) view.findViewById(R.id.imageEvento);
//        ((ImageView) view.findViewById(image.getId())).setImageResource(item.getEventoImagens());
        if(item.getEventoDescricao().length() > 235) {
            ((TextView) view.findViewById(R.id.infoEvento)).setText(item.getEventoDescricao().substring(0, 235) + "...");
        } else {
            ((TextView) view.findViewById(R.id.infoEvento)).setText(item.getEventoDescricao());
        }
        ((TextView) view.findViewById(R.id.dadosEvento)).setText(item.getEventoCriador() + " / " + item.getEventoData());

        return view;
    }
}
