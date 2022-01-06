package com.sofka.ddd.domain.experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.ddd.domain.experiencia.entitys.ExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.values.ExperienciaId;
import com.sofka.ddd.domain.hojavida.values.HojaDeVidaId;

public class CrearExperienciaCommand extends Command {

    private final ExperienciaId entityId;
    private final HojaDeVidaId hojaDeVidaId;
    private final ExperienciaLaboral experienciaLaboral;

    public CrearExperienciaCommand(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId, ExperienciaLaboral experienciaLaboral){

        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.experienciaLaboral = experienciaLaboral;
    }

    public ExperienciaId getEntityId() {
        return entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        return experienciaLaboral;
    }
}
