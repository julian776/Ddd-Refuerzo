package com.sofka.ddd.domain.gestioneducacion;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.gestioneducacion.events.GestionEducacionCreada;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreada event) -> {
            gestionEducacion.tipo = event.getTipo();
            gestionEducacion.estudio = event.getEstudio();
            gestionEducacion.institucion = event.getInstitucion();
            gestionEducacion.periodo = event.getPeriodo();
        });


    }
}
