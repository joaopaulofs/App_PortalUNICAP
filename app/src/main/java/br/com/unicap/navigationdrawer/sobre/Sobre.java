package br.com.unicap.navigationdrawer.sobre;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.unicap.navigationdrawer.R;

/**
 * Created by Joao on 13/09/2015.
 */
public class Sobre extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sobre, container, false);
        return rootView;
    }
}
