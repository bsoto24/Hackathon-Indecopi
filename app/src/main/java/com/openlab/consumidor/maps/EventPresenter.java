package com.openlab.consumidor.maps;

import com.openlab.consumidor.entity.ReclamoTO;

import java.util.List;

/**
 * Created by Bryam Soto on 24/11/2017.
 */

public class EventPresenter implements Event.Presenter {

    private Event.View view;
    private Event.Model model;

    EventPresenter(Event.View view) {
        this.view = view;
        model = new EventModel(this);
    }

    @Override
    public void showMarkers(List<ReclamoTO> reclamos) {
        view.showMarkers(reclamos);
    }

    @Override
    public void findAllReclamos() {
        model.findAllReclamos();
    }
}
