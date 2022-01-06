package com.sofka.ddd.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdquiridos;

public class ExperienciaLaboralConocimientosModificacdos extends DomainEvent {

    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboralConocimientosModificacdos(ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.experiencia.conocimientosadquiridos");
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
