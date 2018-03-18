package com.openlab.consumidor.maps;

import com.openlab.consumidor.entity.ReclamoTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryam Soto on 24/11/2017.
 */

public class EventModel implements Event.Model {

    private Event.Presenter presenter;

    EventModel(Event.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void findAllReclamos() {
        List<ReclamoTO> reclamos = new ArrayList<>();

        reclamos.add(new ReclamoTO("Sede Central", -12.0858177, -77.0099917));
        reclamos.add(new ReclamoTO("Sede Lima Norte", -11.9911507, -77.0755147));
        reclamos.add(new ReclamoTO("Sede Gamarra", -12.0383129, -77.110606));
        reclamos.add(new ReclamoTO("Sede Huancayo", -12.0554597, -75.2173272));
        reclamos.add(new ReclamoTO("Sede Chachapoyas", -6.2291065, -77.8758011));
        reclamos.add(new ReclamoTO("Sede Chiclayo", -6.7802665, -79.8404754));
        reclamos.add(new ReclamoTO("Sede Ayacucho", -13.1566924, -74.2311135));
        reclamos.add(new ReclamoTO("Sede Tacna", -18.0150663,-70.2531915));

        reclamos.add(new ReclamoTO("Sede Cuzco", -13.5226626,-71.9656946));
        reclamos.add(new ReclamoTO("Sede Trujillo", -8.1190693,-79.0385492));
        reclamos.add(new ReclamoTO("Sede Ica", -14.0742525,-75.726722));
        reclamos.add(new ReclamoTO("Sede Puno", -15.8415866,-70.0308708));
        reclamos.add(new ReclamoTO("Sede Tarapoto", -6.4903471,-76.3629695));

        reclamos.add(new ReclamoTO("Sede Amazonas", -6.6915069,-78.7549743));
        reclamos.add(new ReclamoTO("Sede Cajamarca",-7.1572606,-78.5173898));
        reclamos.add(new ReclamoTO("Sede Arequipa", -16.418617,-71.6670927));

        presenter.showMarkers(reclamos);

    }
}
