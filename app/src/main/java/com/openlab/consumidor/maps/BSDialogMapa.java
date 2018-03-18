package com.openlab.consumidor.maps;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openlab.consumidor.R;

/**
 * Created by Bryam Soto on 13/03/2018.
 */

public class BSDialogMapa extends BottomSheetDialogFragment {

    static BSDialogMapa newInstance() {
        return new BSDialogMapa();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_mapa, container, false);
    }
}
