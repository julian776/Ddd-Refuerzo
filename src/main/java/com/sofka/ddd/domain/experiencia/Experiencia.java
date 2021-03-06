package com.sofka.ddd.domain.experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.events.ExperienciaLaboralConocimientosModificacdos;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdquiridos;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

import java.util.List;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected ExperienciaLaboral experienciaLaboral;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId, ExperienciaLaboral experienciaLaboral) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
        this.experienciaLaboral = experienciaLaboral;
        appendChange(new ExperienciaCreada(hojaDeVidaId, experienciaLaboral)).apply();
    }

    private Experiencia(ExperienciaId experienciaId){
        super(experienciaId);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(ExperienciaId experienciaId, List<DomainEvent> retrieveEvents){
        var experiencia = new Experiencia(experienciaId);
        retrieveEvents.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void modificarExperienciaLaboralConocimientos(ConocimientosAdquiridos conocimientosAdquiridos){
        appendChange(new ExperienciaLaboralConocimientosModificacdos(conocimientosAdquiridos));
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }
}
