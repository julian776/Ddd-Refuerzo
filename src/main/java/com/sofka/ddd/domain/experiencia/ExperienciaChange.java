package com.sofka.ddd.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.events.ExperienciaLaboralConocimientosModificacdos;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia) {
        apply((ExperienciaCreada event) -> {
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
            experiencia.experienciaLaboral = event.getExperienciaLaboral();
        });

        apply((ExperienciaLaboralConocimientosModificacdos event) -> {
            experiencia.experienciaLaboral.actualizarConocimientos(event.getConocimientosAdquiridos());
        });
    }
}
