package com.sofka.ddd.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;

public class ExperienciaChange extends EventChange {

    public ExperienciaChange(Experiencia experiencia) {
        apply((ExperienciaCreada event) -> {
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
            experiencia.experienciaLaboral = event.getExperienciaLaboral();
        });
    }
}
