package com.openlab.consumidor.maps;

import com.openlab.consumidor.entity.ReclamoTO;

import java.util.List;

/**
 * Created by Bryam Soto on 24/11/2017.
 */

public interface Event {

    interface Model {
        void findAllReclamos();
    }

    interface View {
        void showMarkers(List<ReclamoTO> reclamos);
    }

    interface Presenter {
        void showMarkers(List<ReclamoTO> reclamos);

        void findAllReclamos();
    }
}
