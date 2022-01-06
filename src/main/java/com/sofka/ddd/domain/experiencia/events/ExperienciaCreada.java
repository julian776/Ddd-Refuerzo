package com.sofka.ddd.domain.experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class ExperienciaCreada extends DomainEvent {
    private final HojaDeVidaId hojaDeVidaId;
    private final ExperienciaLaboral experienciaLaboral;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId, ExperienciaLaboral experienciaLaboral) {
        super("sofka.experiencia.experienciacreada");
        this.hojaDeVidaId = hojaDeVidaId;
        this.experienciaLaboral = experienciaLaboral;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }
}
