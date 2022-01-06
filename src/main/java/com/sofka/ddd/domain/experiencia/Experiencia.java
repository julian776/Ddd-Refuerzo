package com.sofka.ddd.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;
import com.sofka.ddd.domain.hojavida.HojaDeVidaId;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected ExperienciaLaboral experienciaLaboral;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId, ExperienciaLaboral experienciaLaboral) {
        super(entityId);
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
